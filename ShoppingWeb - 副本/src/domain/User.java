package domain;

public class User
{
	private String uId;
	private int rank=0;
	private String uName;
	private String passWord;
	private String address;
	private String tele;
	public String getUid()
	{
		return uId;
	}
	public void setUid(String uId)
	{
		this.uId = uId;
	}
	public int getRank()
	{
		return rank;
	}
	public void setRank(int rank)
	{
		this.rank = rank;
	}
	public String getUname()
	{
		return uName;
	}
	public void setUname(String uName)
	{
		this.uName = uName;
	}
	public String getPassWord()
	{
		return passWord;
	}
	public void setPassWord(String passWord)
	{
		this.passWord = passWord;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public String getTele()
	{
		return tele;
	}
	public void setTele(String tele)
	{
		this.tele = tele;
	}
	
}
