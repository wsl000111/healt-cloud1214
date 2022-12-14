package com.healt.cloud.checkup.queue.mapper;

import com.healt.cloud.checkup.entity.HcQueueNo;
import com.healt.cloud.checkup.queue.vo.CallBigScreenVo;
import com.healt.cloud.checkup.queue.vo.QueueBigScreenVo;
import com.healt.cloud.checkup.queue.vo.QueueBigScreenVoNew;
import com.healt.cloud.checkup.queue.vo.QueueNoDictVo;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author linklee
 * @create 2022-06-16 15:02
 */
@Mapper
public interface QueueNoMapper {

    List<HcQueueNo> findQueueNo(QueueNoDictVo queueNoDictVo);

    List<QueueBigScreenVo> findQueueBigScreen(@Param("hospitalId") String hospitalId,@Param("counselNo") String counselNo,@Param("queueDate") String queueDate);

    List<CallBigScreenVo> findCallBigScreen(@Param("hospitalId") String hospitalId,@Param("counselNo") String counselNo);

    List<QueueBigScreenVoNew> findQueueBigScreenNew(@Param("hospitalId") String hospitalId, @Param("counselNo") String counselNo, @Param("queueDate") String queueDate);
}
