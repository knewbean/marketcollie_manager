package kr.co.collie.mgr.item.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.collie.mgr.category.domain.CategoryListDomain;
import kr.co.collie.mgr.dao.GetCollieHandler;
import kr.co.collie.mgr.item.domain.MgrItemListDomain;
import kr.co.collie.mgr.item.vo.MgrItemAddVO;
import kr.co.collie.mgr.item.vo.MgrItemModifyVO;
import kr.co.collie.mgr.item.vo.SearchItemVO;

public class MgrItemDAO {
	
	private static MgrItemDAO miDAO;
	
	private MgrItemDAO() {
		
	}//MgrItemDAO
	
	public static MgrItemDAO getInstance(){
		if(miDAO==null) {
			miDAO= new MgrItemDAO();
		}//end if
		return miDAO;
	}//getInstance
	
	
	public List<MgrItemListDomain> selectItemList(SearchItemVO siVO){
		
		
		List<MgrItemListDomain> list = null;
		
		SqlSession ss =  GetCollieHandler.getInstance().getSqlSession();
		list=ss.selectList("selectItemList", siVO);
		ss.close();
		
		return list;
	}//selectItemList
	
	public List<CategoryListDomain> selectCategoryList(){
		List<CategoryListDomain> list = null;
		
		return list;
	}//selectCategoryList
	
	public MgrItemListDomain selectItemDetail(String string) {
		MgrItemListDomain mild = null;
		
		return mild;
	}//selectItemDetail
	
	public int insertItem(MgrItemAddVO miaVO) {
		int cnt =0;
		
		SqlSession ss = GetCollieHandler.getInstance().getSqlSession();
		cnt = ss.insert("insertItem", miaVO);
		ss.commit();
		ss.close();
		
		return cnt;
	}//insertItem
	
	public int updateItem(MgrItemModifyVO mimVO) {
		int cnt=0;
		
		return cnt;
	}//updateItem
	
	public int deleteItem(int aa) {
		int cnt=0;
		
		return cnt;
	}//deleteItem
	
	
}//class
