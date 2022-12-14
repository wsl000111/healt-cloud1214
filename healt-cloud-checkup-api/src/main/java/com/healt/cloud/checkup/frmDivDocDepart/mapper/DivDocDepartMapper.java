package com.healt.cloud.checkup.frmDivDocDepart.mapper;

import com.healt.cloud.checkup.entity.HcDiseaseDict;
import com.healt.cloud.checkup.entity.HcPersonInfo;
import com.healt.cloud.checkup.entity.HcPersonVisitInfo;
import com.healt.cloud.checkup.frmDivDocDepart.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-05-22 22:31
 * @description: TODO
 */
@Mapper
public interface DivDocDepartMapper {

    List<ValidateRightVo> validateRight(@Param("hospitalId") String hospitalId,
                                        @PathVariable("userId") String userId);

    List<FrmGetPersonVoRsp> findPerson(FrmGetPersonVo frmGetPersonVo);

    List<FrmGetUnitPersonVoRsp> findUnitPerson(FrmGetUnitPersonVo frmGetUnitPersonVo);

    List<FrmGetPersonVoRsp> findGetPersonHistory(@Param("hospitalId") String hospitalId,
                                                 @Param("personId") String personId,
                                                 @Param("deptId") String deptId);

    int findWorkInfo(@Param("deptId") String deptId,
                        @Param("value1") String value1,
                        @Param("value2") String value2);

    List<FrmPackVsItems> findPackVsItems(@Param("hospitalId") String hospitalId,
                                         @Param("itemPackCode") String itemPackCode);

    List<FrmPackItems> findPackItems(@Param("hospitalId") String hospitalId);

    List<FrmItemVsExternal> findItemVsExternal(@Param("hospitalId") String hospitalId,
                                               @Param("itemCode") String itemCode);

    List<FrmLabResultVo> findLabResult(@Param("testNoList") String testNoList);

    int countHcPersonAppregItems(@Param("personId") String personId,
                                 @Param("personVisitId") String personVisitId,
                                 @Param("finishedSign") String finishedSign);

    List<DeptNameListVo> findDeptNameList(String hospitalId, String deptId);

    List<ResultStatusListVo> findResultStatusList(String personId, String personVisitId);

    List<InitDeptVo> initDept(@Param("userName") String userName);

    List<InitDoctorVo> initDoctor(@Param("hospitalId") String hospitalId,
                                  @Param("deptId") String deptId);

    int findPersonCount(FrmGetPersonVo frmGetPersonVo);

    int findUnitPersonCount(FrmGetUnitPersonVo frmGetUnitPersonVo);

    List<FrmSetDivSourceVoRes> setDivSource(@Param("hospitalId") String hospitalId,
                                            @Param("deptId") String deptId,
                                            @Param("personId") String personId,
                                            @Param("visitId") String visitId);

    @Select("select nvl(t.result_status,'0') from HEALTHCHECKUP.Hc_Person_Visit_Info t where t.hospital_id=#{hospitalId} and t.person_id=#{personId} and t.person_visit_id=#{visitId}")
    String findResultStatus(@Param("hospitalId") String hospitalId,
                            @Param("personId") String personId,
                            @Param("visitId") String visitId);

    @Select("select t.before_date from HEALTHCHECKUP.Hc_Person_Visit_Info t where t.hospital_id=#{hospitalId} and t.person_id=#{personId} and t.person_visit_id=#{visitId}")
    Date findBeforeDate(@Param("hospitalId") String hospitalId,
                        @Param("personId") String personId,
                        @Param("visitId") String visitId);


    @Select("SELECT COUNT(*)  FROM hc_person_appreg_items t where t.hospital_id=#{hospitalId} and t.person_id=#{personId} and t.person_visit_id=#{visitId} and exists (select b.item_pack_code from v_hc_item_pack_dict b where  b.hospital_id = t.hospital_id and b.item_pack_code = t.ITEM_PACK_CODE and b.item_pack_name = t.item_pack_name and b.hc_dept_code = #{deptCode})")
    int findItemsCount(@Param("hospitalId") String hospitalId,
                       @Param("personId") String personId,
                       @Param("visitId") String visitId,
                       @Param("deptCode") String deptCode);

