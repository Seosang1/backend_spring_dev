package kr.co.web.model.Product;

import java.util.List;

public interface productDao {
	
	String NAMESPACE = "product.";
	
	//��ǰ ���
	public List<productDto> selectList();
	//��ǰ ��
	public productDto productDetail(int seq);
	//���ƿ�
	public void recommend(int seq) throws Exception; 

	//�����ڸ��
	public List<productDto> adProductList();
	
	public void insertForm(productDto dto) throws Exception;


	

}
