package com.tool.wechat;

import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.common.wechat.NetWorkHelper;
import com.common.wechat.entry.*;
import com.alibaba.fastjson.*;

@WebServlet(name="AccessTokenServlet", 
			urlPatterns={"/AccessTokenServlet"},
			loadOnStartup=1,
			initParams= {
					@WebInitParam(name="appId", value=""),
					@WebInitParam(name="appSecret", value="")})
public class AccessTokenServlet extends HttpServlet {
	@Override 
	public void init() throws ServletException {
		System.out.println("启动Servlet");
		super.init();
		
		final String appId = getInitParameter("appId");
		final String appSecret = getInitParameter("appSecret");
		
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (true) {
					try {
						AccessTokenInfo.accessToken = getAccessToken(appId, appSecret);
						if(AccessTokenInfo.accessToken != null) {
							Thread.sleep(7000 * 1000);
						} else {
							Thread.sleep(1000 * 3);
						}
					} catch (Exception e) {
						System.out.println(e.getMessage());
						e.printStackTrace();
						try {
							Thread.sleep(1000 * 10);
						}
						catch (Exception e1) {
							// TODO: handle exception
						}
					}
				}
				
			}
		});
		//thread.start();
	}
	
	private AccessToken getAccessToken(String appId, String appSecret) {
		NetWorkHelper netWorkHelper = new NetWorkHelper();
		String Url = String.format("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s", 
				appId, appSecret);
		
		String result = netWorkHelper.getHttpsResponse(Url, "");
		System.out.println("获取到的access_token=" + result);
		JSONObject json = JSON.parseObject(result);
		AccessToken accessToken = new AccessToken();
		//accessToken1.setAccessToken("");
		accessToken.setAccessToken(json.getString("access_token"));
		accessToken.setExpiresin(json.getInteger("expires_in"));
		return accessToken;
	}
}
