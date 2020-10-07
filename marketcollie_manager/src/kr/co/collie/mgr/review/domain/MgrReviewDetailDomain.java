package kr.co.collie.mgr.review.domain;

public class MgrReviewDetailDomain {
	private int review_num;
	private String id, review_subject, review_content;
	
	public int getReview_num() {
		return review_num;
	}
	public String getId() {
		return id;
	}
	public String getReview_subject() {
		return review_subject;
	}
	public String getReview_content() {
		return review_content;
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
	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}
	
}
