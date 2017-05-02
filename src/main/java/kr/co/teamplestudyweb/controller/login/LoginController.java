package kr.co.teamplestudyweb.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysql.jdbc.log.Log;

@Controller
public class LoginController {

	@RequestMapping(value = "/login")
	public String login() {
		System.out.println("Login Init");
		
		return "login/login";
	}
}
