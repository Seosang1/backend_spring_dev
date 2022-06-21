package kr.co.web.model.Admin;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.web.model.Product.productDto;

@Service
public class adminBizImpl implements adminBiz{

	@Autowired
	private adminDao dao;
	
	// 전체보기
	@Override
	public List<productDto> selectList(){
		return dao.selectList();
		
		
	}
	
	// 상세보기
	@Override
	public productDto select(int seq) {
		dao.updateReadCount(seq); // 조회수 증가
		return dao.select(seq);
	}
	
	// 데이터 추가하기
	@Override
	public void insert(productDto pDTO) {
		dao.insert(pDTO);
		
	}
	
	// 데이터 수정하기
	@Override
	public int update(productDto pDTO) {
		return dao.update(pDTO);
	}
	
	// 데이터 삭제하기
	@Override
	public void delete(int seq) {
		dao.delete(seq);
		
	}

	@Override
	public List<Map<String, Object>> pageList(CriteriaDto cri) {
		return dao.pageList(cri);
	}

	@Override
	public int countBoardList() {
		return dao.countBoardList();
	}
	
	// 검색 페이지까지 적용
	@Override
	public List<productDto> searchList(SearchCriteriaDto cri) {
		return dao.searchList(cri);
	}

	@Override
	public int countArticle(String searchType, String keyword) {
		return dao.countArticle(searchType, keyword);
	}

	
}
