package kr.co.teamplestudyweb.controller.rest.login;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import kr.co.teamplestudyweb.vo.LoginVo;

@RestController
public class LoginRestController {

	@RequestMapping(value = "/login/check", method = RequestMethod.POST)
	public LoginVo loginChk(HttpServletRequest request) {
		System.out.println("REST LoginCheck Init");
		// Body 데이터 읽기
		String inData = "";
		try {
			StringBuilder buffer = new StringBuilder();
			BufferedReader reader = request.getReader();
			String line;
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			inData = buffer.toString();
			System.out.println(inData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JSONParser parser = new JSONParser();
		LoginVo loginVo = new LoginVo();
		JSONObject jsonObj = null;
		try {
			jsonObj = (JSONObject) parser.parse(inData);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 데이터베이스 적용전 임시 코드 시작
		String id = jsonObj.get("id").toString() != null ? jsonObj.get("id").toString() : "";
		String pw = jsonObj.get("pw").toString() != null ? jsonObj.get("pw").toString() : "";

		if (id.equals("root") && pw.equals("root123")) {
			loginVo.setId(id);
			loginVo.setPw(pw);
			loginVo.setErrCode("200");
			loginVo.setErrMsg("로그인 성공");
			loginVo.setNextPage("main");
		} else {
			loginVo.setErrCode("-1");
			loginVo.setErrMsg("로그인 실패");
			loginVo.setNextPage("#");
		}
		// 데이터베이스 적용전 임시 코드 끝

		return loginVo;
	}
}
