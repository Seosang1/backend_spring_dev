package kr.co.web.model.Admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.web.model.Product.productDto;

@Repository
public class adminDaoImpl implements adminDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	// 전체보기
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
	
	// 상세보기
	@Override
	public productDto select(int seq) {
		productDto dto = (productDto)sqlSession.selectOne(NAMESPACE+"select", seq);
		return dto;
	}
	
	// 데이터 추가하기
	@Override
	public void insert(productDto pDTO) {
		sqlSession.insert(NAMESPACE+"insert", pDTO);
		
	}
	
	// 데이터 수정하기
	@Override
	public int update(productDto pDTO) {
		return sqlSession.update(NAMESPACE+"update", pDTO);
	}
	
	// 데이터 삭제하기
	@Override
	public void delete(int seq) {
		sqlSession.delete(NAMESPACE+"delete", seq);
		
	}
	
	// 조회수 증가
	@Override
	public int updateReadCount(int seq) {
		return sqlSession.update(NAMESPACE+"updateCount", seq);
	}
	
	// Criteria 객체에 담아서 SQL 매핑에 보낼 파라미터
	// 특정 페이지 게시글의 행(pageStart)과 페이지당 보여줄 게시글의 갯수(perPageNum)
	@Override
	public List<Map<String, Object>> pageList(CriteriaDto cri) {
		return sqlSession.selectList(NAMESPACE+"pageList", cri);
	}

	@Override
	public int countBoardList() {
		return sqlSession.selectOne(NAMESPACE+"countBoardList");
	}
	
	// 검색 페이지까지 적용
	@Override
	public List<productDto> searchList(SearchCriteriaDto cri) {
		return sqlSession.selectList(NAMESPACE+"searchList", cri);
	}

	@Override
	public int countArticle(String searchType, String keyword) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchType", searchType);
		map.put("keyword", keyword);
		return sqlSession.selectOne(NAMESPACE+"countArticle", map);
	}

}