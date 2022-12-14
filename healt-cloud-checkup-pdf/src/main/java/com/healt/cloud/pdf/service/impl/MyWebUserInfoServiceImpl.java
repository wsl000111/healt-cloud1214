package com.healt.cloud.pdf.service.impl;


import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.healt.cloud.checkup.entity.HcPackVsItemDict;
import com.healt.cloud.checkup.entity.WebUserInfo;
import com.healt.cloud.checkup.mapper.WebUserInfoMapper;
import com.healt.cloud.checkup.service.WebUserInfoService;
import com.healt.cloud.pdf.service.MyWebUserInfoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 田恒宇
 * @since 2022-09-22
 */
@Service
@AllArgsConstructor
public class MyWebUserInfoServiceImpl implements MyWebUserInfoService{

	private WebUserInfoService webUserInfoService;

	private static final long serialVersionUID = 1L;

	@Transactional
	@Override
	public boolean save(WebUserInfo webUserInfo) {
		try {
			webUserInfoService.save(webUserInfo);
			return true;
		}catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Transactional
	@Override
	public boolean update(WebUserInfo webUserInfo) {
		try {
			UpdateWrapper<WebUserInfo> updateWrapper = new UpdateWrapper<>();
			updateWrapper.set("BIND_ID","");
			updateWrapper.set("RELATION_SHIP","");
			updateWrapper.eq("ID", webUserInfo.getId());
			webUserInfoService.update(updateWrapper);
			return true;
		}catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}

}
