package test.structs2;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.sun.org.apache.xml.internal.security.utils.UnsyncBufferedOutputStream;
import com.opensymphony.xwork2.ActionContext;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

public class LocaleInterceptor extends AbstractInterceptor{
	
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext ac = invocation.getInvocationContext();
		Map session = ac.getSession();
		HttpServletRequest httpServletRequest=(HttpServletRequest)ac.get(StrutsStatics.HTTP_REQUEST); 
		String queryString =  httpServletRequest.getQueryString();
		if (queryString != null && queryString != "") {
			String[] queryArray = queryString.split("=");
			String[] languageCountry = queryArray[1].split("_");
			Locale locale = new Locale(languageCountry[0], languageCountry[1]);
			session.put("WW_TRANS_I18N_LOCALE",locale);
		}
		//Locale locale = (Locale)session.get("WW_TRANS_I18N_LOCALE");
		//if(locale==null){
		//	locale = new Locale("en","US");
		//	session.put("WW_TRANS_I18N_LOCALE",locale);
		//}
		return invocation.invoke();
	}
}