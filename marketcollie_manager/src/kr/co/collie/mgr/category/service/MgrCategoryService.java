package kr.co.collie.mgr.category.service;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.co.collie.mgr.category.dao.MgrCategoryDAO;
import kr.co.collie.mgr.category.domain.CategoryListDomain;
import kr.co.collie.mgr.pagination.PaginationService;
import kr.co.collie.mgr.pagination.RangeVO;
import kr.co.collie.mgr.pagination.TotalCntVO;

public class MgrCategoryService {
	
	public List<CategoryListDomain> getCategoryList(RangeVO rVO){
		List<CategoryListDomain> list=null;
		
		list=MgrCategoryDAO.getInstance().selectCategoryList(rVO);
		
		return list;
	}//getCategoryList
	
	public String moveCategoryList(int current_page) {
		JSONObject json=new JSONObject();
		
		RangeVO rVO=new RangeVO(current_page); //RangeVO�� ������������ �Ѱ��ָ� ��ȸ�ؾ��� ����Ʈ�� ���۹�ȣ, ����ȣ�� �ʱ�ȭ�Ѵ�
		List<CategoryListDomain> list=MgrCategoryDAO.getInstance().selectCategoryList(rVO); //RangeVO�� ���� ����Ʈ�� ��ȸ
		
		String flag="fail";
		if(list!=null) {
			flag="success";
			JSONArray jsonArr=new JSONArray();
			JSONObject jsonObj=null;
			for(int i=0; i<list.size(); i++) {
				jsonObj=new JSONObject();
				jsonObj.put("cate_num",list.get(i).getCate_num());
				jsonObj.put("cate_name",list.get(i).getCate_name());
				jsonArr.add(jsonObj);
			}//end for
			json.put("cate_list", jsonArr);
			
			TotalCntVO tcVO=new TotalCntVO();
			tcVO.setTable_name("category");
			PaginationService ps=new PaginationService();
			String pagination=ps.getPagination(current_page, tcVO);
			
			json.put("paging", pagination);
		}//end if
		
		json.put("flag", flag);
		
		return json.toJSONString();
	}//moveCategoryList
	
}//class
