package kr.co.collie.mgr.order.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.collie.mgr.dao.GetCollieHandler;
import kr.co.collie.mgr.order.domain.MgrOrderListDomain;
import kr.co.collie.mgr.pagination.RangeVO;

public class MgrOrderDAO {
	
	private static MgrOrderDAO oDAO;
	
	private MgrOrderDAO() {
	}//OrderDAO
	
	public static MgrOrderDAO getInstance() {
		if(oDAO==null) {
			oDAO=new MgrOrderDAO();
		}//end if
		return oDAO;
	}//getInstance
	
	public List<MgrOrderListDomain> selectOrderList(RangeVO rVO){
		List<MgrOrderListDomain> list=null;
		
		SqlSession ss=GetCollieHandler.getInstance().getSqlSession();
		list=ss.selectList("selectOrderList", rVO);
		ss.close();
		
		return list;
	}//selectOrderList
	
}//class
