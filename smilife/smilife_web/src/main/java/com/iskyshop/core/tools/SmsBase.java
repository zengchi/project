package com.iskyshop.core.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

/**
 * 
 * <p>
 * Title: SmsBase.java
 * </p>
 * 
 * <p>
 * Description: 系统手机短信发送类，结合第三方短信平台进行管理使用
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2014
 * </p>
 * 
 * <p>
 * Company: 沈阳网之商科技有限公司 www.iskyshop.com
 * </p>
 * 
 * @author erikzhang
 * 
 * @date 2014-4-24
 * 
 * @version iskyshop_b2b2c 1.0
 */
public class SmsBase {
	private Logger logger = Logger.getLogger(this.getClass());
	private String url;
	private String id;
	private String pwd;

	public SmsBase(String url, String id, String pwd) {
		this.url = url;
		this.id = id;
		this.pwd = pwd;
	}

	public String SendSms(String mobile, String content) throws UnsupportedEncodingException {
		HttpURLConnection httpconn = null;
		String result = "-20";
		logger.info("原始待发送短信内容： " + content);
		content = Jsoup.clean(content, Whitelist.none()).replace("&nbsp;", "").trim();
		// 过滤所有html代码
		logger.info("过滤所有HTML代码后待发送短信内容： " + content);
		StringBuilder sb = new StringBuilder();
		sb.append(url);
		sb.append("?id=").append(id);
		sb.append("&pwd=").append(pwd);
		sb.append("&to=").append(mobile);
		sb.append("&content=").append(URLEncoder.encode(content, "gb2312")); // 注意乱码的话换成gb2312编码
		try {
			URL url = new URL(sb.toString());
			httpconn = (HttpURLConnection) url.openConnection();
			BufferedReader rd = new BufferedReader(new InputStreamReader(httpconn.getInputStream()));
			result = rd.readLine();
			rd.close();
		} catch (MalformedURLException e) {
			logger.error("发送短信异常：" + e);
		} catch (IOException e) {
			logger.error("发送短信异常：" + e);
		} finally {
			if (httpconn != null) {
				httpconn.disconnect();
				httpconn = null;
			}
		}
		return result;
	}

}
