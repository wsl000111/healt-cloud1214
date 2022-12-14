package com.healt.cloud.checkup.mapper;

import com.healt.cloud.checkup.entity.VHisDeptDict;
import com.healt.cloud.checkup.vo.HospitalVo;
import com.healt.cloud.checkup.vo.sys.depart.VHisDeptDictVo;
import com.healt.cloud.checkup.vo.sys.knowledge.HcKnowledgeDictVoRsp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-08 16:49
 * @description: TODO
 */
@Mapper
public interface SysDictMapper {

    List<VHisDeptDictVo> findDtHisDepart(HospitalVo hospitalVo);

    List<VHisDeptDict> findDeptList(String hospitalCode);

    List findItemsDepartList();

    List<HcKnowledgeDictVoRsp> findKnowledgeDict(String hospitalId, String knowledgeType, String itemCode, String deptId, String diseaseCode, String inputCode, String itemNameFlag, String knowledgeName);
}

