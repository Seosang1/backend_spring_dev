package user;


import javax.servlet.http.HttpSession;

public interface UserDao {
	
	String NAMESPACE = "user.";
	
	public UserDto userlogin(UserDto dto);
	
	public int memberjoin(UserDto dto);
	
	//아이디 체크
	public int idcheck(UserDto dto);
	
	public void PWcheck(UserDto dto); 
	
	public String searchId();
	
	public void searchPw();
	
	public void logout(HttpSession session);
	
	public String loginCheck(UserDto dto);
	
	public String level(UserDto dto);
	
	public String forced_Admin(String u_id, String u_pwd);
}
