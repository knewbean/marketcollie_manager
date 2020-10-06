package kr.co.collie.mgr.item.service;

import java.util.List;

import kr.co.collie.mgr.item.dao.MgrItemDAO;
import kr.co.collie.mgr.item.domain.MgrCateListDomain;
import kr.co.collie.mgr.item.domain.MgrItemDetailDomain;
import kr.co.collie.mgr.item.domain.MgrItemListDomain;
import kr.co.collie.mgr.item.vo.MgrItemAddVO;
import kr.co.collie.mgr.item.vo.MgrItemModifyVO;
import kr.co.collie.mgr.item.vo.SearchItemVO;

public class MgrItemService {
	
	public List<MgrItemListDomain> getSearchItem(SearchItemVO siVO){
		List<MgrItemListDomain> list = null;
		MgrItemDAO miDAO = MgrItemDAO.getInstance();
		miDAO.selectItemList(siVO);
		
		
		
		return list;
	}//getSearchItem
	
	public List<MgrCateListDomain> getAllCate(){
		List<MgrCateListDomain> list =null;
		
		
		return list;
	}//getAllCate
	
	public MgrItemDetailDomain getItemDetail(int i) {
		MgrItemDetailDomain midd = null;
		
		return midd;
	}//getItemDetail
	
	public boolean addItem(MgrItemAddVO miaVO) {
		boolean flag = false;
		
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
