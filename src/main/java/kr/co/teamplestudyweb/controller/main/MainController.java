package kr.co.teamplestudyweb.controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping(value = "/main")
	public String login() {
		System.out.println("Main Init");
		return "main/main";
	}
}
