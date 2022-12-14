package com.healt.cloud.checkup.printReport.mapper;

import com.healt.cloud.checkup.entity.HcResultDict;
import com.healt.cloud.checkup.printReport.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author linklee
 * @create 2022-06-01 8:58
 */
@Mapper
public interface PersonReportMapper {

    List<PrintPersonVo> findPrintPersonTotal(PrintPersonDictVo printPersonDictVo);

    List<PrintPersonVo> findPrintPerson(PrintPersonDictVo printPersonDictVo);

    List<PersonBasicInfoVo> findPersonBasicInfo(@Param("hospitalId") String hospitalId,@Param("personId") String personId,@Param("personVisitId") String personVisitId);

    List<PersonResultItemsVo> findPersonResultItems(@Param("hospitalId") String hospitalId, @Param("personId") String personId, @Param("personVisitId") String personVisitId);

    List<PersonAppendResultVo> findPersonAppendResult(@Param("hospitalId") String hospitalId, @Param("personId") String personId, @Param("personVisitId") String personVisitId);

    List<PersonResultVo> findPersonResult(@Param("hospitalId") String hospitalId, @Param("personId") String personId, @Param("personVisitId") String personVisitId);

    void updatePrint(@Param("hospitalId") String hospitalId,@Param("personId") String personId,@Param("personVisitId") String personVisitId,
                     @Param("userName") String userName,@Param("userRealName") String userRealName);

    @Select("select distinct "+
            "t.ITEM_ASSEM_NAME "+
            "from (select ITEM_ASSEM_NAME "+
            "from HC_RESULT_DICT "+
            "where HOSPITAL_ID = #{hospitalId,jdbcType=VARCHAR} "+
            "and PERSON_ID = #{personId,jdbcType=VARCHAR} "+
            "and PERSON_VISIT_ID = #{personVisitId,jdbcType=DECIMAL} "+
            "and ABNORMAL_FLAG is not null and ABNORMAL_FLAG >0 "+
            "order by "+
            "ASSEM_SORT_NO, ITEM_ORDER_NO) t ")
    List<String> selectExpAssemNameList(String hospitalId, String personId, String personVisitId);

    @Select("select * "+
            "from HC_RESULT_DICT "+
            "where HOSPITAL_ID = #{hospitalId,jdbcType=VARCHAR} "+
            "and PERSON_ID = #{personId,jdbcType=VARCHAR} "+
            "and PERSON_VISIT_ID = #{personVisitId,jdbcType=DECIMAL} "+
            "and ITEM_ASSEM_NAME = #{itemAssemName,jdbcType=VARCHAR} "+
            "and ABNORMAL_INDICATOR is not null "+
            "order by "+
            "ASSEM_SORT_NO, ITEM_ORDER_NO")
    List<HcResultDict> selectResultExp(String hospitalId, String personId, String personVisitId, String expAssemName);

    @Select("select distinct "+
            "t.DEPT_NAME "+
            "from (select DEPT_NAME "+
            "from HC_RESULT_DICT "+
            "where HOSPITAL_ID = #{hospitalId,jdbcType=VARCHAR} "+
            "and PERSON_ID = #{personId,jdbcType=VARCHAR} "+
            "and PERSON_VISIT_ID = #{personVisitId,jdbcType=DECIMAL} "+
            "order by "+
            "ASSEM_SORT_NO, ITEM_ORDER_NO ) t")
    List<String> selectDeptList(String hospitalId, String personId, String personVisitId);

    @Select("select distinct "+
            "t.ITEM_ASSEM_NAME "+
            "from (select ITEM_ASSEM_NAME "+
            "from HC_RESULT_DICT "+
            "where HOSPITAL_ID = #{hospitalId,jdbcType=VARCHAR} "+
            "and PERSON_ID = #{personId,jdbcType=VARCHAR} "+
            "and PERSON_VISIT_ID = #{personVisitId,jdbcType=DECIMAL} "+
            "and DEPT_NAME = #{deptName,jdbcType=VARCHAR} "+
            "order by "+
            "ASSEM_SORT_NO, ITEM_ORDER_NO) t")
    List<String> selectAssemNameList(String hospitalId, String personId, String personVisitId, String deptName);
}
