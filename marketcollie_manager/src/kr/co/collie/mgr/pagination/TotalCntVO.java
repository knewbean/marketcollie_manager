package kr.co.collie.mgr.pagination;

public class TotalCntVO {
	
	private String table_name, col_name, col_value;

	public TotalCntVO() {
	}
	
	public TotalCntVO(String table_name, String col_name, String col_value) {
		this.table_name = table_name;
		this.col_name = col_name;
		this.col_value = col_value;
	}

	public String getTable_name() {
		return table_name;
	}

	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}

	public String getCol_name() {
		return col_name;
	}

	public void setCol_name(String col_name) {
		this.col_name = col_name;
	}

	public String getCol_value() {
		return col_value;
	}

	public void setCol_value(String col_value) {
		this.col_value = col_value;
	}
	
}//class
