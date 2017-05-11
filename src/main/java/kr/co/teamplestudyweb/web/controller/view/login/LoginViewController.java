package kr.co.teamplestudyweb.web.controller.view.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginViewController {
	private static final Logger log = LoggerFactory.getLogger(LoginViewController.class);

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, HttpSession session) {
		log.debug("Login Init");
		log.debug(request.getHeader("User-Agent"));
		if (session.getAttribute("userInfo") != null) {
			log.debug("현재 로그인 세션 있음.");
			return "login/login";
		} else {
			log.debug("현재 로그인 세션 없음.");
			return "login/login";
		}

	}

	/*
	 * @RequestMapping(value = "/login/check", method = RequestMethod.POST)
	 * public String loginChk(HttpServletRequest request) {
	 * System.out.println("LoginCheck Init");
	 * 
	 * String id = request.getParameter("id"); String pw =
	 * request.getParameter("pw");
	 * 
	 * System.out.println("ID:" + id + "/ PW:" + pw);
	 * 
	 * return "main/main"; }
	 */
}
