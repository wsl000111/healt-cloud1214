package com.healt.cloud.web.compontent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务管理器
 * @author Ilzz
 */
@Component
@EnableScheduling
public class SchedulerTask {

	private static final Logger logger = LoggerFactory.getLogger(SchedulerTask.class);
	
	@Autowired
	private CaptchaCache cache;
	
	/**
	 * @Scheduled(cron=""):详见cron表达式http://www.pppet.net/ 测试使用0/4 * * * * ?"
	 */
    @Scheduled(cron="0 0 1 * * ?")
    private void clearCaptchaCache(){
        logger.info("执行定时任务：每日凌晨1点清除验证码Map缓存");
        if(cache.clearCache()) {
        	logger.info("执行定时任务：每日凌晨1点清除验证码Map缓存------清除成功");
        }else {
        	logger.info("执行定时任务：每日凌晨1点清除验证码Map缓存！！！！！清除失败");
        }
    }
	
}
