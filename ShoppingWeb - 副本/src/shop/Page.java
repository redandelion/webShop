package shop;

public class Page
{
	private int curpage;//页面
	private int pageCount;//总页数
	private int pageSize=10;//页面大小
	
	public int getPageSize()
	{
		return pageSize;
	}
	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
	}
	public int getCurpage()
	{
		return curpage;
	}
	public void setCurpage(int curpage)
	{
		this.curpage = curpage;
	}
	public int getPageCount()
	{
		return pageCount;
	}
	public void setPageCount(int pageCount)
	{
		this.pageCount = pageCount;
	}
	
}
