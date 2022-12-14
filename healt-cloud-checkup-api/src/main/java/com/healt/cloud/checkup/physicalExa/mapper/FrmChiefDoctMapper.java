package com.healt.cloud.checkup.physicalExa.mapper;

import com.healt.cloud.checkup.entity.HcDeptResultDict;
import com.healt.cloud.checkup.physicalExa.vo.frmChiefDoct.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * @author GuYue
 * @date 2022-05-26 0:18
 * @description: TODO
 */
@Mapper
public interface FrmChiefDoctMapper {

    @Select("select FIRST_DOCOTER from hc_person_visit_info a where a.hospital_id = #{hospitalCode} and a.person_id =#{personId} and a.person_visit_id =#{visitId}")
    String firstDocoter(String hospitalCode, String personId, String visitId);

    @Update("update hc_person_appreg_items a set a.finished_sign = '完成' where a.hospital_id = #{hospitalCode} and a.person_id = #{personId} and a.person_visit_id = #{visitId} and a.finished_sign = '未完成' and a.item_pack_code in (select b.ITEM_PACK_CODE from v_hc_item_pack_dict b where b.AUTO_FINISHED = '1')")
    void autoFinishedSign(String hospitalCode, String personId, String visitId);

    @Select("select ITEM_PACK_NAME from hc_person_appreg_items a where a.hospital_id = #{hospitalCode} and a.person_id = #{personId} and a.person_visit_id = #{visitId} and a.finished_sign = '未完成' and a.item_pack_code not in (select b.ITEM_PACK_CODE from v_hc_item_pack_dict b where b.AUTO_FINISHED = '1')")
    List<Map<String, String>> getItemPackName(String hospitalCode, String personId, String visitId);

    @Select("SELECT * FROM ( SELECT TMP.*, ROWNUM ROW_ID FROM (select a.person_id,a.name,a.sex,b.unit_name,b.unit_id,b.person_visit_id,b.unit_visit_id,b.age,b.marital_status,b.before_date,b.appoints_date,b.result_status, case  when  to_char(b.print_date,'yyyymmdd') is null then '未打印' else '已打印' end print_flag from  Hc_Person_info a,HC_Person_visit_info b where a.hospital_id = b.hospital_id and a.person_id = b.person_id ${strWhere} ) TMP WHERE ROWNUM <= ${pageNum*pageSize}) WHERE ROW_ID > ${(pageNum-1)*pageSize}")
    List<ChiefPersonVisitInfoVo> searchChiefDoct(String strWhere, int pageNum, int pageSize);

    @Select("select count(*) from  Hc_Person_info a,HC_Person_visit_info b where a.hospital_id = b.hospital_id and a.person_id = b.person_id ${strWhere}")
    int searchChiefDoctCount(String strWhere);

    @Select("select a.item_pack_name,a.finished_sign ,b.dept_name,to_char(a.register_date,'yyyy-mm-dd hh24:mi:ss') register_date, a.doctor_id, a.doctor_name " +
            " from hc_person_appreg_items a,v_hc_item_pack_dict b where a.hospital_id = b.HOSPITAL_ID and a.item_pack_code = b.ITEM_PACK_CODE " +
            " and a.hospital_id = #{hospitalId} and a.person_id = #{personId} and a.person_visit_id =#{visitId}")
    List<ChiemItemStatusVo> chiemItemStatus(String hospitalId, String personId, String visitId);

    @Select("select HOSPITAL_ID hospitalId, PERSON_ID personId, PERSON_VISIT_ID personVisitId, DEPT_ID deptId, DEPT_NAME deptName, " +
            "HC_RESULT_DATE hcResultDate, MEDICAL_HISTORY medicalHistory, CONCLUSION_TEXT conclusionText, SUGGEST_TEXT suggestText, " +
            "MED_IN_DEPT_REPORT medInDeptReport, DOCTOR dortor, DOCTOR_NAME doctorName, OPERATOR opeartor, OPERATOR_NAME operatorName, " +
            "JUDGEMENT judgement, CHIEF_SUM_FLAG chiefSumFlag from HC_DEPT_RESULT_DICT  where hospital_id = #{hospitalId} and person_id = #{personId} and person_visit_id = #{visitId}")
    List<HcDeptResultDict> deptchiefaudit(String hospitalId, String personId, String visitId);

    @Select("select a.dept_name,a.SUGGEST_TEXT from HC_DEPT_RESULT_DICT a,depart_dict b where a.hospital_id = b.hospital_id and a.dept_id = b.dept_id and a.hospital_id =#{hospitalId}"+
            " and a.person_id = #{personId} and a.person_visit_id =#{visitId} and a.SUGGEST_TEXT is not null  order by  b.SORT_NO asc")
    List<DtSuggestVo> dtSuggest(String hospitalId, String personId, String visitId);

    @Select("select a.content from HC_append_result a "+
            " where a.hospital_id = #{hospitalId} and a.person_id = #{personId} and a.person_visit_id = #{visitId} ")
    String dtContent(String hospitalId, String personId, String visitId);

    @Select("SELECT * FROM ( SELECT TMP.*, ROWNUM ROW_ID FROM (" +
            "select a.person_id,a.name,a.sex,b.unit_name,b.unit_id,b.person_visit_id,b.unit_visit_id,b.age,b.marital_status," +
            "b.before_date,b.appoints_date,b.result_status " +
            "from Hc_Person_info a, HC_Person_visit_info b " +
            "where a.hospital_id = b.hospital_id and a.person_id = b.person_id and a.hospital_id = #{hospitalId} " +
            "and b.unit_id = #{unitId} and b.unit_visit_id = #{unitVisitId}) TMP WHERE ROWNUM <= ${pageNum*pageSize}) WHERE ROW_ID > ${(pageNum-1)*pageSize}")
    List<UnitPersonInfoVo> selectUnitPersonInfo(String hospitalId, String unitId, int unitVisitId, int pageSize, int pageNum);

    @Select("select count(*) from Hc_Person_info a, HC_Person_visit_info b " +
            "where a.hospital_id = b.hospital_id and a.person_id = b.person_id and a.hospital_id = #{hospitalId} " +
            "and b.unit_id = #{unitId} and b.unit_visit_id = #{unitVisitId}")
    int selectUnitPersonInfoTotal(String hospitalId, String unitId, int unitVisitId, int pageSize, int pageNum);

    @Select("select a.person_id,a.name,a.sex,b.unit_name,b.unit_id,b.person_visit_id,b.unit_visit_id,b.age,b.marital_status," +
            "b.before_date,b.appoints_date,b.result_status " +
            "from Hc_Person_info a, HC_Person_visit_info b " +
            "where a.hospital_id = b.hospital_id and a.person_id = b.person_id " +
            "and a.hospital_id = #{hospitalId} and b.person_id = #{perosnId}")
    List<PersonHistoryInfoVo> getPersonHistory(String hospitalId, String perosnId);

    @Select("select distinct a.knowledge_name as guide_class  from hc_knowledge_dict a where a.knowledge_type = #{knowledgeType} and a.hospital_id = #{hospitalId}")
    List<Map<String, String>> findGuideClass(String knowledgeType, String hospitalId);

    @Select("select a.knowledge_name  as guide_class ,a.knowledge_code,a.guide_suggest as guide_content,a.sort_no from hc_knowledge_dict a where a.knowledge_type = #{knowledgeType} and a.hospital_id = #{hospitalId}")
    List<GuideInfoVo> findGuideInfo(String knowledgeType, String hospitalId);
}
