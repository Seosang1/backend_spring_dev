package kr.co.web.model.Admin;

import java.util.List;
import java.util.Map;

import kr.co.web.model.Product.productDto;

public interface adminDao {
	
	String NAMESPACE = "admin.";
	
	// 전체보기
	public List<productDto> selectList();
	
	// 상세보기
	public productDto select(int seq);
	
	// 데이터 추가하기
	public void insert(productDto pDTO);
	
	// 데이터 수정하기
	public int update(productDto pDTO);
	
	// 데이터 삭제하기
	public void delete(int seq);
	
	// 조회수 증가
	public int updateReadCount(int seq);
	
	// 페이지 적용
	public List<Map<String, Object>> pageList(CriteriaDto cri);
	
	// 총 게시글 수
	public int countBoardList();
	
	// 검색 기능
	public List<productDto> searchList(SearchCriteriaDto cri);
	public int countArticle(String searchType, String keyword);
}
