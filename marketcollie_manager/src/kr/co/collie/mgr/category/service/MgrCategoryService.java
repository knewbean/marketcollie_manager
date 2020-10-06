package kr.co.collie.mgr.category.service;

import java.util.List;

import kr.co.collie.mgr.category.dao.MgrCategoryDAO;
import kr.co.collie.mgr.category.domain.CategoryListDomain;
import kr.co.collie.mgr.pagination.RangeVO;

public class MgrCategoryService {
	
	public List<CategoryListDomain> getCategoryList(RangeVO rVO){
		List<CategoryListDomain> list=null;
		
		list=MgrCategoryDAO.getInstance().selectCategoryList(rVO);
		
		return list;
	}//getCategoryList
	
}//class
