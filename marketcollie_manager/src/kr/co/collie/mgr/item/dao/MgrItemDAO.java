package kr.co.collie.mgr.item.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.collie.mgr.category.domain.MgrCategoryDomain;
import kr.co.collie.mgr.dao.GetCollieHandler;
import kr.co.collie.mgr.item.domain.MgrCateListDomain;
import kr.co.collie.mgr.item.domain.MgrItemDetailDomain;
import kr.co.collie.mgr.item.domain.MgrItemListDomain;
import kr.co.collie.mgr.item.vo.MgrDetailItemVO;
import kr.co.collie.mgr.item.vo.MgrItemAddVO;
import kr.co.collie.mgr.item.vo.MgrItemModifyVO;
import kr.co.collie.mgr.pagination.ItemRangeVO;

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
	
	public List<MgrItemListDomain> selectItemList(ItemRangeVO irVO){
		
		List<MgrItemListDomain> list = null;
		
		SqlSession ss =  GetCollieHandler.getInstance().getSqlSession();
		list=ss.selectList("selectItemList", irVO);
		ss.close();
		
		return list;
	}//selectItemList
	
	public int selectItemListCnt(ItemRangeVO irVO) {
		int cnt=0;
		
		SqlSession ss=GetCollieHandler.getInstance().getSqlSession();
		cnt=ss.selectOne("selectItemListCnt",irVO);
		ss.close();
		
		return cnt;
	}//selectItemListCnt
	
	public List<MgrCateListDomain> selectCategory(){
		List<MgrCateListDomain> list = null;
		
		SqlSession ss = GetCollieHandler.getInstance().getSqlSession();
		list = ss.selectList("kr.co.collie.mgr.item.selectCategory");
		ss.close();
		
		return list;
	}//selectCategoryList
	
	public MgrItemDetailDomain selectItemDetail(int item_num) {
		MgrItemDetailDomain midd = null;
		
		SqlSession ss = GetCollieHandler.getInstance().getSqlSession();
		midd= ss.selectOne("selectItemDetail", item_num); //세부항목조회
		List<String> list = ss.selectList("selectItemDetailImage", item_num); //세부항목의 n개의 이미지 조회
		midd.setDetail_img(list); //조회된 n개의 이미지를 세부항목에 추가
		ss.close();
		
		return midd;
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
		
		SqlSession ss = GetCollieHandler.getInstance().getSqlSession();
		cnt = ss.update("updateItem",mimVO);
		if(cnt==1) {
			ss.delete("deleteItem", mimVO.getItem_num());
			
			MgrDetailItemVO mdiVO=new MgrDetailItemVO();
			mdiVO.setItem_num(mimVO.getItem_num());
			for(int i=0; i<mimVO.getDetail_img().size(); i++) {
				mdiVO.setDetail_img(mimVO.getDetail_img().get(i));
				ss.insert("modifyItem", mdiVO);
			}//end for
			
			ss.commit();
		}else {
			ss.rollback();
		}//end if
		ss.close();
		
		return cnt;
	}//updateItem
	
}//class
