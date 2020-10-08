package kr.co.collie.mgr.review.domain;

public class MgrReviewListDomain {
	private int review_num;
	private String id, review_subject, input_date;
	
	public int getReview_num() {
		return review_num;
	}
	public String getId() {
		return id;
	}
	public String getReview_subject() {
		return review_subject;
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
	public void setReview_subject(String review_subject) {
		this.review_subject = review_subject;
	}
	public void setInput_date(String input_date) {
		this.input_date = input_date;
	}
	
}
