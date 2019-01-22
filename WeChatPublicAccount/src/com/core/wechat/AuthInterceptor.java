package com.core.wechat;

import java.io.PrintWriter;
import com.tool.wechat.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthInterceptor extends AbstractInterceptor {
	private final String TOKEN = "";
	
	public String intercept(ActionInvocation invocation) throws Exception {
	
		ActionContext actionContext = invocation.getInvocationContext(); 
		HttpServletRequest request = (HttpServletRequest)actionContext.get(StrutsStatics.HTTP_REQUEST);
		HttpServletResponse response = (HttpServletResponse)actionContext.get(StrutsStatics.HTTP_RESPONSE);
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		String mySignature = SHA1.getSHA1New(TOKEN, timestamp, nonce);
		
		if(mySignature != null && mySignature != "" && mySignature.equals(signature)) {
			System.out.println("签名校验通过。");
			response.getWriter().write(echostr);
		}
		else {
			System.out.println("签名校验失败.");
		}
		
		String result = invocation.invoke();
		
		return result;
	}
}
