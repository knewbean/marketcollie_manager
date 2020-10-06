package kr.co.collie.mgr.item.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.collie.mgr.item.domain.MgrItemListDomain;
import kr.co.collie.mgr.item.service.MgrItemService;
import kr.co.collie.mgr.item.vo.MgrItemAddVO;
import kr.co.collie.mgr.item.vo.MgrItemModifyVO;
import kr.co.collie.mgr.item.vo.SearchItemVO;

@Controller
public class MgrItemController {
	
	@RequestMapping(value="/mgr/item/search_item.do")
	public String searchItem(SearchItemVO siVO, String s, Model model) {
		
		List<MgrItemListDomain> item_list = new MgrItemService().getSearchItem(siVO);
		
		model.addAttribute("item_list", item_list);
		
		return "";
	}//searchItem
	
	@RequestMapping(value = "/mgr/item/detail.do")
	public String getItemDetail(String s, Model model) {
		
		return "";
	}//getItemDetail
	
	@RequestMapping(value = "/mgr/item/add_form.do")
	public String addItemForm(Model model) {
		
		return "";
	}//addItemForm
	@RequestMapping(value="/mgr/item/add_item_image.do")
	public String addItemImage(HttpServletRequest request) {
		
		return "";
	}//addItemImage
	
	@RequestMapping(value = "/mgr/item/add_item_detail_image.do")
	public String addItemDetailImage(HttpServletRequest request) {
		
		
		return "";
	}//addItemDetailImage
	
	@RequestMapping(value = "/mgr/item/add_item_tab_image.do")
	public String addItemTabImg(HttpServletRequest request) {
		
		return "";
	}//addItemTabImg
	
	@RequestMapping(value = "/mgr/item/add_item.do")
	public String addItem(MgrItemAddVO miaVO) {
		
		return "";
	}//addItem
	
	@RequestMapping(value = "/mgr/item/modify_item.do")
	public String modifyItem(MgrItemModifyVO mimVO, Model model) {
		
		return "";
	}//modifyItem
	
	@RequestMapping(value = "/mgr/item/remove_item.do")
	public String removeItem(String s, Model model) {
		
		return "";
	}//removeItem
	
	
}//class













