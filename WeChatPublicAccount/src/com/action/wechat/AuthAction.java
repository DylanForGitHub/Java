package com.action.wechat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tool.wechat.SHA1;

public class AuthAction extends ActionSupport {
	private InputStream streamActionResult = null;
	
	public InputStream getStreamActionResult() {
		return streamActionResult;
	}
	
	public String execute() throws Exception {
		String TOKEN = "DylanToken";
		ActionContext actionContext = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)actionContext.get(StrutsStatics.HTTP_REQUEST);
		//HttpServletResponse response = (HttpServletResponse)actionContext.get(StrutsStatics.HTTP_RESPONSE);
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		String mySignature = SHA1.getSHA1New(TOKEN, timestamp, nonce);
		
		if(mySignature != null && mySignature != "" && mySignature.equals(signature)) {
			System.out.println("签名校验通过。");
			//response.getWriter().write(echostr);
			streamActionResult = new ByteArrayInputStream(echostr.getBytes("UTF-8"));
		}
		else {
			System.out.println("签名校验失败.");
		}
		
		String strResult = "stream";
	    return strResult;
	}
}
