package kr.co.teamplestudyweb.web.controller.rest;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonRestController {

	private static final Logger log = LoggerFactory.getLogger(CommonRestController.class);

	// RequestBody 정보 읽어오기
	public String readRequestBody(HttpServletRequest request) {
		String readData = "";
		try {
			StringBuilder buffer = new StringBuilder();
			BufferedReader reader = request.getReader();
			String line;
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			readData = buffer.toString();
			log.debug(readData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return readData;
	}

	// Json String 파싱 후 Json Object 로 변환
	public JSONObject parseringJsonString(String jsonString) {
		JSONParser parser = new JSONParser();
		JSONObject jsonObj = null;
		try {
			jsonObj = (JSONObject) parser.parse(jsonString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObj;
	}

}
