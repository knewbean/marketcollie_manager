package kr.co.collie.mgr.pagination;

public class PaginationService {
	
	/**
	 * 테이블명, 컬럼명, 컬럼값을 저장하는 TotalCntVO를 매개변수로 받아 조건에 맞는 행의 수를 구하는 method
	 * tcVO 중 테이블명은 반드시 값을 가지고 있어야하고, 컬럼명과 컬럼값은 null이어도 된다.
	 * @param tcVO
	 * @return
	 */
	public int getTotalCnt(TotalCntVO tcVO) {
		int cnt=0;
		
		cnt=PaginationDAO.getInstance().selectTotalCnt(tcVO);
		
		return cnt;
	}//getTotalCnt
	
	/**
	 * 한 페이지에서 보여줄 게시글의 수 (10개)
	 * @return
	 */
	public int pageScale() {
		int page_scale=1;
		
		return page_scale;
	}//pageScale
	
	/**
	 * 현재 페이지를 받아 게시글의 시작번호를 구하는 method
	 * @param currentPage
	 * @return
	 */
	public int startNum( int current_page ) {
		int page_scale=pageScale();
		int start_num=(current_page-1)*page_scale+1 ;
		return start_num;
	}//startNum
	
	/**
	 * 현재 페이지를 받아 게시글의 끝번호를 구하는 method
	 * @param currentPage
	 * @return
	 */
	public int  endNum( int current_page ) {
		int page_scale=pageScale();
		int end_num=((current_page-1)*page_scale+1)+page_scale-1;
		return end_num;
	}//startNum
	
	/**
	 * 현재 페이지와 테이블명, 컬럼명, 컬럼값을 저장하는 TotalCntVO를 매개변수로 받아 
	 * 이전페이지, 다음페이지, 시작페이지, 끝페이지를 구하는 method
	 * @param currentPage
	 * @param totalCnt
	 * @return
	 */
	public PageVO calcPaging(int current_page, TotalCntVO tcVO) {
		PageVO pVO=null;
		int total_cnt=getTotalCnt(tcVO);
		
		int page_scale=pageScale();
		int total_page=(int)Math.ceil((double)total_cnt/page_scale);
		
		int page_range=5;
		int start_page=((current_page-1)/page_range)*page_range+1;
		int end_page=start_page+page_range-1;
		if(total_page < end_page) {
			end_page = total_page;
		}//end if
		
		int pre_page=start_page - page_range;
		int next_page=start_page + page_range;
		
		if( pre_page < 1 ) { //"이전" 버튼을 비활성화하는 조건
			pre_page=-1;
		}//end if
		
		if( total_page<next_page ){ //"다음" 버튼을 비활성화하는 조건
			next_page=-1;
		}//end if
		
		pVO=new PageVO(current_page, pre_page, next_page, start_page, end_page, total_page);
		
		return pVO;
	}//calcPage
	
	public PageVO calcPaging(int current_page, int total_cnt) {
		PageVO pVO=null;
		
		int page_scale=pageScale();
		int total_page=(int)Math.ceil((double)total_cnt/page_scale);
		
		int page_range=5;
		int start_page=((current_page-1)/page_range)*page_range+1;
		int end_page=start_page+page_range-1;
		if(total_page < end_page) {
			end_page = total_page;
		}//end if
		
		int pre_page=start_page - page_range;
		int next_page=start_page + page_range;
		
		if( pre_page < 1 ) { //"이전" 버튼을 비활성화하는 조건
			pre_page=-1;
		}//end if
		
		if( total_page < next_page ){ //"다음" 버튼을 비활성화하는 조건
			next_page=-1;
		}//end if
		
		pVO=new PageVO(current_page, pre_page, next_page, start_page, end_page, total_page);
		
		return pVO;
	}//calcPage
	
