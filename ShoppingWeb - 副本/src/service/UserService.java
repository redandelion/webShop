package service;


import java.util.List;

import domain.User;

public interface UserService
{
///////////////////////////////////////////////////////////L
	public User logincheck(String uId, String password);

	public boolean registUser(User user);

	public boolean checkUid(String uid);

	public User getuserInfo(String uid);

	public boolean updateinfo(User user);
/////////////////////////////////////////////////////////////C
	public List loadData();
	public Boolean edit(User user);
	public int add(User user);
	public Boolean delete(String[] temp);
	public List search(String keyword);
///////////////////////////////////////////////////////////Y
}
