package kr.co.collie.mgr.order.domain;

public class MgrOrderListDomain {
	
	private int order_num, member_num;
	private String total_price, input_date, shipping_flag;
	public int getOrder_num() {
		return order_num;
	}
	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}
	public int getMember_num() {
		return member_num;
	}
	public void setMember_num(int member_num) {
		this.member_num = member_num;
	}
	public String getTotal_price() {
		return total_price;
	}
	public void setTotal_price(String total_price) {
		this.total_price = total_price;
	}
	public String getInput_date() {
		return input_date;
	}
	public void setInput_date(String input_date) {
		this.input_date = input_date;
	}
	public String getShipping_flag() {
		return shipping_flag;
	}
	public void setShipping_flag(String shipping_flag) {
		this.shipping_flag = shipping_flag;
	}
	
}//class