    @Select("select COUNT(*) from hc_settle_master a where a.hospital_id=#{hospitalId} and a.person_id=#{personId} and a.person_visit_id=#{visitId} and nvl(a.finish_flag,'0')= '0' and a.rcpt_no in (SELECT b.rcpt_no FROM hc_settle_detail b WHERE b.person_id = a.person_id AND b.person_visit_id = a.person_visit_id AND exists(select c.item_pack_code from v_hc_item_pack_dict c where c.hospital_id = b.hospital_id and c.item_pack_code = b.item_pack_code and c.item_pack_name = b.item_pack_name and c.HC_DEPT_CODE = #{deptCode}))")
    int findCountSettle(@Param("hospitalId") String hospitalId,
                        @Param("personId") String personId,
                        @Param("visitId") String visitId,
                        @Param("deptCode") String deptCode);

    @Select("select * from HC_PERSON_VISIT_INFO where hospital_id=#{hospitalId} and person_id=#{personId} and person_visit_id=#{visitId}")
    List<HcPersonVisitInfo> findHcPersonVisitInfo(@Param("hospitalId") String hospitalId,
                                                  @Param("personId") String personId,
                                                  @Param("visitId") String visitId);

    @Select("select * from hc_person_info where hospital_id=#{hospitalId} and person_id=#{personId}")
    List<HcPersonInfo> findHcPersonInfo(@Param("hospitalId") String hospitalId,
                                        @Param("personId") String personId);

    @Select("select CLASS_NAME from HEALTHCHECKUP.V_DEPART_DICT where hospital_id=#{hospitalId} and dept_id=#{deptId}")
    String findClassName(@Param("hospitalId") String hospitalId,
                         @Param("deptId") String deptId);


    @Select("select count(*) from HEALTHCHECKUP.Hc_Person_Appreg_Items where hospital_id=#{hospitalId} and dept_id=#{deptId} and person_id=#{personId} and person_visit_id=#{visitId} and  FINISHED_SIGN='未完成' and  nvl(APPLY_NO,'0')<>'0'")
    int findCountApply(@Param("hospitalId") String hospitalId,
                       @Param("deptId") String deptId,
                       @Param("personId") String personId,
                       @Param("visitId") String visitId);


    @Select("SELECT hc_person_info.NAME,hc_person_info.SEX, hc_person_info.BARTHDAY,hc_unit_info.UNIT_NAME,hpv.person_id,hpv.person_visit_id,hpv.UNIT_ID,hpv.UNIT_VISIT_ID,hpv.AGE,hpv.PERSON_CHARGE,hpv.RESULT_STATUS,hpv.MARITAL_STATUS" +
            "  FROM hc_person_info, hc_person_visit_info hpv, hc_unit_info WHERE hc_person_info.hospital_id = hpv.hospital_id    and hc_person_info.person_id = hpv.person_id    and hpv.hospital_id = hc_unit_info.hospital_id(+) and hpv.unit_id = hc_unit_info.unit_id(+)  and hpv.hospital_id=#{hospitalId} and hpv.person_id=#{personId} and hpv.person_visit_id=#{visitId}")
    List<SetPersonInfoVo> findSetPersonInfo(@Param("hospitalId") String hospitalId,
                                            @Param("personId") String personId,
                                            @Param("visitId") String visitId);

    List<GetHcResultVo> findHcResult(@Param("hospitalId") String hospitalId,
                                     @Param("personId") String personId,
                                     @Param("visitId") String visitId,
                                     @Param("packCode") String packCode,
                                     @Param("deptId") String deptId);

    List<FrmGetHcAppregItem> findHcAppregItem(@Param("hospitalId") String hospitalId,
                                              @Param("personId") String personId,
                                              @Param("personVisitId") String personVisitId,
                                              @Param("packCode") String packCode);

    List<HcAppregItemsVo> findHcAppregItems(@Param("hospitalId") String hospitalId,
                                            @Param("personId") String personId,
                                            @Param("visitId") String visitId,
                                            @Param("deptClass") String deptClass);

    @Select("select RESULT_HANDLE from healthcheckup.v_hc_item_pack_dict where hospital_id=#{hospitalId} and item_pack_code=#{itemPackCode}")
    String findResultHandle(@Param("hospitalId") String hospitalId,
                            @Param("itemPackCode") String itemPackCode);

    @Select("select  conclusion_text  From  HEALTHCHECKUP.HC_DEPT_CONCLUSION_DICT where  hospital_id =#{hospitalId} and HC_DEPT_CODE = #{hcDeptCode} And EFFECTIVE_FLAG = '1' And rownum =1")
    String findUpdateConclusion(@Param("hospitalId") String hospitalId,
                                @Param("hcDeptCode") String hcDeptCode);

