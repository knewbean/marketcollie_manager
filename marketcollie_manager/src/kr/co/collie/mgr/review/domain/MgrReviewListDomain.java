package kr.co.collie.mgr.review.domain;

public class MgrReviewListDomain {
	private int review_num;
	private String id, review_subejct, input_date;
	
	public int getReview_num() {
		return review_num;
	}
	public String getId() {
		return id;
	}
	public String getReview_subejct() {
		return review_subejct;
	}
	public String getInput_date() {
		return input_date;
	}
	public void setReview_num(int review_num) {
		this.review_num = review_num;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setReview_subejct(String review_subejct) {
		this.review_subejct = review_subejct;
	}
	public void setInput_date(String input_date) {
		this.input_date = input_date;
	}
	
}
