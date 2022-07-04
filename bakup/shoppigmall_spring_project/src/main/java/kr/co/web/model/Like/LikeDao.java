package kr.co.web.model.Like;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LikeDao {
	@Autowired
	private SqlSessionTemplate sqltemp;
	
	public int ltlikecount(LikeDto dto) {
		return sqltemp.selectOne("like.ltlikecount",dto);
	}
	
	public int ltlikegetinfo(LikeDto dto) {
		return sqltemp.selectOne("like.ltlikegetinfo",dto);
	}
	
	public void likeinsert(LikeDto dto) {
		sqltemp.insert("like.likeinsert",dto);
	}
	
	public void likeupdate(LikeDto dto) {
		sqltemp.update("like.likeupdate",dto);
	}
	

}
