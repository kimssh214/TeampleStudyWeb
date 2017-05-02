package kr.co.teamplestudyweb.controller.rest;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.teamplestudyweb.vo.common.CommonVo;

@RestController
public class RestfulController {

	@ResponseBody
	@RequestMapping(value = "/rest", produces = "application/json")
	public String get(HttpServletRequest request) {
		System.out.println("[INIT] REST");
		String inputParam = request.getParameter("param");

		if (inputParam != null) {
			System.out.println("inputParam: " + inputParam);
		}

		String param = "{\"id\":\"test\",\"pw\":\"test\",\"userName\":\"테스트\",\"pwErrCnt\":0}";
		JSONParser parser = new JSONParser();
		// JSONObject jsonObj = null;
		CommonVo commonVo = new CommonVo();
		String printParam = "";
		try {
			System.out.println(parser.parse(param).toString());
			printParam = parser.parse(param).toString();
			commonVo.setErrCode("0");
			commonVo.setErrMsg("통신 성공");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			commonVo.setErrCode("-1");
			commonVo.setErrMsg("통신 실패");
		}
		return printParam;
	}
}
