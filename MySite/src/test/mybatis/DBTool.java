package test.mybatis;

import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;;

public class DBTool {
	
	
	public static SqlSessionFactory _SqlSessionFactory;
	
	public static SqlSession getSession() {
		return _SqlSessionFactory.openSession();
		
	}
	
	static {
		try {
			String resourcename = "conf.xml";
			Reader reader = Resources.getResourceAsReader(resourcename);
			_SqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
