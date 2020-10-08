package kr.co.collie.mgr.pagination;

/**
 * �� ����Ʈ�� ��ȸ�� �� ������ �Ǵ� (where ���� ����) ī�װ� ��, ��ǰ���� �˻��� ��, ���۹�ȣ, ����ȣ�� �����ϴ� VO
 * �� ����Ʈ ��ȸ�� �� �̰Ÿ� vo�� ���õ��� ��������ϴ� (-.-)(__)(-.-)
 * @author sist24
 */
public class ItemRangeVO {
	
	private String cate_value, item_name_value;
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
