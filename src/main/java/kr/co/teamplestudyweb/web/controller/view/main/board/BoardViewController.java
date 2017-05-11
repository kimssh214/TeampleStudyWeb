package kr.co.teamplestudyweb.web.controller.view.main.board;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.teamplestudyweb.web.vo.LoginVo;

@Controller
public class BoardViewController {
	private static final Logger log = LoggerFactory.getLogger(BoardViewController.class);

	/* @RequestMapping(value = "/main/board")// Path 에러 발생 */
	@RequestMapping(value = "/board")
	public String board(HttpSession session, Model md) {
		log.debug("Board Init");
		LoginVo loginVo = (LoginVo) session.getAttribute("userInfo");
		log.debug(loginVo.getId());
		md.addAttribute("userInfo", (LoginVo) session.getAttribute("userInfo"));
		return "main/board/board";
	}
}
