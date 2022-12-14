package com.healt.cloud.checkup.appointmentReg.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.healt.cloud.checkup.entity.HcPersonAppregItems;
import com.healt.cloud.checkup.appointmentReg.service.ModifyItemStatusService;
import com.healt.cloud.checkup.service.HcPersonAppregItemsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author linklee
 * @create 2022-06-24 16:36
 */
@Service
@AllArgsConstructor
public class ModifyItemStatusServiceImpl implements ModifyItemStatusService {

    private HcPersonAppregItemsService hcPersonAppregItemsService;

    @Override
    public void updateItemFinshedSign(String hospitalId, String personId, String personVisitId, String itemPackCode, String itemNo, String editerId, String editerName) {
        UpdateWrapper<HcPersonAppregItems> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("FINISHED_SIGN", "完成")
                .set("FINISHED_DATE", new Date())
                .set("EDITER_ID", editerId)
                .set("EDITER_NAME", editerName);
        updateWrapper.eq("hospital_id", hospitalId)
                .eq("person_id", personId)
                .eq("person_visit_id", personVisitId)
                .eq("item_pack_code", itemPackCode)
                .eq("item_no", itemNo);
        hcPersonAppregItemsService.update(updateWrapper);
    }

    @Override
    public void updateItemFinshedSignToBeContinued(String hospitalId, String personId, String personVisitId, String itemPackCode, String itemNo, String editerId, String editerName) {
        UpdateWrapper<HcPersonAppregItems> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("FINISHED_SIGN", "未完成")
                .set("FINISHED_DATE", "")
                .set("EDITER_ID", editerId)
                .set("EDITER_NAME", editerName);
        updateWrapper.eq("hospital_id", hospitalId)
                .eq("person_id", personId)
                .eq("person_visit_id", personVisitId)
                .eq("item_pack_code", itemPackCode)
                .eq("item_no", itemNo);
        hcPersonAppregItemsService.update(updateWrapper);
    }

    @Override
    public void updateItemFinshedSignPostpone(String hospitalId, String personId, String personVisitId, String itemPackCode, String itemNo, String editerId, String editerName) {
        UpdateWrapper<HcPersonAppregItems> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("FINISHED_SIGN", "延期")
                .set("FINISHED_DATE", new Date())
                .set("EDITER_ID", editerId)
                .set("EDITER_NAME", editerName);
        updateWrapper.eq("hospital_id", hospitalId)
                .eq("person_id", personId)
                .eq("person_visit_id", personVisitId)
                .eq("item_pack_code", itemPackCode)
                .eq("item_no", itemNo);
        hcPersonAppregItemsService.update(updateWrapper);
    }
}
