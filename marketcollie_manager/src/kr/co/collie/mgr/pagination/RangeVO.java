package kr.co.collie.mgr.pagination;

/**
 * 글 리스트를 조회할 때 조건이 되는 (where 절에 들어가는) 컬럼명, 컬럼값, 시작번호, 끝번호를 저장하는 VO
 * 글 리스트 조회할 때 이거를 vo로 쓰시도록 만들었습니다 (-.-)(__)(-.-)
 * @author sist24
 */
public class RangeVO {
	
	private String column_name, column_value;
	private int start_num, end_num;
	
	public RangeVO() {
	}
	
	/**
	 * 현재페이지를 받아 해당 페이지에서 보여줄 게시글의 시작번호와 끝번호를 구하는 method
	 * @param current_page
	 */
	public RangeVO(int current_page) {
		PaginationService pService=new PaginationService();
		this.start_num=pService.startNum(current_page);
		this.end_num=pService.endNum(current_page);
	}

	public RangeVO(String column_name, String column_value, int start_num, int end_num) {
		this.column_name = column_name;
		this.column_value = column_value;
		this.start_num = start_num;
		this.end_num = end_num;
	}

	public String getColumn_name() {
		return column_name;
	}

	public void setColumn_name(String column_name) {
		this.column_name = column_name;
	}

	public String getColumn_value() {
		return column_value;
	}

	public void setColumn_value(String column_value) {
		this.column_value = column_value;
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
