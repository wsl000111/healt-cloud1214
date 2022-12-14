package com.healt.cloud.checkup.service.business.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.healt.cloud.checkup.entity.*;
import com.healt.cloud.checkup.service.*;
import com.healt.cloud.checkup.vo.busniess.clinicPrice.ClinicItemPrice;
import com.healt.cloud.checkup.mapper.BusinessMapper;
import com.healt.cloud.checkup.service.business.PackVsClinicService;
import com.healt.cloud.checkup.service.ws.WebServiceClient;
import com.healt.cloud.checkup.service.ws.his.BdClinicpriceQueryVO;
import com.healt.cloud.checkup.service.ws.his.ClinicItemEntity;
import com.healt.cloud.checkup.service.ws.his.CodeTable;
import com.healt.cloud.checkup.service.ws.his.CodeTableItem;
import com.healt.cloud.checkup.vo.busniess.packClinic.SaveHcPackVsClincListVo;
import com.healt.cloud.checkup.vo.busniess.packClinic.SaveHcPackVsClincVo;
import com.healt.cloud.checkup.vo.busniess.packClinic.VClinicItemsVo;
import com.healt.cloud.common.utils.PropertiesUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * @author GuYue
 * @date 2022-03-11 9:55
 * @description: TODO
 */
@Service
public class PackVsClinicServiceImpl implements PackVsClinicService {
    @Autowired
    private VClinicItemClassService vClinicItemClassService;
    @Autowired
    private VClinicItemsService vClinicItemsService;
    @Autowired
    HcPackVsClinicService hcPackVsClinicService;
    @Autowired
    private BusinessMapper businessMapper;

    @Autowired
    private MdmClinicitemQueryService mdmClinicitemQueryService;

    @Autowired
    private MdmClinicpriceQueryService mdmClinicpriceQueryService;

    @Autowired
    private WebServiceClient client;

    private String isHis = PropertiesUtils.ISHIS;

    @Override
    public List<VClinicItemClass> findDtClinicItemClass() {
        List<VClinicItemClass> list = new ArrayList<>();
//        if("Y".equals(isHis)){
            List<CodeTable> codeTables = client.mdmCodeQuery("YB0003", "findDtClinicItemClass");
            for(CodeTable codeTable : codeTables){
                List<CodeTableItem> codeTableItems = codeTable.getItemList().getItem();
                for(CodeTableItem codeTableItem : codeTableItems){
                    VClinicItemClass vClinicItemClass = new VClinicItemClass();
                    vClinicItemClass.setClassCode(codeTableItem.getItemValue());
                    vClinicItemClass.setClassName(codeTableItem.getItemName());
                    vClinicItemClass.setSerialNo(codeTableItem.getItemId().intValue());
                    list.add(vClinicItemClass);
                }
            }
//        }else{
//            QueryWrapper<VClinicItemClass> queryWrapper = new QueryWrapper<>();
//            queryWrapper.orderByAsc("SERIAL_NO");
//            list = vClinicItemClassService.list();
//        }
        if(list.size() == 0){
            list.add(new VClinicItemClass());
        }
        return list;
    }

    @Override
    public List<VClinicItemsVo> findDtClinicItems(String itemClass) {
        List<VClinicItemsVo> list = businessMapper.findDtClinicItems(itemClass);
        if(list.size() == 0){
            list.add(new VClinicItemsVo());
        }
        return list;
    }

    @Override
    public List<HcPackVsClinic> findDtPackVsClinic(String hospitalCode, String itemPackCode) {
        QueryWrapper<HcPackVsClinic> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("HOSPITAL_ID", hospitalCode);
        queryWrapper.eq("ITEM_PACK_CODE", itemPackCode);
        List<HcPackVsClinic> list = hcPackVsClinicService.list(queryWrapper);
        if(list.size() == 0){
            list.add(new HcPackVsClinic());
        }
        return list;
    }

    @Autowired
    private VHcPackVsPriceService hcPackVsPriceService;

    @Autowired
    private HcItemPackDictService hcItemPackDictService;

