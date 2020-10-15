package kr.co.collie.mgr.item.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.IOException;
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

import kr.co.collie.mgr.category.domain.CategoryListDomain;
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
		
		List<MgrItemListDomain> list = mis.getAllCate(irVO);
		List<CategoryListDomain> cateList = mis.getCategory();
		
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
	 * ������ ������ ������ DB ���� �ѷ���
	 * @param item_num
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/item/detail.do")
	public String getItemDetail(int item_num, Model model) {
		
		MgrItemService mis = new MgrItemService();
		
		MgrItemDetailDomain midd =  mis.getItemDetail(item_num);
		
		model.addAttribute("midd",midd);
		
		
		
		return "item/item_detail_frm";
	}//getItemDetail
	
	/**
	 * ������ �̹��� �߰��� ���� ������
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/item/add_item_image.do", method = RequestMethod.GET)
	public String addItemImage(HttpServletRequest request, Model model )  {
		
		
		
		
		return "item/add_item_img_frm";
	}//addItemImage
	
	/**
	 * ������ �̹��� �߰��ϴ� ��
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/item/add_item_image_result.do", method = RequestMethod.POST)
	public String addItemImageResult(HttpServletRequest request, Model model ) throws IOException  {
		
		//���ε� ������ ����� ������ ���.
		String path="C:/Users/sist/git/marketcollie_manager/marketcollie_manager/WebContent/common/images/item";
		//���ε������� ũ��(byte) : 10MByte
		int maxSize = 1024 * 1024 * 10;
		//���ε带 ������ MultipartRequest ���� : upload����
		MultipartRequest mr = new MultipartRequest(request, path, maxSize,"UTF-8", new DefaultFileRenamePolicy());
		//�信�� ������ �� ����
		
		model.addAttribute("file1_origin", mr.getOriginalFileName("file1"));
		model.addAttribute("file1_rename", mr.getFilesystemName("file1"));
		
		
		
		return "forward:add_item_img_result.jsp";
	}//addItemImage
	
	/**
	 * ������ �̹��� �߰��ϴ� ��
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/item/add_detail_image_result.do", method = RequestMethod.POST)
	public String addImageResult(HttpServletRequest request, Model model ) throws IOException  {
		
		//���ε� ������ ����� ������ ���.
		String path="C:/Users/sist/git/marketcollie_manager/marketcollie_manager/WebContent/common/images/item";
		//���ε������� ũ��(byte) : 10MByte
		int maxSize = 1024 * 1024 * 10;
		//���ε带 ������ MultipartRequest ���� : upload����
		MultipartRequest mr = new MultipartRequest(request, path, maxSize,"UTF-8", new DefaultFileRenamePolicy());
		//�信�� ������ �� ����
		
		model.addAttribute("file1_origin", mr.getOriginalFileName("file1"));
		model.addAttribute("file1_rename", mr.getFilesystemName("file1"));
		
		
		
		return "forward:add_detail_img_result.jsp";
	}//addItemImage
	
	/**
	 * ������ �̹��� �߰��ϴ� ������
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/item/add_detail_image.do")
	public String addItemDetailImage(HttpServletRequest request) {
		
		
		return "item/add_detail_img_frm";
	}//addItemDetailImage
	
	/**
	 * ������ �� �̹��� �߰��ϴ� ��
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/item/add_item_tab_image.do")
	public String addItemTabImg(HttpServletRequest request) {
		
		return "";
	}//addItemTabImg
	
	/**
	 * ������ �߰��� ���� ������
	 * @param model
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/item/add_form.do", method= {RequestMethod.POST, RequestMethod.GET})
	public String addItemForm( Model model ){
		
		
		
		
		return "item/add_item_frm";
	}//addItemForm
	
	
	/**
	 * ������ �߰��ϴ� ���� �ϴ� ������
	 * @param miaVO
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/item/add_item.do", method=RequestMethod.POST)
	public String addItem(MgrItemAddVO miaVO, Model model)  {
		System.out.println(miaVO);
		boolean flag = false;
		
		MgrItemService mis = new MgrItemService();
		
		flag = mis.addItem(miaVO);
		
		return "redirect:add_item_result.jsp";
	}//addItem
	
	@ExceptionHandler(IOException.class)
	public ModelAndView ioExceptionHandling( IOException ie ) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("err/exception_view");
		mav.addObject("except1", "���Ͼ��ε� �����۾� �� ���� �߻�");
		mav.addObject("except2", ie);
		return mav;
		
	}//ioExceptionHandling
	
	/**
	 * �������� ���� �ϴ� ��
	 * @param mimVO
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/item/modify_item.do")
	public String modifyItem(MgrItemModifyVO mimVO, Model model) {
		
		boolean flag = false;
		
		
		MgrItemService mis = new MgrItemService();
		flag= mis.modifyItem(mimVO);
		mis.modifyDetailImg(mimVO);
		System.out.println("---------------------------------"+flag);
		
		return "redirect:modify_item_result.jsp";
	}//modifyItem
	
	/**
	 * �������� �����ϴ� ��
	 * @param item_num
	 * @param model
	 * @return
	 */
	/*
	 * @RequestMapping(value = "/item/remove_item.do") public String removeItem(int
	 * item_num, Model model) { boolean flag = false;
	 * 
	 * MgrItemService mis = new MgrItemService();
	 * 
	 * flag = mis.removeItem(item_num);
	 * 
	 * 
	 * return "redirect:remove_item_result.jsp"; }//removeItem
	 */	
	
	
}//class













