package com.healt.cloud.checkup.appointmentReg.mapper;

import com.healt.cloud.checkup.appointmentReg.vo.beforeSignIn.XRGuidanceSheetVo;
import com.healt.cloud.checkup.vo.appointmentReg.beforSign.PersonAndVisitVo;
import com.healt.cloud.checkup.vo.appointmentReg.personAppointReg.PersonItemsVo;
import com.healt.cloud.checkup.vo.appointmentReg.unitPersons.DtUnitVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author linklee
 * @create 2022-04-15 15:44
 */
@Mapper
public interface BeforeSignInMapper {

    List<DtUnitVo> findDtUnit(@Param("hospitalId") String hospitalId);

    List<PersonAndVisitVo> selectPersonAndVisit(@Param("pageNum") int pageNum,
                                                @Param("pageSize") int pageSize,
                                                @Param("strWhere") String strWhere);

    long selectPersonAndVisitTotal(@Param("strWhere") String strWhere);

    List<PersonItemsVo> selectPersonItems(@Param("hospitalId") String hospitalId, @Param("personId") String personId,
                                          @Param("personVisitId") Integer personVisitId);

    List<PersonItemsVo> selectPersonItemsNew(@Param("hospitalId") String hospitalId, @Param("personId") String personId,
                                             @Param("personVisitId") Integer personVisitId);

    void updateSubmitApplyNo(@Param("applyNo") String applyNo,@Param("itemPackCode") String itemPackCode,
                             @Param("hospitalId") String hospitalId,@Param("personId") String personId,
                             @Param("personVisitId") Integer personVisitId,@Param("itemNo") Integer itemNo);

    void updatePersonVisitInfo(@Param("beforeId") String beforeId,@Param("beforeName") String beforeName,
                               @Param("hospitalId") String hospitalId,@Param("personId") String personId,
                               @Param("personVisitId") Integer personVisitId);

    List<String> selectFinishedItemPackName(@Param("hospitalId") String hospitalId,@Param("personId") String personId,
                                            @Param("personVisitId") Integer personVisitId);

    void updateBeforeSign(@Param("hospitalId") String hospitalId,@Param("personId") String personId,
                          @Param("personVisitId") Integer personVisitId);

    List<XRGuidanceSheetVo> xRGuidanceSheet(String hospitalId, String personId, String personVisitId);

    List<PersonAndVisitVo> selectPersonAndVisitPrintNullNoPage (String startDate, String endDate);

    List<PersonAndVisitVo> selectPersonAndVisitPrintNotNullNoPage(String startDate, String endDate);

    List<PersonAndVisitVo> selectPersonAndVisitPrintNull(int pageNum, int pageSize, String startDate, String endDate);

    List<PersonAndVisitVo> selectPersonAndVisitPrintNotNull(int pageNum, int pageSize, String startDate, String endDate);

    long selectPersonAndVisitPrintNotNullTotal(String startDate, String endDate);

    long selectPersonAndVisitPrintNullTotal(String startDate, String endDate);

}
