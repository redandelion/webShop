package dao;

import java.util.List;

import domain.Comment;
import domain.Commodity;
import shop.Cart;

public interface ProductDao
{
	/////////////////////////////////////////////////////////// L
	public List<Cart> getCart(String uid, String sta, int num);

	public boolean setNum(int num, int oid);

	public boolean delete_Cart_item(int oid);

	public boolean deleteall_cart_item(String[] ids);

	public boolean payall_cart_item(String[] l);

	public int getTNum(String uid, String sta);
	///////////////////////////////////////////////////////////// C

	/////////////////////////////////////////////////////////// Y
	public List<Commodity> getCommodity(String[] prt);

	public boolean insertCommodity(Commodity t);

	public boolean deleteCommodity(int cid);

	public boolean editCommodity(Commodity t);

	public boolean addToCart(int cid, String uid);

	public boolean insertComment(Comment cmt);

	public boolean deletetComment(Comment cmt);

	public List<Comment> getComment(int cid);
}
