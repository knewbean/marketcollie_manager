package kr.co.collie.mgr.order.service;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.co.collie.mgr.order.dao.MgrOrderDAO;
import kr.co.collie.mgr.order.domain.MgrOrderListDomain;
import kr.co.collie.mgr.order.domain.MgrOrderShippingDomain;
import kr.co.collie.mgr.order.vo.MgrOrderShippingVO;
import kr.co.collie.mgr.pagination.PaginationService;
import kr.co.collie.mgr.pagination.RangeVO;
import kr.co.collie.mgr.pagination.TotalCntVO;

public class MgrOrderService {
	
	public List<MgrOrderListDomain> getOrderList(RangeVO rVO){
		List<MgrOrderListDomain> list=null;
		
		list=MgrOrderDAO.getInstance().selectOrderList(rVO);
		
		return list;
	}//getOrderList
	
	public String moveOrderList(int current_page) {
		JSONObject json=new JSONObject();
		
		RangeVO rVO=new RangeVO(current_page); 
		List<MgrOrderListDomain> list=MgrOrderDAO.getInstance().selectOrderList(rVO); 
		
		String flag="fail";
		if(list!=null) {
			flag="success";
			JSONArray jsonArr=new JSONArray();
			JSONObject jsonObj=null;
			for(int i=0; i<list.size(); i++) {
				jsonObj=new JSONObject();
				jsonObj.put("order_num",list.get(i).getOrder_num());
				jsonObj.put("member_num",list.get(i).getMember_num());
				jsonObj.put("total_price",list.get(i).getTotal_price());
				jsonObj.put("input_date",list.get(i).getInput_date());
				jsonObj.put("shipping_flag",list.get(i).getShipping_flag());
				jsonArr.add(jsonObj);
			}//end for
			json.put("order_list", jsonArr);
			
			TotalCntVO tcVO=new TotalCntVO();
			tcVO.setTable_name("order_form");
			PaginationService ps=new PaginationService();
			String pagination=ps.getPagination(current_page, tcVO);
			
			json.put("paging", pagination);
		}//end if
		
		json.put("flag", flag);
		
		return json.toJSONString();
	}//moveCategoryList
	
	public MgrOrderShippingDomain getOrderShipping(int orderNum) {
		MgrOrderShippingDomain mosd=null;
		
		mosd=MgrOrderDAO.getInstance().selectOrderShipping(orderNum);
		
		return mosd;
	}//getOrderShipping
	
	public boolean modifyOrderShipping(MgrOrderShippingVO mosVO) {
		boolean flag=false;
		
		int cnt=MgrOrderDAO.getInstance().updateOrderShipping(mosVO);
		if(cnt==1) {
			flag=true;
		}//end if
		
		return flag;
	}//modifyOrderShipping
	
}//class
