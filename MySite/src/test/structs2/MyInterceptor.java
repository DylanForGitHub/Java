package test.structs2;

import java.util.*;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyInterceptor extends AbstractInterceptor {

	//@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		//return null;
		String output = "Pre-processing";
		System.out.println(output);
		
		String result = invocation.invoke();
		
		output = "Past-processing";
		System.out.println(output);
		
		return result;
	}

}


