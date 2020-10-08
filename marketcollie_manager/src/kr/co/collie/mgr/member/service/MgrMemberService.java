package kr.co.collie.mgr.member.service;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.co.collie.mgr.category.dao.MgrCategoryDAO;
import kr.co.collie.mgr.category.domain.CategoryListDomain;
import kr.co.collie.mgr.member.dao.MgrMemberDAO;
import kr.co.collie.mgr.member.domain.MgrMemberDetailDomain;
import kr.co.collie.mgr.member.domain.MgrMemberListDomain;
import kr.co.collie.mgr.pagination.PaginationService;
import kr.co.collie.mgr.pagination.RangeVO;
import kr.co.collie.mgr.pagination.TotalCntVO;

public class MgrMemberService {
	
	public List<MgrMemberListDomain> getMemberList(RangeVO rVO){
		List<MgrMemberListDomain> list=null;
		
		list=MgrMemberDAO.getInstance().selectMemberList(rVO);
		
		return list;
	}//getMemberList
	
	public String moveMemberList(int current_page) {
		JSONObject json=new JSONObject();
		
		RangeVO rVO=new RangeVO(current_page);
		List<MgrMemberListDomain> list=MgrMemberDAO.getInstance().selectMemberList(rVO);
		
		String flag="fail";
		if(list!=null) {
			flag="success";
			JSONArray jsonArr=new JSONArray();
			JSONObject jsonObj=null;
			for(int i=0; i<list.size(); i++) {
				jsonObj=new JSONObject();
				jsonObj.put("member_num",list.get(i).getMember_num());
				jsonObj.put("id",list.get(i).getId());
				jsonObj.put("name",list.get(i).getName());
				jsonObj.put("phone",list.get(i).getPhone());
				jsonObj.put("input_date",list.get(i).getInput_date());
				jsonArr.add(jsonObj);
			}//end for
			json.put("mem_list", jsonArr);
			
			PaginationService ps=new PaginationService();
			String pagination=ps.getPagination(current_page, new TotalCntVO("member", "member_flag", "Y"));
			
			json.put("paging", pagination);
		}//end if
		
		json.put("flag", flag);
		
		return json.toJSONString();
	}//moveCategoryList
	
	public MgrMemberDetailDomain getMemberDetail(int memberNum) {
		MgrMemberDetailDomain mmdd=null;
		
		mmdd=MgrMemberDAO.getInstance().selectMemberDetail(memberNum);
		
		return mmdd;
	}//getMemberDetail
	
}//class
