package kr.co.collie.mgr.pagination;

/**
 * �� ����Ʈ�� ��ȸ�� �� ������ �Ǵ� (where ���� ����) ī�װ� ��, ��ǰ���� �˻��� ��, ���۹�ȣ, ����ȣ�� �����ϴ� VO
 * �� ����Ʈ ��ȸ�� �� �̰Ÿ� vo�� ���õ��� ��������ϴ� (-.-)(__)(-.-)
 * @author sist24
 */
public class ItemRangeVO {
	
	private String cate_name, search_word;
	private int start_num, end_num;
	
	public ItemRangeVO() {
	}
	
	/**
	 * ������������ �޾� �ش� ���������� ������ �Խñ��� ���۹�ȣ�� ����ȣ�� ���ϴ� method
	 * @param current_page
	 */
	public ItemRangeVO(int current_page) {
		PaginationService pService=new PaginationService();
		this.start_num=pService.startNum(current_page);
		this.end_num=pService.endNum(current_page);
	}
	
	/**
	 * ����������, ī�װ� ��ȣ, ��ǰ���� �˻��� ���� �޾� ���� �ʱ�ȭ�ϴ� method
	 * @param current_page
	 * @param column_name
	 * @param column_value
	 */
	public ItemRangeVO(int current_page, String cate_name, String search_word) {
		PaginationService pService=new PaginationService();
		this.start_num=pService.startNum(current_page);
		this.end_num=pService.endNum(current_page);
		this.cate_name = cate_name;
		this.search_word = search_word;
	}

	public ItemRangeVO(String cate_name, String search_word, int start_num, int end_num) {
		this.cate_name = cate_name;
		this.search_word = search_word;
		this.start_num = start_num;
		this.end_num = end_num;
	}

	public String getCate_name() {
		return cate_name;
	}

	public void setCate_name(String cate_name) {
		this.cate_name = cate_name;
	}

	public String getSearch_word() {
		return search_word;
	}

	public void setSearch_word(String search_word) {
		this.search_word = search_word;
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
