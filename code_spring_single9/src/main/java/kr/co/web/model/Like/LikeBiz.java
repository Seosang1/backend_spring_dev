package kr.co.web.model.Like;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeBiz {
	
	@Autowired
	private LikeDao dao;
	
	public int ltlikecount(LikeDto dto) {
		return dao.ltlikecount(dto);
	}
	
	public int ltlikegetinfo(LikeDto dto) {
		return dao.ltlikegetinfo(dto);
	}
	
	public void likeinsert(LikeDto dto) {
		dao.likeinsert(dto);
	}
	
	public void likeupdate(LikeDto dto) {
		dao.likeupdate(dto);
	}


}
