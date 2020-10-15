package kr.co.collie.mgr.order.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.collie.mgr.order.domain.MgrOrderDetailDomain;
import kr.co.collie.mgr.order.domain.MgrOrderListDomain;
import kr.co.collie.mgr.order.domain.MgrOrderShippingDomain;
import kr.co.collie.mgr.order.service.MgrOrderService;
import kr.co.collie.mgr.order.vo.MgrOrderShippingVO;
import kr.co.collie.mgr.pagination.PaginationService;
import kr.co.collie.mgr.pagination.RangeVO;
import kr.co.collie.mgr.pagination.TotalCntVO;

@Controller
public class MgrOrderController {
	
	@RequestMapping(value="/order/list.do", method= {GET, POST})
	public String getOrderList(String current_page,Model model) {
		
		if(current_page==null || "".equals(current_page)) {
			current_page="1";
		}//end if
		int currentPage=Integer.parseInt(current_page);
		
		RangeVO rVO=new RangeVO(currentPage);
		List<MgrOrderListDomain> list=new MgrOrderService().getOrderList(rVO);
		
		TotalCntVO tcVO=new TotalCntVO();
		tcVO.setTable_name("order_form");
		PaginationService ps=new PaginationService();
		String pagination=ps.getPagination(currentPage, tcVO);
		
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
	public String modifyShippingForm(int order_num, String current_page, Model model) {
		
		//배송상태, 택배사코드, 운송장 번호 조회해오기
		MgrOrderShippingDomain mosd=new MgrOrderService().getOrderShipping(order_num);
		model.addAttribute("shipping", mosd);
		model.addAttribute("current_page", current_page);
		
		return "order/modify_shipping_form";
	}//modifyShipping
	
	@RequestMapping(value="/order/modify_shipping_process.do", method=POST)
	public String modifyShipping(MgrOrderShippingVO mosVO) {
		String url="";
		
		boolean flag=new MgrOrderService().modifyOrderShipping(mosVO);
		if(flag) {
			url="forward:/order/list.do";
		}//end if
		
		return url;
	}//modifyShipping
	
	@RequestMapping(value="/order/detail.do", method=GET)
	public String viewOrderDetail(int order_num, String current_page, Model model) {
		MgrOrderDetailDomain modd=new MgrOrderService().getOrderDetail(order_num);
		
		model.addAttribute("order_detail", modd);
		model.addAttribute("current_page", current_page);
		
		return "order/view_order_detail";
	}//modifyShipping
}//class
