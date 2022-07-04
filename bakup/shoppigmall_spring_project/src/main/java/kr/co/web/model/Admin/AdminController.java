package kr.co.web.model.Admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.web.model.Product.productBiz;
import kr.co.web.model.Product.productDto;

@Controller
public class AdminController {
	
	@Autowired
	private adminBiz biz;
	private productBiz  pbiz;
	
	// 게시판 페이징 + 검색 
	@RequestMapping(value="/admin/operator_main_paging_search")
	public ModelAndView list(SearchCriteriaDto cri, HttpSession session) {
		
		ModelAndView mav = new ModelAndView("/jsp/admin/operator_main_paging_search");

		PageMakerDto pageMaker = new PageMakerDto();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(biz.countArticle(cri.getSearchType(), cri.getKeyword()));

		List<productDto> searchList = biz.searchList(cri);
		int count = biz.countArticle(cri.getSearchType(), cri.getKeyword());

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchList", searchList);
		map.put("count", count);
		map.put("searchOption", cri.getSearchType());
		map.put("keyword", cri.getKeyword());
//		mav.addObject("pageMaker", pageMaker);
//		mav.addObject("map", map);
//		return mav;
		
		

		mav.addObject("searchList", searchList);
		mav.addObject("pageMaker", pageMaker);

		return mav;
	}
	
	
	// 게시판 페이징
	@RequestMapping(value="/admin/operator_main_paging")
	public ModelAndView adminPageList(CriteriaDto cri, HttpSession session) {
		ModelAndView mav = null;
			mav = new ModelAndView("/jsp/admin/operator_main_paging");
			PageMakerDto pageMaker = new PageMakerDto();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(biz.countBoardList());

			List<Map<String, Object>> list = biz.pageList(cri);

			mav.addObject("list", list);
			mav.addObject("pageMaker", pageMaker);

			return mav;
	}
	
	// 임시 admin 탭
	  
    @RequestMapping(value = "/admin/operator_main", method = RequestMethod.GET)
    public String admin(Model model) throws Exception {
		  
		List<productDto> plist;		

		plist = biz.selectList();	

		model.addAttribute("plist",plist);
		  
			return "/jsp/admin/operator_main";
  }
    
    // 게시글 상세 내역
 	@RequestMapping(value="/admin/detail/{seq}")
 	public String adminRead(Model model, @PathVariable int seq) {
 		model.addAttribute("productDto", biz.select(seq));
 		return "/jsp/admin/detail";
 	}
	
 	// a태그 혹은 주소창 입력시 들어오는 곳
 	// 바인딩 에러처리를 위해 Model 객체와 model.addAttribute() 추가
 	@RequestMapping(value="/admin/ad_Write", method=RequestMethod.GET)
 	public String adminWrite(Model model) { 		
 		model.addAttribute("productDto", new productDto());
 		return "/jsp/admin/ad_Write";
 	}

 	// 게시글 작성
 	// Hibernate-validator까지 처리한 코드
 	@RequestMapping(value="/admin/ad_Write", method=RequestMethod.POST)
 	public String adminWrite(@Valid productDto pDTO, BindingResult bindingResult, HttpSession session) {
 		if(bindingResult.hasErrors()) {
 			return "/jsp/admin/ad_Write"; // ViewResolver로 보냄
 		} else {
 			pDTO.setTitle_photo((String)session.getAttribute("title_photo"));
 			biz.insert(pDTO);
 			return "redirect:/admin/operator_main"; // 새글을 반영하기 위해 컨트롤러로 보냄
 		}
 	}
 	
 	// 게시글 수정권한 판단
 	@RequestMapping(value="/admin/ad_Modify/{seq}", method=RequestMethod.GET)
 	public String adminModify(@PathVariable int seq, Model model, HttpSession session) {
 		
 			 model.addAttribute("productDto", biz.select(seq));
 			return "/jsp/admin/ad_Modify";
 		} 
 	
 	
 	// 수정 검증 : BindingResut + Validator
 	@RequestMapping(value="/admin/ad_Modify/{seq}", method=RequestMethod.POST)
 	public String adminModify(@Valid productDto pDTO, BindingResult bindingResult) {
 		if(bindingResult.hasErrors()) return "/jsp/admin/ad_Modify";
 		else {
 			biz.update(pDTO);
 			return "redirect:/admin/operator_main_paging_search";
 		}
 	}
 	
 	// 게시글 삭제
 	@RequestMapping(value="/admin/delete", method=RequestMethod.GET)
 	public String adminDelete(@RequestParam int seq) {
 		biz.delete(seq);
 		return "redirect:/admin/operator_main_paging_search";
 	}
 	
    @RequestMapping(value="/productReg.do",method = RequestMethod.GET)
    public String insertForm(Model model) {
       
       return "jsp/main/product_reg";
    }
    

	@RequestMapping(value = "operatorMain.do", method = RequestMethod.GET)
	public String operatorMain(Model model) {
		
		return "jsp/operator/operator_main";
	}


	//�����ڸ�� ��ǰ����Ʈ
	@RequestMapping(value="/adProductList.do")
	public String adProductList(Model model) {
	model.addAttribute("list",pbiz.adProductList());
		return "jsp/admin/productList";
	} 
	//�����ڸ�� ��ǰ ����ϱ�
	@RequestMapping(value="/adProductWrite.do")
	public String adProductWrite(productDto dto, HttpSession session,Model model) {
		
		return "jsp/admin/productList";
	}
	
}
