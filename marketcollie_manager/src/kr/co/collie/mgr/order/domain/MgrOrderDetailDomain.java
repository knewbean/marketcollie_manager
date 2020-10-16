package kr.co.collie.mgr.order.domain;

import java.util.List;

public class MgrOrderDetailDomain {
	
	private int member_num, total_price;
	private String payment, input_date, shipping_flag;
	private List<MgrOrderItemDomain> order_item;
	public int getMember_num() {
		return member_num;
	}
	public void setMember_num(int member_num) {
		this.member_num = member_num;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
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
	public List<MgrOrderItemDomain> getOrder_item() {
		return order_item;
	}
	public void setOrder_item(List<MgrOrderItemDomain> order_item) {
		this.order_item = order_item;
	}
	
}//class
