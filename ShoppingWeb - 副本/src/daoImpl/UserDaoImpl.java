package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DBCon.DBHelper;
import dao.UserDao;
import domain.CommType;
import domain.User;

public class UserDaoImpl implements UserDao
{
///////////////////////////////////////////////////////////L
	public User getUserInfo(String uId, String password)
	{
		
		// 获取数据
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		User user=new User();
		try
		{
			conn = DBHelper.getConnection();
			String sql = "select uname,rank from user where uid='" + uId + "' and password='" + password + "'";
			stmt = conn.prepareStatement(sql);
			System.out.println(sql);
			rs = stmt.executeQuery();
			System.out.println("query");
			while(rs.next())
			{
				user.setUname( rs.getString("uname"));
				System.out.println("uname"+rs.getString("uname"));
				user.setRank(rs.getInt("rank"));	
				System.out.println("rank"+rs.getInt("rank"));
			}
			return user;
		} catch (Exception ex)
		{
			System.out.println("出错");
			ex.getStackTrace();
			return null;
		} finally
		{
			if (rs != null)
			{
				try
				{
					// 关闭结果集
					rs.close();
					rs = null;
				} catch (Exception ex)
				{
					ex.getStackTrace();
				}
			}
			if (stmt != null)
			{
				try
				{
					// 关闭会话
					stmt.close();
					stmt = null;
				} catch (Exception ex)
				{
					ex.getStackTrace();
				}
			}
		}
	}

	// 注册账号
	public boolean registUser(User user)
	{
		// 获取数据
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String name = "";
		try
		{
			conn = DBHelper.getConnection();
			String sql = "insert into user value('" + user.getUid() + "','" + user.getRank() + "','" + user.getUname()
					+ "','" + user.getPassWord() + "','" + user.getAddress() + "','" + user.getTele() + "')";
			System.out.println(sql);
			stmt = conn.prepareStatement(sql);
			stmt.executeUpdate();
			return true;
		} catch (Exception ex)
		{
			System.out.println("出错");
			ex.getStackTrace();
			return false;
		} finally
		{
			if (rs != null)
			{
				try
				{
					// 关闭结果集
					rs.close();
					rs = null;
				} catch (Exception ex)
				{
					ex.getStackTrace();
				}
			}
			if (stmt != null)
			{
				try
				{
					// 关闭会话
					stmt.close();
					stmt = null;
				} catch (Exception ex)
				{
					ex.getStackTrace();
				}
			}
		}
	}

