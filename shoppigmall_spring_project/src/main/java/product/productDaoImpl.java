package product;



import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<ProductDto> selectList() {

		List<ProductDto> list = new ArrayList<ProductDto>();
		
		try {
			
		list = sqlSession.selectList(NAMESPACE+"selectList");
		}catch (Exception e) {
			System.out.println("[error: select list" );
			e.printStackTrace();
		}
		
		
		return list;
		
}

	@Override
	public ProductDto productDetail(int seq) {
		
		ProductDto res = null;		
		try {
			res = sqlSession.selectOne(NAMESPACE+"productDetail",seq);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public void insertForm(ProductDto dto) throws Exception {
		sqlSession.insert(NAMESPACE+"insertForm", dto);
		
	}
}