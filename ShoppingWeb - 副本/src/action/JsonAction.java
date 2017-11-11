package action;

import java.util.ArrayList;
import java.util.List;


import com.opensymphony.xwork2.Action;

import domain.CartItem;
import service.ProductService;
import serviceImpl.ProductServiceImpl;
import shop.Cart;

public class JsonAction extends SuperAction
{
///////////////////////////////////////////////////////////L	
	private static final long serialVersionUID = 7443363719737618408L;

	private ProductService pService = new ProductServiceImpl();

	private CartItem cartitem;

	private List<String> abid;
	
	private String result;

	private CartItem cartid;
	public String changenum()
	{
		int num = cartitem.getNum();
		int oid = cartitem.getOid();
		if (pService.setNum(num, oid))
		{
			result = "true";
		}
		return SUCCESS;
	}

	public String delete()
	{
		int oid = cartid.getOid();
		if (pService.delete_Cart_item(oid))
		{
			result = "true";
		}
		return SUCCESS;
	}

	public String deleteall()
	{

		String arr = abid.get(0).substring(0);

		String[] l = new String[100];
		l = arr.split(",");
		if (pService.deleteall_Cart_item(l))
		{
			result = "true";
		}
		return SUCCESS;
	}

	public String payall()
	{

		String arr = abid.get(0).substring(0);

		String[] l = new String[100];
		l = arr.split(",");
		if (pService.payall_Cart_item(l))
		{
			result = "true";
		}
		return SUCCESS;
	}
	//getter setter 方法
		public List<String> getAbid()
		{
			return abid;
		}

		public void setAbid(List<String> abid)
		{
			this.abid = abid;
		}

		

		public CartItem getCartitem()
		{
			return cartitem;
		}

		public void setCartitem(CartItem cartitem)
		{
			this.cartitem = cartitem;
		}

		public CartItem getCartid()
		{
			return cartid;
		}
		
		public String getResult()
		{
			return result;
		}

		public void setResult(String result)
		{
			this.result = result;
		}

		public void setCartid(CartItem cartid)
		{
			this.cartid = cartid;
		}

	
/////////////////////////////////////////////////////C

	
/////////////////////////////////////////////////////Y
	
	

}
