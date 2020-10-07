package kr.co.collie.mgr.itemqna.domain;

public class MgrItemQnaDetailDomain {
	private String id, email, phone, item_qna_subject, item_qna_content, item_qna_reply;

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getItem_qna_subject() {
		return item_qna_subject;
	}

	public String getItem_qna_content() {
		return item_qna_content;
	}

	public String getItem_qna_reply() {
		return item_qna_reply;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setItem_qna_subject(String item_qna_subject) {
		this.item_qna_subject = item_qna_subject;
	}

	public void setItem_qna_content(String item_qna_content) {
		this.item_qna_content = item_qna_content;
	}

	public void setItem_qna_reply(String item_qna_reply) {
		this.item_qna_reply = item_qna_reply;
	}
	
}
