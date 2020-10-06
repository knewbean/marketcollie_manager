package kr.co.collie.mgr.pagination;

public class PaginationService {
	
	public int getTotalCnt(TotalCntVO tcVO) {
		int cnt=0;
		
		cnt=PaginationDAO.getInstance().selectTotalCnt(tcVO);
		
		return cnt;
	}//getTotalCnt
	
	public int pageScale() {
		int pageScale=10;
		
		return pageScale;
	}//pageScale
	
	public int startNum( int currentPage ) {
		int pageScale=pageScale();
		int startNum=(currentPage-1)*pageScale+1 ;
		return startNum;
	}//startNum
	
	public int  endNum( int currentPage ) {
		int pageScale=pageScale();
		int endNum=((currentPage-1)*pageScale+1)+pageScale-1;
		return endNum;
	}//startNum
	
	public PageVO calcPaging(int currentPage, int totalCnt) {
		PageVO pVO=null;
		
		int pageScale=pageScale();
		int totalPage=(int)Math.ceil((double)totalCnt/pageScale);
		
		int pageRange=5;
		int startPage=((currentPage-1)/pageRange)*pageRange+1;
		int endPage=startPage+pageRange-1;
		if(totalPage < endPage) {
			endPage = totalPage;
		}//end if
		
		System.out.println("==========================totalCnt : "+totalCnt);
		System.out.println("==========================pageScale : "+pageScale);
		System.out.println("==========================totalPage : "+totalPage);
		System.out.println("==========================pageRange : "+pageRange);
		System.out.println("==========================startPage : "+startPage);
		System.out.println("==========================endPage : "+endPage);
		
		int prePage=currentPage - 1;
		int nextPage=currentPage + 1;
		
		if( prePage < 1 ) { //"이전" 버튼을 비활성화하는 조건
			prePage=currentPage;
		}//end if
		
		if( endPage<nextPage ){ //"다음" 버튼을 비활성화하는 조건
			nextPage=currentPage;
		}//end if
		
		pVO=new PageVO(currentPage, prePage, nextPage, startPage, endPage);
		
		return pVO;
	}//calcPage
	
	public String getPagination(int currentPage, TotalCntVO tcVO) {
		StringBuilder view =new StringBuilder();
		int totalCnt=getTotalCnt(tcVO);
		PageVO pVO=calcPaging(currentPage, totalCnt);
		
		view.append("<nav aria-label='Page navigation example'>\n")
		.append("<ul class='pagination justify-content-center'>\n")
		.append("<li class='page-item");
		if(pVO.getPrePage() <= 1) {
			view.append(" disabled'>\n");
		}else {
			view.append(" active'>\n");
		}//end else
		view.append("<a class='page-link'");
		if( pVO.getPrePage() > 1) {
			view.append(" onclick='movePage(")
			.append(pVO.getPrePage())
			.append(")'"); 
		}//end if
		view.append(" aria-label='Previous'>\n")
		.append("<span aria-hidden='true'>&laquo;</span>\n")
		.append("</a>\n")
		.append("</li>\n");
		
		System.out.println("===========================startpage: "+pVO.getStartPage());
		System.out.println("===========================endpage: "+pVO.getEndPage());
		for(int i=pVO.getStartPage(); i<=pVO.getEndPage(); i++) {
			view.append("<li class=\"page-item\">")
			.append("<a class='page-link'");
			if( pVO.getCurrentPage() != i) {
				view.append(" onclick='movePage(")
				.append(i)
				.append(")'"); 
			}//end if
			view.append(">\n")
			.append(i)
			.append("</a>\n")
			.append("</li>\n");
		}//end for
		
		view.append("<li class='page-item");
		if(pVO.getEndPage() < pVO.getNextPage()) {
			view.append(" disabled'>\n");
		}else {
			view.append(" active'>\n");
		}//end else
		view.append("<a class='page-link'");
		if( pVO.getEndPage() >= pVO.getNextPage()) {
			view.append(" onclick='movePage(")
			.append(pVO.getNextPage())
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
