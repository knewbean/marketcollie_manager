package kr.co.collie.mgr.item.service;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.co.collie.mgr.category.domain.CategoryListDomain;
import kr.co.collie.mgr.item.dao.MgrItemDAO;
import kr.co.collie.mgr.item.domain.MgrItemDetailDomain;
import kr.co.collie.mgr.item.domain.MgrItemListDomain;
import kr.co.collie.mgr.item.vo.MgrItemAddVO;
import kr.co.collie.mgr.item.vo.MgrItemModifyVO;
import kr.co.collie.mgr.pagination.ItemRangeVO;
import kr.co.collie.mgr.pagination.PaginationService;

public class MgrItemService {
	
	
	public List<MgrItemListDomain> getAllCate(ItemRangeVO irVO){
		
		List<MgrItemListDomain> list =null;
		
		MgrItemDAO miDAO = MgrItemDAO.getInstance();
		list = miDAO.selectItemList(irVO);
		
		
		return list;
	}//getAllCate

	public String getSearchItem(ItemRangeVO irVO, int currentPage){
		JSONObject json = new JSONObject();
		
		List<MgrItemListDomain> list = null;

		MgrItemDAO miDAO = MgrItemDAO.getInstance();
		
		list = miDAO.selectItemList(irVO);
		String flag = "fail";
		if(list!=null) {
			flag="success";
			JSONArray jsonArr = new JSONArray();
			JSONObject jsonObj = null;
			
			for(int i=0; i<list.size();i++) {
				jsonObj= new JSONObject();
				jsonObj.put("item_num", list.get(i).getItem_num());
				jsonObj.put("item_price", list.get(i).getItem_price());
				jsonObj.put("cate_name", list.get(i).getCate_name());
				jsonObj.put("item_stock", list.get(i).getItem_stock());
				jsonObj.put("item_name", list.get(i).getItem_name());
				jsonObj.put("item_unit", list.get(i).getItem_unit());
				jsonObj.put("item_weight", list.get(i).getItem_weight());
				jsonObj.put("input_date", list.get(i).getInput_date());
				jsonArr.add(jsonObj);
			}//end for
			json.put("item_list", jsonArr);
			
			int totalCnt=miDAO.selectItemListCnt(irVO);
			
			String pagination=new PaginationService().getPagination(currentPage, totalCnt);
			json.put("paging", pagination);
			
		}//end if
		json.put("flag", flag);
		
		return json.toJSONString();
	}//getSearchItem
	
	public int getTotalCnt(ItemRangeVO irVO) {
		int cnt=0;
		
		cnt=MgrItemDAO.getInstance().selectItemListCnt(irVO);
		
		return cnt;
	}//getTotalCnt
	
	public List<CategoryListDomain> getCategory(){
		List<CategoryListDomain> list = null;
		
		list=MgrItemDAO.getInstance().selectCategory();
		return list;
	}
	
	
	public MgrItemDetailDomain getItemDetail(int i) {
		MgrItemDetailDomain midd = null;
		
		return midd;
	}//getItemDetail
	
	public boolean addItem(MgrItemAddVO miaVO) {
		boolean flag = false;
		
		MgrItemDAO miDAO = MgrItemDAO.getInstance();
		flag = miDAO.insertItem(miaVO) != 0;
		
		
		return flag;
	}//addItem
	
	public boolean modifyItem(MgrItemModifyVO mimVO) {
		boolean flag = false;
		
		return flag;
	}//modifyItem
	
	public boolean removeItem(int i) {
		boolean flag = false;
		
		
		return flag;
	}//removeItem
	
}//class
