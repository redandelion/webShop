package action;

import java.util.*;

import com.opensymphony.xwork2.ModelDriven;

import domain.Commodity;
import service.ProductService;
import serviceImpl.ProductServiceImpl;
import domain.Commodity;

public class CommodityAction extends SuperAction implements ModelDriven<Commodity>{

	private ProductService ps=new ProductServiceImpl();
	private Commodity cdy;
	private String col="1",prt_val="1",a,addu,addc;
	public String getAddu() {
		return addu;
	}

	public void setAddu(String addu) {
		this.addu = addu;
	}

	public String getAddc() {
		return addc;
	}

	public void setAddc(String addc) {
		this.addc = addc;
	}
	
	private boolean view=false,ed=false;
	
	public boolean isView() {
		return view;
	}

	public void setView(boolean view) {
		this.view = view;
	}

	public boolean isEd() {
		return ed;
	}

	public void setEd(boolean ed) {
		this.ed = ed;
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

private Commodity c = new Commodity();	
	
	public Commodity getModel()
	{
		return c;
	}

	public String getPrt_val() {
		return prt_val;
	}

	public void setPrt_val(String prt_val) {		
		this.prt_val = prt_val;
	}

	public String getCol() {
		return col;
	}

	public void setCol(String col) {		
		this.col = col;
	}

	public String display()
	{			
		List<Commodity> l=new ArrayList<Commodity>();
		//传入一个userid(#session.uid)
		if(col.equals("10")){
			col="1";prt_val="1";
		}	
	 
		String[] prt={col,prt_val};	
		l= ps.getCommodity(prt); 
		session.setAttribute("cdy",l);
		
		if(ed){
		ed=false;	
		session.setAttribute("cdy",l.get(0));
		return "edit";
		}else{	
		col="1";prt_val="1";
		return "commodity";
		}
	}
	
	public String addCommodity(){
		ps.insertCommodity(c);				
		return "addCommodity";
	}
	
	public String deleteCommodity(){
		String[] d=a.split(",");
		for(String i:d){
			ps.deleteCommodity(Integer.parseInt(i));
		}
		return "commodity";
	}
	
	
	public String editCommodity(){
		ps.editCommodity(c);		
		return "commodity";
	}
	
	public String addToCart() {
		System.out.println("action"+addc+addu);
		ps.addToCart(Integer.parseInt(addc),addu);
		return "addtocart";
	}
}
