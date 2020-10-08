package kr.co.collie.mgr.qna.service;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.co.collie.mgr.pagination.PaginationService;
import kr.co.collie.mgr.pagination.RangeVO;
import kr.co.collie.mgr.pagination.TotalCntVO;
import kr.co.collie.mgr.qna.dao.MgrQnaDAO;
import kr.co.collie.mgr.qna.domain.MgrQnaDetailDomain;
import kr.co.collie.mgr.qna.domain.MgrQnaListDomain;
import kr.co.collie.mgr.qna.vo.MgrModifyQnaReplyVO;

public class MgrQnaService {
	
	/**
	 * 
	 * 모든 문의 사항을 조회한다.
	 * @param rVO 
	 * @return
	 */
	public List<MgrQnaListDomain> getAllQna(RangeVO rVO) {
		List<MgrQnaListDomain> list = null;
		list = MgrQnaDAO.getInstance().selectAllQna(rVO);
		return list;
	}
	
	public MgrQnaDetailDomain getQnaDetail(int qna_num) {
		MgrQnaDetailDomain mqdd = null;
		mqdd = MgrQnaDAO.getInstance().selectQnaDetail(qna_num);
		return mqdd;
	}
	
	public boolean modifyQnaReply(MgrModifyQnaReplyVO mmqrVO) {
		MgrQnaDAO mqDAO = MgrQnaDAO.getInstance();
		if(mmqrVO.getQna_reply().trim().length() > 0) {
			mmqrVO.setQna_flag("Y");
		}
		int result = mqDAO.updateQnaReply(mmqrVO);
		return result != 0;
	}
	
	public static String getQnaListToJson(int current_page) {
		JSONObject json=new JSONObject();
		
		RangeVO rVO=new RangeVO(current_page); //RangeVO에 현재페이지를 넘겨주면 조회해야할 리스트의 시작번호, 끝번호를 초기화한다
		
		List<MgrQnaListDomain> list = MgrQnaDAO.getInstance().selectAllQna(rVO); //RangeVO로 글의 리스트를 조회
		
		String flag="fail";
		if(list!=null) {
			flag="success";
			JSONArray jsonArr=new JSONArray();
			JSONObject jsonObj=null;
//			for(int i=0; i<list.size(); i++) {
			for(MgrQnaListDomain mqld : list) {
				jsonObj=new JSONObject();
				jsonObj.put("qna_subject",mqld.getQna_subject());
				jsonObj.put("qna_flag",mqld.getQna_flag());
				jsonObj.put("id",mqld.getId());
				jsonArr.add(jsonObj);
			}//end for
			json.put("qna_list", jsonArr);
			
			TotalCntVO tcVO=new TotalCntVO();
			tcVO.setTable_name("qna");
			PaginationService ps=new PaginationService();
			String pagination=ps.getPagination(current_page, tcVO);
			
			json.put("paging", pagination);
		}//end if
		
		json.put("flag", flag);
		
		return json.toJSONString();
	}

}
