package kr.co.collie.mgr.pagination;

public class PaginationService {
	
	/**
	 * ���̺��, �÷���, �÷����� �����ϴ� TotalCntVO�� �Ű������� �޾� ���ǿ� �´� ���� ���� ���ϴ� method
	 * tcVO �� ���̺���� �ݵ�� ���� ������ �־���ϰ�, �÷���� �÷����� null�̾ �ȴ�.
	 * @param tcVO
	 * @return
	 */
	public int getTotalCnt(TotalCntVO tcVO) {
		int cnt=0;
		
		cnt=PaginationDAO.getInstance().selectTotalCnt(tcVO);
		
		return cnt;
	}//getTotalCnt
	
	/**
	 * �� ���������� ������ �Խñ��� �� (10��)
	 * @return
	 */
	public int pageScale() {
		int page_scale=1;
		
		return page_scale;
	}//pageScale
	
	/**
	 * ���� �������� �޾� �Խñ��� ���۹�ȣ�� ���ϴ� method
	 * @param currentPage
	 * @return
	 */
	public int startNum( int current_page ) {
		int page_scale=pageScale();
		int start_num=(current_page-1)*page_scale+1 ;
		return start_num;
	}//startNum
	
	/**
	 * ���� �������� �޾� �Խñ��� ����ȣ�� ���ϴ� method
	 * @param currentPage
	 * @return
	 */
	public int  endNum( int current_page ) {
		int page_scale=pageScale();
		int end_num=((current_page-1)*page_scale+1)+page_scale-1;
		return end_num;
	}//startNum
	
	/**
	 * ���� �������� ���̺��, �÷���, �÷����� �����ϴ� TotalCntVO�� �Ű������� �޾� 
	 * ����������, ����������, ����������, ���������� ���ϴ� method
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
		
		if( pre_page < 1 ) { //"����" ��ư�� ��Ȱ��ȭ�ϴ� ����
			pre_page=-1;
		}//end if
		
		if( total_page<next_page ){ //"����" ��ư�� ��Ȱ��ȭ�ϴ� ����
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
		
		if( pre_page < 1 ) { //"����" ��ư�� ��Ȱ��ȭ�ϴ� ����
			pre_page=-1;
		}//end if
		
		if( total_page < next_page ){ //"����" ��ư�� ��Ȱ��ȭ�ϴ� ����
			next_page=-1;
		}//end if
		
		pVO=new PageVO(current_page, pre_page, next_page, start_page, end_page, total_page);
		
		return pVO;
	}//calcPage
	
	/**
	 * ���� �������� ���̺��, �÷���, �÷����� �����ϴ� TotalCntVO�� �Ű������� �޾� 
	 * �Խñ� �ؿ� �߰��Ǵ� ���������̼� view �ڵ带 String���� �������ִ� method
	 * ����Ͻô� ���� �̰� String���� �޾Ƽ� Model�� �־ view���������� 
	 * <c:out var="${ model�� ���� �̸� }" escapeXml="false"/> �� ���ø� ���������̼��� ����ϴپ�
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
			//class active �߰� css ���� �Ʒ��� ���� ���
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
	 * ���̺��� join�ؾ��ϴ� ��� ����� method
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
