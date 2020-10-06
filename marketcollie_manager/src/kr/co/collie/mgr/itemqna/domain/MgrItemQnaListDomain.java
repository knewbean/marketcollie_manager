package kr.co.collie.mgr.itemqna.domain;

public class MgrItemQnaListDomain {
	private int item_qna_num;
	private String id, item_qna_subject;
	private char item_qna_flag;
	
	public int getItem_qna_num() {
		return item_qna_num;
	}
	public String getId() {
		return id;
	}
	public String getItem_qna_subject() {
		return item_qna_subject;
	}
	public char getItem_qna_flag() {
		return item_qna_flag;
	}
	public void setItem_qna_num(int item_qna_num) {
		this.item_qna_num = item_qna_num;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setItem_qna_subject(String item_qna_subject) {
		this.item_qna_subject = item_qna_subject;
	}
	public void setItem_qna_flag(char item_qna_flag) {
		this.item_qna_flag = item_qna_flag;
	}
	
}
