package kr.co.collie.mgr.item.vo;

public class SearchItemVO {
	private String category="";
	private String search_word = "";

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}


	public String getSearch_word() {
		return search_word;
	}

	public void setSearch_word(String search_word) {
		this.search_word = search_word;
	}

	@Override
	public String toString() {
		return "SearchItemVO [category=" + category + ", search_word=" + search_word + "]";
	}
	
	
	
	
}//class