	/**
	 * 현재 페이지와 테이블명, 컬럼명, 컬럼값을 저장하는 TotalCntVO를 매개변수로 받아 
	 * 게시글 밑에 추가되는 페이지네이션 view 코드를 String으로 리턴해주는 method
	 * 사용하시는 분은 이거 String으로 받아서 Model에 넣어서 view페이지에서 
	 * <c:out var="${ model에 넣은 이름 }" escapeXml="false"/> 로 쓰시면 페이지네이션이 생깁니다아
	 * @param currentPage
	 * @param tcVO
	 * @return
	 */
	public String getPagination(int currentPage, TotalCntVO tcVO) {
		StringBuilder view =new StringBuilder();
		PageVO pVO=calcPaging(currentPage, tcVO);
		
		view.append("<nav aria-label='Page navigation example'>\n")
		.append("<ul class='pagination justify-content-center'>\n")
		.append("<li class='page-item");
		if(pVO.getPre_page() == -1) {
			view.append(" disabled'>\n");
		}else {
			view.append(" active'>\n");
		}//end else
		view.append("<a class='page-link'");
		if( pVO.getPre_page() != -1) {
			view.append(" onclick='movePage(")
			.append(pVO.getPre_page())
			.append(")'"); 
		}//end if
		view.append(" aria-label='Previous'>\n")
		.append("<span aria-hidden='true'>&laquo;</span>\n")
		.append("</a>\n")
		.append("</li>\n");
		
		for(int i=pVO.getStart_page(); i<=pVO.getEnd_page(); i++) {
			//class active 추가 css 사용시 아래와 같이 사용
			//.page-item.active {background-color:#17462B; border-color:#17462B;}
			view.append("<li class=\"page-item");
			if( pVO.getCurrent_page() != i) {
				view.append(" active");
			}
			view.append("\">");
			
			view.append("<a class='page-link'");
			if( pVO.getCurrent_page() != i) {
				view.append(" onclick='movePage(")
				.append(i)
				.append(")'"); 
			}else {
				view.append(" style='background-color:#77AF9C; border-color:#77AF9C; color:#fff'");
			}//end else
			view.append(">\n")
			.append(i)
			.append("</a>\n")
			.append("</li>\n");
		}//end for
		
		view.append("<li class='page-item");
		if(pVO.getNext_page()==-1) {
			view.append(" disabled'>\n");
		}else {
			view.append(" active'>\n");
		}//end else
		view.append("<a class='page-link'");
		if( pVO.getNext_page()!=-1 ) {
			view.append(" onclick='movePage(")
			.append(pVO.getNext_page())
			.append(")'"); 
		}//end if
		view.append(" aria-label='Next'>\n")
		.append("<span aria-hidden='true'>&raquo;</span>\n")
		.append("</a>\n")
		.append("</li>\n")
		.append("</ul>\n")
		.append("</nav>\n");
		
		return view.toString();
	}//getPagination
	
	/**
	 * 테이블을 join해야하는 경우 사용할 method
	 * @param currentPage
	 * @param total_cnt
	 * @return
	 */
	public String getPagination(int currentPage, int total_cnt) {
		StringBuilder view =new StringBuilder();
		PageVO pVO=calcPaging(currentPage, total_cnt);
		
		view.append("<nav aria-label='Page navigation example'>\n")
		.append("<ul class='pagination justify-content-center'>\n")
		.append("<li class='page-item");
		if(pVO.getPre_page() == -1) {
			view.append(" disabled'>\n");
		}else {
			view.append(" active'>\n");
		}//end else
		view.append("<a class='page-link'");
		if( pVO.getPre_page() != -1) {
			view.append(" onclick='movePage(")
			.append(pVO.getPre_page())
			.append(")'"); 
		}//end if
		view.append(" aria-label='Previous'>\n")
		.append("<span aria-hidden='true'>&laquo;</span>\n")
		.append("</a>\n")
		.append("</li>\n");
		
		for(int i=pVO.getStart_page(); i<=pVO.getEnd_page(); i++) {
			view.append("<li class=\"page-item");
			if( pVO.getCurrent_page() != i) {
				view.append(" active");
			}
			view.append("\">");
			view.append("<a class='page-link'");
			if( pVO.getCurrent_page() != i) {
				view.append(" onclick='movePage(")
				.append(i)
				.append(")'"); 
			}else {
				view.append(" style='background-color:#77AF9C; border-color:#77AF9C; color:#fff'");
			}//end else
			view.append(">\n")
			.append(i)
			.append("</a>\n")
			.append("</li>\n");
		}//end for
		
		view.append("<li class='page-item");
		if(pVO.getNext_page() == -1) {
			view.append(" disabled'>\n");
		}else {
			view.append(" active'>\n");
		}//end else
		view.append("<a class='page-link'");
		if( pVO.getNext_page() != -1) {
			view.append(" onclick='movePage(")
			.append(pVO.getNext_page())
			.append(")'"); 
		}//end if
		view.append(" aria-label='Next'>\n")
		.append("<span aria-hidden='true'>&raquo;</span>\n")
		.append("</a>\n")
		.append("</li>\n")
		.append("</ul>\n")
		.append("</nav>\n");
		
		return view.toString();
	}//getPagination
	
}//class
