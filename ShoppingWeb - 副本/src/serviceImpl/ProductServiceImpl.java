package serviceImpl;

import java.util.ArrayList;
import java.util.List;

import dao.ProductDao;
import daoImpl.ProductDaoImpl;
import domain.Comment;
import domain.Commodity;
import service.ProductService;
import shop.Cart;

public class ProductServiceImpl implements ProductService
{
///////////////////////////////////////////////////////////L
	private ProductDao pDao=new ProductDaoImpl();
	//获取全部购物车里的详细项
	public List<Cart> getAllCart(String uid,String sta,int num)
	{
		List<Cart>cart = new ArrayList<Cart>();
		cart=pDao.getCart(uid,sta,num);
		return cart;
	}
	//设置购物蓝该物品的数量
	public boolean setNum(int num,int oid)
	{
		boolean sta=pDao.setNum(num,oid);
		return sta;
	}

	//删除单条购物篮信息
	public boolean delete_Cart_item(int oid)
	{
		System.out.println("delete_Cart_item");
		boolean sta=pDao.delete_Cart_item(oid);
		return sta;
	}

	//删除选中的购物篮条的信息
	public boolean deleteall_Cart_item(String[] ids)
	{
		System.out.println("deleteall_Cart_item");
		
		return pDao.deleteall_cart_item(ids);
	}
	//结算选中的购物篮条的信息
	public boolean payall_Cart_item(String[] l)
	{
		return pDao.payall_cart_item(l);
	}
	//获取当前状态的总条数
	public int getCartNum(String uid, String sta)
	{
		
		return pDao.getTNum(uid,sta);
	}
/////////////////////////////////////////////////////////////C
///////////////////////////////////////////////////////////Y
	@Override
	public List<Commodity> getCommodity(String[] prt) {
		
		List<Commodity> cdy = new ArrayList<Commodity>();
		cdy=pDao.getCommodity(prt);
		return cdy;
	}
	@Override
	public boolean insertCommodity(Commodity t) {
		boolean stat=pDao.insertCommodity(t);
		return stat;
	}
	@Override
	public boolean deleteCommodity(int cid) {
		boolean stat=pDao.deleteCommodity(cid);
		return stat;
	}
	@Override
	public boolean editCommodity(Commodity t) {
		boolean stat=pDao.editCommodity(t);
		return stat;
	}
	@Override
	public List<Comment> getComment(int cid) {
		List<Comment> cmt = new ArrayList<Comment>();
		 cmt=pDao.getComment(cid);		
		return cmt;
	}
	
	@Override
	public boolean insertComment(Comment cmt) {
		boolean stat=pDao.insertComment(cmt);
		return stat;
	}
	
	@Override
	public boolean addToCart(int cid, String uid) {
		boolean stat=pDao.addToCart(cid, uid);
		return stat;
	}
	
	@Override
	public boolean deletetComment(Comment cmt) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
