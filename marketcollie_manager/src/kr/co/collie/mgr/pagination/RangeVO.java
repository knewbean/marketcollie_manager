package kr.co.collie.mgr.pagination;

/**
 * �� ����Ʈ�� ��ȸ�� �� ������ �Ǵ� (where ���� ����) �÷���, �÷���, ���۹�ȣ, ����ȣ�� �����ϴ� VO
 * �� ����Ʈ ��ȸ�� �� �̰Ÿ� vo�� ���õ��� ��������ϴ� (-.-)(__)(-.-)
 * @author sist24
 */
public class RangeVO {
	
	private String column_name, column_value;
	private int start_num, end_num;
	
	public RangeVO() {
	}
	
	/**
	 * ������������ �޾� �ش� ���������� ������ �Խñ��� ���۹�ȣ�� ����ȣ�� ���ϴ� method
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