    @Select("select DEPT_ID,DEPT_NAME,CLASS_NAME  from healthcheckup.v_depart_dict a where a.hospital_id=#{hospitalId} union all SELECT '&&&&&' dept_id,'&&&&&' dept_name,'普通' class_name FROM dual ")
    List<LoadDeptDictVo> loadDeptDict(@Param("hospitalId") String hospitalId);

    @Select("select distinct b.disease_name as DISEASE_GROUP_NAME ,a.disease_code as DISEASE_GROUP_CODE ,nvl(a.dept_id,'&&&&&') hc_dept_code from hc_knowledge_dict a ,hc_disease_dict b" +
            " where a.hospital_id = b.hospital_id" +
            "  and  a.disease_code = b.disease_code " +
            "  and a.hospital_id = #{hospitalId}" +
            " and ( a.dept_id is null or a.dept_id = #{deptId})")
    List<DeptDiseaseGroupVo> getDeptDiseaseGroup(String hospitalId, String deptId);

    @Select("select b.HOSPITAL_ID, b.DISEASE_CODE, b.DISEASE_NAME, b.SUGGEST_TEXT, b.KNOWLEDGE_TEXT, b.INPUT_CODE, b.INPUT_CODE_CUST, b.DIAG_WHERE, b.DIAG_DEGREE, b.DIAG_CLASS from hc_knowledge_dict a, hc_disease_dict b  where a.hospital_id = b.hospital_id" +
            "  and  a.disease_code = b.disease_code " +
            "  and a.hospital_id = #{hospitalId}" +
            " and ( a.dept_id is null or a.dept_id = #{deptId})" +
            " and b.disease_code = #{diseaseCode}")
    List<HcDiseaseDict> getHcDiseaseDict(String hospitalId, String diseaseCode, String deptId);

    @Update("Update hc_person_visit_info Set result_status =(Select case count(*) when 0 then '2' else '1' end  From hc_person_appreg_items where person_id = #{ls_p_id} And person_visit_id = #{li_p_visit_id} And finished_sign = '未完成' and not exists(select v_hc_item_pack_dict.ITEM_PACK_CODE from v_hc_item_pack_dict where v_hc_item_pack_dict.ITEM_PACK_CODE = hc_person_appreg_items.item_pack_code and auto_finished = '1')) where person_id = #{ls_p_id} And person_visit_id = #{li_p_visit_id}")
    boolean updatePersonVisitInfo(String ls_p_id, int li_p_visit_id);

    @Update("Update hc_person_visit_info Set result_status =(Select case count(*) when 0 then '2' else '1' end  From hc_person_appreg_items where person_id = #{personId} And person_visit_id = #{personVisitId} And finished_sign = '未完成' and not exists(select v_hc_item_pack_dict.ITEM_PACK_CODE from v_hc_item_pack_dict where v_hc_item_pack_dict.ITEM_PACK_CODE = hc_person_appreg_items.item_pack_code and auto_finished = '1')) where person_id = #{personId} And person_visit_id = #{personVisitId}")
    boolean updatePersonVisitInfoDepart(String personId, String personVisitId);

    @Update("update  HEALTHCHECKUP.Hc_Person_Appreg_Items set ${values} where hospital_id=#{hospitalId} and person_id=#{personId} and person_id=#{personId} and person_visit_id=#{personVisitId} and ITEM_PACK_CODE=#{itemPackCode}")
    void updateHcPersonAppregItems(String values, String hospitalId, String personId, String personVisitId, String itemPackCode);

    @Select( "SELECT LAB_RESULT.REPORT_ITEM_NAME, LAB_RESULT.REPORT_ITEM_CODE,LAB_RESULT.RESULT, LAB_RESULT.UNITS,LAB_RESULT.ABNORMAL_INDICATOR,"+
            "LAB_RESULT.INSTRUMENT_ID,LAB_RESULT.RESULT_DATE_TIME,LAB_RESULT.PRINT_CONTEXT,LAB_RESULT.TEST_NO FROM HCLAB_RESULT LAB_RESULT, hclab_test_master LAB_TEST_MASTER "+
            "WHERE LAB_RESULT.TEST_NO = LAB_TEST_MASTER.TEST_NO and LAB_RESULT.TEST_NO in ( ${testNoList} ) AND LAB_TEST_MASTER.RESULT_STATUS = '4'")
    List<FrmLabResultVo> findLabResultOut1(String testNoList);
}
