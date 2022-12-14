package com.healt.cloud.checkup.service.sysDict;

import com.healt.cloud.checkup.entity.DepartClass;
import com.healt.cloud.checkup.entity.DepartDict;
import com.healt.cloud.checkup.entity.VDepartDict;
import com.healt.cloud.checkup.entity.VInterfaceSource;
import com.healt.cloud.checkup.vo.HospitalVo;
import com.healt.cloud.checkup.vo.sys.depart.SaveDepartDictListVo;
import com.healt.cloud.checkup.vo.sys.depart.VHisDeptDictVo;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-05 14:17
 * @description: TODO
 */
public interface DepartService {

    List<VInterfaceSource> findDtInoerfaceSource(HospitalVo hospitalVo);

    List<DepartClass> findDtDepartClass(HospitalVo hospitalVo);

    List<DepartDict> findDtDepart(HospitalVo hospitalVo);

    void saveDepartDict(SaveDepartDictListVo departDictVo);

    List<VDepartDict> findVDtDepart(HospitalVo hospitalVo);

    List<VHisDeptDictVo> findDtHisDepart(HospitalVo hospitalVo);

    List<VHisDeptDictVo> findDeptList(String hospitalCode);
}
