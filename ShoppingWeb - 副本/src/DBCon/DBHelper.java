package DBCon;
import java.sql.*;
public class DBHelper {
	private static final String driver="com.mysql.jdbc.Driver";//连接数据库的URL地址
	private static final String url="jdbc:mysql://localhost:3306/db_shop?useUnicode=true&characterEncoding=UTF-8";
	private static final String username="root";//数据库用户名
	private static final String password="root";//数据库密码
	
	private static  Connection conn=null;
	
	//静态代码块负责加载驱动
	static
	{
		try
		{
			Class.forName(driver);
		}catch(Exception ex)
		{
			ex.getStackTrace();
		}
		
	}

	//单例模式返回数据库连接对象
public static Connection getConnection()
{
	if(conn==null)
	{
		try{
			conn=DriverManager.getConnection(url,username,password);
		}catch(Exception ex)
		{
			ex.getStackTrace();
		}
		return conn;
	}
	return conn;
}
////关闭连接
		public static void close( Connection con) {
			try {
				 if(con !=null) {
					 con.close();				 
				 }
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
			// 关闭预处理
			public static void close( java.sql.PreparedStatement ps) {
				try {
					 if(ps !=null) {
						 ps.close();				 
					 }
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
		}
		// 关闭结果集
			public static void close( ResultSet rs) {
				try {
					 if(rs !=null) {
						 rs.close();				 
					 }
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
		}
public static void main(String []args)
{
	try{
			Connection conn=DBHelper.getConnection();
			if(conn!=null)
			{
				System.out.println("连接数据库成功");
			}else
			{
				System.out.println("连接数据库失败");
			}
		}catch(Exception ex)
		{
			ex.getStackTrace();
		}
	
}
}