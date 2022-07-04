package product;



import java.util.List;

public interface ProductDao {
	
	String NAMESPACE = "product.";

	public List<ProductDto> selectList();

	public ProductDto productDetail(int seq);

	public void insertForm(ProductDto dto) throws Exception;

	

}
