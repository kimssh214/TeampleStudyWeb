package kr.co.teamplestudyweb.web.controller.rest.main.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.teamplestudyweb.web.controller.rest.CommonRestController;
import kr.co.teamplestudyweb.web.controller.rest.login.LoginRestController;
import kr.co.teamplestudyweb.web.vo.LogoutVo;

@RestController
public class BoardRestController extends CommonRestController {
	private static final Logger log = LoggerFactory.getLogger(BoardRestController.class);

	@RequestMapping(value = "/board/read", method = RequestMethod.GET)
	public String load(HttpSession session, HttpServletRequest request) {
		log.debug("REST Board Read Init");
		String sampleData = "{\"header\":[[\"\",0,\"Item ID\",\"Item Detail\",\"\",\"\"],[\"Item Name\",\"Item Price\",\"Item Operate\"]],\"data\":[{\"Item Name\":0,\"Item Price\":0,\"Item Operate\":0,\"undefined\":0},{\"Item Name\":\"\",\"Item Price\":\"\",\"Item Operate\":\"\",\"undefined\":0},{\"Item Name\":0,\"Item Price\":2,\"Item Operate\":2,\"undefined\":0},{\"Item Name\":0,\"Item Price\":3,\"Item Operate\":3,\"undefined\":0},{\"Item Name\":0,\"Item Price\":4,\"Item Operate\":4,\"undefined\":0},{\"Item Name\":0,\"Item Price\":5,\"Item Operate\":5,\"undefined\":0},{\"Item Name\":0,\"Item Price\":6,\"Item Operate\":6,\"undefined\":0},{\"Item Name\":0,\"Item Price\":7,\"Item Operate\":7,\"undefined\":0},{\"Item Name\":0,\"Item Price\":8,\"Item Operate\":8,\"undefined\":0},{\"Item Name\":0,\"Item Price\":9,\"Item Operate\":9,\"undefined\":0}]}";
		return sampleData;
	}
}
