package com.healt.cloud.web.compontent;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.druid.support.json.JSONUtils;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.healt.cloud.web.utils.JwtTokenUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

//拦截器
@Component
public class JWTInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//放行OPTIONS请求,对于【复杂的】跨域ajax请求，浏览器会先发送一个 OPTIONS请求，确认是可以请求的，
		//之后才发送我们真正的 get 或者 post 等我们在 ajax 中定义的请求；第一次 OPTIONS 请求，headers 是不会带过来的，
		//所以拦截器要跳过这种请求
		if("OPTIONS".equals(request.getMethod())) {
			return true;
		}
		String token = JwtTokenUtils.getToken(request);
		String msg = "";
		try {
			JwtTokenUtils.verify(token);
			return true;
		} catch (SignatureVerificationException e) {//验证签名异常
			msg = "illegalToken";
			e.printStackTrace();
		} catch (TokenExpiredException e) {//token过期
			msg = "tokenExpired";
			e.printStackTrace();
		} catch (AlgorithmMismatchException e) {//签名算法不一致
			e.printStackTrace();
			msg = "algorithmMismatch";
		} catch (Exception e) {//未知错误
			e.printStackTrace();
			msg = "errToken";
		}
		response.setContentType("application/json;charset=UTF-8");
		Map<String, String> data = new HashMap<String, String>();
		data.put("msg", msg);
		response.getWriter().append(JSONUtils.toJSONString(data));
		
		return false;
	}

}
