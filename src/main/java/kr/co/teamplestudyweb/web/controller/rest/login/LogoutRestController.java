package kr.co.teamplestudyweb.web.controller.rest.login;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import kr.co.teamplestudyweb.web.controller.rest.CommonRestController;
import kr.co.teamplestudyweb.web.service.LogoutService;
import kr.co.teamplestudyweb.web.vo.LogoutVo;

@RestController
public class LogoutRestController extends CommonRestController {
	private static final Logger log = LoggerFactory.getLogger(LogoutRestController.class);

	@Autowired
	LogoutService logoutService;

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public LogoutVo loginChk(HttpSession session, HttpServletRequest request) {
		log.debug("REST LogoutCheck Init");
		String jsonStringData = readRequestBody(request);
		log.debug("jsonStringData:" + jsonStringData);
		JSONObject jsonObj = parseringJsonString(jsonStringData);
		LogoutVo logoutVo = logoutService.getLoginInfo(jsonObj, session);

		// 데이터베이스 적용전 임시 코드 끝

		return logoutVo;
	}
}
