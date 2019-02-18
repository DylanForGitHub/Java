package com.common.wechat;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.cert.X509Certificate;
import javax.net.ssl.*;

public class NetWorkHelper {
	
	public String getHttpsResponse(String reqUrl, String requestMethod) {
		URL url;
		InputStream inputStream;
		String resultData = "";
		try {
			url = new URL(reqUrl);
			HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
			TrustManager[] trustManagers = {xTrustManager};
			
			SSLContext sslContext = SSLContext.getInstance("TLS");
			sslContext.init(null, trustManagers, null);
			
			con.setSSLSocketFactory(sslContext.getSocketFactory());
			con.setHostnameVerifier(new HostnameVerifier() {
				
				@Override
				public boolean verify(String arg0, SSLSession arg1) {
					// TODO Auto-generated method stub
					return true;
				}
			});
			
			con.setDoInput(true);
			
			con.setDoOutput(false);
			con.setUseCaches(false);
			if(null != requestMethod && !requestMethod.equals("")) {
				con.setRequestMethod(requestMethod);
			} else {
				con.setRequestMethod("GET");
			}
			
			inputStream = con.getInputStream();
			InputStreamReader iStreamReader = new InputStreamReader(inputStream);
			BufferedReader bufferedReader = new BufferedReader(iStreamReader);
			String inputLine;
			while((inputLine = bufferedReader.readLine()) != null) {
				resultData += inputLine + "\n";
			}
			System.out.println(resultData);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultData;
	}
	
	X509TrustManager xTrustManager = new X509TrustManager() {
		@Override
		public X509Certificate[] getAcceptedIssuers() {
			return null;
		}
		
		@Override
		public void checkClientTrusted(X509Certificate[] arg0, String arg1) {

		}
		
		@Override
		public void checkServerTrusted(X509Certificate[] arg0, String arg1) {

		}
	};
}
