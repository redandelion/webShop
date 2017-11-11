package daoImpl;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import DBCon.DBHelper;
import dao.ProductDao;
import domain.Comment;
import domain.Commodity;
import shop.Cart;

public class ProductDaoImpl implements ProductDao
{
///////////////////////////////////////////////////////////L
	// 获取购物车的内容
	public List<Cart> getCart(String uid, String sta, int num)
	{
		System.out.println("获取10数目");
		int first = num * 10;
		List<Cart> list = new ArrayList<Cart>();// 购物车结果集
		// 获取数据
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try
		{
			conn = DBHelper.getConnection();
			String sql = "select p.cid,c.oid,c.num,c.createtime,p.cname,p.cost,p.info,"
					+ "p.classify,p.pic,p.merchant from commodity p right join cart_item c  on c.cid=p.cid  "
					+ "where uId='" + uid + "' and statu='" + sta + "' limit " + first + ", 10 ";
			System.out.println(sql);			
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next())
			{
				Cart ct = new Cart();
				ct.setCid(rs.getInt("cid"));
				ct.setClassify(rs.getString("Classify"));
				ct.setCname(rs.getString("Cname"));
				ct.setCost(rs.getDouble("Cost"));
				ct.setCreatetime(rs.getDate("Createtime"));
				ct.setInfo(rs.getString("Info"));
				ct.setMerchant(rs.getString("Merchant"));
				ct.setNum(rs.getInt("Num"));
				ct.setOid(rs.getInt("Oid"));
				ct.setPic(rs.getString("Pic"));
				ct.setSumPrice(0);
				list.add(ct);
			}
			return list;
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
					System.out.println("rs");
					return null;
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
					System.out.println("stmt");
					return null;
				}
			}
	
		}	
	}

	// 设置购物车某商品的数量
	public boolean setNum(int num, int oid)
	{
		// 获取数据
		Connection conn = null;
		PreparedStatement stmt = null;
		try
		{
			conn = DBHelper.getConnection();
			String sql = "update cart_item set num='" + num + "' where oid='" + oid + "'";
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

	// 删除全部选中商品
	public boolean delete_Cart_item(int oid)
	{
		System.out.println("删除");
		// 获取数据
		Connection conn = null;
		PreparedStatement stmt = null;
		try
		{
			conn = DBHelper.getConnection();
			String sql = "delete from  cart_item where oid='" + oid + "'";
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

	// 删除数组里的购物车详细项
	public boolean deleteall_cart_item(String[] ids)
	{
		// 获取数据
		Connection conn = null;
		PreparedStatement stmt = null;

		String sql = "delete from  cart_item where  ";
		String query = " ";
		for (int i = 0; i < ids.length; i++)
		{
			if (i == (ids.length - 1))
			{
				query += " oid='" + ids[i] + "' ";
			} else
			{
				query += " oid='" + ids[i] + "' or ";
			}
		}
		sql += query;
		System.out.println(sql);
		try
		{
			conn = DBHelper.getConnection();
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

	// 改变数组里的购物车详细项的状态
	public boolean payall_cart_item(String[] l)
	{
		// 获取数据
		Connection conn = null;
		PreparedStatement stmt = null;

		String sql = "update   cart_item  set statu='0' where  ";
		String query = " ";
		for (int i = 0; i < l.length; i++)
		{
			if (i == (l.length - 1))
			{
				query += " oid='" + l[i] + "' ";
			} else
			{
				query += " oid='" + l[i] + "' or ";
			}
		}
		sql += query;
		System.out.println(sql);
		try
		{
			conn = DBHelper.getConnection();
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

	// 获取详细项数目总数
	public int getTNum(String uid, String sta)
	{
		System.out.println("获取所有数目");
		int sum =0;
		// 获取数据
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try
		{
			conn = DBHelper.getConnection();
			String sql = "select count(oid) sum from cart_item " + "where uId='" + uid + "' and statu='" + sta + "'";
			System.out.println(sql);
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next())
			{
				sum = rs.getInt("sum");
				System.out.println("sum");
			}
			return sum;
		} catch (Exception ex)
		{
			System.out.println("出错");
			ex.getStackTrace();
			return 0;
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
					System.out.println("rs");
					return 0;
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
					System.out.println("rs");
					return 0;
				}
			}
		}
	}
/////////////////////////////////////////////////////////////C
///////////////////////////////////////////////////////////Y
	@Override
	public List<Commodity> getCommodity(String[] prt) {
		
		List<Commodity> data=new ArrayList<Commodity>();		
		try {
			Connection conn = DBHelper.getConnection();
			String sql;
			if(prt[0].equals("cid")){
				 sql = "select * from commodity where cid=?";
			}else if(prt[0].equals("cname")){
				 sql = "select * from commodity where cname=?";
			}else if(prt[0].equals("classify")){
				 sql = "select * from commodity where classify=?";
			}else if(prt[0].equals("merchant")){
				 sql = "select * from commodity where merchant=?";
			}else{
				 sql = "select * from commodity where '1'=?";
			}
			
		    PreparedStatement pstmt = conn.prepareStatement(sql);
		   
			if(prt[0].equals("cid")){
				pstmt.setInt(1,Integer.parseInt(prt[1]));
			}else{
				pstmt.setString(1,prt[1]);
			}
			ResultSet rs = pstmt.executeQuery();
			if (pstmt != null)
				System.out.println(pstmt);
			if (rs != null)
				System.out.println(rs);
			while (rs.next()) {
				Commodity cd = new Commodity();
				cd.setCid(rs.getInt(1));
				cd.setCname(rs.getString(2));				
				cd.setCost(rs.getDouble(3));
				cd.setInfo(rs.getString(4));
				cd.setClassify(rs.getString(5));
				cd.setPic(rs.getString(6));
				cd.setMerchant(rs.getString(7));
				cd.setStore(rs.getInt(8));				
				data.add(cd);				
			}				
			rs.close();					
			pstmt.close();
			return data;
			
		} catch (SQLException ex) {
			System.out.println("getCommodity出错");
			ex.getStackTrace();
			System.out.println(ex.getMessage());
			return null;
		} 
			
	}

	@Override
	public boolean insertCommodity(Commodity t) {
		Connection conn = DBHelper.getConnection();		
		try {
			
			String sql = "insert into Commodity(cname,cost,info,classify,pic,merchant,store) values(?,?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
//			pstmt.setInt(1,t.getCid());
			pstmt.setString(1,t.getCname());
			pstmt.setDouble(2,t.getCost());
			pstmt.setString(3,t.getInfo());
			pstmt.setString(4,t.getClassify());
			pstmt.setString(5,t.getPic());
			pstmt.setString(6,t.getMerchant());
			pstmt.setInt(7,t.getStore());
			
			int r = pstmt.executeUpdate();	
			System.out.println(pstmt);
			System.out.println(r);
			pstmt.close();
			
			if(r > 0){
				return true;
			}else{
				return false;
			}						
		} catch (SQLException ex) {
			System.out.println("insertCommodity出错");
			System.out.println(ex.getMessage());
			ex.getStackTrace();
			
			return false;
		} 
	}

	@Override
	public boolean deleteCommodity(int cid) {
		Connection conn = DBHelper.getConnection();		
		try {
			System.out.println("dao"+cid);
			String sql = "delete from Commodity where cid=? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
					
			pstmt.setInt(1,cid);			
			int rs = pstmt.executeUpdate();
			System.out.println(pstmt);
			System.out.println(rs);
			pstmt.close();						
			if(rs > 0){
				return true;
			}else{
				return false;
			}												
		} catch (SQLException ex) {
			System.out.println("insertCommodity出错");
			ex.getStackTrace();
			return false;
		} 
	}

	@Override
	public boolean editCommodity(Commodity t) {
		Connection conn = DBHelper.getConnection();		
		try {
			
			String sql = "update Commodity set cname=?,cost=?,info=?,classify=?,pic=?,merchant=?,store=? where cid=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,t.getCname());
			pstmt.setDouble(2,t.getCost());
			pstmt.setString(3,t.getInfo());
			pstmt.setString(4,t.getClassify());
			pstmt.setString(5,t.getPic());
			pstmt.setString(6,t.getMerchant());
			pstmt.setInt(7,t.getStore());
			pstmt.setInt(8,t.getCid());	
			
			int rs = pstmt.executeUpdate();
			System.out.println("edit"+pstmt);
			System.out.println(rs);
			pstmt.close();			
			
			if(rs > 0){
				return true;
			}else{
				return false;
			}												
		} catch (SQLException ex) {
			System.out.println("editCommodity出错");
			ex.getStackTrace();
			return false;
		} 
	}
	@Override
	public List<Comment> getComment(int cid) {
		List<Comment> data=new ArrayList<Comment>();		
		try {
			Connection conn = DBHelper.getConnection();
			String sql = "select * from tb_comment where cid=?";		
		    PreparedStatement pstmt = conn.prepareStatement(sql);
		    pstmt.setInt(1,cid);			
			ResultSet rs = pstmt.executeQuery();
			
				System.out.println(pstmt);
				System.out.println(rs);
			while (rs.next()) {
				Comment cmt = new Comment();
				cmt.setUid(rs.getString(2));
				cmt.setCid(rs.getInt(3));				
				cmt.setMessage(rs.getString(4));
				cmt.setCom_time(rs.getDate(5));
				cmt.setEvaluate(rs.getInt(6));
						
				data.add(cmt);				
			}				
			rs.close();					
			pstmt.close();
			return data;
			
		} catch (SQLException ex) {
			System.out.println("getComment出错");
			ex.getStackTrace();
			System.out.println(ex.getMessage());
			return null;
		} 
	}
	
	
	@Override
	public boolean insertComment(Comment cmt) {
		Connection conn = DBHelper.getConnection();		
		try {
			
			String sql = "insert into tb_Comment(uid,cid,message) values(?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			

			pstmt.setString(1,cmt.getUid());
			pstmt.setInt(2,cmt.getCid());
			pstmt.setString(3,cmt.getMessage());
//			pstmt.setDate(4,cmt.getCom_time());
//			pstmt.setInt(4,cmt.getEvaluate());
	
			
			int r = pstmt.executeUpdate();	
			System.out.println(pstmt);
			System.out.println(r);
			pstmt.close();
			
			if(r > 0){
				return true;
			}else{
				return false;
			}						
		} catch (SQLException ex) {
			System.out.println("insertComment出错");
			System.out.println(ex.getMessage());
			ex.getStackTrace();
			
			return false;
		} 
	}

	@Override
	public boolean addToCart(int cid, String uid) {
		Connection conn = DBHelper.getConnection();		
		try {
		String sql = "insert into cart_item(cid,uid,num) values(?,?,1)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1,cid);
		pstmt.setString(2,uid);
		int rs = pstmt.executeUpdate();	
		System.out.println(pstmt);
		System.out.println(rs);
		pstmt.close();
		
		if(rs > 0){
			return true;
		}else{
			return false;
		}						
	} catch (SQLException ex) {
		System.out.println("addToCart出错");
		System.out.println(ex.getMessage());
		ex.getStackTrace();
		
		return false;
	} 
	}

	@Override
	public boolean deletetComment(Comment cmt) {
		// TODO Auto-generated method stub
		return false;
	}
}
