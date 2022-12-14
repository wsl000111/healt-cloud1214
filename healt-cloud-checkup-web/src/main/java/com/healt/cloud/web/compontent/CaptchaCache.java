package com.healt.cloud.web.compontent;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * 验证码缓存操作
 * @author Ilzz
 */
@Component
public class CaptchaCache {
	
	private static Map<String, Map<String, Object>> cache = new HashMap<String, Map<String, Object>>();
	
	private static boolean notice = true;
	
	public static final String CAPTCHA = "CAPTCHA";
	
	public static final String EXPIREDTIME = "EXPIREDTIME";

	/**
	 * 清空验证码缓存
	 * @return
	 */
	public boolean clearCache() {
		try {
			cache.clear();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean removeCache(String key) {
		try {
			cache.remove(key);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean setCache(String key, Map<String, Object> value) {
		try {
			/*为防止刷验证码攻击，造成map缓存过大，当数据大于十万条时，进行暴力清空*/
			if(cache.size()>100000) {
				cache.clear();
				if(notice) {
					//TODO 调用短信接口通知管理员，服务器正遭受攻击
					notice = false;
				}
			}
			cache.put(key, value);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Map<String, Object> getCache(String key) {
		Map<String, Object> result = null;
		try {
			result = cache.get(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean setNotice() {
		notice = true;
		return notice;
	}
	
}
