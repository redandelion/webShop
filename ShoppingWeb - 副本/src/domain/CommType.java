package domain;

public class CommType {
	// 总页数
	private static  ThreadLocal<Integer> totalpages=  new ThreadLocal<Integer>();
	// 搜索内容 
	private static  ThreadLocal<String> searchCon =  new ThreadLocal<String>();
	//当前页
	private static ThreadLocal<Integer> pageIndex = new ThreadLocal<Integer>();
	
	public static void setPageIndex( int _pageIndex) {
		pageIndex.set(_pageIndex);
		
	}
	public static  int getPageIndex() {
		
		return pageIndex.get();
	}		
	
	public static void removePageIndex() {
		pageIndex.remove();
	}	

	public static void setSearchCon( String _searchCon) {
		searchCon.set(_searchCon);
		
	}
	public static  String getSearchCon() {
		
		return searchCon.get();
	}		
	
	public static void removeSearchCon() {
		searchCon.remove();
	}	
	public static void setTotalpages( int _totalpages) {
		totalpages.set(_totalpages);
		
	}
	public static  int getTotalpages() {
		
		return totalpages.get();
	}		
	
	public static void removeTotalpages() {
		totalpages.remove();
	}	
}
