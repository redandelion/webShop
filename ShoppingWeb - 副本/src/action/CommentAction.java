package action;

import java.util.ArrayList;
import java.util.List;

import service.ProductService;
import serviceImpl.ProductServiceImpl;

import com.opensymphony.xwork2.ModelDriven;

import domain.Comment;
import domain.Commodity;



public class CommentAction extends SuperAction implements ModelDriven<Comment>{
	
	private ProductService ps=new ProductServiceImpl();
	private Comment c=new Comment();
	private String prt_val;
	public String getPrt_val() {
		return prt_val;
	}

	public void setPrt_val(String prt_val) {
		this.prt_val = prt_val;
	}

	public Comment getModel() {		
		return c;
	}
	
	public String getComment(){
		List<Comment> l=new ArrayList<Comment>();	
		List<Commodity> ld=new ArrayList<Commodity>();					
			String[] p={"cid",prt_val};	
			l=ps.getComment(Integer.parseInt(prt_val));
			ld=ps.getCommodity(p);
			session.setAttribute("cdy",ld);	
			session.setAttribute("cmt",l);	
			System.out.println("fff");
			return "getcomment";		
	}
	
	public String addComment(){
		String userid=session.getAttribute("uid").toString();	
		c.setUid(userid);
		c.setCid(Integer.parseInt(prt_val));
		System.out.println("www"+prt_val);
		ps.insertComment(c);
		getComment();
		return "addcomment";
	}
}
