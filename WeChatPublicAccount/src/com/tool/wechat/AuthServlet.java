package com.tool.wechat;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Map;

import org.apache.ibatis.mapping.VendorDatabaseIdProvider;

//import com.sun.javafx.collections.MappingChange.Map;

@WebServlet("/AuthServlet")
public class AuthServlet extends HttpServlet {
	private final String Token = "Dylan";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		System.out.println("Reponse to the wexin");
		String result = "";
		try {
			Map<String, String> map = MessageHandlerUtil.parseXml(request);
			System.out.println("Start to construct message.");
			result = MessageHandlerUtil.buildXml(map);
			System.out.println(result);
			if(result.equals("")) {
				result = "Error occurred in response.";
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error Occurred when response to the WX.");
		}
		response.getWriter().println(result);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		//String sortString = sort(Token, timestamp, nonce);
		String mySiguature = "";
		try { 
			mySiguature = SHA1.getSHA1New(Token, timestamp, nonce);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		if (mySiguature != null && mySiguature != "" && mySiguature.equals(signature)) {
			System.out.println("签名校验通过。");
			response.getWriter().write(echostr);
		}
		else {
			System.out.println("签名校验失败.");
		}
	}
	
	private String sort(String token, String timestamp, String nonce) {
		String[] newArray = {token, timestamp, nonce};
		Arrays.sort(newArray);
		StringBuilder sb = new StringBuilder();
		for (String str : newArray) {
			sb.append(str);
		}
		return sb.toString();
	}
}
