package kr.co.web;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.web.model.board.BoardDao;
import kr.co.web.model.board.BoardDto;

//Runner Ŭ����(�׽�Ʈ �޼ҵ带 �����ϴ� Ŭ����) �� SpringJUnit4ClassRunner�� ��
@RunWith(SpringJUnit4ClassRunner.class)
//location �Ӽ� ��ο� �ִ� xml ������ �̿��ؼ� �������� �ε���
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")

public class BoardDaoTest {

	private static final Logger logger = LoggerFactory.getLogger(BoardDaoTest.class);

	@Inject
	private BoardDao dao;


	/* @Ignore
	public void testSelectMember() throws Exception {
		List<BoardDto> vo = dao.getBoardList(Pagination pagination);
		System.out.println(vo);

		logger.info("\n Board List \n ");
		if (vo.size() > 0) {
			for (BoardDto list : vo) {
				logger.info(list.getTitle());
			}
		} else {
			logger.info("�����Ͱ� �����ϴ�.");
		}
	}
	 */



	@Ignore
	public void testInsertBoard() throws Exception {

		BoardDto vo = new BoardDto();

		vo.setU_id("test1");
		vo.setTitle("ù��° �Խù� �Դϴ�.");
		vo.setContents("ù��° �Խù��Դϴ�.");
		vo.setCategory("etc");

		int result = dao.insertBoard(vo);

		logger.info("\n Insert Board Result " + result);

		if (result == 1) {
			logger.info("\n success");
		} else {
			logger.info("\n fail");
		}
	}
	/*
	@Test
	public void testModify() {
		BoardDto vo = new BoardDto();
		BoardBiz biz = new BoardBiz();

		vo.setSeq(100);
		vo.setTitle("���� ����");
		vo.setContents("���� ����");

		int result = BoardBiz.updateQna(vo);
		log.info("result : " + result);

	}
	 */

	@Ignore
	public void insert() throws Exception {

		BoardDto vo = new BoardDto();


		for( int i = 1; i < 100 ; i++) {

			vo.setTitle(i + " ��° Q&A.");

			vo.setContents(i + " ��° Q&A ����");

			vo.setCategory("etc");

			vo.setU_id("test1");

			int result = dao.insertBoard(vo);

			logger.info("\n Insert Board Result " +result);
			if(result == 1) {
				logger.info("\n �Խù� ��� ���� ");

			} else {

				logger.info("\n �Խù� ��� ����");

			}
		}

	}


	@Ignore
	public void testUpdateViewCnt() throws Exception {
		int result = dao.viewCnt(1);

		logger.info("\n Update View Count Result \n ");

		if (result > 0) {
			logger.info("\n success");
		} else {
			logger.info("\n fail");
		}
	}

	@Ignore
	public void testUpdateBoard() throws Exception {

		BoardDto vo = new BoardDto();

		vo.setSeq(100);
		vo.setTitle("����- ");
		vo.setContents("MM ");
		int result = dao.updateQna(vo);

		logger.info("\n Update Board Result \n ");

		if (result > 0) {
			logger.info("\n success");
		} else {
			logger.info("\n fail");
		}
	}

	@Ignore

	public void tesDeleteBoard() throws Exception {

		int result = dao.deleteQna(1);

		logger.info("\n Delete Board Result \n ");

		if (result > 0) {
			logger.info("\n success");
		} else {
			logger.info("\n fail");
		}

	}

}
