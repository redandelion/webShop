package service;

import java.util.List;

import domain.Comment;
import domain.Commodity;
import shop.Cart;

public interface ProductService
{
	/////////////////////////////////////////////////////////// L
	public List<Cart> getAllCart(String uid, String sta, int num);

	public boolean setNum(int num, int oid);

	public boolean delete_Cart_item(int oid);

	public boolean deleteall_Cart_item(String[] ids);

	public boolean payall_Cart_item(String[] l);

	public int getCartNum(String uid, String sta);

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
