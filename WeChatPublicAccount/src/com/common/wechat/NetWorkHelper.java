package com.common.wechat;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Proxy;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.security.cert.CertificateException;
import javax.net.ssl.*;

public class NetWorkHelper {
	
	public String getHttpsResponse(String reqUrl, String requestMethod) {
		URL url;
		InputStream inputStream;
		String resultData = "";
		try {
			url = new URL(reqUrl);
			Proxy proxy = new Proxy(Proxy.Type.HTTP, new java.net.InetSocketAddress("proxy.global.sonyericsson.net", 8080));
			HttpsURLConnection con = (HttpsURLConnection)url.openConnection(proxy);
			
			//certificates
			TrustManager[] trustManagers = {xTrustManager};	
			SSLContext sslContext = SSLContext.getInstance("TLS");
			//SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, trustManagers, new java.security.SecureRandom());			
			con.setSSLSocketFactory(sslContext.getSocketFactory());
			con.setHostnameVerifier(new HostnameVerifier() {
				@Override
				public boolean verify(String arg0, SSLSession arg1) {
					return true;
				}
			});
			
			con.setDoInput(true);
			//con.setDoOutput(false);
			con.setDoOutput(true);
			//con.setUseCaches(false);
			if(null != requestMethod && !requestMethod.equals("")) {
				con.setRequestMethod(requestMethod);
			} else {
				con.setRequestMethod("GET");
			}
			//con.setRequestProperty("Content-type", "application/json");
			con.connect();
			inputStream = con.getInputStream();
			InputStreamReader iStreamReader = new InputStreamReader(inputStream,"utf-8");
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
		public void checkClientTrusted(X509Certificate[] arg0, String arg1) 
				throws CertificateException {

		}
		
		@Override
		public void checkServerTrusted(X509Certificate[] arg0, String arg1) 
				throws CertificateException {

		}
	};
}
