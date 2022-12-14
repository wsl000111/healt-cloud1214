package com.healt.cloud.checkup.triage.mapper;

import com.healt.cloud.checkup.entity.HcCounselRequestInfo;
import com.healt.cloud.checkup.triage.vo.CounselRequestInfoDictVo;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author linklee
 * @create 2022-06-19 9:46
 */
@Mapper
public interface CounselRequestInfoMapper {

    List<HcCounselRequestInfo> findCounselRequestInfo(CounselRequestInfoDictVo counselRequestInfoDictVo);

    void updateQueueNo(@Param("hospitalId") String hospitalId,@Param("queueNo") String queueNo,
                       @Param("roomCode") String roomCode,@Param("queueDate") String queueDate,
                       @Param("hcQueueCode") String hcQueueCode);

    void updateRoomDict(@Param("hospitalId") String hospitalId,@Param("roomCode") String roomCode,
                        @Param("sppid") String sppid,@Param("sppidxh") String sppidxh);

    void updateIntervalRecord(@Param("hospitalId") String hospitalId,@Param("queueNo") String queueNo,
                              @Param("roomCode") String roomCode,@Param("personId") String personId,
                              @Param("personVisitId") String personVisitId,@Param("queueIndicator") String queueIndicator,
                              @Param("endTime") String endTime);
}
