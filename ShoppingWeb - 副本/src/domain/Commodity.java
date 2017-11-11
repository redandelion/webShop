package domain;

public class Commodity
{
	private int cId;
	private String cname;
	private double cost;
	private String  info;
	private String classify;
	private String pic;
	private String merchant;
	private int store;
	public int getCid()
	{
		return cId;
	}
	public void setCid(int cId)
	{
		this.cId = cId;
	}
	public String getCname()
	{
		return cname;
	}
	public void setCname(String cName)
	{
		this.cname = cName;
	}
	public double getCost()
	{
		return cost;
	}
	public void setCost(double cost)
	{
		this.cost = cost;
	}
	public String getInfo()
	{
		return info;
	}
	public void setInfo(String info)
	{
		this.info = info;
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
	public int getStore()
	{
		return store;
	}
	public void setStore(int store)
	{
		this.store = store;
	}
	
}
