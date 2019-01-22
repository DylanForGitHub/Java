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
		
		PrintWriter out = response.getWriter();
		
		
		
		String result = invocation.invoke();
		
		return result;
	}
}
