package action;

import java.util.List;

import domain.CommType;
import domain.User;
import net.sf.json.JSONObject;
import service.UserService;
import serviceImpl.UserServiceImpl;

public class UserAction extends SuperAction
{
	/////////////////////////////////////////////////////////// L
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserService uservice = new UserServiceImpl();
	private String password;
	private String username;
	private String Uid;
	private User user = new User();

	private String result;
	
	public String put()
	{
		session.invalidate();
		return "put";
	}
	
	public String checkLogin()
	{	
			try {
			user=uservice.logincheck(Uid,password);			
			if(user.getUname().length()>0)
			{
				user.setUid(Uid);
				session.setAttribute("username", user.getUname());
				session.setAttribute("uid", Uid);
				setUsername(user.getUname());
				result="true";	
				return SUCCESS;
			}else {
				result="false";	
				return SUCCESS;
			}
			}catch(Exception ex)
			{
				ex.getStackTrace();
				System.out.println("esb");
				result="false";	
				return SUCCESS;
			}
				
	
			
//			}
	}

	// 检查uid
	public String checkUid()
	{
		if (uservice.checkUid(Uid))
		{
			result = "false";
		}
		return SUCCESS;
	}

	public String userInfo()
	{
		String uid = (String) session.getAttribute("uid");
		user = uservice.getuserInfo(uid);
		System.out.println("user" + user);
		session.setAttribute("userInfo", user);
		return "update";
	}

	public String changeuinfo()
	{

		User info = new User();
		int count = 0;
		info = (User) session.getAttribute("userInfo");
		// 判断是否更改数据
		if (info.getUname().equals(user.getUname()))
		{
			user.setUname(null);
			count++;
		} else
		{
			info.setUname(user.getUname());
		}
		if (info.getAddress().equals(user.getAddress()))
		{
			user.setAddress(null);
			count++;
		} else
		{
			info.setAddress(user.getAddress());
		}
		if (info.getTele().equals(user.getTele()))
		{
			user.setTele(null);
			count++;
		} else
		{
			info.setTele(user.getTele());
		}
		if (info.getPassWord().equals(user.getPassWord()))
		{
			user.setPassWord(null);
			count++;
		} else
		{
			info.setPassWord(user.getPassWord());
		}
		if (count == 4)
		{
			result = "no";
		} else
		{
			user.setUid(session.getAttribute("uid").toString());
			boolean r = uservice.updateinfo(user);
			session.setAttribute("userInfo", info);
			if (user.getUname() != null)
			{
				session.setAttribute("username", user.getUname());
			}
			if (r)
			{
				result = "true";
			} else
			{
				result = "false";
			}
		}
		return SUCCESS;
	}

	// getter setter方法

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	/////////////////
	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	////////////////////
	public String getUid()
	{
		return Uid;
	}

	public void setUid(String uId)
	{
		this.Uid = uId;
	}

	////////////////////////
	public String getResult()
	{
		return result;
	}

	public void setResult(String result)
	{
		this.result = result;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}
	///////////////////////////////////////////////////////////// C

	// json 加载用户列表
	private List<User> ulist;

	private int pagecount;
	// flag 编辑或添加用户
	private int flag;
	private String message;
	private List<String> deleteList;
	private boolean resultIndex = false;
	private String curpage;
	private String searchCon;
	// 查询异步更新关键字
	private String keyword;

	public String getKeyword()
	{
		return keyword;
	}

	public void setKeyword(String keyword)
	{
		this.keyword = keyword;
	}

	public String getCurpage()
	{
		return curpage;
	}

	public void setCurpage(String curpage)
	{
		this.curpage = curpage;
	}

	public String getSearchCon()
	{
		return searchCon;
	}

	public void setSearchCon(String searchCon)
	{
		this.searchCon = searchCon;
	}

	public List<String> getDeleteList()
	{
		return deleteList;
	}

	public void setDeleteList(List<String> deleteList)
	{
		this.deleteList = deleteList;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public boolean isResultIndex()
	{
		return resultIndex;
	}

	public void setResultIndex(boolean resultIndex)
	{
		this.resultIndex = resultIndex;
	}

	public int getFlag()
	{
		return flag;
	}

	public void setFlag(int flag)
	{
		this.flag = flag;
	}

	public List<User> getUlist()
	{
		return ulist;
	}

	public void setUlist(List<User> ulist)
	{
		this.ulist = ulist;
	}

	public int getPagecount()
	{
		return pagecount;
	}

	public void setPagecount(int pagecount)
	{
		this.pagecount = pagecount;
	}

	public String userlist()
	{
		System.out.println("进入");
		// List<User> Ulist = null;
		// System.out.println("页数"+curpage);
		// System.out.println("搜索内容"+searchCon);
		CommType.setPageIndex(Integer.parseInt(curpage));
		CommType.setSearchCon(searchCon);
		// System.out.println("THe"+CommType.getPageIndex());
		try
		{

			ulist = uservice.loadData();
			pagecount = CommType.getTotalpages();
			// JSONObject json=new JSONObject();
			// json.accumulate("userList",Ulist);
			// json.accumulate("pages",CommType.getTotalpages());
			// ulist= json.toString();
			// System.out.println(ulist);
			System.out.println("page" + pagecount);
			for (int i = 0; i < ulist.size(); i++)
			{
				System.out.println(ulist.get(i).getUname());
			}

		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return SUCCESS;
	}

	public String edit() throws Exception
	{
		System.out.println("进入编辑");
		System.out.println(user.getUid());
		System.out.println(user.getUname());
		System.out.println(user.getRank());
		System.out.println(user.getTele());
		System.out.println(user.getAddress());
		System.out.println(user.getPassWord());
		System.out.println(flag);
		System.out.println("退出编辑");
		try
		{
			if (flag == 0)
			{
				// 编辑
				if (uservice.edit(user))
				{
					result = "修改成功";
				} else
				{
					result = "用户名已存在哟";

				}
			} else if (flag == 1)
			{
				// 添加
				int addIndex = 2;
				addIndex = uservice.add(user);
				System.out.println("进去添加");
				if (addIndex == 0)
				{
					// addIndex为0 则账号存在
					result = "账号已存在！";
				} else if (addIndex == 1)
				{
					// addIndex为1 则用户名存在
					result = "用户名已存在！";
				} else
				{
					result = "添加成功！";
				}

			} else
			{
				result = "用户名或账号已存在！";

			}

		} catch (Exception e)
		{

			result = "用户名已存在!!";
			return SUCCESS;
		}

		return SUCCESS;
	}

	// 删除操作
	public String delete() throws Exception
	{

		String[] temp = new String[]
		{};
		temp = deleteList.get(0).split(",");

		try
		{
			if (uservice.delete(temp))
			{
				result = "删除成功！";
			} else
			{
				result = "删除失败！";
			}

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		System.out.println(temp);
		return SUCCESS;
	}

	public String search() throws Exception
	{
		List<String> Ulist = null;
		// System.out.println(keyword);
		try
		{

			ulist = uservice.search(keyword);
			// JSONObject json=new JSONObject();
			// json.accumulate("userList",Ulist);
			// ulist = json.toString();
			// System.out.println("search"+ulist);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return SUCCESS;
	}

	/////////////////////////////////////////////////////////// Y
}
