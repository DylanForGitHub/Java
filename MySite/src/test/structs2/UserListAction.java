package test.structs2;

import java.util.ArrayList;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.ibatis.session.SqlSession;
import test.mybatismapping.UserMapper;

import test.mybatis.*;;

public class UserListAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<User> userList = new ArrayList<User>();
	
	public String execute() {
		SqlSession sqlSession = DBTool.getSession();
		try {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			//User user = mapper.selectUserById(1);
			userList = mapper.selectAllUsers();
			//userList.add(user);
			return SUCCESS;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ERROR;
		}
		finally{
			sqlSession.close();
		}
	   }
	
	
	public List<User> getUserList() {
		return userList;
	}
	
	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}
}
