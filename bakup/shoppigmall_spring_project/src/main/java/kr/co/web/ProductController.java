package kr.co.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.web.model.Like.LikeBiz;
import kr.co.web.model.Like.LikeDto;
import kr.co.web.model.Product.productBiz;

@Controller
public class ProductController {
	
	@Autowired
	private productBiz biz;
	
	@Autowired
	private LikeBiz lbiz;

	//상품리스트
	@RequestMapping(value = "/productList.do")
	public String product(Model model) {	
	model.addAttribute("list",biz.selectList());
		return "jsp/member/productList";
	}	
	//상품 상세페이지
	@RequestMapping(value = "/productDetail",method = RequestMethod.GET)
	public String productDetail(Model model,int seq) {
	model.addAttribute("dto",biz.productDetail(seq));
	
	
	/*LikeDto dto = new LikeDto();
	dto.setLseq(seq);
	dto.setLu_id(currentUserName());
	
	int like_check = 0;
	
	int check = lbiz.ltlikecount(dto);
	
	if(check ==0) {
		
		lbiz.likeinsert(dto);
		
	}else if(check==1) {
		
		like_check = lbiz.ltlikegetinfo(dto);
	}
	
	model.addAttribute("like_check",like_check);
	
	*/
	return "/productDetail"; 

	}
	//장바구니 리스트
	@RequestMapping(value = "/shoppingBasket.do")
	public String shoppingBasket(Model model) {
		return "jsp/member/SHOPPING_BASKET";
	}
	//좋아요
    @RequestMapping("/recommend.do")
    public String recommend (@RequestParam int seq) throws Exception {
        
        biz.recommend(seq);
    
        return "forward:/productDetail.do"; //페이지값을 그대로 넘겨받기위해서 포워딩을 사용해 컨트롤러로 리턴시킨다.
    }
	
	
	
	

	
}




