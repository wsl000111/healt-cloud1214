package com.healt.cloud.pdf.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.healt.cloud.checkup.entity.WebUserInfo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 田恒宇
 * @since 2022-09-22
 */
public interface MyWebUserInfoService  {

    boolean save(WebUserInfo webUserInfo);
    boolean update(WebUserInfo webUserInfo);
}
