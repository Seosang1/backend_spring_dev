package board;

import java.util.List;
 


public interface BoardBiz {

	public void insertBoard(BoardDto boardDtO) throws Exception;


	public List<BoardDto> getBoardList(BoardDto boardDtO) throws Exception;


	public BoardDto qnaDetail(int seq) throws Exception;

	public void deleteQna(int seq) throws Exception;

	public void updateQna(BoardDto boardDto) throws Exception;

	public int getBoardListCnt(BoardDto boardDtO) throws Exception;

	public List<BoardDto> getReplyList(int seq) throws Exception;

	public int saveReply(BoardDto boardDto) throws Exception;

	public int updateReply(BoardDto boardDto) throws Exception;

	public int deleteReply(int rid) throws Exception;

}