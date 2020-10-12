package kr.co.collie.mgr.pagination;

public class PageVO {
	
	public int current_page, pre_page, next_page, start_page, end_page, total_page;

	public PageVO() {
	}

	public PageVO(int current_page, int pre_page, int next_page, int start_page, int end_page, int total_page) {
		this.current_page = current_page;
		this.pre_page = pre_page;
		this.next_page = next_page;
		this.start_page = start_page;
		this.end_page = end_page;
		this.total_page = total_page;
	}

	public int getCurrent_page() {
		return current_page;
	}

	public void setCurrent_page(int current_page) {
		this.current_page = current_page;
	}

	public int getPre_page() {
		return pre_page;
	}

	public void setPre_page(int pre_page) {
		this.pre_page = pre_page;
	}

	public int getNext_page() {
		return next_page;
	}

	public void setNext_page(int next_page) {
		this.next_page = next_page;
	}

	public int getStart_page() {
		return start_page;
	}

	public void setStart_page(int start_page) {
		this.start_page = start_page;
	}

	public int getEnd_page() {
		return end_page;
	}

	public void setEnd_page(int end_page) {
		this.end_page = end_page;
	}

	public int getTotal_page() {
		return total_page;
	}

	public void setTotal_page(int total_page) {
		this.total_page = total_page;
	}
	
}//class
