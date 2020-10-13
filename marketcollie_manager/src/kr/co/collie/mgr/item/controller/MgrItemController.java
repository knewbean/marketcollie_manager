package kr.co.collie.mgr.item.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.collie.mgr.category.domain.CategoryListDomain;
import kr.co.collie.mgr.item.domain.MgrItemListDomain;
import kr.co.collie.mgr.item.service.MgrItemService;
import kr.co.collie.mgr.item.vo.MgrItemAddVO;
import kr.co.collie.mgr.item.vo.MgrItemModifyVO;
import kr.co.collie.mgr.pagination.ItemRangeVO;
import kr.co.collie.mgr.pagination.PaginationService;

@Controller
public class MgrItemController {
	
	@RequestMapping(value="/item/item_list.do", method = {GET,POST} )
	public String SearchItem(Model model) {
		int current_page=1;
		ItemRangeVO irVO=new ItemRangeVO(current_page);
		
		MgrItemService mis=new MgrItemService();
		
		List<MgrItemListDomain> list = mis.getAllCate(irVO);
		List<CategoryListDomain> cateList = mis.getCategory();
		
		int totalCnt=mis.getTotalCnt(irVO);
		String pagination=new PaginationService().getPagination(current_page, totalCnt);
		
		model.addAttribute("item_list", list);
		model.addAttribute("paging",pagination);
		model.addAttribute("cate_list",cateList);
		
		return "/item/item_list";
	}//searchItem
	
	@RequestMapping(value = "/item/item_search_list.do",method =GET , produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String SearchItemList(String current_page, String cate_name, String search_word) throws NumberFormatException {
		String json="";
		if(current_page==null || "".equals(current_page) || "undefined".equals(current_page)) {
			current_page="1";
		}//end if
		
		int currentPage=Integer.parseInt(current_page);
		ItemRangeVO irVO=new ItemRangeVO(currentPage, cate_name, search_word);
		MgrItemService mis= new MgrItemService();
		
		json=mis.getSearchItem(irVO, currentPage);
		
		return json;
	}//
	
	
	@RequestMapping(value = "/mgr/item/detail.do")
	public String getItemDetail(String item_num, Model model) {
		
		
		
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
		
		boolean flag = new MgrItemService().addItem(miaVO);
		
		return "add_item";
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













