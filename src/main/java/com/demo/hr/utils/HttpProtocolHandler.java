package com.demo.hr.utils;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.util.IdleConnectionTimeoutThread;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HttpProtocolHandler {

	private static Log log = LogFactory.getLog(HttpProtocolHandler.class);

	/** 连接超时时间 */
	private int defaultConnectionTimeout = 5000;

	/** 回应超时时间 */
	private int defaultSoTimeout = 5000;

	/** 闲置连接超时时间 */
	private int defaultIdleConnTimeout = 10000;

	private int defaultMaxConnPerHost = 3000;

	private int defaultMaxTotalConn = 10000;

	/** 默认等待HttpConnectionManager返回连接超时 */
	private static final long defaultHttpConnectionManagerTimeout = 3000;

	/**
	 * HTTP连接管理器，该连接管理器必须是线程安全的.
	 */
	private HttpConnectionManager connectionManager;

	private static HttpProtocolHandler httpProtocolHandler = new HttpProtocolHandler();

	private HttpClient httpclient = null;

	/**
	 * 工厂方法
	 * 
	 * @return
	 */
	public static HttpProtocolHandler getInstance() {
		return httpProtocolHandler;
	}

	/**
	 * 私有的构造方法
	 */
	private HttpProtocolHandler() {
		// 创建一个线程安全的HTTP连接池
		connectionManager = new MultiThreadedHttpConnectionManager();
		connectionManager.getParams().setDefaultMaxConnectionsPerHost(
				defaultMaxConnPerHost);
		connectionManager.getParams().setMaxTotalConnections(
				defaultMaxTotalConn);
		connectionManager.getParams().setStaleCheckingEnabled(true);

		IdleConnectionTimeoutThread ict = new IdleConnectionTimeoutThread();
		ict.addConnectionManager(connectionManager);
		ict.setConnectionTimeout(defaultIdleConnTimeout);

		ict.start();

		httpclient = new HttpClient(connectionManager);

		// 设置连接超时
		httpclient.getHttpConnectionManager().getParams()
				.setConnectionTimeout(defaultConnectionTimeout);

		// 设置回应超时
		httpclient.getHttpConnectionManager().getParams()
				.setSoTimeout(defaultSoTimeout);

		// 设置等待ConnectionManager释放connection的时间
		httpclient.getParams().setConnectionManagerTimeout(
				defaultHttpConnectionManagerTimeout);

	}

	/**
	 * 执行Http请求
	 * 
	 * @return
	 * @throws HttpException
	 *             , IOException
	 */
	public String doGet(String pageUrl) throws HttpException, IOException {

		HttpMethod method = new GetMethod(pageUrl);
		method.getParams().setCredentialCharset("UTF-8");

		int paramIndex = pageUrl.indexOf("?");
		if (paramIndex > 0) {
			String queryString = pageUrl.substring(paramIndex + 1,
					pageUrl.length());
			if (null != queryString && !"".equals(queryString)) {
				method.setQueryString(queryString);
			}
		}

		// method.addRequestHeader("User-Agent", "Mozilla/4.0");
		String result = "";
		try {
			int statusCode = httpclient.executeMethod(method);
			// 301 or 302
			if (statusCode == HttpStatus.SC_MOVED_PERMANENTLY
					|| statusCode == HttpStatus.SC_MOVED_TEMPORARILY) {
				Header locationHeader = method.getResponseHeader("location");
				String location = null;
				if (locationHeader != null) {
					location = locationHeader.getValue();
					System.out
							.println("The page was redirected to:" + location);
				} else {
					System.err.println("Location field value is null.");
				}
			}
			result = method.getResponseBodyAsString();
		} catch (UnknownHostException ex) {
			ex.printStackTrace();
			return ex.getMessage();
		} catch (IOException ex) {
			ex.printStackTrace();
			return ex.getMessage();
		} catch (Exception ex) {
			ex.printStackTrace();
			return ex.getMessage();
		} finally {
			method.releaseConnection();
		}
		return result;
	}

	/**
	 * 执行Http请求
	 * 
	 * @return
	 * @throws HttpException
	 *             , IOException
	 */
	public String doPost(String pageUrl, Map<String, String> pdata)
			throws HttpException, IOException {

		HttpMethod method = new PostMethod(pageUrl);
		method.getParams().setCredentialCharset("UTF-8");

		// 设置参数
		((PostMethod) method).addParameters(toNameValuePair(pageUrl, pdata));

		method.addRequestHeader("Content-Type",
				"application/x-www-form-urlencoded; text/html; charset=UTF-8");
		// 设置Http Header中的User-Agent属性
		// method.addRequestHeader("User-Agent", "Mozilla/4.0");

		String result = "";
		try {
			int statusCode = httpclient.executeMethod(method);
			// 301 or 302
			if (statusCode == HttpStatus.SC_MOVED_PERMANENTLY
					|| statusCode == HttpStatus.SC_MOVED_TEMPORARILY) {
				Header locationHeader = method.getResponseHeader("location");
				String location = null;
				if (locationHeader != null) {
					location = locationHeader.getValue();
					System.out.println("The page was redirected to:" + location);
				} else {
					System.err.println("Location field value is null.");
				}
			}
			result = method.getResponseBodyAsString();
		} catch (UnknownHostException ex) {
			ex.printStackTrace();
			return ex.getMessage();
		} catch (IOException ex) {
			ex.printStackTrace();
			return ex.getMessage();
		} catch (Exception ex) {
			ex.printStackTrace();
			return ex.getMessage();
		} finally {
			method.releaseConnection();
		}
		return result;
	}
	
	/**
     * 执行Http请求 重写方法 加入超时时间设置
     * @return 
     * @throws HttpException, IOException 
     */
    public String doPost(String pageUrl, Map<String,String> pdata,int connectionTimeout,int soTimeout) throws HttpException, IOException {

        HttpMethod method = new PostMethod(pageUrl);
        method.getParams().setCredentialCharset("UTF-8");
        
        //重置相应时间
        // 设置连接超时
        httpclient.getHttpConnectionManager().getParams().setConnectionTimeout(connectionTimeout);
        // 设置回应超时
        httpclient.getHttpConnectionManager().getParams().setSoTimeout(soTimeout);
        //设置参数
        ((PostMethod) method).addParameters(toNameValuePair(pageUrl,pdata));
            
        method.addRequestHeader("Content-Type", "application/x-www-form-urlencoded; text/html; charset=UTF-8");
        // 设置Http Header中的User-Agent属性
        //method.addRequestHeader("User-Agent", "Mozilla/4.0");
        
        String result = "";
        try {
			int statusCode = httpclient.executeMethod(method);
			// 301 or 302
			if (statusCode == HttpStatus.SC_MOVED_PERMANENTLY
					|| statusCode == HttpStatus.SC_MOVED_TEMPORARILY) {
				Header locationHeader = method.getResponseHeader("location");  
				String location = null;
				if (locationHeader != null) {
					location = locationHeader.getValue();
					System.out.println("The page was redirected to:" + location);
				} else {
					System.err.println("Location field value is null.");
				}
			}
			result = method.getResponseBodyAsString();
        } catch (UnknownHostException ex) {
        	ex.printStackTrace();
            return ex.getMessage();
        } catch (IOException ex) {
        	ex.printStackTrace();
            return ex.getMessage();
        } catch (Exception ex) {
        	ex.printStackTrace();
        	return ex.getMessage();
        } finally {
            method.releaseConnection();
        }
        return result;
    }
    
    /**
     * 执行Http请求 重写方法 加入超时时间设置 加入请求头信息 caijh1 20141028 add
     * @return 
     * @throws HttpException, IOException 
     */
    public String doPost(String pageUrl, Map<String,String> pdata, List<Header> headers, 
    		int connectionTimeout,int soTimeout) throws HttpException, IOException {

        HttpMethod method = new PostMethod(pageUrl);
        method.getParams().setCredentialCharset("UTF-8");
        
        //重置相应时间
        // 设置连接超时
        httpclient.getHttpConnectionManager().getParams().setConnectionTimeout(connectionTimeout);
        // 设置回应超时
        httpclient.getHttpConnectionManager().getParams().setSoTimeout(soTimeout);
        //设置参数
        ((PostMethod) method).addParameters(toNameValuePair(pageUrl,pdata));
        
		if ((headers != null) && (!headers.isEmpty())) {
			for (Header header : headers) {
				method.addRequestHeader(header);
			}
		}
            
        method.addRequestHeader("Content-Type", "application/x-www-form-urlencoded; text/html; charset=UTF-8");
        // 设置Http Header中的User-Agent属性
        //method.addRequestHeader("User-Agent", "Mozilla/4.0");
        
        String result = "";
        try {
			int statusCode = httpclient.executeMethod(method);
			// 301 or 302
			if (statusCode == HttpStatus.SC_MOVED_PERMANENTLY
					|| statusCode == HttpStatus.SC_MOVED_TEMPORARILY) {
				Header locationHeader = method.getResponseHeader("location");  
				String location = null;
				if (locationHeader != null) {
					location = locationHeader.getValue();
					System.out.println("The page was redirected to:" + location);
				} else {
					System.err.println("Location field value is null.");
				}
			}
			result = method.getResponseBodyAsString();
        } catch (UnknownHostException ex) {
        	ex.printStackTrace();
            return ex.getMessage();
        } catch (IOException ex) {
        	ex.printStackTrace();
            return ex.getMessage();
        } catch (Exception ex) {
        	ex.printStackTrace();
        	return ex.getMessage();
        } finally {
            method.releaseConnection();
        }
        return result;
    }

	protected NameValuePair[] toNameValuePair(String pageUrl,
			Map<String, String> pdata) {
		Object[] key = pdata.keySet().toArray();
		for (Object map_Key : key) {
			if (pdata.get(map_Key) == null) {
				pdata.remove(map_Key);
			}
		}
		NameValuePair[] nameValues = new NameValuePair[pdata.size()];
		int i = 0;
		StringBuffer sb = new StringBuffer();
		for (Map.Entry<String, String> entry : pdata.entrySet()) {
			String name = entry.getKey().toString();
			String value = entry.getValue();
			if (value != null) {
				nameValues[i] = new NameValuePair(name, value);
				i++;
				if (i == 1)
					sb.append("?" + name + "=" + value + "&");
				else
					sb.append(name + "=" + value + "&");
			}
		}
		log.info("HttpClientDoPostPage:" + pageUrl + sb.toString());
		return nameValues;
	}
}
