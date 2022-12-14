package com.healt.cloud.checkup.listener;

import com.github.houbb.pinyin.constant.enums.PinyinStyleEnum;
import com.github.houbb.pinyin.util.PinyinHelper;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author GuYue
 * @date 2022-08-05 16:21
 * @description: TODO
 */
@Component
public class SystemStartApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println(PinyinHelper.toPinyin("初始化", PinyinStyleEnum.NORMAL));
    }
}
