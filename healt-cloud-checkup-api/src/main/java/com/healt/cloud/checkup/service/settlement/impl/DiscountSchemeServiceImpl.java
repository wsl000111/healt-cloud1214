package com.healt.cloud.checkup.service.settlement.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.healt.cloud.checkup.entity.HcDiscountScheme;
import com.healt.cloud.checkup.entity.HcDiscountSchemeDetail;
import com.healt.cloud.checkup.mapper.appointmentReg.DiscountSchemeMapper;
import com.healt.cloud.checkup.service.HcDiscountSchemeDetailService;
import com.healt.cloud.checkup.service.HcDiscountSchemeService;
import com.healt.cloud.checkup.service.settlement.DiscountSchemeService;
import com.healt.cloud.checkup.vo.settlement.DtItemPackVo;
import com.healt.cloud.checkup.vo.settlement.HcDiscountSchemeDetailVo;
import com.healt.cloud.checkup.vo.settlement.HcDiscountSchemeVo;
import com.healt.cloud.checkup.vo.settlement.vo.SaveHcDiscountSchemeVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-05 14:25
 */
@Service
@AllArgsConstructor
public class DiscountSchemeServiceImpl implements DiscountSchemeService {

    private DiscountSchemeMapper discountSchemeMapper;

    private HcDiscountSchemeService hcDiscountSchemeService;
    private HcDiscountSchemeDetailService hcDiscountSchemeDetailService;

    @Override
    public List<DtItemPackVo> findDtItemPack(String hospitalId) {
        List<DtItemPackVo> list = discountSchemeMapper.findDtItemPack(hospitalId);
        if (list.size() == 0) {
            list.add(new DtItemPackVo());
        }
        return list;
    }

    @Override
    public List<HcDiscountScheme> findDiscountScheme() {
        List<HcDiscountScheme> list = discountSchemeMapper.findDiscountScheme();
        if (list.size() == 0) {
            list.add(new HcDiscountScheme());
        }
        return list;
    }

    @Override
    public List<HcDiscountSchemeDetail> findDiscountSchemeDetail() {
        List<HcDiscountSchemeDetail> list = discountSchemeMapper.findDiscountSchemeDetail();
        if (list.size() == 0) {
            list.add(new HcDiscountSchemeDetail());
        }
        return list;
    }

    @Override
    public String findSysdate() {
        String sysdate = discountSchemeMapper.findSysdate();
        if (sysdate == null) {
            sysdate = "";
        }
        return sysdate;
    }

    @Override
    @Transactional
    public void deleteDiscountSchemeAndDetail(String hospitalId, String schemeCode) {
        QueryWrapper wrapper1 = new QueryWrapper();
        wrapper1.eq("hospital_id",hospitalId);
        wrapper1.eq("scheme_code",schemeCode);
        hcDiscountSchemeService.remove(wrapper1);
        QueryWrapper wrapper2 = new QueryWrapper();
        wrapper2.eq("hospital_id",hospitalId);
        wrapper2.eq("scheme_code",schemeCode);
        hcDiscountSchemeDetailService.remove(wrapper2);
    }

    @Override
    @Transactional
    public void saveDiscountSchemeAndDetail(SaveHcDiscountSchemeVo saveHcDiscountScheme) {
        for (HcDiscountSchemeVo hcDiscountSchemeVo : saveHcDiscountScheme.getHcDiscountScheme()) {
            HcDiscountScheme hcDiscountScheme = new HcDiscountScheme();
            hcDiscountScheme.setSchemeName(hcDiscountSchemeVo.getSchemeName());
            hcDiscountScheme.setSchemeCode(hcDiscountSchemeVo.getSchemeCode());
            hcDiscountScheme.setEffectiveFlag(hcDiscountSchemeVo.getEffectiveFlag());
            hcDiscountScheme.setHospitalId(hcDiscountSchemeVo.getHospitalId());
            switch (hcDiscountSchemeVo.getStat()) {
                case "delete":
                    QueryWrapper<HcDiscountScheme> queryWrapper = new QueryWrapper<>();
                    queryWrapper.eq("scheme_code",hcDiscountSchemeVo.getSchemeCode());
                    queryWrapper.eq("hospital_id",hcDiscountSchemeVo.getHospitalId());
                    hcDiscountSchemeService.remove(queryWrapper);
                    break;
                case "add":
                    hcDiscountSchemeService.save(hcDiscountScheme);
                    break;
                case "update":
                    //UpdateWrapper<HcDiscountScheme> updateWrapper = new UpdateWrapper<HcDiscountScheme>(hcDiscountScheme);
                    QueryWrapper updateWrapper = new QueryWrapper();
                    updateWrapper.eq("scheme_code",hcDiscountSchemeVo.getSchemeCode());
                    updateWrapper.eq("hospital_id",hcDiscountSchemeVo.getHospitalId());
                    hcDiscountSchemeService.update(hcDiscountScheme,updateWrapper);
                    break;
            }
        }
        for (HcDiscountSchemeDetailVo hcDiscountSchemeDetailVo : saveHcDiscountScheme.getHcDiscountSchemeDetail()) {
            HcDiscountSchemeDetail hcDiscountSchemeDetail = new HcDiscountSchemeDetail();
            hcDiscountSchemeDetail.setSchemeCode(hcDiscountSchemeDetailVo.getSchemeCode());
            hcDiscountSchemeDetail.setItemAssemCode(hcDiscountSchemeDetailVo.getItemAssemCode());
            hcDiscountSchemeDetail.setDiscountClass(hcDiscountSchemeDetailVo.getDiscountClass());
            hcDiscountSchemeDetail.setDiscountRatio(hcDiscountSchemeDetailVo.getDiscountRatio());
            hcDiscountSchemeDetail.setDiscountPrice(hcDiscountSchemeDetailVo.getDiscountPrice());
            hcDiscountSchemeDetail.setHospitalId(hcDiscountSchemeDetailVo.getHospitalId());
            switch (hcDiscountSchemeDetailVo.getStat()) {
                case "delete":
                    QueryWrapper<HcDiscountSchemeDetail> queryWrapper = new QueryWrapper<>();
                    queryWrapper.eq("scheme_code",hcDiscountSchemeDetailVo.getSchemeCode());
                    queryWrapper.eq("item_assem_code",hcDiscountSchemeDetailVo.getItemAssemCode());
                    queryWrapper.eq("hospital_id",hcDiscountSchemeDetailVo.getHospitalId());
                    hcDiscountSchemeDetailService.remove(queryWrapper);
                    break;
                case "add":
                    hcDiscountSchemeDetailService.save(hcDiscountSchemeDetail);
                    break;
                case "update":
                    //UpdateWrapper<HcDiscountSchemeDetail> updateWrapper = new UpdateWrapper<HcDiscountSchemeDetail>(hcDiscountSchemeDetail);
                    QueryWrapper updateWrapper = new QueryWrapper();
                    updateWrapper.eq("scheme_code",hcDiscountSchemeDetailVo.getSchemeCode());
                    updateWrapper.eq("item_assem_code",hcDiscountSchemeDetailVo.getItemAssemCode());
                    updateWrapper.eq("hospital_id",hcDiscountSchemeDetailVo.getHospitalId());
                    hcDiscountSchemeDetailService.update(hcDiscountSchemeDetail,updateWrapper);
                    break;
            }
        }
    }

    @Override
    public void deleteDiscountSchemeDetail(String itemAssemCode, String schemeCode) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("item_assem_code",itemAssemCode);
        wrapper.eq("scheme_code",schemeCode);
        hcDiscountSchemeDetailService.remove(wrapper);
    }
}
