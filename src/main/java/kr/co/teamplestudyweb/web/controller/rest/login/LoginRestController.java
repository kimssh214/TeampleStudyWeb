package kr.co.teamplestudyweb.web.controller.rest.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.teamplestudyweb.web.controller.rest.CommonRestController;
import kr.co.teamplestudyweb.web.service.LoginService;
import kr.co.teamplestudyweb.web.vo.LoginVo;

@RestController
public class LoginRestController extends CommonRestController {
	private static final Logger log = LoggerFactory.getLogger(LoginRestController.class);

	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/login/check", method = RequestMethod.POST)
	public LoginVo loginChk(HttpSession session, HttpServletRequest request, Model md) {
		log.debug("REST LoginCheck Init");

		// Body 데이터 읽기
		String jsonStringData = readRequestBody(request);
		log.debug("jsonStringData:" + jsonStringData);
		JSONObject jsonObj = parseringJsonString(jsonStringData);
		LoginVo loginVo = loginService.getLoginInfo(jsonObj, session);

		return loginVo;
	}

}
