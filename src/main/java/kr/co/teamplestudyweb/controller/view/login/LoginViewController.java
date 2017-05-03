package kr.co.teamplestudyweb.controller.view.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginViewController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		System.out.println("Login Init");

		return "login/login";
	}
	
/*
	@RequestMapping(value = "/login/check", method = RequestMethod.POST)
	public String loginChk(HttpServletRequest request) {
		System.out.println("LoginCheck Init");

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		System.out.println("ID:" + id + "/ PW:" + pw);

		return "main/main";
	}
*/
}