    @Override
    public void saveHcPackVsClincList(SaveHcPackVsClincListVo saveHcPackVsClincListVo) {
        for(SaveHcPackVsClincVo saveHcPackVsClincVo : saveHcPackVsClincListVo.getSaveHcPackVsClincList()){
            switch (saveHcPackVsClincVo.getStat()){
                case "delete" :
                    for(HcPackVsClinic hcPackVsClinic : saveHcPackVsClincVo.getHcPackVsClinc()){
                        QueryWrapper<HcPackVsClinic> queryWrapper = new QueryWrapper<>();
                        queryWrapper.eq("ITEM_NO", hcPackVsClinic.getItemNo());
                        queryWrapper.eq("HOSPITAL_ID", hcPackVsClinic.getHospitalId());
                        queryWrapper.eq("ITEM_PACK_CODE", hcPackVsClinic.getItemPackCode());
                        hcPackVsClinicService.remove(queryWrapper);
                        UpdateWrapper<HcPackVsClinic> updateWrapper= new UpdateWrapper<>();
                        updateWrapper.setSql("ITEM_NO = ITEM_NO - 1");
                        updateWrapper.gt("ITEM_NO", hcPackVsClinic.getItemNo()); //gt 大于
                        updateWrapper.eq("HOSPITAL_ID", hcPackVsClinic.getHospitalId());
                        updateWrapper.eq("ITEM_PACK_CODE", hcPackVsClinic.getItemPackCode());
                        hcPackVsClinicService.update(updateWrapper);
                    }
                    break;
                case "add":
                    for(HcPackVsClinic hcPackVsClinic : saveHcPackVsClincVo.getHcPackVsClinc()){
                        hcPackVsClinicService.save(hcPackVsClinic);
                        //保存诊疗项目对照后，利用诊疗项目查找V_HC_PACK_VS_PRICE视图的 价表合计金额更新到 组合项目 hc_item_pack_dict 的 金额 ITEM_PACK_PRICE 上
                        LambdaQueryWrapper<VHcPackVsPrice> vHcPackVsPriceLambdaQueryWrapper = new LambdaQueryWrapper<>();
                        vHcPackVsPriceLambdaQueryWrapper.eq(VHcPackVsPrice::getItemPackCode, hcPackVsClinic.getItemPackCode());
                        List<VHcPackVsPrice> vHcPackVsPrices =  hcPackVsPriceService.list(vHcPackVsPriceLambdaQueryWrapper);
                        if(vHcPackVsPrices.size()>0){
                            BigDecimal chargePrice = new BigDecimal(0);
                            for(VHcPackVsPrice vHcPackVsPrice : vHcPackVsPrices){
                                chargePrice = chargePrice.add(vHcPackVsPrice.getChargePricemoney());
                            }
                            LambdaUpdateWrapper<HcItemPackDict> hcItemPackDictLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
                            hcItemPackDictLambdaUpdateWrapper.set(HcItemPackDict::getItemPackPrice, chargePrice)
                                    .eq(HcItemPackDict::getItemPackCode, hcPackVsClinic.getItemPackCode());
                            hcItemPackDictService.update(hcItemPackDictLambdaUpdateWrapper);
                        }
                    }
                    //hcPackVsClinicService.saveBatch(saveHcPackVsClincVo.getHcPackVsClinc());
                    break;
                case "update":
                    for(HcPackVsClinic hcPackVsClinic : saveHcPackVsClincVo.getHcPackVsClinc()){
                        UpdateWrapper<HcPackVsClinic> updateWrapper= new UpdateWrapper<>();
                        updateWrapper.eq("ITEM_NO", hcPackVsClinic.getItemNo());
                        updateWrapper.eq("HOSPITAL_ID", hcPackVsClinic.getHospitalId());
                        updateWrapper.eq("ITEM_PACK_CODE", hcPackVsClinic.getItemPackCode());
                        hcPackVsClinicService.update(hcPackVsClinic, updateWrapper);
                        //保存诊疗项目对照后，利用诊疗项目查找V_HC_PACK_VS_PRICE视图的 价表合计金额更新到 组合项目 hc_item_pack_dict 的 金额 ITEM_PACK_PRICE 上
                        LambdaQueryWrapper<VHcPackVsPrice> vHcPackVsPriceLambdaQueryWrapper = new LambdaQueryWrapper<>();
                        vHcPackVsPriceLambdaQueryWrapper.eq(VHcPackVsPrice::getItemPackCode, hcPackVsClinic.getItemPackCode());
                        List<VHcPackVsPrice> vHcPackVsPrices =  hcPackVsPriceService.list(vHcPackVsPriceLambdaQueryWrapper);
                        if(vHcPackVsPrices.size()>0){
                            BigDecimal chargePrice = new BigDecimal(0);
                            for(VHcPackVsPrice vHcPackVsPrice : vHcPackVsPrices){
                                chargePrice = chargePrice.add(vHcPackVsPrice.getChargePricemoney());
                            }
                            LambdaUpdateWrapper<HcItemPackDict> hcItemPackDictLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
                            hcItemPackDictLambdaUpdateWrapper.set(HcItemPackDict::getItemPackPrice, chargePrice)
                                    .eq(HcItemPackDict::getItemPackCode, hcPackVsClinic.getItemPackCode());
                            hcItemPackDictService.update(hcItemPackDictLambdaUpdateWrapper);
                        }
                    }
                    break;
            }
        }
    }

