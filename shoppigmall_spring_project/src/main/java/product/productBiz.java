package product;
import java.util.List;

public interface ProductBiz {
	
	public List<ProductDto> selectList()  throws Exception;

	public ProductDto productDetail(int seq)  throws Exception;

	public ProductDto insertForm(ProductDto dto) throws Exception;

}
