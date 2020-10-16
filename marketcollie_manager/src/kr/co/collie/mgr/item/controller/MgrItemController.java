package kr.co.collie.mgr.item.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.collie.mgr.category.domain.MgrCategoryDomain;
import kr.co.collie.mgr.item.domain.MgrCateListDomain;
import kr.co.collie.mgr.item.domain.MgrItemDetailDomain;
import kr.co.collie.mgr.item.domain.MgrItemListDomain;
import kr.co.collie.mgr.item.service.MgrItemService;
import kr.co.collie.mgr.item.vo.MgrItemAddVO;
import kr.co.collie.mgr.item.vo.MgrItemModifyVO;
import kr.co.collie.mgr.pagination.ItemRangeVO;
import kr.co.collie.mgr.pagination.PaginationService;

@Controller
public class MgrItemController {
	
	@RequestMapping(value="/item/item_list.do", method = {GET,POST} )
	public String SearchItem(Model model) {
		int current_page=1;
		ItemRangeVO irVO=new ItemRangeVO(current_page);
		
		MgrItemService mis=new MgrItemService();
		
		List<MgrItemListDomain> list = mis.getAllItem(irVO);
		List<MgrCateListDomain> cateList = mis.getCategory();
		
		int totalCnt=mis.getTotalCnt(irVO);
		String pagination=new PaginationService().getPagination(current_page, totalCnt);
		
		model.addAttribute("item_list", list);
		model.addAttribute("paging",pagination);
		model.addAttribute("cate_list",cateList);
		
		return "/item/item_list";
	}//searchItem
	