    @Override
    public void reloadMdmClinicitemQuery(String itemClass) {
        List<MdmClinicitemQuery> mdmClinicitemQueries = new ArrayList<>();
        List<ClinicItemEntity> list = client.mdmClinicitemQuery(itemClass, "reloadMdmClinicitemQuery");
        if(list!=null){
            for(ClinicItemEntity clinicItemEntity : list){
                if(!"1".equals(clinicItemEntity.getIsEnable())){
                    mdmClinicitemQueryService.removeById(clinicItemEntity.getClinicId());
                    continue;
                }
                MdmClinicitemQuery mdmClinicitemQuery = new MdmClinicitemQuery();
                BeanUtils.copyProperties(clinicItemEntity,mdmClinicitemQuery);
                mdmClinicitemQueries.add(mdmClinicitemQuery);
            }
            mdmClinicitemQueryService.saveOrUpdateBatch(mdmClinicitemQueries);
        }
    }
    @Override
    public void reloadMdmClinicpriceQuery(String itemClass, String itemCode) {
        List<MdmClinicpriceQuery> mdmClinicpriceQueries = new ArrayList<>();
        List<BdClinicpriceQueryVO> bdClinicpriceQueryVOS = client.mdmClinicpriceQuery(itemClass, itemCode, "reloadMdmClinicpriceQuery");
        if(bdClinicpriceQueryVOS!=null){
            for(BdClinicpriceQueryVO bdClinicpriceQueryVO : bdClinicpriceQueryVOS){
                if("0".equals(bdClinicpriceQueryVO.getIsEnable())){
                    mdmClinicpriceQueryService.removeById(bdClinicpriceQueryVO.getPriceId());
                    continue;
                }
                MdmClinicpriceQuery mdmClinicpriceQuery = new MdmClinicpriceQuery();
                BeanUtils.copyProperties(bdClinicpriceQueryVO, mdmClinicpriceQuery);
                mdmClinicpriceQueries.add(mdmClinicpriceQuery);
            }
            mdmClinicpriceQueryService.saveOrUpdateBatch(mdmClinicpriceQueries);
        }
    }

    @Override
    public List<ClinicItemPrice> findClinicItemPrice(String itemClass, String itemCode, String method) {
        List<ClinicItemPrice> list = new ArrayList<>();
        List<BdClinicpriceQueryVO> bdClinicpriceQueryVOS = client.mdmClinicpriceQuery(itemClass, itemCode, method);
        for(BdClinicpriceQueryVO bdClinicpriceQueryVO : bdClinicpriceQueryVOS){
            ClinicItemPrice clinicItemPrice = new ClinicItemPrice();
            clinicItemPrice.setItemClass(bdClinicpriceQueryVO.getItemClass());
            clinicItemPrice.setItemCode(bdClinicpriceQueryVO.getItemCode());
            clinicItemPrice.setItemName(bdClinicpriceQueryVO.getItemName());
            clinicItemPrice.setItemUnit(bdClinicpriceQueryVO.getItemUnit());
            clinicItemPrice.setPriceMoney(bdClinicpriceQueryVO.getPriceMoney());
            clinicItemPrice.setItemClassName(bdClinicpriceQueryVO.getItemClassName());
            clinicItemPrice.setIsEnable(bdClinicpriceQueryVO.getIsEnable());
            clinicItemPrice.setPyCode(bdClinicpriceQueryVO.getPyCode());
            clinicItemPrice.setLatestEnableTime(bdClinicpriceQueryVO.getLatestEnableTime());
            list.add(clinicItemPrice);
        }
        if(list.size() ==0 ){
            list.add(new ClinicItemPrice());
        }
        return list;
    }


}
