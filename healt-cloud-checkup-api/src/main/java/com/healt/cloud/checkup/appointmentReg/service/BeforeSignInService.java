package com.healt.cloud.checkup.appointmentReg.service;

import com.healt.cloud.checkup.appointmentReg.vo.beforeSignIn.CancelBeforeSignListVo;
import com.healt.cloud.checkup.appointmentReg.vo.beforeSignIn.SaveBeforeSignInListVo;
import com.healt.cloud.checkup.appointmentReg.vo.beforeSignIn.XRGuidanceSheetVo;
import com.healt.cloud.checkup.vo.appointmentReg.beforSign.PersonAndVisitVo;
import com.healt.cloud.checkup.vo.appointmentReg.beforSign.PersonByWherePageVo;
import com.healt.cloud.checkup.vo.appointmentReg.personAppointReg.PersonItemsVo;
import com.healt.cloud.checkup.vo.appointmentReg.unitPersons.DtUnitVo;
import com.healt.cloud.common.pages.PageResult;

import java.util.List;

/**
 * @author linklee
 * @create 2022-04-15 15:41
 */
public interface BeforeSignInService {

    public List<DtUnitVo> findDtUnit(String hospitalId);

    public PageResult selectPersonAndVisit(PersonByWherePageVo personByWherePageVo);

    public PageResult selectPersonAndVisitPrintNUll(PersonByWherePageVo personByWherePageVo);

    public PageResult selectPersonAndVisitPrintNotNull(PersonByWherePageVo personByWherePageVo);

    public PageResult selectPersonAndVisitPrintNotNullNoPage(PersonByWherePageVo personByWherePageVo);

    public List<PersonItemsVo> selectPersonItems(String hospitalId, String personId, Integer personVisitId);

    public void updateSubmitApplyNo(String applyNo, String itemPackCode, String hospitalId, String personId, Integer personVisitId, Integer itemNo);

    public void updatePersonVisitInfo(String beforeId, String beforeName, String hospitalId, String personId, Integer personVisitId);

    public List<String> selectFinishedItemPackName(String hospitalId, String personId, Integer personVisitId);

    public void updateBeforeSign(String hospitalId, String personId, Integer personVisitId);

    String beforeSignIn(SaveBeforeSignInListVo saveBeforeSignInListVo);

    String cancelBeforeSign(CancelBeforeSignListVo cancelBeforeSignListVo);

    List<XRGuidanceSheetVo> xRGuidanceSheet(String hospitalId, String personId, String personVisitId);

    PageResult<PersonAndVisitVo> selectPersonAndVisitPrintNullNoPage(PersonByWherePageVo personByWherePageVo);

    List<PersonItemsVo> selectPersonItemsNew(String hospitalId, String personId, Integer personVisitId);
}
