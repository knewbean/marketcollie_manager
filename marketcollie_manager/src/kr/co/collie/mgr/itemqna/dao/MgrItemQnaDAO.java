package kr.co.collie.mgr.itemqna.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.collie.mgr.dao.GetCollieHandler;
import kr.co.collie.mgr.itemqna.domain.MgrItemQnaDetailDomain;
import kr.co.collie.mgr.itemqna.domain.MgrItemQnaListDomain;
import kr.co.collie.mgr.itemqna.vo.MgrItemQnaUpdateVO;
import kr.co.collie.mgr.pagination.RangeVO;

public class MgrItemQnaDAO {
	
	private static MgrItemQnaDAO miqDAO;
	
	private MgrItemQnaDAO() {
	}//MgrItemQnaDAO
	
	public static MgrItemQnaDAO getInstance() {
		if( miqDAO == null ) {
			miqDAO = new MgrItemQnaDAO();
		}//end if
		return miqDAO;
	}//getInstance
	
	/**
	 * 상품문의 목록을 불러오는 일
	 * @param rVO
	 * @return
	 */
	public List<MgrItemQnaListDomain> selectItemQnaList(RangeVO rVO){
		List<MgrItemQnaListDomain> list = null;
		SqlSession ss = GetCollieHandler.getInstance().getSqlSession();
		list = ss.selectList("kr.co.collie.mgr.itemqna.selectItemQnaList", rVO);
		ss.close();
		
		return list;
	}//selectItemQnaList
	
	/**
	 * 상품문의 목록 개수를 세는 일
	 * @param rVO
	 * @return
	 */
	public int selectItemQnaListCnt(RangeVO rVO) {
		int cnt = 0;
		SqlSession ss = GetCollieHandler.getInstance().getSqlSession();
		cnt = ss.selectOne("kr.co.collie.mgr.itemqna.selectItemQnaListCnt", rVO);
		ss.close();
		
		return cnt;
	}//selectItemQnaListCnt
	
	/**
	 * 상품문의 상세내용을 확인하는 일
	 * @param item_qna_num
	 * @return
	 */
	public MgrItemQnaDetailDomain selectItemQnaDetail(int item_qna_num) {
		MgrItemQnaDetailDomain miqdd = null;
		SqlSession ss = GetCollieHandler.getInstance().getSqlSession();
		miqdd = ss.selectOne("kr.co.collie.mgr.itemqna.selectItemQnaDetail", item_qna_num);
		ss.close();
		
		return miqdd;
	}//selectItemQnaDetail
	
	/**
	 * 상품문의 답변을 등록 및 수정하는 일
	 * @param miquVO
	 * @return
	 */
	public int UpdateItemQnaReply(MgrItemQnaUpdateVO miquVO) {
		int cnt = 0;
		SqlSession ss = GetCollieHandler.getInstance().getSqlSession();
		cnt = ss.update("kr.co.collie.mgr.itemqna.updateItemQnaReply", miquVO);
		ss.commit();
		ss.close();
		
		return cnt;
	}//UpdateItemQnaReply
	
}//class
