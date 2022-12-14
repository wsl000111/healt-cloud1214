package com.healt.cloud.checkup.appointmentReg.mapper;

import com.healt.cloud.checkup.appointmentReg.vo.finishedSign.FinishedSignPerson;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author linklee
 * @create 2022-04-18 14:19
 */
@Mapper
public interface FinishedSignMapper {


    List<FinishedSignPerson> findPersonByWherePage(@Param("pageNum") int pageNum,
                                                   @Param("pageSize") int pageSize,
                                                   @Param("strWhere") String strWhere);

    long selectPersonByWhereTotal(@Param("strWhere") String strWhere);

    int updateHcPersonVistInfoFinished(@Param("personId") String personId,
                                       @Param("personVisitId") String personVisitId,
                                       @Param("hospitalId") String hospitalId,
                                       @Param("values") String values);
}
