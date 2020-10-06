package kr.co.collie.mgr.item.domain;

import java.util.List;

public class MgrItemDetailDomain {
	private int cate_num, price, item_stock;
	private String cate_name, item_name, item_unit, item_weight, item_img, item_guide, item_title, item_subtitle, item_detail;
	
	private List<String> detail_img;

	public int getCate_num() {
		return cate_num;
	}

	public void setCate_num(int cate_num) {
		this.cate_num = cate_num;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getItem_stock() {
		return item_stock;
	}

	public void setItem_stock(int item_stock) {
		this.item_stock = item_stock;
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

	public String getItem_img() {
		return item_img;
	}

	public void setItem_img(String item_img) {
		this.item_img = item_img;
	}

	public String getItem_guide() {
		return item_guide;
	}

	public void setItem_guide(String item_guide) {
		this.item_guide = item_guide;
	}

	public String getItem_title() {
		return item_title;
	}

	public void setItem_title(String item_title) {
		this.item_title = item_title;
	}

	public String getItem_subtitle() {
		return item_subtitle;
	}

	public void setItem_subtitle(String item_subtitle) {
		this.item_subtitle = item_subtitle;
	}

	public String getItem_detail() {
		return item_detail;
	}

	public void setItem_detail(String item_detail) {
		this.item_detail = item_detail;
	}

	public List<String> getDetail_img() {
		return detail_img;
	}

	public void setDetail_img(List<String> detail_img) {
		this.detail_img = detail_img;
	}
	
	
	
}//class
