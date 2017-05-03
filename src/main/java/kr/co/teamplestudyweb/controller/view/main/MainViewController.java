package kr.co.teamplestudyweb.controller.view.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainViewController {

	@RequestMapping(value = "/main")
	public String login() {
		System.out.println("Main Init");
		return "main/main";
	}
}
