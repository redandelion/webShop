package domain;

import java.util.Date;

public class CartItem
{
	private int oId;
	private int cId;
	private String uId;
	private int num;
	private Date createtime;
	public int getOid()
	{
		return oId;
	}
	public void setOid(int oId)
	{
		this.oId = oId;
	}
	public int getCid()
	{
		return cId;
	}
	public void setCid(int cId)
	{
		this.cId = cId;
	}
	public String getUid()
	{
		return uId;
	}
	public void setUid(String uId)
	{
		this.uId = uId;
	}
	public int getNum()
	{
		return num;
	}
	public void setNum(int num)
	{
		this.num = num;
	}
	public Date getCreatetime()
	{
		return createtime;
	}
	public void setCreatetime(Date createtime)
	{
		createtime = createtime;
	}
	
}
