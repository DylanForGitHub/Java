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
	
		String result = invocation.invoke();
		
		return result;
	}
}
