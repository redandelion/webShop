package action;

import java.util.ArrayList;
import java.util.List;

import service.ProductService;
import serviceImpl.ProductServiceImpl;
import shop.Cart;

public class ProductAction extends SuperAction
{
///////////////////////////////////////////////////////////L
	private static final long serialVersionUID = 1L;

	ProductService pServiceImpl = new ProductServiceImpl();
	private String status = "1";
	private String flag;
	private String result;
	private List<Cart> cart = new ArrayList<Cart>();

	public String cart()
	{
		System.out.println("status" + status);
		List<Cart> list = new ArrayList<Cart>();
		String uid=session.getAttribute("uid").toString();
		int sum=pServiceImpl.getCartNum(uid,"1");
		int soldnum=pServiceImpl.getCartNum(uid,"0");
		session.setAttribute("allitems", sum);
		session.setAttribute("sold", soldnum);
		list = pServiceImpl.getAllCart(uid, status, 0);

		request.setAttribute("cart_list", list);
		session.setAttribute("status", status);
		request.setAttribute("flag", "1");
//		if (status.equals("1"))
//		{
//			
//			int sold=pServiceImpl.getCartNum(uid,"0");
//			
//		} else
//		{
//			session.setAttribute("sold", sum);
//			int sold=pServiceImpl.getCartNum(uid,"1");
//			session.setAttribute("sold", sold);
//		}
		return "cart";
	}

	public String checkmore()
	{
		System.out.println("flag" + "1");
		int num = Integer.parseInt(flag);
		int sum = 0;
		if (session.getAttribute("status").equals("1"))
		{
			System.out.println("session.getAttribute('status').equals('1')");
			sum = Integer.parseInt((session.getAttribute("allitems").toString()));
			System.out.println("sum" + sum);
		} else
		{
			sum = Integer.parseInt((session.getAttribute("sold")).toString());
		}
		System.out.println("sum" + sum);
		if (sum - (num * 10) < 0)
		{
			System.out.println("false");
			result = "false";
		}else {
			result = "true";
		}
		String u=session.getAttribute("uid").toString();
		cart = pServiceImpl.getAllCart(u, status, num);
		System.out.println("cart" + cart.size());
		
		System.out.println("sdasdasda");
		System.out.println("查询成功");
		return SUCCESS;
	}

	///////////////////////GET SET方法
	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getResult()
	{
		return result;
	}

	public void setResult(String result)
	{
		this.result = result;
	}

	public List<Cart> getCart()
	{
		return cart;
	}

	public void setCart(List<Cart> cart)
	{
		this.cart = cart;
	}



	public String getFlag()
	{
		return flag;
	}

	public void setFlag(String flag)
	{
		this.flag = flag;
	}
/////////////////////////////////////////////////////////////C
	
///////////////////////////////////////////////////////////Y
}
