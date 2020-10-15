package kr.co.collie.mgr.order.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.collie.mgr.dao.GetCollieHandler;
import kr.co.collie.mgr.order.domain.MgrOrderDetailDomain;
import kr.co.collie.mgr.order.domain.MgrOrderItemDomain;
import kr.co.collie.mgr.order.domain.MgrOrderListDomain;
import kr.co.collie.mgr.order.domain.MgrOrderShippingDomain;
import kr.co.collie.mgr.order.vo.MgrOrderShippingVO;
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
	
	public MgrOrderShippingDomain selectOrderShipping(int orderNum) {
		MgrOrderShippingDomain mosd=null;
		
		SqlSession ss=GetCollieHandler.getInstance().getSqlSession();
		mosd=ss.selectOne("selectOrderShipping", orderNum);
		ss.close();
		
		return mosd;
	}//selectOrderShipping
	
	public int updateOrderShipping(MgrOrderShippingVO mosVO) {
		int cnt=0;
		
		SqlSession ss=GetCollieHandler.getInstance().getSqlSession();
		cnt=ss.update("updateOrderShipping", mosVO);
		if(cnt==1) {
			ss.commit();
		}//end if
		ss.close();
		
		return cnt;
	}//updateOrderShipping
	
	public MgrOrderDetailDomain selectOrderDetail(int orderNum) {
		MgrOrderDetailDomain modd=null;
		List<MgrOrderItemDomain> list=null;
		
		SqlSession ss=GetCollieHandler.getInstance().getSqlSession();
		modd=ss.selectOne("selectOrderDetail",orderNum);
		list=ss.selectList("selectOrderItem",orderNum);
		modd.setOrder_item(list);
		
		return modd;
	}//selectOrderDetail
	
}//class
