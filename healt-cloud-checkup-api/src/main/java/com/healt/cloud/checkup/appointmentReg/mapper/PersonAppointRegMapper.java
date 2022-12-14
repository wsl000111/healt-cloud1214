package com.healt.cloud.checkup.appointmentReg.mapper;

import com.healt.cloud.checkup.vo.appointmentReg.personAppointReg.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author linklee
 * @create 2022-03-29 17:46
 */
@Mapper
public interface PersonAppointRegMapper {

    List<PackSetDictVo> findPackSetDict(@Param("hospitalId") String hospitalId);

    List<PackItemDictVo> findPackItemDict(@Param("hospitalId") String hospitalId);

    List<SetItemListVo> findSetItemList(@Param("hospitalId") String hospitalId, @Param("setCode") String setCode);

    List<SelectedItemsVo> findSelectedItems(@Param("hospitalId") String hospitalId, @Param("personId") String personId, @Param("personVisitId") Integer personVisitId);

    List<UnitListVo> findUnitList(@Param("hospitalId") String hospitalId);

    List<UnitVisitInfoVo> findUnitVisitInfo(@Param("hospitalId") String hospitalId,@Param("unitId") String unitId);

    List<UnitGroupVo> findUnitGroup(@Param("hospitalId") String hospitalId,@Param("unitId") String unitId,@Param("unitVisitId") Integer unitVisitId);

    List<PersonVisitInfoVo> findPersonVisitInfo(@Param("hospitalId") String hospitalId, @Param("personId") String personId);

    List<PersonInfoVo> findPersonInfo(@Param("hospitalId")String hospitalId, @Param("personId") String personId);

    void updateFinishedSign(@Param("hospitalId") String hospitalId,@Param("personId") String personId,@Param("personVisitId") Integer personVisitId);

    List<UnitGroupListVo> findUnitGroupList(@Param("hospitalId") String hospitalId,@Param("groupCode") String groupCode,@Param("unitId") String unitId,@Param("unitVisitId") Integer unitVisitId);

    void updateApplyNoPrint(@Param("hospitalId") String hospitalId,@Param("applyNo") String applyNo);

    Integer selectOrderId();

    @Update("update hcLAB_TEST_MASTER set PRINT_DATETIME=sysdate where test_no = #{applyNo}")
    void updatePrint(String applyNo);
}
