package kr.co.collie.mgr.pagination;

/**
 * ��ȸ�� ����Ʈ�� �� ������ ��ȸ�� �� ���Ǵ� VO
 * @author sist24
 */
public class TotalCntVO {
	
	private String table_name, column_name, column_value;

	public TotalCntVO() {
	}
	
	public TotalCntVO(String table_name) {
		this.table_name = table_name;
	}
	
	public TotalCntVO(String table_name, String column_name, String column_value) {
		this.table_name = table_name;
		this.column_name = column_name;
		this.column_value = column_value;
	}

	public String getTable_name() {
		return table_name;
	}

	public void setTable_name(String table_name) {
		this.table_name = table_name;
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
	
}//class
