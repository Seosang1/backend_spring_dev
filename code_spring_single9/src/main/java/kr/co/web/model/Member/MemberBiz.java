package kr.co.web.model.Member;

import javax.servlet.http.HttpSession;

public interface MemberBiz {
	
	//유저
	//로그인
	public MemberDto userlogin(MemberDto dto) throws Exception;
	
	//회원가입
	public int memberjoin(MemberDto dto);
	
	//아이디체크
	public int idcheck(MemberDto dto) throws Exception;
	
	//비밀번호체크
	public void PWcheck(MemberDto dto); 
	
	//아이디찾기
	public String searchId();
	
	//비밀번호찾기
	public void searchPw();
	
	//로그아웃
	public void logout(HttpSession session);
	
	//유저 회원가입
	//로그인체크
	public String loginCheck(MemberDto dto);
	
	//유저 등급
	public String level(MemberDto dto);
	
	//뭐지...?
	public String forced_Admin(String u_id, String u_pwd);

}
