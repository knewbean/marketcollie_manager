package kr.co.collie.mgr.category.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.collie.mgr.category.domain.CategoryListDomain;
import kr.co.collie.mgr.dao.GetCollieHandler;
import kr.co.collie.mgr.pagination.RangeVO;

public class MgrCategoryDAO {
	
	private static MgrCategoryDAO mcDAO;
	
	private MgrCategoryDAO() {
	}
	
	public static MgrCategoryDAO getInstance() {
		if(mcDAO==null) {
			mcDAO=new MgrCategoryDAO();
		}//end if
		return mcDAO;
	}//getInstance
	
	public List<CategoryListDomain> selectCategoryList(RangeVO rVO){
		List<CategoryListDomain> list=null;
		
		SqlSession ss=GetCollieHandler.getInstance().getSqlSession();
		list=ss.selectList("selectCategoryList", rVO);
		ss.close();
		
		return list;
	}//selectCategoryList
	
}//class
