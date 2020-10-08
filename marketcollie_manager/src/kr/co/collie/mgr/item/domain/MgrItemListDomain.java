package kr.co.collie.mgr.item.domain;

public class MgrItemListDomain {

	private int item_num, item_price;
	private String cate_name, item_stock,item_name, item_unit, item_weight, input_date;
	
	
	public int getItem_num() {
		return item_num;
	}
	public void setItem_num(int item_num) {
		this.item_num = item_num;
	}
	public int getItem_price() {
		return item_price;
	}
	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}
	public String getCate_name() {
		return cate_name;
	}
	public void setCate_name(String cate_name) {
		this.cate_name = cate_name;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getItem_unit() {
		return item_unit;
	}
	public void setItem_unit(String item_unit) {
		this.item_unit = item_unit;
	}
	public String getItem_weight() {
		return item_weight;
	}
	public void setItem_weight(String item_weight) {
		this.item_weight = item_weight;
	}
	public String getInput_date() {
		return input_date;
	}
	public void setInput_date(String input_date) {
		this.input_date = input_date;
	}
	public String getItem_stock() {
		return item_stock;
	}
	public void setItem_stock(String item_stock) {
		this.item_stock = item_stock;
	}
	
}
