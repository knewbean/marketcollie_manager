package kr.co.collie.mgr.order.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.collie.mgr.order.domain.MgrOrderListDomain;
import kr.co.collie.mgr.order.service.MgrOrderService;
import kr.co.collie.mgr.pagination.PaginationService;
import kr.co.collie.mgr.pagination.RangeVO;
import kr.co.collie.mgr.pagination.TotalCntVO;

@Controller
public class MgrOrderController {
	
	@RequestMapping(value="/order/list.do", method=GET)
	public String getOrderList(Model model) {
		
		int current_page=1;
		RangeVO rVO=new RangeVO(current_page);
		List<MgrOrderListDomain> list=new MgrOrderService().getOrderList(rVO);
		
		TotalCntVO tcVO=new TotalCntVO();
		tcVO.setTable_name("order_form");
		PaginationService ps=new PaginationService();
		String pagination=ps.getPagination(current_page, tcVO);
		
		model.addAttribute("order_list", list);
		model.addAttribute("paging", pagination);
		
		return "order/view_order_list";
	}//getOrderList
	
	@RequestMapping(value="/order/move_order_list.do", method=POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String moveOrderList(int current_page) throws NumberFormatException {
		String json=null;
		json=new MgrOrderService().moveOrderList(current_page);
		return json;
	}//moveCategoryList
	
	@RequestMapping(value="/order/modify_shipping_form.do", method=GET)
	public String modifyShipping(String order_num) {
		
		//배송상태, 택배사코드, 운송장 번호 조회해오기
		
		return "order/modify_shipping_form";
	}//modifyShipping
	
}//class
