package cn.Test;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWordAction extends ActionSupport {
	
	@Override
	public String execute() throws Exception {
		System.out.println("Actioning...");
		return SUCCESS;
	}
}
