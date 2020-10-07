package kr.co.collie.mgr.category.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.collie.mgr.category.domain.CategoryListDomain;
import kr.co.collie.mgr.category.service.MgrCategoryService;
import kr.co.collie.mgr.pagination.PaginationService;
import kr.co.collie.mgr.pagination.RangeVO;
import kr.co.collie.mgr.pagination.TotalCntVO;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

@Controller
public class MgrCategoryController {
	
	@RequestMapping(value="/category/list.do", method=GET)
	public String getCategoryList(Model model) {
		int current_page=1;
		PaginationService ps=new PaginationService();
		RangeVO rVO=new RangeVO();
		rVO.setStart_num(ps.startNum(current_page));
		rVO.setEnd_num(ps.endNum(current_page));
		
		List<CategoryListDomain> list=new MgrCategoryService().getCategoryList(rVO);
		
		TotalCntVO tcVO=new TotalCntVO();
		tcVO.setTable_name("category");
		String pagination=ps.getPagination(current_page, tcVO);
		
		model.addAttribute("cate_list", list);
		model.addAttribute("paging", pagination);
		
		return "cate/view_cate_list";
	}//getCategoryList
	
}//class
