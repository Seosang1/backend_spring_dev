package kr.co.web.model.Product;

import java.util.List;

public interface productBiz {
	
	public List<productDto> selectList();

	public productDto productDetail(int seq);

	public void insertForm(productDto dto) throws Exception;

	public List<productDto> adProductList();

	public void recommend(int seq) throws Exception;
		
	

}
