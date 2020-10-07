package kr.co.collie.mgr.pagination;

public class PageVO {
	
	public int currentPage, prePage, nextPage, startPage, endPage;

	public PageVO() {
	}

	public PageVO(int currentPage, int prePage, int nextPage, int startPage, int endPage) {
		this.currentPage = currentPage;
		this.prePage = prePage;
		this.nextPage = nextPage;
		this.startPage = startPage;
		this.endPage = endPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPrePage() {
		return prePage;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
}//class
