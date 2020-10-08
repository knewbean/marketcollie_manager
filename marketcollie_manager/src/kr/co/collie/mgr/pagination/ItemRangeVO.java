package kr.co.collie.mgr.pagination;

/**
 * 글 리스트를 조회할 때 조건이 되는 (where 절에 들어가는) 카테고리 값, 상품명에서 검색할 값, 시작번호, 끝번호를 저장하는 VO
 * 글 리스트 조회할 때 이거를 vo로 쓰시도록 만들었습니다 (-.-)(__)(-.-)
 * @author sist24
 */
public class ItemRangeVO {
	
	private String cate_value, item_name_value;
	private int start_num, end_num;
	
	public ItemRangeVO() {
	}
	
	/**
	 * 현재페이지를 받아 해당 페이지에서 보여줄 게시글의 시작번호와 끝번호를 구하는 method
	 * @param current_page
	 */
	public ItemRangeVO(int current_page) {
		PaginationService pService=new PaginationService();
		this.start_num=pService.startNum(current_page);
		this.end_num=pService.endNum(current_page);
	}
	
	/**
	 * 현재페이지, 카테고리 번호, 상품명에서 검색할 값을 받아 값을 초기화하는 method
	 * @param current_page
	 * @param column_name
	 * @param column_value
	 */
	public ItemRangeVO(int current_page, String cate_value, String item_name_value) {
		PaginationService pService=new PaginationService();
		this.start_num=pService.startNum(current_page);
		this.end_num=pService.endNum(current_page);
		this.cate_value = cate_value;
		this.item_name_value = item_name_value;
	}

	public ItemRangeVO(String cate_value, String item_name_value, int start_num, int end_num) {
		this.cate_value = cate_value;
		this.item_name_value = item_name_value;
		this.start_num = start_num;
		this.end_num = end_num;
	}

	public String getCate_value() {
		return cate_value;
	}

	public void setCate_value(String cate_value) {
		this.cate_value = cate_value;
	}

	public String getItem_name_value() {
		return item_name_value;
	}

	public void setItem_name_value(String item_name_value) {
		this.item_name_value = item_name_value;
	}

	public int getStart_num() {
		return start_num;
	}

	public void setStart_num(int start_num) {
		this.start_num = start_num;
	}

	public int getEnd_num() {
		return end_num;
	}

	public void setEnd_num(int end_num) {
		this.end_num = end_num;
	}
	
}//class
