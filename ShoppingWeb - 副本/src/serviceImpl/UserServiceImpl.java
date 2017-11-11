package serviceImpl;




import java.util.ArrayList;
import java.util.List;

import dao.UserDao;
import daoImpl.UserDaoImpl;
import domain.User;
import service.UserService;

public class UserServiceImpl implements UserService
{
///////////////////////////////////////////////////////////L
	private UserDao uDao=new UserDaoImpl();
	public User logincheck(String uId, String password)
	{
		System.out.println("进入service");			
		return uDao.getUserInfo(uId, password);
	}
//注册用户
	public boolean registUser(User user)
	{		
		return uDao.registUser(user);
	}
	//检查用户是否存在
	public boolean checkUid(String uid)
	{
		
		return uDao.checkUid(uid);
	}
	//获取当前用户信息
	public User getuserInfo(String uid)
	{
		

		return uDao.getUserInfo(uid);
	}
	//修改信息
	public boolean updateinfo(User user)
	{
		
		return uDao.updateinfo(user);
	}
/////////////////////////////////////////////////////////////C
	//查询用户数据
	public List loadData() {
		List<User> uList = null;
		try {
			uList = uDao.getUserList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return uList;
	}
	//编辑用户
	public Boolean edit(User user) {
		Boolean flag=false;
		try {
			flag = uDao.edit(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	//添加用户
	public int add(User user) {
		int flag=0;
		try {
			flag = uDao.add(user);			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;	
		
	}
	//删除用户
	
	public Boolean delete(String[] list) {
		Boolean flag=false;
		try {
			flag = uDao.delete(list);			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return flag;
	}
	//搜索提示查询

	public List<String> search(String keyword) {
		ArrayList<User> searchlist = new ArrayList<User>();
		List<String> searchLists = new ArrayList();
		try {
			searchlist = uDao.search(keyword);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(User data :searchlist ) {
			if(data.getUid().contains(keyword)) {
				searchLists.add(data.getUid());	
			}
			if(data.getUname().contains(keyword)) {
				searchLists.add(data.getUname());	
			}
			
		}
		
		return searchLists;
	}
///////////////////////////////////////////////////////////Y
}
