package com.healt.cloud.checkup.mapper.pubComm;

import com.healt.cloud.checkup.vo.pubComm.InterfaceSourceVo;
import com.healt.cloud.checkup.vo.pubComm.PersonVisitAndInfoVo;
import com.healt.cloud.checkup.vo.pubComm.PublicDictVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author linklee
 * @create 2022-05-03 10:06
 */
@Mapper
public interface PubCommMapper {

    List<InterfaceSourceVo> findItemExternalInterface(@Param("hospitalId") String hospitalId, @Param("itemPackCode") String itemPackCode);

    List<PublicDictVo> findPublicDict(@Param("dictType") String dictType);

    String selectExamNo();

    String selectTestNo();

    String selectSysdate();

    List<PersonVisitAndInfoVo> selectPersonInfo(@Param("hospitalId") String hospitalId,
                                                @Param("personId") String personId,
                                                @Param("personVisitId") String personVisitId);

    @Select("select APPLY_SENDTO from v_hc_item_pack_dict a where a.item_pack_code = #{itemPackCode}")
    String selectApplySendTo(String itemPackCode);

    List<Map<String, Object>> selectExamClass(@Param("hospitalId") String hospitalId,
                                              @Param("itemPackCode") String itemPackCode);

    List<Map<String, Object>> selectItemVsCode(@Param("hospitalId") String hospitalId,
                                               @Param("itemPackCode") String itemPackCode);

    List<Map<String, Object>> selectPackVsItemVsExternal(@Param("hospitalId") String hospitalId,
                                                         @Param("itemPackCode") String itemPackCode);

    List<Map<String, Object>> selectPackVsClinic(@Param("hospitalId") String hospitalId,
                                                 @Param("itemPackCode") String itemPackCode,
                                                 @Param("itemClass") String itemClass);
}