	// 查找是否有相同uid
	public boolean checkUid(String uid)
	{
		// 获取数据
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try
		{
			conn = DBHelper.getConnection();
			String sql = "select * from user where uid='" + uid + "' ";
			System.out.println(sql);
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next())
			{
				return true;
			}
		} catch (Exception ex)
		{
			System.out.println("出错");
			ex.getStackTrace();
			return false;
		} finally
		{
			if (rs != null)
			{
				try
				{
					// 关闭结果集
					rs.close();
					rs = null;
				} catch (Exception ex)
				{
					ex.getStackTrace();
				}
			}
			if (stmt != null)
			{
				try
				{
					// 关闭会话
					stmt.close();
					stmt = null;
				} catch (Exception ex)
				{
					ex.getStackTrace();
				}
			}
		}
		return false;
	}

	// 获取当前用户信息
	public User getUserInfo(String uid)
	{
		User user = new User();

		// 获取数据
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try
		{
			conn = DBHelper.getConnection();
			String sql = "select * from user where uid='" + uid + "' ";
			System.out.println(sql);
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next())
			{
				user.setUid(uid);
				user.setUname(rs.getString("uname"));
				user.setPassWord(rs.getString("password"));
				user.setAddress(rs.getString("address"));
				user.setTele(rs.getString("tele"));
				user.setRank(rs.getInt("rank"));
			}
			return user;
		} catch (Exception ex)
		{
			System.out.println("出错");
			ex.getStackTrace();
			return null;
		} finally
		{
			if (rs != null)
			{
				try
				{
					// 关闭结果集
					rs.close();
					rs = null;
				} catch (Exception ex)
				{
					ex.getStackTrace();
				}
			}
			if (stmt != null)
			{
				try
				{
					// 关闭会话
					stmt.close();
					stmt = null;
				} catch (Exception ex)
				{
					ex.getStackTrace();
				}
			}
		}

	}

	// 修改当前用户信息
	public boolean updateinfo(User user)
	{		
		// 获取数据
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try
		{
			conn = DBHelper.getConnection();
			String sql = "update user set ";
			String query="";
			if(user.getUname()!=null)
			{
				query+="uname='"+user.getUname()+"' ";
			}
			if(user.getAddress()!=null)
			{
				if(query.length()>0)
				{
					query+=", address='"+ user.getAddress()+"' ";
				}else {
					query+=" address='"+ user.getAddress()+"' ";
				}
			}
			if(user.getTele()!=null)
			{
				if(query.length()>0)
				{
					query+=",  tele='"+ user.getTele()+"' ";
				}else {
					query+=" tele='"+ user.getTele()+"' ";
				}
			}
			if(user.getPassWord()!=null)
			{
				if(query.length()>0)
				{
					query+=", password='"+ user.getPassWord()+"'  ";
				}else {
					query+=" password='"+ user.getPassWord()+"'  ";
				}
				
			}
			sql+=query+ " where uid='" + user.getUid() + "'";
					
			System.out.println(sql);
			stmt = conn.prepareStatement(sql);
			stmt.executeUpdate();
			return true;
		} catch (Exception ex)
		{
			System.out.println("出错");
			ex.getStackTrace();
			return false;
		} finally
		{
			if (rs != null)
			{
				try
				{
					// 关闭结果集
					rs.close();
					rs = null;
				} catch (Exception ex)
				{
					ex.getStackTrace();
				}
			}
			if (stmt != null)
			{
				try
				{
					// 关闭会话
					stmt.close();
					stmt = null;
				} catch (Exception ex)
				{
					ex.getStackTrace();
				}
			}
		}
	}
