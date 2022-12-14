package com.healt.cloud.checkup.queryReport.service;

import com.healt.cloud.checkup.queryReport.vo.DoctorItemVo;
import com.healt.cloud.checkup.queryReport.vo.EditerItemVo;
import com.healt.cloud.checkup.queryReport.vo.FinalDocoterVo;
import com.healt.cloud.checkup.queryReport.vo.ItemPackVo;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-29 13:13
 */
public interface DoctorWorkService {

    public List<DoctorItemVo> findDoctorItem(String beginDate, String endDate);

    public List<EditerItemVo> findEditerItem(String beginDate, String endDate);

    public List<FinalDocoterVo> findFinalDocoter(String beginDate, String endDate);

    public List<ItemPackVo> findItemPack(String beginDate, String endDate);
}
