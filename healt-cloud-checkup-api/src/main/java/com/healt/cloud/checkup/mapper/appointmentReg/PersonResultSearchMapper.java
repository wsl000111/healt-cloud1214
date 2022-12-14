package com.healt.cloud.checkup.mapper.appointmentReg;

import com.healt.cloud.checkup.queryReport.vo.PersonInfoVo;
import com.healt.cloud.checkup.queryReport.vo.PersonItemsCostVo;
import com.healt.cloud.checkup.queryReport.vo.PersonItemsVo;
import com.healt.cloud.checkup.queryReport.vo.ResultDictVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-27 9:20
 */
@Mapper
public interface PersonResultSearchMapper {

    String findPersonVisitCount(@Param("hospitalId") String hospitalId,@Param("personId") String personId);

    List<PersonInfoVo> findPersonInfo(@Param("hospitalId") String hospitalId, @Param("personId") String personId, @Param("personVisitId") String personVisitId);

    List<ResultDictVo> findLabHcResultDict(@Param("hospitalId") String hospitalId, @Param("personId") String personId, @Param("personVisitId") String personVisitId);

    List<ResultDictVo> findReportHcResultDict(@Param("hospitalId") String hospitalId,@Param("personId") String personId,@Param("personVisitId") String personVisitId);

    List<PersonItemsVo> findPersonItems(@Param("hospitalId") String hospitalId, @Param("personId") String personId, @Param("personVisitId") String personVisitId);

    List<PersonItemsCostVo> findPersonItemsCost(@Param("hospitalId") String hospitalId, @Param("personId") String personId, @Param("personVisitId") String personVisitId);
}
