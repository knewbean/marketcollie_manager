package kr.co.collie.mgr.pagination;

import org.apache.ibatis.session.SqlSession;

import kr.co.collie.mgr.dao.GetCollieHandler;

public class PaginationDAO {
	
	private static PaginationDAO pDAO;
	
	private PaginationDAO() {
	}//PaginationDAO
	
	public static PaginationDAO getInstance() {
		if(pDAO == null) {
			pDAO = new PaginationDAO();
		}
		return pDAO;
	}//getInstance
	
	public int selectTotalCnt(TotalCntVO tcVO) {
		int cnt=0;
		
		SqlSession ss=GetCollieHandler.getInstance().getSqlSession();
		cnt=ss.selectOne("selectTotalCnt", tcVO);
		ss.close();
		
		return cnt;
	}//selectTotalCnt
	
}//class
