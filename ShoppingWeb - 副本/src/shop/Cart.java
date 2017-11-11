package shop;

import java.util.Date;

public class Cart
{
	private int oId;//订单号w
	private int cId;//商品idw
	private String cName;//商品名字
	private String  info;//商品信息
	private int num;//商品数量
	private double cost;//商品价格
	private String classify;//产品分类
	private String pic;//图片
	private String merchant;//商家
	private Date createtime;//订单详细项创造时间
	private double sumPrice;//计算总价
	public int getOid()
	{
		return oId;
	}
	public void setOid(int oid)
	{
		this.oId = oid;
	}
	public int getCid()
	{
		return cId;
	}
	public void setCid(int cid)
	{
		this.cId = cid;
	}
	public String getCname()
	{
		return cName;
	}
	public void setCname(String cname)
	{
		this.cName = cname;
	}
	public String getInfo()
	{
		return info;
	}
	public void setInfo(String info)
	{
		this.info = info;
	}
	public int getNum()
	{
		return num;
	}
	public void setNum(int num)
	{
		this.num = num;
	}
	public double getCost()
	{
		return cost;
	}
	public void setCost(double cost)
	{
		this.cost = cost;
	}
	public String getClassify()
	{
		return classify;
	}
	public void setClassify(String classify)
	{
		this.classify = classify;
	}
	public String getPic()
	{
		return pic;
	}
	public void setPic(String pic)
	{
		this.pic = pic;
	}
	public String getMerchant()
	{
		return merchant;
	}
	public void setMerchant(String merchant)
	{
		this.merchant = merchant;
	}
	public Date getCreatetime()
	{
		return createtime;
	}
	public void setCreatetime(Date createtime)
	{
		this.createtime = createtime;
	}
	public double getSumPrice()
	{
		return sumPrice;
	}
	public void setSumPrice(double sumprice)
	{
		if(sumprice==0)
		{
		this.sumPrice = this.cost*this.num;
		}else {
			this.sumPrice=sumprice;
		}
	}
	
	
}
