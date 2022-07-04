package product;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductBizImpl implements ProductBiz{

	@Autowired
	private ProductDao dao;
	
	@Override
	public List<ProductDto> selectList(){
		return dao.selectList();
		
		
	}

	@Override
	public ProductDto productDetail(int seq) {
		return dao.productDetail(seq);
	}

	@Override
	public void insertForm(ProductDto dto) throws Exception {
		dao.insertForm(dto);		
	}

	
	
}
