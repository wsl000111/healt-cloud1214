package com.healt.cloud.checkup.appointmentReg.mapper;

import com.healt.cloud.checkup.vo.appointmentReg.modifyPersonItems.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author linklee
 * @create 2022-04-15 14:42
 */
@Mapper
public interface ModifyPersonItemsMapper {

    List<ModifySelectedItemsVo> findModifySelectedItems(@Param("hospitalId") String hospitalId, @Param("personId") String personId, @Param("personVisitId") Integer personVisitId);

    List<SelectedPackSetVo> findSelectedPackSetVo(@Param("hospitalId") String hospitalId, @Param("personId") String personId, @Param("personVisitId") Integer personVisitId);

    List<PublicDictVo> findPublicDict(@Param("dictType") String dictType);

    List<UnitPersonsVo> findUnitPersons(@Param("hospitalId") String hospitalId, @Param("unitId") String unitId, @Param("unitVisitId") Integer unitVisitId);

    String findItemClass(@Param("hospitalId") String hospitalId,@Param("itemPackCode") String itemPackCode);

    String findApplySendto(@Param("itemPackCode") String itemPackCode);

    List<ModifyPersonVisitInfoVo> findModifyPersonVisitInfoVo(@Param("hospitalId") String hospitalId, @Param("personId") String personId);

    List<ModifyPersonVisitInfoVo> findModifyPersonVisitInfoVoTwo(@Param("hospitalId") String hospitalId, @Param("personId") String personId,
                                                               @Param("personVisitId") String personVisitId);
}
