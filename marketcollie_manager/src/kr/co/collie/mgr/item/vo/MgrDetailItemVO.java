package kr.co.collie.mgr.item.vo;


public class MgrDetailItemVO {
	private int item_num;
	private String detail_img;
	
	public int getItem_num() {
		return item_num;
	}
	public void setItem_num(int item_num) {
		this.item_num = item_num;
	}
	 
	public String getDetail_img() {
		return detail_img;
	}
	public void setDetail_img(String detail_img) {
		this.detail_img = detail_img;
	}
	@Override
	public String toString() {
		return "MgrDetailItemVO [item_num=" + item_num + ", detail_img=" + detail_img + "]";
	}
	
	
}
