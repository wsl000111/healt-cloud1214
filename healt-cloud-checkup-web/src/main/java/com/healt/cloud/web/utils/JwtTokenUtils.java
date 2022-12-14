package com.healt.cloud.web.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;



/**
 * JWT工具类
 *
 */
public class JwtTokenUtils {
	
	/**
	 * 密钥
	 */
	private static final String SECRET = "!@$SD35dsA*)*";
	
	/**
	 * 过期时间
	 */
	private static int time = 30;
	
	/**
	 * 过期时间单位
	 */
	private static int dateType = Calendar.DATE;

	/**
	 * 有效期30天
	 */
	private static final long EXPIRE_TIME = 2592000000L;

	/**
     * 从数据声明生成令牌
     *
     * @param claims 数据声明
     * @return 令牌
     */
    public static String generateToken(Map<String, Object> claims) {
//		Calendar instance = Calendar.getInstance();
//		instance.add(dateType, time);
//		JWTCreator.Builder creator = JWT.create();
//		//payload
//		claims.forEach((k, v) -> {
//			creator.withClaim(k, v);
//		});
//
//		//设置token过期时间
//		creator.withExpiresAt(instance.getTime());
//
//		String token = creator.sign(Algorithm.HMAC256(SECRET));	//密钥签名

		Date expirationDate = new Date(System.currentTimeMillis() + EXPIRE_TIME);
//		return Jwts.builder().setClaims(claims).setExpiration(expirationDate).signWith(SignatureAlgorithm.HS256, SECRET).compact();
		String jwtToken = Jwts.builder()
				.setHeaderParam("typ", "JWT")
				.setHeaderParam("alg", "HS256")
				.setClaims(claims)
				.setExpiration(expirationDate)
				.signWith(SignatureAlgorithm.HS256, SECRET)
				.compact();
		return jwtToken;
    }

	/**
	 * 从令牌中获取数据声明
	 *
	 * @param token 令牌d
	 * @return 数据声明
	 */
	public static Claims getClaimsFromToken(String token) {
		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.trim()).getBody();
		} catch (Exception e) {
			e.printStackTrace();
			claims = null;
		}
		return claims;
	}

	/**
	 * 验证token是否合法，非法token会抛异常,token合法，返回DecodedJWT对象
	 * @param token
	 * @return DecodedJWT
	 */
	public static DecodedJWT verify(String token) {
		return JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token);
	}

    /**
     * 从request请求头中获取token
     * @param request
     * @return
     */
    public static String getToken(HttpServletRequest request) {
    	String token = request.getHeader("Authorization");
        String tokenHead = "Bearer";
        if(token == null) {
        	token = request.getHeader("token");
        } else if(token.contains(tokenHead)){
        	token = token.substring(tokenHead.length());
        } 
        if("".equals(token)) {
        	token = null;
        }
        return token;
    }
	/**
	 * 从令牌中获取用户名
	 *
	 * @param token 令牌
	 * @return 用户名
	 */
	public static String getIdFromToken(String token) {
		String id;
		try {
			Claims claims = getClaimsFromToken(token);
			id = claims.get("id").toString();
		} catch (Exception e) {
			e.printStackTrace();
			id = null;
		}
		return id;
	}

	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
		Date expirationDate = new Date(System.currentTimeMillis() + EXPIRE_TIME);
		System.out.println(expirationDate);
	}
}
