package board;

import java.util.List;
 

public interface BoardDao {


	public List<BoardDto> getBoardList(BoardDto boardDto) throws Exception;

	public int insertBoard(BoardDto boardDto) throws Exception;

	public BoardDto qnaDetail(int seq) throws Exception;

	public int updateQna(BoardDto boardDto) throws Exception;

	public int deleteQna(int seq) throws Exception;

	public int viewCnt(int seq) throws Exception;

	public int getBoardListCnt(BoardDto boardDto) throws Exception;

	public List<BoardDto> getReplyList(int seq) throws Exception;

	public int saveReply(BoardDto boardDto) throws Exception;

	public int updateReply(BoardDto boardDto) throws Exception;

	public int deleteReply(int rid) throws Exception;




}

