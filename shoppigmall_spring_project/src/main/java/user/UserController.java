package user;


import java.io.Console;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.util.JSONPObject;


@Controller
@RequestMapping(value="/member")
public class UserController {
	
	@Autowired 
	private UserBiz biz;
	
	@Autowired
	private JavaMailSender mailSender;
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	
	//�α���
	@RequestMapping(value = "/userlogin", method = RequestMethod.POST)
	public String loginPOST(HttpServletRequest request, UserDto dto) throws Exception{
		
		HttpSession session = request.getSession();
		System.out.println("����id: "+session.getId());
		UserDto user = biz.userlogin(dto);
		
		if(user != null) {
			String uid = request.getParameter("u_id");
			session.setAttribute("user", user);
			session.setAttribute("u_id", uid);
			System.out.println("�α��� ����");
			
			return "jsp/main";
		} else {
			session.setAttribute("user", null);
			System.out.println(user + "�α��μ��Ǿ��̵�");
			return "jsp/member/login";
		}
	}
	
	//�α׾ƿ�
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		biz.logout(session);
		
		return "jsp/main";
	}
	
	//ȸ������
	@RequestMapping(value = "/joinmember", method = RequestMethod.POST)
	public String joinmember(UserDto dto) {
		int res = biz.memberjoin(dto);
		
		if (res > 0) {
			return "jsp/main";
		} else
			return "jsp/member/join";
	}
	
	//id �ߺ� üũ 
	@ResponseBody
	@RequestMapping(value = "/checkid", method = RequestMethod.POST)
	public int checkid (UserDto dto) throws Exception {
		logger.info("checkid");
		System.out.println("�����߻�");
		int res = biz.idcheck(dto);
		System.out.println("�����߻�2");
		return res;
		
	}
	
	//�̸��� ����(����~)
	@RequestMapping(value = "/mailCheck", method=RequestMethod.GET)
	@ResponseBody
	public String mailCheckGET(String u_email) throws Exception {
		//������ Ȯ�ο��ε� �ȵ�...
		logger.info("�̸��� ������ Ȯ��");
		logger.info("������ȣ: "+u_email);
		
		//������ȣ ���� ����
		Random random = new Random();
		int checkNum = random.nextInt(888888) + 111111;
		logger.info("������ȣ"+checkNum);
		
		String setFrom = "owo_14@daum.net";
		String toMail = u_email;
		String title = "AT Shopping Mall ���� ���� �̸��� �Դϴ�.";
		String content = "�ݰ����ϴ�."+"<br>"+"������ȣ�� "+checkNum+" �Դϴ�";
		
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
