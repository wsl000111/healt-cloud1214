package com.healt.cloud.checkup.service.business.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.healt.cloud.checkup.mapper.MyHcPackVsPriceMapper;
import com.healt.cloud.checkup.service.business.MyHcPackVsPriceService;
import com.healt.cloud.checkup.entity.HcPackVsPrice;
import com.healt.cloud.checkup.service.HcPackVsPriceService;
import com.healt.cloud.checkup.service.ws.WebServiceClient;
import com.healt.cloud.checkup.service.ws.his.BdClinicpriceQueryVO;
import com.healt.cloud.checkup.vo.busniess.clinicPrice.HcPersonPriceVo;
import com.healt.cloud.resultex.exception.CommonException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-07-14 16:22
 * @description: TODO
 */
@Service
public class MyHcPackVsPriceServiceImpl implements MyHcPackVsPriceService {

    @Autowired
    private HcPackVsPriceService hcPackVsPriceService;

    @Autowired
    private MyHcPackVsPriceMapper myHcPackVsPriceMapper;

    @Autowired
    private WebServiceClient client;

    @Override
    public List<HcPackVsPrice> findPackVsPriceList(String itemPackCode, String hospitalId) {
        QueryWrapper<HcPackVsPrice> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("ITEM_PACK_CODE", itemPackCode);
        queryWrapper.eq("hospital_id", hospitalId);
        queryWrapper.orderByAsc("ITEM_NO");
        List<HcPackVsPrice> list = hcPackVsPriceService.list(queryWrapper);
        if (list.size() == 0){
            list.add(new HcPackVsPrice());
        }
        return list;
    }

    @Override
    public void findAndSaveHcPackVsPrice(String hospitalId, String itemPackCode, String clinicItemCode, String clinicItemName) {
        List<BdClinicpriceQueryVO> bdClinicpriceQueryVOS = client.mdmClinicpriceQuery("*", clinicItemCode, "findAndSaveHcPackVsPrice");
        if(bdClinicpriceQueryVOS == null){
            throw new CommonException(500, clinicItemName+":没有价表项目");
        }
        List<HcPackVsPrice> list = new ArrayList<>();
        int i = 0;
        for(BdClinicpriceQueryVO item : bdClinicpriceQueryVOS){
            HcPackVsPrice hcPackVsPrice = new HcPackVsPrice();
            hcPackVsPrice.setItemPackCode(itemPackCode);
            hcPackVsPrice.setItemNo(i++);
            hcPackVsPrice.setItemClass(item.getItemClass());
            hcPackVsPrice.setClinicItemCode(clinicItemCode);
            hcPackVsPrice.setClinicItemName(clinicItemName);
            hcPackVsPrice.setChargeItemCode(item.getItemCode());
            hcPackVsPrice.setChargeItemName(item.getItemName());
            hcPackVsPrice.setHospitalId(hospitalId);
            hcPackVsPrice.setChargeItemClass(item.getItemClass());
            hcPackVsPrice.setChargePricemoney(new BigDecimal(item.getPriceMoney()));
            hcPackVsPrice.setItemUnit(item.getItemUnit());
            list.add(hcPackVsPrice);
        }
        hcPackVsPriceService.saveOrUpdateBatch(list);
    }

    @Override
    public List<HcPersonPriceVo> findHcPersonPriceByUnit(String hospitalId, String unitId, String unitVisitId) {
        List<HcPersonPriceVo> list = myHcPackVsPriceMapper.findHcPersonPriceByUnit(hospitalId, unitId, unitVisitId);
        if(list == null||list.size()==0){
            list = new ArrayList<>();
            list.add(new HcPersonPriceVo());
        }
        return list;
    }

    @Override
    public List<HcPersonPriceVo> findHcPersonPriceByPerson(String hospitalId, String personId, String personVisitId) {
        List<HcPersonPriceVo> list = myHcPackVsPriceMapper.findHcPersonPriceByPerson(hospitalId, personId, personVisitId);
        if(list == null||list.size()==0){
            list = new ArrayList<>();
            list.add(new HcPersonPriceVo());
        }
        return list;
    }

    @Override
    public List<HcPersonPriceVo> findHcPersonPriceByUnitPerson(String hospitalId, String unitId, String unitVisitId, String personIdStr) {
        String personIdStrWhe = "(";
        if(StringUtils.isNotEmpty(personIdStr)){
            String[] personIdAry = personIdStr.split(",");
            for(int i=0;i<personIdAry.length;i++){
                personIdStrWhe += "'"+personIdAry[i]+"',";
            }
            personIdStrWhe = personIdStrWhe.substring(0, personIdStrWhe.length()-1);
        }
        personIdStrWhe += ")";
        List<HcPersonPriceVo> list = myHcPackVsPriceMapper.findHcPersonPriceByUnitPerson(hospitalId, unitId, unitVisitId, personIdStrWhe);
        if(list == null||list.size()==0){
            list = new ArrayList<>();
            list.add(new HcPersonPriceVo());
        }
        return list;
    }
}
