package dao;

import java.util.ArrayList;
import java.util.List;

import domain.User;

public interface UserDao
{
///////////////////////////////////////////////////////////L
	public User getUserInfo(String uId, String password);

	public boolean registUser(User user);

	public boolean checkUid(String uid);

	public User getUserInfo(String uid);

	public boolean updateinfo(User user);
/////////////////////////////////////////////////////////////C

	public List<User> getUserList();
	public Boolean edit(User user);
	//flag 返回0为账号存在，1为用户名存在，2为成功添加
	public int add(User user);
	public Boolean delete(String[] list);
	public ArrayList<User> search(String keyword);
///////////////////////////////////////////////////////////Y
}
