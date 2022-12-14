package com.healt.cloud.checkup.appointmentReg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.healt.cloud.checkup.appointmentReg.mapper.PersonAppointRegMapper;
import com.healt.cloud.checkup.appointmentReg.service.PersonAppointRegService;
import com.healt.cloud.checkup.entity.HcChangeVsItem;
import com.healt.cloud.checkup.entity.HcChangeitemLog;
import com.healt.cloud.checkup.entity.HcItemPackDict;
import com.healt.cloud.checkup.entity.HcPersonAppregItems;
import com.healt.cloud.checkup.vo.appointmentReg.changeItem.ChangeItemm;
import com.healt.cloud.checkup.vo.appointmentReg.changeItem.SaveHcChargeItemListVo;
import com.healt.cloud.checkup.vo.appointmentReg.changeItem.SaveHcChargeItemVo;
import com.healt.cloud.checkup.appointmentReg.mapper.ChangeItemMapper;
import com.healt.cloud.checkup.service.HcChangeitemLogService;
import com.healt.cloud.checkup.service.HcItemPackDictService;
import com.healt.cloud.checkup.service.HcPersonAppregItemsService;
import com.healt.cloud.checkup.appointmentReg.service.ChangeItemService;
import com.healt.cloud.resultex.exception.CommonException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author linklee
 * @create 2022-05-16 14:34
 */
@Service
@AllArgsConstructor
public class ChangeItemServiceImpl implements ChangeItemService {

    private ChangeItemMapper changeItemMapper;

    private HcPersonAppregItemsService hcPersonAppregItemsService;
    private HcChangeitemLogService hcChangeitemLogService;
    private HcItemPackDictService hcItemPackDictService;

    private PersonAppointRegMapper personAppointRegMapper;

    @Override
    public List<HcChangeitemLog> findChangeVsItemLog() {
        List<HcChangeitemLog> list = new ArrayList<>();
        list.add(new HcChangeitemLog());
        return list;
    }

    @Override
    public List<HcChangeVsItem> findChangeVsItem(String hospitalId, String itemCode) {
        List<HcChangeVsItem> list = changeItemMapper.findChangeVsItem(hospitalId,itemCode);
        if (list.size() == 0) {
            list.add(new HcChangeVsItem());
        }
        return list;
    }

    @Override
    @Transactional
    public void saveHcChargeItemList(SaveHcChargeItemListVo saveHcChargeItemList) {
        for (SaveHcChargeItemVo saveHcChargeItemVo : saveHcChargeItemList.getSaveHcChargeItemList()) {
            // 1.删除hc_person_appreg_items被兑换项目 新增hc_person_appreg_items兑换项目(item_no序号如使用原来的item_no)
            QueryWrapper<HcPersonAppregItems> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("HOSPITAL_ID", saveHcChargeItemVo.getHospitalId());
            queryWrapper.eq("PERSON_ID", saveHcChargeItemVo.getPersonId());
            queryWrapper.eq("PERSON_VISIT_ID", saveHcChargeItemVo.getPersonVisitId());
            queryWrapper.eq("ITEM_PACK_CODE", saveHcChargeItemVo.getItemPackCode());
            queryWrapper.eq("ITEM_NO", saveHcChargeItemVo.getItemNo());
            HcPersonAppregItems hcPersonAppregItems = hcPersonAppregItemsService.getOne(queryWrapper);
            if(hcPersonAppregItems == null){
                throw new CommonException(500, "项目已经更换！");
            }
            hcPersonAppregItemsService.remove(queryWrapper);

            for (ChangeItemm changeItemm : saveHcChargeItemVo.getChangeItemm()) {
                String[] code = changeItemm.getChangeItemCode().split("\\|");
                String[] name = changeItemm.getChangeItemName().split("\\|");
                for (int i = 0; i < code.length; i++) {
                    QueryWrapper wrapper = new QueryWrapper();
                    wrapper.eq("HOSPITAL_ID",saveHcChargeItemVo.getHospitalId());
                    wrapper.eq("ITEM_PACK_CODE",code[i]);
                    HcItemPackDict hcItemPackDict = hcItemPackDictService.getOne(wrapper);
                    String orderId = personAppointRegMapper.selectOrderId().toString();
                    hcPersonAppregItems.setOrderId(orderId);
                    hcPersonAppregItems.setItemPackCode(code[i]);
                    hcPersonAppregItems.setItemPackName(name[i]);
                    hcPersonAppregItems.setCosts(hcItemPackDict.getItemPackPrice());
                    hcPersonAppregItems.setCharges(hcItemPackDict.getItemPackDiscountPrice()==null?hcItemPackDict.getItemPackPrice():hcItemPackDict.getItemPackDiscountPrice());
                    hcPersonAppregItemsService.save(hcPersonAppregItems);

                    //2.插入兑换日志 hc_changeitem_log(存日志的时候，同一个被兑换项目存在多个兑换项目的话用竖线分割存一条日志)
                    HcChangeitemLog hcChangeitemLog = new HcChangeitemLog();
                    hcChangeitemLog.setHospitalId(saveHcChargeItemVo.getHospitalId());
                    hcChangeitemLog.setItemNo(saveHcChargeItemVo.getItemNo());
                    hcChangeitemLog.setItemPackCode(saveHcChargeItemVo.getItemPackCode());
                    hcChangeitemLog.setChangeItemCode(code[i]);
                    hcChangeitemLog.setItemPackName(saveHcChargeItemVo.getItemPackName());
                    hcChangeitemLog.setChangeItemName(name[i]);
                    hcChangeitemLog.setOperDate(saveHcChargeItemVo.getOperDate());
                    hcChangeitemLog.setOperId(saveHcChargeItemVo.getOperId());
                    hcChangeitemLog.setOperName(saveHcChargeItemVo.getOperName());
                    hcChangeitemLog.setPersonId(saveHcChargeItemVo.getPersonId());
                    hcChangeitemLog.setPersonVisitId(saveHcChargeItemVo.getPersonVisitId());
                    hcChangeitemLog.setItemNo(saveHcChargeItemVo.getItemNo());
                    hcChangeitemLogService.save(hcChangeitemLog);
                }

            }
            //3.已报到项目 按申请号 撤销被兑换项目申请， 发送 兑换项目申请


        }
    }
}
