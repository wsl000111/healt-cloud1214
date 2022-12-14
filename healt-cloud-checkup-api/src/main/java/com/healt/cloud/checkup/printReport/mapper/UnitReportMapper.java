package com.healt.cloud.checkup.printReport.mapper;

import com.healt.cloud.checkup.queryReport.vo.AbnormalResultsVo;
import com.healt.cloud.checkup.printReport.vo.AbnormalResultsTwoVo;
import com.healt.cloud.checkup.printReport.vo.UnitQueryReportDictVo;
import com.healt.cloud.checkup.printReport.vo.UnitQueryReportVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author linklee
 * @create 2022-06-02 8:50
 */
@Mapper
public interface UnitReportMapper {

    List<UnitQueryReportVo> findUnitQueryReport(UnitQueryReportDictVo unitQueryReportDictVo);

    List<UnitQueryReportVo> findUnitInfo(@Param("unitId") String unitId,@Param("unitVisitId") String unitVisitId);

    String findCountByAge(@Param("hospitalId") String hospitalId,@Param("unitId") String unitId,@Param("unitVisitId") String unitVisitId,
                          @Param("age1") String age1,@Param("age2") String age2,@Param("sex") String sex);


    String findCountByAgeTotal(@Param("hospitalId") String hospitalId,@Param("unitId") String unitId,@Param("unitVisitId") String unitVisitId,
                               @Param("age1") String age1,@Param("age2") String age2);

    List<AbnormalResultsVo> findAbnormalResults1(@Param("hospitalId") String hospitalId, @Param("unitId") String unitId, @Param("unitVisitId") String unitVisitId);

    List<AbnormalResultsTwoVo> findAbnormalResults2(@Param("hospitalId") String hospitalId,@Param("unitId") String unitId,@Param("unitVisitId") String unitVisitId);

    @Select("select '全部'as department  from dual " +
            "union all " +
            "select distinct  a.department from hc_person_visit_info a where a.unit_id = #{unitId} and a.unit_visit_id = #{unitVisitId} ")
    List<String> findUnitDepartment(String unitId, String unitVisitId);


    @Select("select '全部' as person_level from dual " +
            "union all " +
            "select distinct a.person_level  from hc_person_visit_info a where a.unit_id = #{unitId} and a.unit_visit_id = #{unitVisitId}")
    List<String> findUnitLevel(String unitId, String unitVisitId);

    String findCountByAge1(String hospitalId, String unitId, String unitVisitId, String age1, String age2, String sex, String department, String personLeve);

    String findCountByAgeTotal1(String hospitalId, String unitId, String unitVisitId, String age1, String age2, String department, String personLeve);

    List<AbnormalResultsVo> findAbnormalResults11(String hospitalId, String unitId, String unitVisitId, String department, String personLeve);

    List<AbnormalResultsTwoVo> findAbnormalResults21(String hospitalId, String unitId, String unitVisitId, String department, String personLeve);
}
