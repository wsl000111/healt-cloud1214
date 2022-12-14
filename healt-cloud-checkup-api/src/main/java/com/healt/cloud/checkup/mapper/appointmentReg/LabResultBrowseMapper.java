package com.healt.cloud.checkup.mapper.appointmentReg;

import com.healt.cloud.checkup.entity.InterfaceSource;
import com.healt.cloud.checkup.physicalExa.vo.*;
import com.healt.cloud.checkup.vo.member.PackVsItemsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-20 10:57
 */
@Mapper
public interface LabResultBrowseMapper {

    List<InterfaceSource> findHisConnStr(@Param("hospitalId") String hospitalId);

    List<PersonListVo> findPersonListTotal(@Param("hospitalId") String hospitalId, @Param("unitId") String unitId, @Param("unitVisitId") String unitVisitId,
                                           @Param("personId") String personId, @Param("personVisitId") String personVisitId, @Param("name") String name);

    List<PersonListVo> findPersonList(@Param("hospitalId") String hospitalId,@Param("unitId") String unitId,@Param("unitVisitId") String unitVisitId,
                            @Param("personId") String personId,@Param("personVisitId") String personVisitId,@Param("name") String name,
                            @Param("pageNum") int pageNum,@Param("pageSize") int pageSize);

    List<LabTestMasterVo> findLabTestMaster(@Param("txzbl") String txzbl);

    String findResultHandle(@Param("hospitalId") String hospitalId,@Param("itemPackCode") String itemPackCode);

    List<UnitVisitVo> findUnitVisit(@Param("hospitalId") String hospitalId, @Param("personId") String personId, @Param("personVisitId") Integer personVisitId);

    List<DoctorNoteVo> findDoctorNote(@Param("testNo") String testNo);

    void updateHcPersonVisitInfo(@Param("personId") String personId,@Param("personVisitId") Integer personVisitId);

    List<LabResultVo> findLabResult(@Param("testNo") String testNo);

    List<PackVsItemsVo> findPackVsItems(@Param("hospitalId") String hospitalId,@Param("itemPackCode") String itemPackCode);

    List<ItemVsExternalVo> findItemVsExternal(@Param("hospitalId") String hospitalId,@Param("hcItemCode") String hcItemCode);

    List<LabResult1Vo> findLabResult1(@Param("testNo") String testNo);

    List<HcResultVo> findHcResult(@Param("hcDeptCode") String hcDeptCode,@Param("hospitalId") String hospitalId,@Param("personId") String personId,@Param("personVisitId") String personVisitId,@Param("itemAssemCode") String itemAssemCode);

    List<HcDeptResultItemsVo> findHcDeptResultItems(@Param("hospitalId") String hospitalId,@Param("personId") String personId, @Param("personVisitId") Integer personVisitId, @Param("deptId") String deptId, @Param("packCode") String packCode);

    List<HcAppregItemsVo> findHcAppregItems(@Param("hospitalId") String hospitalId, @Param("personId") String personId, @Param("personVisitId") Integer personVisitId, @Param("className") String className);

    List<HcAppregItems1Vo> findHcAppregItems1(@Param("hospitalId") String hospitalId, @Param("personId") String personId, @Param("personVisitId") Integer personVisitId, @Param("itemPackCode") String itemPackCode);

    List<DeptResultItemsVo> findDeptResultItems(@Param("hospitalId") String hospitalId,@Param("personId") String personId, @Param("personVisitId") Integer personVisitId, @Param("deptId") String deptId);

    List<VLabResultVo> findVLabResult(@Param("testNo") String testNo);

}
