package test.mybatismapping;

import java.util.List;
import java.util.ArrayList;

import test.mybatis.User;

public interface UserMapper {
	public User selectUserById(int id) throws Exception;
	
	public List<User> selectAllUsers() throws Exception;
}
