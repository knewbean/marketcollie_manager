package kr.co.collie.mgr.category.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.collie.mgr.category.domain.MgrCategoryDomain;
import kr.co.collie.mgr.category.vo.MgrModifyCateVO;
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
	
	public List<MgrCategoryDomain> selectCategoryList(RangeVO rVO){
		List<MgrCategoryDomain> list=null;
		
		SqlSession ss=GetCollieHandler.getInstance().getSqlSession();
		list=ss.selectList("selectCategoryList", rVO);
		ss.close();
		
		return list;
	}//selectCategoryList
	
	public void insertCategory(String cateName) throws SQLException {
		
		SqlSession ss=GetCollieHandler.getInstance().getSqlSession();
		int cnt=ss.insert("insertCategory", cateName);
		if(cnt==1) {
			ss.commit();
		}//end if
		ss.close();
		
	}//insertCategory
	
	public String selectCategory(int cateNum) {
		String cateName=null;
		
		SqlSession ss=GetCollieHandler.getInstance().getSqlSession();
		cateName=ss.selectOne("kr.co.collie.mgr.category.selectCategory", cateNum);
		
		return cateName;
	}//selectCategory
	
	public int updateCategory(MgrModifyCateVO mmcVO) {
		int cnt=0;
		SqlSession ss=GetCollieHandler.getInstance().getSqlSession();
		cnt=ss.update("updateCategory", mmcVO);
		if(cnt==1) {
			ss.commit();
		}//end if
		ss.close();
		
		return cnt;
	}//updateCategory
	
}//class
