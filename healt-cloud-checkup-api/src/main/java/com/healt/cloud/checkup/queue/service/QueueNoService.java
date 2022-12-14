package com.healt.cloud.checkup.queue.service;

import com.healt.cloud.checkup.entity.HcQueueNo;
import com.healt.cloud.checkup.queue.vo.*;

import java.util.List;

/**
 * @author linklee
 * @create 2022-06-16 14:58
 */
public interface QueueNoService {

    public List<HcQueueNo> findQueueNo(QueueNoDictVo queueNoDictVo);

    public void saveQueueNo(SaveQueueNoListVo saveQueueNoList);

    public List<QueueBigScreenVo> findQueueBigScreen(String hospitalId, String counselNo, String queueDate);

    public List<CallBigScreenVo> findCallBigScreen(String hospitalId, String counselNo);

    List<QueueBigScreenVoNew> findQueueBigScreenNew(String hospitalId, String counselNo, String queueDate);
}
