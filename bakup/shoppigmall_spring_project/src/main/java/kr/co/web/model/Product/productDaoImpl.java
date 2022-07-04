package kr.co.web.model.Product;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class productDaoImpl implements productDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<productDto> selectList() {

		List<productDto> list = new ArrayList<productDto>();
		
		try {
			
		list = sqlSession.selectList(NAMESPACE+"selectList");
		}catch (Exception e) {
			System.out.println("[error: select list" );
			e.printStackTrace();
		}
		
		
		return list;
		
}

	@Override
	public productDto productDetail(int seq) {
		
		productDto res = null;		
		try {
			res = sqlSession.selectOne(NAMESPACE+"productDetail",seq);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}
	//���ƿ�
	@Override
	public void recommend(int seq) throws Exception {
		 sqlSession.update(NAMESPACE+"recommend", seq);		
	}
	
	
	
	
	@Override
	public void insertForm(productDto dto) throws Exception {
		sqlSession.insert(NAMESPACE+"insertForm", dto);
		
	}

	@Override
	public List<productDto> adProductList() {
		
		List<productDto> list = new ArrayList<productDto>();
		
		try {
			list = sqlSession.selectList(NAMESPACE+"adProductList");
			System.out.println(list.toString());
		} catch (Exception e) {
			System.out.println("[error]: select list" );
			e.printStackTrace();
		}
		return list;
	}



}