/////////////////////////////////////////////////////////////C
	//redadelion-用户列表查询
	public List<User> getUserList() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<User> userList = new ArrayList<User>();
		User user = null;
		int index = 0;
		//当前页索引
		index =(CommType.getPageIndex()-1)*8;
		//搜索内容
		String searchCon=CommType.getSearchCon();
		
		try {
			con = DBHelper.getConnection();		
			//String sql = "select uid,rank,uname,password,address,tele from user limit "+index+",8";
			String sql = "select uid,rank,uname,address,tele from user where uid like '%"+searchCon+"%'  or tele like '%"+searchCon+"%' or uname like '%"+searchCon+"%'" +"limit "+index+",8" ;

			String sqlPageSize = "select count(*) from user  where	uid like '%"+searchCon+"%'  or tele like '%"+searchCon+"%' or uname like '%"+searchCon+"%'";	
			
			ps = (PreparedStatement) con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				user = new User();
				user.setUid(rs.getString("uid"));
				
				user.setUname(rs.getString("uname"));
				user.setAddress(rs.getString("address"));
				user.setTele(rs.getString("tele"));
				user.setRank(rs.getInt("rank"));
				userList.add(user);
/*     			System.out.println(user.getAddress());
				System.out.println(user.getPassWord());
				System.out.println(user.getRank());
				System.out.println(user.getTele());
				System.out.println(user.getUid());
				System.out.println(user.getUname());*/
			}
			ps = (PreparedStatement) con.prepareStatement(sqlPageSize);
			rs = ps.executeQuery();
			int totalPageSize= 0;
			while(rs.next()) {
				totalPageSize = rs.getInt(1);
			}
			int pages = (totalPageSize-1)/8 +1;
			CommType.setTotalpages(pages);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(rs);
			DBHelper.close(ps);
			//DBHelper.close(con);
			CommType.removePageIndex();
			CommType.removeSearchCon();
		}
		
		return userList;
	}

	//redadelion-edit 用户信息编辑
	public Boolean edit  (User user) {
		Boolean flag = false;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
/*		System.out.println("进入dao层");	
		System.out.println(user.getUid());			
		System.out.println(user.getUname());
		System.out.println(user.getRank());
		System.out.println(user.getTele());
		System.out.println(user.getAddress());*/
		try {
				con = DBHelper.getConnection();
				String sql = "select count(*) from user where uname=? ";
				ps=  (PreparedStatement) con.prepareStatement(sql);
				ps.setString(1,user.getUname());
				rs = ps.executeQuery();
				while(rs.next()) {
					if(rs.getInt(1)>0) {// throw new LibException("该用户名已存在！");
						flag = false;			
						
					}else {
						sql = "update  user  set uname=?,address=?,rank=?,tele=? where uid=? ";
						ps = (PreparedStatement) con.prepareStatement(sql);			
						ps.setString(1, user.getUname());
						ps.setString(2, user.getAddress());
						ps.setInt(3, user.getRank());
						ps.setString(4, user.getTele());
						ps.setString(5, user.getUid());						
						ps.executeUpdate();
						flag =true;						
					}		
				}				

		} catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			return flag;
			
		}finally {
			DBHelper.close(rs);
			DBHelper.close(ps);
			
			
		}
		
		return flag;
	}

	//redadelion-add 用户信息添加
	public int add(User user) {
		int flag=3;
		Connection con = null;
		PreparedStatement ps = null;		
		ResultSet rs = null;
		try {
			con = DBHelper.getConnection();
			String sql="select count(*) from user where uid=?";
			ps =(PreparedStatement)con.prepareStatement(sql); 
			ps.setString(1,user.getUid());
			rs = ps.executeQuery();			
			while(rs.next()) {
				if(rs.getInt(1)>0) {// 返回0 用户id已存在
					flag = 0;	
					System.out.println("账号");
					return flag;
				}	
			}
			sql="select count(*) from user where uname=?";
			ps =(PreparedStatement)con.prepareStatement(sql); 	
			ps.setString(1,user.getUname());
			rs = ps.executeQuery();		
			while(rs.next()) {
				if(rs.getInt(1)>0) {
					flag = 1;		
					System.out.println("yonghuming");
					return flag;
				}
			}
			sql = "insert into user values(?,?,?,?,?,?)";
			ps = (PreparedStatement) con.prepareStatement(sql);			
			ps.setString(1, user.getUid());
			ps.setInt(2, (user.getRank()));
			ps.setString(3, user.getUname());
			ps.setString(4, user.getPassWord());	
			ps.setString(5, user.getAddress());					
			ps.setString(6, user.getTele());										
			ps.executeUpdate();
			//返回2添加成功
			flag =2;	
		} catch (SQLException e) {
			e.printStackTrace();
			return flag;
		}
		
		return flag;
	}

	
	//redadelion delete 删除用户
	public Boolean delete(String[] list) {
		Boolean flag = false;
		Connection con = null;
		PreparedStatement ps=null;
		// java 变量一定要赋初始值
		String temp = "";	
		for(int i=0;i<list.length;i++) {
			temp +="'"+list[i]+"',";
			
		}
		//System.out.println(temp);
		try {			
			con = DBHelper.getConnection();
			String sql = "delete  from user where uid in(";					
			sql+=temp+"'')";
			
			System.out.println(sql);
			if(temp!=null&&!temp.isEmpty()) {
				flag =true;
			}else {
				flag =false;
			}
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.execute();
						
		} catch (Exception e) {
			flag =false;
			e.printStackTrace();
		}finally {
			DBHelper.close(ps);
					
			
		}		
		
		return flag;
	}
	//搜索框提示

	@Override
	public ArrayList<User> search(String keyword) {
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		User sb =null ;
		ArrayList<User> searchlist = new ArrayList<User>();
		try {
			con = DBHelper.getConnection();
			String sql = "select uid,uname from user  where uid like '%"+keyword+"%' or uname like '%"+keyword +"%'"+"limit 80";
			ps = (PreparedStatement) con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
			sb =new User();
			sb.setUid(rs.getString("uid"));
			sb.setUname(rs.getString("uname"));
			System.out.println(sb.getUid());
			System.out.println(sb.getUname());
			searchlist.add(sb);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBHelper.close(rs);
			DBHelper.close(ps);
		}
		
		return searchlist;
	}

///////////////////////////////////////////////////////////Y
}
