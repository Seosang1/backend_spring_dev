package kr.co.web.model.board;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.web.Search;

@Service
public class BoardBizImpl implements BoardBiz {

	@Inject
	private BoardDao boardDao;

	@Override
	public List<BoardDto> getBoardList(Search search) throws Exception {
		return boardDao.getBoardList(search);
	}

	@Override
	public void insertBoard(BoardDto boardDto) throws Exception {
		boardDao.insertBoard(boardDto);
		/*
		 * if ( boardDao.insertBoard(boardDto) == 1) {
		 * System.out.println("BoardBizImpl insertBoard �� Ȯ�� ����"); } else {
		 * System.out.println("BoardBizImpl insertBoard �� Ȯ�� ����"); }
		 */
	}

	@Override
	public BoardDto qnaDetail(int seq) throws Exception {
		boardDao.viewCnt(seq);
		return boardDao.qnaDetail(seq);

	}

	@Override
	public void updateQna(BoardDto boardDto) throws Exception {
		boardDao.updateQna(boardDto);

		int result = boardDao.updateQna(boardDto);

		if (result == 1) {
			System.out.println("BoardBizImpl updateQna �� Ȯ�� ����");
		} else {
			System.out.println("BoardBizImpl updateQna �� Ȯ�� ����");
		}
	}

	@Override
	public void deleteQna(int seq) throws Exception {
		boardDao.deleteQna(seq);

	}

	// �� �Խñ� ���� Ȯ��
	@Override

	public int getBoardListCnt(Search search) throws Exception {

		return boardDao.getBoardListCnt(search);

	}

	// ��� ����Ʈ
	@Override

	public List<BoardDto> getReplyList(int seq) throws Exception {

		return boardDao.getReplyList(seq);

	}

	@Override

	public int saveReply(BoardDto boardDto) throws Exception {

		return boardDao.saveReply(boardDto);

	}

	@Override

	public int updateReply(BoardDto boardDto) throws Exception {

		return boardDao.updateReply(boardDto);

	}

	@Override

	public int deleteReply(int rid) throws Exception {

		return boardDao.deleteReply(rid);

	}

	@Override
	public int answerYn(BoardDto boardDto) throws Exception {
		return boardDao.answerYn(boardDto);
	}

}
