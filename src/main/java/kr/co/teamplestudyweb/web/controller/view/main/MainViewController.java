package kr.co.teamplestudyweb.web.controller.view.main;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.teamplestudyweb.web.vo.LoginVo;

@Controller
public class MainViewController {
	private static final Logger log = LoggerFactory.getLogger(MainViewController.class);

	@RequestMapping(value = "/main")
	public String main(HttpSession session, Model md) {
		log.debug("Main Init");
		LoginVo loginVo = (LoginVo) session.getAttribute("userInfo");
		log.debug(loginVo.getId());
		md.addAttribute("userInfo", (LoginVo) session.getAttribute("userInfo"));
		return "main/main";
	}
}
