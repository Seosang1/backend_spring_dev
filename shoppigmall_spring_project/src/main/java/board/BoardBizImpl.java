package board;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
 

@Service
public abstract class BoardBizImpl implements BoardBiz {

	@Inject
	private BoardDao boardDao;

	@Override
	public List<BoardDto> getBoardList(BoardDto boardDto) throws Exception {
		return boardDao.getBoardList(boardDto);
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

	public int getBoardListCnt(BoardDto boardDto) throws Exception {

		return boardDao.getBoardListCnt(boardDto);

	}

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

}
