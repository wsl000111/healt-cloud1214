package com.healt.cloud.checkup.queryReport.service.impl;

import com.healt.cloud.checkup.mapper.appointmentReg.DoctorWorkMapper;
import com.healt.cloud.checkup.queryReport.service.DoctorWorkService;
import com.healt.cloud.checkup.queryReport.vo.DoctorItemVo;
import com.healt.cloud.checkup.queryReport.vo.EditerItemVo;
import com.healt.cloud.checkup.queryReport.vo.FinalDocoterVo;
import com.healt.cloud.checkup.queryReport.vo.ItemPackVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-29 13:14
 */
@Service
@AllArgsConstructor
public class DoctorWorkServiceImpl implements DoctorWorkService {

    private DoctorWorkMapper doctorWorkMapper;

    @Override
    public List<DoctorItemVo> findDoctorItem(String beginDate, String endDate) {
        List<DoctorItemVo> list = doctorWorkMapper.findDoctorItem(beginDate,endDate);
        if (list.size() == 0) {
            list.add(new DoctorItemVo());
        }
        return list;
    }

    @Override
    public List<EditerItemVo> findEditerItem(String beginDate, String endDate) {
        List<EditerItemVo> list = doctorWorkMapper.findEditerItem(beginDate,endDate);
        if (list.size() == 0) {
            list.add(new EditerItemVo());
        }
        return list;
    }

    @Override
    public List<FinalDocoterVo> findFinalDocoter(String beginDate, String endDate) {
        List<FinalDocoterVo> list = doctorWorkMapper.findFinalDocoter(beginDate,endDate);
        if (list.size() == 0) {
            list.add(new FinalDocoterVo());
        }
        return list;
    }

    @Override
    public List<ItemPackVo> findItemPack(String beginDate, String endDate) {
        List<ItemPackVo> list = doctorWorkMapper.findItemPack(beginDate,endDate);
        if (list.size() == 0) {
            list.add(new ItemPackVo());
        }
        return list;
    }
}
