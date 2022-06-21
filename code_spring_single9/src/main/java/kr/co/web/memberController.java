package kr.co.web;

import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.web.model.Member.MemberBiz;
import kr.co.web.model.Member.MemberDto;

@Controller
@RequestMapping(value="/member")
public class memberController {

	@Autowired
	private MemberBiz biz;

	@Autowired
	private JavaMailSender mailSender;

	private Logger logger = LoggerFactory.getLogger(memberController.class);


	//로그인
	@RequestMapping(value = "/userlogin", method = RequestMethod.POST)
	public String loginPOST(HttpServletRequest request, MemberDto dto) throws Exception{

		HttpSession session = request.getSession();
		System.out.println("세션id: "+session.getId());
		MemberDto user = biz.userlogin(dto);

		if(user != null) {
			String uid = request.getParameter("u_id");
			session.setAttribute("user", user);
			session.setAttribute("u_id", uid);
			System.out.println("ucode" + "u_code");
			System.out.println("로그인 생성");

			return "jsp/main";
		} else {
			session.setAttribute("user", null);
			System.out.println(user + "로그인세션아이디");
			return "jsp/member/login";
		}
	}

	//로그아웃
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		biz.logout(session);

		return "jsp/main";
	}

	//회원가입
	@RequestMapping(value = "/joinmember", method = RequestMethod.POST)
	public String joinmember(MemberDto dto) {
		int res = biz.memberjoin(dto);

		if (res > 0) {
			return "jsp/main";
		} else
			return "jsp/member/join";
	}

	//id 중복 체크
	@ResponseBody
	@RequestMapping(value = "/checkid", method = RequestMethod.POST)
	public String checkid (MemberDto dto) throws Exception {
		
		int result = biz.idcheck(dto);
		
		if(result != 1) {
			return "fail";
		} else {
			return "success";
		}
		
	}

	//이메일 인증(성공~)
	@RequestMapping(value = "/mailCheck", method=RequestMethod.GET)
	@ResponseBody
	public String mailCheckGET(String u_email) throws Exception {
		//데이터 확인용인데 성공했지렁~지렁지렁이~
		logger.info("이메일 데이터 확인");
		logger.info("인증번호: "+u_email);

		//인증번호 난수 생성
		Random random = new Random();
		int checkNum = random.nextInt(888888) + 111111;//난수 생성 코드
		logger.info("인증번호"+checkNum);

		String setFrom = "owo_14@daum.net";		//이메일을 보내기 위해 계정필요
		String toMail = u_email;				// db에서 이메일을 가져왔다.
		String title = "AT Shopping Mall 가입 인증 이메일 입니다."; //이메일을 보냈을때 문구를 나타낸다.
		String content = "반갑습니다."+"<br>"+"인증번호는 "+checkNum+" 입니다"; //이메일을 보냈을때 문구를 나타낸다. checkNum은 난수의 번호를 보여주는것이다.

		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			helper.setFrom(setFrom);
			helper.setTo(toMail);
			helper.setSubject(title);
			helper.setText(content,true);
			mailSender.send(message);

		}catch(Exception e) {
			e.printStackTrace();
		}

		String num = Integer.toString(checkNum);
		return num;
	}

}
