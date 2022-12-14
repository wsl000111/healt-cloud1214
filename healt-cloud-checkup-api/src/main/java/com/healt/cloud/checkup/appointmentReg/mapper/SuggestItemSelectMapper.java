package com.healt.cloud.checkup.appointmentReg.mapper;

import com.healt.cloud.checkup.appointmentReg.vo.suggestItemSelect.SuggestDepartDictVo;
import com.healt.cloud.checkup.appointmentReg.vo.suggestItemSelect.SuggestDictVo;
import com.healt.cloud.checkup.appointmentReg.vo.suggestItemSelect.SuggestVDepartDictVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-05-31 15:56
 * @description: TODO
 */
@Mapper
public interface SuggestItemSelectMapper {

    @Select("select a.dept_id,a.dept_name,a.class_id,a.sort_no  from depart_dict a  union all SELECT '****' dept_id,    '****' dept_name,    '普通' class_id,       null  sort_no   FROM dual ")
    public List<SuggestDepartDictVo> loadDepartDict();

    @Select("select DEPT_ID,DEPT_NAME,CLASS_NAME,SORT_NO,INPUT_CODE from healthcheckup.v_depart_dict a where a.hospital_id=#{hospitalId} union all SELECT '****' dept_id,'****' dept_name,'普通' class_name,null SORT_NO, '****' input_code  FROM dual  ")
    List<SuggestVDepartDictVo> loadVDepartDict(String hospitalId);

    @Select("select a.HOSPITAL_ID ,a.knowledge_code as SUGGEST_CODE,a.knowledge_name as SUGGEST_NAME, decode(a.disease_code,null,2,1) as REC_CLASS ,a.dept_id,a.guide_suggest as SUGGEST_TEXT,"+
            "'0' as KNOWLEDGE_TEXT, a.INPUT_CODE from hc_knowledge_dict a where a.hospital_id = #{hospitalId} and a.dept_id =#{deptId} and a.guide_suggest is not null")
    List<SuggestDictVo> loadSuggestDict(String hospitalId, String deptId);
}
