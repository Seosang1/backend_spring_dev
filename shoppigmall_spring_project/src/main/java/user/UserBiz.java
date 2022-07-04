package user;

import javax.servlet.http.HttpSession;
 

public interface UserBiz {
	
	public UserDto userlogin(UserDto dto) throws Exception;
	
	public int memberjoin(UserDto dto);
	
	public int idcheck(UserDto dto) throws Exception;
	
	public void PWcheck(UserDto dto); 
	
	public String searchId();
	
	public void searchPw();
	
	public void logout(HttpSession session);
	
	public String loginCheck(UserDto dto);
	
	public String level(UserDto dto);
	
	public String forced_Admin(String u_id, String u_pwd);

}
