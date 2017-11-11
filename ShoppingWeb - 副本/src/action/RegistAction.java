package action;

import com.opensymphony.xwork2.ModelDriven;

import domain.User;
import service.UserService;
import serviceImpl.UserServiceImpl;

public class RegistAction extends SuperAction implements ModelDriven<User>
{
///////////////////////////////////////////////////////////L
	private User user = new User();
	private UserService uservice = new UserServiceImpl();
	public User getModel()
	{
		
		return user;
	}
	
	
	//注册功能
	public String regist()
	{
		String name=(String)user.getUname();
		if(uservice.registUser(user))
		{
			session.setAttribute("uid", user.getUid());
			session.setAttribute("username", name);
			
			return "regist";
		}
		return "regist_error";
	}
/////////////////////////////////////////////////////////////C
///////////////////////////////////////////////////////////Y
}