	@RequestMapping(value = "/item/item_search_list.do",method =GET , produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String SearchItemList(String current_page, String cate_name, String search_word) throws NumberFormatException {
		String json="";
		if(current_page==null || "".equals(current_page)) {
			current_page="1";
		}//end if
		
		int currentPage=Integer.parseInt(current_page);
		ItemRangeVO irVO=new ItemRangeVO(currentPage, cate_name, search_word);
		MgrItemService mis= new MgrItemService();
		
		json=mis.getSearchItem(irVO, currentPage);
		
		return json;
	}//
	
	/**
	 * 아이템 추가를 위한 페이지
	 * @param model
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/item/add_form.do", method= {RequestMethod.POST, RequestMethod.GET})
	public String addItemForm( Model model ){
		
		List<MgrCateListDomain> list=new MgrItemService().getCategory();
		model.addAttribute("cate_list", list);
		
		return "item/add_item_frm";
	}//addItemForm
	
	
	/**
	 * 아이템 추가하는 일을 하는 페이지
	 * @param miaVO
	 * @param model
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value = "/item/add_item.do", method=RequestMethod.POST)
	public String addItem(HttpServletRequest request, Model model) throws IOException, NumberFormatException  {
		String url=null;
		boolean flag = false;
		
		//파일 업로드 수행
		String path="C:/Users/sist/git/marketcollie_manager/marketcollie_manager/WebContent/common/images/item";
		int maxSize = 1024 * 1024 * 10;
		MultipartRequest mr = new MultipartRequest(request, path, maxSize,"UTF-8", new DefaultFileRenamePolicy());
		
		//파라메터 처리
		//detail_img처리
		Enumeration<String> en=mr.getFileNames();
		List<String> imgList=new ArrayList<String>();
		String tempImg=null;
		while( en.hasMoreElements()) {
			tempImg=en.nextElement();
			if(!"item_img".equals(tempImg)) {
				imgList.add(mr.getFilesystemName(tempImg));
			}//end if
		}//while
		
		MgrItemAddVO miaVO=new MgrItemAddVO();
		miaVO.setCate_num(Integer.parseInt(mr.getParameter("cate_num")));
		miaVO.setItem_price(Integer.parseInt(mr.getParameter("item_price")));
		miaVO.setItem_stock(Integer.parseInt(mr.getParameter("item_stock")));
		miaVO.setItem_name(mr.getParameter("item_name"));
		miaVO.setItem_unit(mr.getParameter("item_unit"));
		miaVO.setItem_weight(mr.getParameter("item_weight"));
		miaVO.setItem_guide(mr.getParameter("item_guide"));
		miaVO.setItem_title(mr.getParameter("item_title"));
		miaVO.setItem_subtitle(mr.getParameter("item_subtitle"));
		miaVO.setItem_detail(mr.getParameter("item_detail"));
		miaVO.setItem_img(mr.getFilesystemName("item_img"));
		miaVO.setDetail_img(imgList);
		System.out.println(miaVO);
		MgrItemService mis = new MgrItemService();
		flag = mis.addItem(miaVO);
		if(flag) {
			url="add_item_result";
		}//end if
		
		return url;
	}//addItem
	
	@ExceptionHandler(IOException.class)
	public ModelAndView ioExceptionHandling( IOException ie ) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("err/exception_view");
		mav.addObject("except1", "파일업로드 업무작업 중 문제 발생");
		mav.addObject("except2", ie);
		
		return mav;
	}//ioExceptionHandling
	
	/**
	 * 아이템 디테일 페이지 DB 값을 뿌려줌
	 * @param item_num
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/item/detail.do")
	public String getItemDetail(int item_num, Model model) {
		
		MgrItemService mis = new MgrItemService();
		MgrItemDetailDomain midd=mis.getItemDetail(item_num);
		List<MgrCateListDomain> list=mis.getCategory();
		
		model.addAttribute("midd",midd);
		model.addAttribute("cate_list", list);
		
		return "item/item_detail_frm";
	}//getItemDetail
	
	/**
	 * 아이템을 수정 하는 일
	 * @param mimVO
	 * @param model
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value = "/item/modify_item.do")
	public String modifyItem(HttpServletRequest request, Model model) throws IOException {
		String url=null;
		boolean flag = false;
		
		//파일 업로드 수행
		String path="C:/Users/sist/git/marketcollie_manager/marketcollie_manager/WebContent/common/images/item";
		int maxSize = 1024 * 1024 * 10;
		MultipartRequest mr = new MultipartRequest(request, path, maxSize,"UTF-8", new DefaultFileRenamePolicy());
		//파라메터 처리
		//detail_img처리
		Enumeration<String> en=mr.getFileNames();
		List<String> imgList=new ArrayList<String>();
		String tempImg=null;
		while( en.hasMoreElements()) {
			tempImg=en.nextElement();
			if(!"item_img".equals(tempImg)) {
				imgList.add(mr.getFilesystemName(tempImg));
			}//end if
		}//while
		
		MgrItemModifyVO mimVO=new MgrItemModifyVO();
		mimVO.setItem_num(Integer.parseInt(mr.getParameter("item_num")));
		mimVO.setCate_num(Integer.parseInt(mr.getParameter("cate_num")));
		mimVO.setItem_price(Integer.parseInt(mr.getParameter("item_price")));
		mimVO.setItem_stock(Integer.parseInt(mr.getParameter("item_stock")));
		mimVO.setItem_name(mr.getParameter("item_name"));
		mimVO.setItem_unit(mr.getParameter("item_unit"));
		mimVO.setItem_weight(mr.getParameter("item_weight"));
		mimVO.setItem_guide(mr.getParameter("item_guide"));
		mimVO.setItem_title(mr.getParameter("item_title"));
		mimVO.setItem_subtitle(mr.getParameter("item_subtitle"));
		mimVO.setItem_detail(mr.getParameter("item_detail"));
		mimVO.setItem_img(mr.getFilesystemName("item_img"));
		mimVO.setDetail_img(imgList);
		System.out.println(mimVO);
		
		
		MgrItemService mis = new MgrItemService();
		flag= mis.modifyItem(mimVO);
		if(flag) {
			url="modify_item_result";
		}//end if
		
		return url;
	}//modifyItem
	
}//class













