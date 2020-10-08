package kr.co.collie.mgr.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.collie.mgr.dao.GetCollieHandler;
import kr.co.collie.mgr.member.domain.MgrMemberDetailDomain;
import kr.co.collie.mgr.member.domain.MgrMemberListDomain;
import kr.co.collie.mgr.pagination.RangeVO;

public class MgrMemberDAO {
	
	private static MgrMemberDAO mmDAO;
	
	private MgrMemberDAO() {
	}
	
	public static MgrMemberDAO getInstance() {
		if(mmDAO==null) {
			mmDAO=new MgrMemberDAO();
		}//end if
		return mmDAO;
	}//getInstance
	
	public List<MgrMemberListDomain> selectMemberList(RangeVO rVO){
		List<MgrMemberListDomain> list=null;
		
		SqlSession ss=GetCollieHandler.getInstance().getSqlSession();
		list=ss.selectList("selectMemberList", rVO);
		ss.close();
		
		return list;
	}//selectMemberList
	
	public MgrMemberDetailDomain selectMemberDetail(int memberNum) {
		MgrMemberDetailDomain mmdd=null;
		
		SqlSession ss=GetCollieHandler.getInstance().getSqlSession();
		mmdd=ss.selectOne("selectMemberDetail", memberNum);
		ss.close();
		
		return mmdd;
	}//selectMemberDetail
	
}//class
