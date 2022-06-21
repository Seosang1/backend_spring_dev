package kr.co.web.model.Product;

import java.util.List;

public interface productDao {
	
	String NAMESPACE = "product.";
	
	//상품 목록
	public List<productDto> selectList();
	//상품 상세
	public productDto productDetail(int seq);
	//좋아요
	public void recommend(int seq) throws Exception; 

	//관리자모드
	public List<productDto> adProductList();
	
	public void insertForm(productDto dto) throws Exception;


	

}
