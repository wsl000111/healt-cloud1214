package com.healt.cloud.checkup.triage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.healt.cloud.checkup.entity.HcCounselRequestInfo;
import com.healt.cloud.checkup.service.HcCounselRequestInfoService;
import com.healt.cloud.checkup.service.HcIntervalRecordService;
import com.healt.cloud.checkup.triage.mapper.CounselRequestInfoMapper;
import com.healt.cloud.checkup.triage.service.CounselRequestInfoService;
import com.healt.cloud.checkup.triage.vo.CounselRequestInfoDictVo;
import com.healt.cloud.checkup.triage.vo.HcCounselRequestInfoListVo;
import com.healt.cloud.checkup.triage.vo.SaveCallPatientVo;
import com.healt.cloud.checkup.triage.vo.UpdateCallPatientVo;
import com.healt.cloud.resultex.exception.CommonException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author linklee
 * @create 2022-06-19 9:44
 */
@Service
@AllArgsConstructor
public class CounselRequestInfoServiceImpl implements CounselRequestInfoService {

    private CounselRequestInfoMapper counselRequestInfoMapper;

    private HcCounselRequestInfoService hcCounselRequestInfoService;

    private HcIntervalRecordService hcIntervalRecordService;


    @Override
    public List<HcCounselRequestInfo> findCounselRequestInfo(CounselRequestInfoDictVo counselRequestInfoDictVo) {
        List<HcCounselRequestInfo> list = counselRequestInfoMapper.findCounselRequestInfo(counselRequestInfoDictVo);
        if (list.size() == 0) {
            list.add(new HcCounselRequestInfo());
        }
        return list;
    }

    @Transactional
    @Override
    public void deleteCounselRequestInfo(HcCounselRequestInfoListVo hcCounselRequestInfoList) {
        for (HcCounselRequestInfo hcCounselRequestInfo : hcCounselRequestInfoList.getHcCounselRequestInfo()) {
            QueryWrapper<HcCounselRequestInfo> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("SERIAL_NO",hcCounselRequestInfo.getSerialNo());
            queryWrapper.eq("COUNSEL_NO",hcCounselRequestInfo.getCounselNo());
            queryWrapper.eq("HOSPITAL_ID",hcCounselRequestInfo.getHospitalId());
            hcCounselRequestInfoService.remove(queryWrapper);
        }
    }

    @Transactional
    @Override
    public void saveCallPatient(SaveCallPatientVo saveCallPatient) {

        try {
            //修改  HC_QUEUE_NO  的  HC_QUEUE_CODE 值为 1 导检中
            counselRequestInfoMapper.updateQueueNo(saveCallPatient.getHospitalId(),
                    saveCallPatient.getQueueNo(),saveCallPatient.getRoomCode(),
                    saveCallPatient.getQueueDate(),saveCallPatient.getHcQueueCode());
        } catch (Exception e) {
            throw new CommonException(500,"修改HC_QUEUE_NO表的HC_QUEUE_CODE值失败！");
        }
        try {
            // 插入 HC_INTERVAL_RECORD
            hcIntervalRecordService.saveBatch(saveCallPatient.getHcIntervalRecord());
        } catch (Exception e) {
            throw new CommonException(500,"保存HC_INTERVAL_RECORD表失败！");
        }
        try {
            // 插入 HC_COUNSEL_REQUEST_INFO 呼叫系统
            hcCounselRequestInfoService.saveBatch(saveCallPatient.getHcCounselRequestInfo());
        } catch (Exception e) {
            throw new CommonException(500,"保存HC_COUNSEL_REQUEST_INFO表失败！");
        }
        try {
            //修改 HC_ROOM_DICT 的 SPPID 与SPPIDXH 条件是 HOSPITAL_ID 与 ROOM_CODE
            counselRequestInfoMapper.updateRoomDict(saveCallPatient.getHospitalId(),
                    saveCallPatient.getRoomCode(),saveCallPatient.getSppid(),saveCallPatient.getSppidxh());
        } catch (Exception e) {
            throw new CommonException(500,"修改HC_ROOM_DICT表的SPPID与SPPIDXH值失败！");
        }
    }

    @Transactional
    @Override
    public void updateCallPatient(UpdateCallPatientVo updateCallPatient) {

        try {
            //更新  HC_QUEUE_NO  的  HC_QUEUE_CODE 值为3  完成导检 END_TIME 为当前时间
            counselRequestInfoMapper.updateQueueNo(updateCallPatient.getHospitalId(),
                    updateCallPatient.getQueueNo(),updateCallPatient.getRoomCode(),
                    updateCallPatient.getQueueDate(),updateCallPatient.getHcQueueCode());
        } catch (Exception e) {
            throw new CommonException(500,"修改HC_QUEUE_NO表的HC_QUEUE_CODE值失败！");
        }
        try {
            // 更新 HC_INTERVAL_RECORD 的QUEUE_INDICATOR 值为 2 已离开检查室
            counselRequestInfoMapper.updateIntervalRecord(updateCallPatient.getHospitalId(),
                    updateCallPatient.getQueueNo(),updateCallPatient.getRoomCode(),
                    updateCallPatient.getPersonId(),updateCallPatient.getPersonVisitId(),
                    updateCallPatient.getQueueIndicator(),updateCallPatient.getEndTime());
        } catch (Exception e) {
            throw new CommonException(500,"修改HC_INTERVAL_RECORD表的QUEUE_INDICATOR值失败！");
        }
    }
}
