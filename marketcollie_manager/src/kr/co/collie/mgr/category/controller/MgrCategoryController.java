package kr.co.collie.mgr.category.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.collie.mgr.category.domain.CategoryListDomain;
import kr.co.collie.mgr.category.service.MgrCategoryService;
import kr.co.collie.mgr.pagination.PaginationService;
import kr.co.collie.mgr.pagination.RangeVO;
import kr.co.collie.mgr.pagination.TotalCntVO;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

@Controller
public class MgrCategoryController {
	
	@RequestMapping(value="/category/list.do", method=GET)
	public String getCategoryList(Model model) {
		
		//ó�� ����Ʈ�� �Ҹ����� 1�������̹Ƿ� current_page�� 1�� �ش�
		int current_page=1;
		RangeVO rVO=new RangeVO(current_page); //RangeVO�� ������������ �Ѱ��ָ� ��ȸ�ؾ��� ����Ʈ�� ���۹�ȣ, ����ȣ�� �ʱ�ȭ�Ѵ�
		List<CategoryListDomain> list=new MgrCategoryService().getCategoryList(rVO); //RangeVO�� ���� ����Ʈ�� ��ȸ
		
		TotalCntVO tcVO=new TotalCntVO();
		tcVO.setTable_name("category");
		
		PaginationService ps=new PaginationService();
		String pagination=ps.getPagination(current_page, tcVO);
		
		model.addAttribute("cate_list", list);
		model.addAttribute("paging", pagination);
		
		return "cate/view_cate_list";
	}//getCategoryList
	
	@RequestMapping(value="/category/move_cate_list.do", method=POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String moveCategoryList(int current_page) throws NumberFormatException {
		String json=null;
		json=new MgrCategoryService().moveCategoryList(current_page);
		return json;
	}//moveCategoryList
	
}//class
