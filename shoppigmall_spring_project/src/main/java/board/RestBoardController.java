package Board;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController

@RequestMapping(value = "/restBoard")
public class RestBoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Inject
	private BoardBiz boardBiz;

	@RequestMapping(value = "/getReplyList", method = RequestMethod.POST)
	public List<BoardDto> getReplyList(@RequestParam("seq") int seq) throws Exception {
		return boardBiz.getReplyList(seq);
	}

	@RequestMapping(value = "/saveReply", method = RequestMethod.POST)
	public Map<String, Object> saveReply(@RequestBody BoardDto boardDto) throws Exception {
		Map<String, Object> result = new HashMap<>();

		try {
			boardBiz.saveReply(boardDto);
			result.put("status", "OK");
			System.out.println("��۵�� ����");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", "False");
			System.out.println("��۵�� ����");
		}
		return result;
	}
	@RequestMapping(value = "/updateReply", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> updateReply(@RequestBody BoardDto boardDto) throws Exception {

		Map<String, Object> result = new HashMap<>();
		try {
			boardBiz.updateReply(boardDto);
			result.put("status", "OK");
			System.out.println("��ۼ��� ����");

		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", "False");
			System.out.println("��ۼ��� ����");
		}
		return result;
	}

	@RequestMapping(value = "/deleteReply", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> deleteReply(@RequestParam("rid") int rid) throws Exception {

		Map<String, Object> result = new HashMap<>();
		try {
			boardBiz.deleteReply(rid);
			result.put("status", "OK");
			System.out.println("��� ���� ����");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", "False");
			System.out.println("��� ���� ����");
		}
		return result;
	}

}