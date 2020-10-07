package kr.co.collie.mgr.main.domain;

public class MgrLoginDomain {
	
	private String id;
	
	private String member_flag;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMember_flag() {
		return member_flag;
	}

	public void setMember_flag(String member_flag) {
		this.member_flag = member_flag;
	}

	@Override
	public String toString() {
		return "MgrLoginDomain [id=" + id + ", member_flag=" + member_flag + "]";
	}
	
	
	
}
