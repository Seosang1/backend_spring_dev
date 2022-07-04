package user;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 

@Service
public class UserBizImpl implements UserBiz {
	
	@Autowired
	private UserDao dao;

	@Override
	public UserDto userlogin(UserDto dto) throws Exception {
		return dao.userlogin(dto);
	}

	@Override
	public int memberjoin(UserDto dto) {
		return dao.memberjoin(dto);
	}

	@Override
	public int idcheck(UserDto dto) throws Exception  {
		return dao.idcheck(dto);
	}

	@Override
	public void PWcheck(UserDto dto) {
		
	}

	@Override
	public String searchId() {
		return null;
	}

	@Override
	public void searchPw() {
		
	}

	@Override
	public void logout(HttpSession session) {
		session.invalidate();
	}

	@Override
	public String loginCheck(UserDto dto) {
		return null;
	}

	@Override
	public String level(UserDto dto) {
		return null;
	}

	@Override
	public String forced_Admin(String u_id, String u_pwd) {
		return null;
	}

}
