package com.healt.cloud.checkup.appointmentReg.service;

/**
 * @author linklee
 * @create 2022-06-24 16:36
 */
public interface ModifyItemStatusService {

    public void updateItemFinshedSign(String hospitalId, String personId, String personVisitId, String itemPackCode, String itemNo, String editerId, String editerName);

    public void updateItemFinshedSignToBeContinued(String hospitalId, String personId, String personVisitId, String itemPackCode, String itemNo, String editerId, String editerName);

    public void updateItemFinshedSignPostpone(String hospitalId, String personId, String personVisitId, String itemPackCode, String itemNo, String editerId, String editerName);
}
