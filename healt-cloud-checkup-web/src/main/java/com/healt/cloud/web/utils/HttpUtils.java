package com.healt.cloud.web.utils;

import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.net.ssl.SSLContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.*;
import java.util.Map.Entry;

/**
 * @author wangchen http请求工具类,用于通过java代码访问某支持http协议的服务端
 */
public class HttpUtils {

	/**
	 * 结果key名称
	 */
	public static final String RESULT = "result";
	/**
	 * 状态key名称
	 */
	public static final String STATUS_CODE = "statusCode";

	public static String encoding = "UTF-8";

	public static int connTimeOut = 8;

	public static int soTimeOut = 10;

	public static List<NameValuePair> map2pairList(Map<String, String> map) {
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		Iterator<Entry<String, String>> it = map.entrySet().iterator();

		while (it.hasNext()) {
			Entry<String, String> entry = it.next();
			NameValuePair pair = new BasicNameValuePair(entry.getKey(), entry.getValue());
			list.add(pair);
		}

		return list;
	}

	/**
	 * @param url
	 *            请求地址
	 * @return 返回结果为map形式,目前包含两对键值对,消息与状态码
	 */
	public static Map<String, String> get(String url) {
		return get(url, new BasicHttpContext(), encoding);
	}

	/**
	 * @param url
	 *            请求地址
	 * @param charactor
	 *            字符集
	 * @return 返回结果为map形式,目前包含两对键值对,消息与状态码
	 */
	public static Map<String, String> get(String url, String charactor) {

		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		Builder builder = RequestConfig.custom();
		builder.setConnectionRequestTimeout(connTimeOut * 1000);
		builder.setConnectTimeout(connTimeOut * 1000);
		builder.setSocketTimeout(soTimeOut * 1000);

		HttpGet httpGet = new HttpGet(url);
		httpGet.setConfig(builder.build());

		String str = "";
		int code = 0;
		Map<String, String> resultMap = new HashMap<String, String>();

		try {
			httpClient = HttpClients.createDefault();
			response = httpClient.execute(httpGet, HttpClientContext.create());
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				str = EntityUtils.toString(entity, charactor);
				code = response.getStatusLine().getStatusCode();
				resultMap.put(RESULT, str);
			}
			resultMap.put(STATUS_CODE, String.valueOf(code));
		}catch (Throwable e) {
			e.printStackTrace();
			try {
				response.close();
				httpClient.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		} finally {
			try {
				response.close();
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return resultMap;
	}

	/**
	 * @param url
	 *            请求地址
	 * @param context
	 *            http请求上下文根,其中保存了cookie等信息
	 * @return 返回结果为map形式,目前包含两对键值对,消息与状态码
	 */
	public static Map<String, String> get(String url, HttpContext context) {
		return get(url, context, encoding);
	}

	/**
	 * @param url
	 *            请求地址
	 * @param context
	 *            http请求上下文根,其中保存了cookie等信息
	 * @param charactor
	 *            字符集
	 * @return 返回结果为map形式,目前包含两对键值对,消息与状态码
	 */
	public static Map<String, String> get(String url, HttpContext context, String charactor) {

		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		Builder builder = RequestConfig.custom();
		builder.setConnectionRequestTimeout(connTimeOut * 1000);
		builder.setConnectTimeout(connTimeOut * 1000);
		builder.setSocketTimeout(soTimeOut * 1000);

		HttpGet httpGet = new HttpGet(url);
		httpGet.setConfig(builder.build());

		String str = "";
		int code = 0;
		Map<String, String> resultMap = new HashMap<String, String>();

		try {
			httpClient = HttpClients.createDefault();
			response = httpClient.execute(httpGet, context);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				str = EntityUtils.toString(entity, charactor);
				code = response.getStatusLine().getStatusCode();
				resultMap.put(RESULT, str);
			}
			resultMap.put(STATUS_CODE, String.valueOf(code));
		} catch (Throwable e) {
			e.printStackTrace();
			try {
				response.close();
				httpClient.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		} finally {
			try {
				response.close();
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultMap;
	}

	/**
	 * @param url
	 *            请求地址
	 * @return 返回结果为map形式,目前包含两对键值对,消息与状态码
	 */
	public static Map<String, String> post(String url) {
		return post(url, new HashMap<String, String>(), new BasicHttpContext(), encoding);
	}

	/**
	 * @param url
	 *            请求地址
	 * @param params
	 *            map类型参数
	 * @return 返回结果为map形式,目前包含两对键值对,消息与状态码
	 */
	public static Map<String, String> post(String url, Map<String, String> params) {
		return post(url, params, new BasicHttpContext(), encoding, connTimeOut, soTimeOut);
	}

	/**
	 * @param url
	 *            请求地址
	 * @param params
	 *            map类型参数
	 * @param soTimeOut
	 *            数据传输超时时间(秒)
	 * @return 返回结果为map形式,目前包含两对键值对,消息与状态码
	 */
	public static Map<String, String> post(String url, Map<String, String> params, int soTimeOut) {
		return post(url, params, new BasicHttpContext(), encoding, connTimeOut, soTimeOut);
	}

	/**
	 * @param url
	 *            请求地址
	 * @param params
	 *            map类型参数
	 * @param conntimeOut
	 *            连接超时时间(秒)
	 * @param soTimeOut
	 *            数据传输超时时间(秒)
	 * @return 返回结果为map形式,目前包含两对键值对,消息与状态码
	 */
	public static Map<String, String> post(String url, Map<String, String> params, int conntimeOut, int soTimeOut) {
		return post(url, params, new BasicHttpContext(), encoding, conntimeOut, soTimeOut);
	}

	/**
	 * @param url
	 *            请求地址
	 * @param params
	 *            map类型参数
	 * @param context
	 *            http请求上下文根,其中保存了cookie等信息
	 * @return 返回结果为map形式,目前包含两对键值对,消息与状态码
	 */
	public static Map<String, String> post(String url, Map<String, String> params, HttpContext context) {
		return post(url, params, context, encoding);
	}

	/**
	 * @param url
	 *            请求地址
	 * @param params
	 *            string类型参数
	 * @param connTimeOut
	 *            http请求上下文根,其中保存了cookie等信息
	 * @return 返回结果为map形式,目前包含两对键值对,消息与状态码
	 */
	public static Map<String, String> post(String url, String params, int connTimeOut, int soTimeOut) {
		return post(url, params, new BasicHttpContext(), encoding, connTimeOut, soTimeOut);
	}

	/**
	 * @param url
	 *            请求地址
	 * @param params
	 *            map类型参数
	 * @param charactor
	 *            字符集
	 * @return 返回结果为map形式,目前包含两对键值对,消息与状态码
	 */
	public static Map<String, String> post(String url, Map<String, String> params, String charactor) {

		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		Builder builder = RequestConfig.custom();
		builder.setConnectionRequestTimeout(connTimeOut * 1000);
		builder.setConnectTimeout(connTimeOut * 1000);
		builder.setSocketTimeout(soTimeOut * 1000);

		HttpPost httpPost = new HttpPost(url);
		httpPost.setConfig(builder.build());

		UrlEncodedFormEntity uefEntity;
		String str = "";
		int code = 0;
		Map<String, String> resultMap = new HashMap<String, String>();

		try {
			httpClient = HttpClients.createDefault();
			uefEntity = new UrlEncodedFormEntity(map2pairList(params), charactor);
			httpPost.setEntity(uefEntity);
			response = httpClient.execute(httpPost, HttpClientContext.create());
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				str = EntityUtils.toString(entity, charactor);
				code = response.getStatusLine().getStatusCode();
				resultMap.put(RESULT, str);
			}
			resultMap.put(STATUS_CODE, String.valueOf(code));
		} catch (Throwable e) {
			e.printStackTrace();
			try {
				response.close();
				httpClient.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}  finally {
			try {
				response.close();
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultMap;
	}

	/**
	 * @param url
	 *            请求地址
	 * @param params
	 *            map类型参数
	 * @param context
	 *            http请求上下文根,其中保存了cookie等信息
	 * @param charactor
	 *            字符集
	 * @return 返回结果为map形式,目前包含两对键值对,消息与状态码 备注:通过map取值时建议使用如下方式:
	 *         map.get(HttpUtils.RESULT) map.get(HttpUtils.STATUS_CODE)
	 */
	public static Map<String, String> post(String url, Map<String, String> params, HttpContext context, String charactor) {

		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		Builder builder = RequestConfig.custom();
		builder.setConnectionRequestTimeout(connTimeOut * 1000);
		builder.setConnectTimeout(connTimeOut * 1000);
		builder.setSocketTimeout(soTimeOut * 1000);

		HttpPost httpPost = new HttpPost(url);
		httpPost.setConfig(builder.build());

		UrlEncodedFormEntity uefEntity;
		String str = "";
		int code = 0;
		Map<String, String> resultMap = new HashMap<String, String>();

		try {
			httpClient = HttpClients.createDefault();
			uefEntity = new UrlEncodedFormEntity(map2pairList(params), charactor);
			httpPost.setEntity(uefEntity);
			response = httpClient.execute(httpPost, context);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				str = EntityUtils.toString(entity, charactor);
				code = response.getStatusLine().getStatusCode();
				resultMap.put(RESULT, str);
			}
			resultMap.put(STATUS_CODE, String.valueOf(code));
		} catch (Throwable e) {
			e.printStackTrace();
			try {
				response.close();
				httpClient.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}  finally {
			try {
				response.close();
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return resultMap;
	}

	/**
	 * @param url
	 *            请求地址
	 * @param params
	 *            map类型参数
	 * @param context
	 *            http请求上下文根,其中保存了cookie等信息
	 * @param charactor
	 *            字符集
	 * @param connTimeOut
	 *            连接超时时间(秒)
	 * @param soTimeOut
	 *            数据传输超时时间(秒)
	 * @return 返回结果为map形式,目前包含两对键值对,消息与状态码 备注:通过map取值时建议使用如下方式:
	 *         map.get(HttpUtils.RESULT) map.get(HttpUtils.STATUS_CODE)
	 */
	public static Map<String, String> post(String url, Map<String, String> params, HttpContext context, String charactor, int connTimeOut, int soTimeOut) {

		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		Builder builder = RequestConfig.custom();
		builder.setConnectionRequestTimeout(connTimeOut * 1000);
		builder.setConnectTimeout(connTimeOut * 1000);
		builder.setSocketTimeout(soTimeOut * 1000);

		HttpPost httpPost = new HttpPost(url);
		httpPost.setConfig(builder.build());

		UrlEncodedFormEntity uefEntity;
		String str = "";
		int code = 0;
		Map<String, String> resultMap = new HashMap<String, String>();

		try {
			httpClient = HttpClients.createDefault();
			uefEntity = new UrlEncodedFormEntity(map2pairList(params), charactor);
			httpPost.setEntity(uefEntity);
			response = httpClient.execute(httpPost, context);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				str = EntityUtils.toString(entity, charactor);
				code = response.getStatusLine().getStatusCode();
				resultMap.put(RESULT, str);
			}
			resultMap.put(STATUS_CODE, String.valueOf(code));
		} catch (Throwable e) {
			e.printStackTrace();
			try {
				response.close();
				httpClient.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}  finally {
			try {
				response.close();
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return resultMap;
	}

	/**
	 * @param url
	 *            请求地址
	 * @param params
	 *            string类型参数
	 * @param context
	 *            http请求上下文根,其中保存了cookie等信息
	 * @param charactor
	 *            字符集
	 * @param connTimeOut
	 *            连接超时时间(秒)
	 * @param soTimeOut
	 *            数据传输超时时间(秒)
	 * @return 返回结果为map形式,目前包含两对键值对,消息与状态码 备注:通过map取值时建议使用如下方式:
	 *         map.get(HttpUtils.RESULT) map.get(HttpUtils.STATUS_CODE)
	 */
	public static Map<String, String> post(String url, String params, HttpContext context, String charactor, int connTimeOut, int soTimeOut) {

		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		Builder builder = RequestConfig.custom();
		builder.setConnectionRequestTimeout(connTimeOut * 1000);
		builder.setConnectTimeout(connTimeOut * 1000);
		builder.setSocketTimeout(soTimeOut * 1000);

		HttpPost httpPost = new HttpPost(url);
		httpPost.setConfig(builder.build());

		String str = "";
		int code = 0;
		Map<String, String> resultMap = new HashMap<String, String>();

		try {
			httpClient = HttpClients.createDefault();
			httpPost.setEntity(new StringEntity(params, charactor));
			response = httpClient.execute(httpPost, context);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				str = EntityUtils.toString(entity, charactor);
				code = response.getStatusLine().getStatusCode();
				resultMap.put(RESULT, str);
			}
			resultMap.put(STATUS_CODE, String.valueOf(code));
		} catch (Throwable e) {
			e.printStackTrace();
			try {
				response.close();
				httpClient.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}  finally {
			try {
				response.close();
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultMap;
	}

	public static Map<String, String> post(String url, String params){
		HttpClient client = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost(url);

        String str = "";
        HttpEntity entity = new StringEntity(params, ContentType.APPLICATION_JSON);
        post.setEntity(entity);
        Map<String, String> resultMap = new HashMap<String, String>();
        try {
            HttpResponse response = client.execute(post);
            StatusLine line = response.getStatusLine();
            if (line.getStatusCode() == HttpStatus.SC_OK) {
            	str = EntityUtils.toString(response.getEntity());
	            resultMap.put(RESULT, str);
            }
            resultMap.put(STATUS_CODE, String.valueOf(line.getStatusCode()));
            return resultMap;
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            return resultMap;
        } catch (IOException e) {
            e.printStackTrace();
            return resultMap;
        } finally {
            post.releaseConnection();
        }
	}

	// post默认发送
	public static Map<String, Object> defaultHttpGet(String uri, String charactor, int soTimeout) {

		CloseableHttpClient httpClient = createHttpClient(charactor, soTimeout);
		HttpGet httpGet = new HttpGet(uri);
		CloseableHttpResponse response = null;
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			response = httpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			int code = 0;
			if (entity != null) {
				String str = EntityUtils.toString(entity, charactor);
				code = response.getStatusLine().getStatusCode();
				resultMap.put(RESULT, str);
			}
			resultMap.put(STATUS_CODE, code);
		} catch (Throwable e) {
			e.printStackTrace();
			try {
				response.close();
				httpClient.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		} finally {
			try {
				response.close();
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultMap;
	}

	// post默认发送
	public static Map<String, Object> defaultHttpPost(String uri, String params, String charactor, int soTimeout) {

		CloseableHttpClient httpClient = createHttpClient(charactor, soTimeout);
		HttpPost httpPost = new HttpPost(uri);

		try {
			httpPost.setEntity(new StringEntity(params, charactor));
		} catch (Exception e) {
			e.printStackTrace();
		}
		CloseableHttpResponse response = null;
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			response = httpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			int code = 0;
			if (entity != null) {
				String str = EntityUtils.toString(entity, charactor);
				code = response.getStatusLine().getStatusCode();
				resultMap.put(RESULT, str);
			}
			resultMap.put(STATUS_CODE, code);
		} catch (Throwable e) {
			e.printStackTrace();
			try {
				response.close();
				httpClient.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		} finally {
			try {
				response.close();
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultMap;
	}

	// HTTP访问、无证书HTTPS访问客户端创建
	private static CloseableHttpClient createHttpClient(String charactor, int soTimeout) {

		RegistryBuilder<ConnectionSocketFactory> registryBuilder = RegistryBuilder.<ConnectionSocketFactory> create();
		ConnectionSocketFactory plainSF = new PlainConnectionSocketFactory();
		registryBuilder.register("http", plainSF);
		// 指定信任密钥存储对象和连接套接字工厂
		try {
			KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
			SSLContext sslContext = SSLContexts.custom().useTLS().loadTrustMaterial(trustStore, new TrustStrategy() {
				public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
					return true;
				}
			}).build();
			LayeredConnectionSocketFactory sslSF = new SSLConnectionSocketFactory(sslContext, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
			registryBuilder.register("https", sslSF);
		} catch (KeyStoreException e) {
			throw new RuntimeException(e);
		} catch (KeyManagementException e) {
			throw new RuntimeException(e);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		Registry<ConnectionSocketFactory> registry = registryBuilder.build();

		ConnectionConfig connectionConfig = ConnectionConfig.custom().setCharset(Charset.forName(charactor)).build();
		SocketConfig socketConfig = SocketConfig.custom().setSoTimeout(soTimeout).build();
		// 设置连接管理器
		PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(registry);
		connManager.setDefaultConnectionConfig(connectionConfig);
		connManager.setDefaultSocketConfig(socketConfig);
		// 构建客户端
		return HttpClientBuilder.create().setConnectionManager(connManager).build();
	}

	public static String getToken(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        return request.getHeader("token");
    }
}
