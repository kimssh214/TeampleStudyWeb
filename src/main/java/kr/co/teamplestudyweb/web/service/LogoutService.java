package kr.co.teamplestudyweb.web.service;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.co.teamplestudyweb.web.dao.LoginDao;
import kr.co.teamplestudyweb.web.vo.LoginVo;
import kr.co.teamplestudyweb.web.vo.LogoutVo;

@Service
public class LogoutService {
	private static final Logger log = LoggerFactory.getLogger(LogoutService.class);

	@Autowired
	LoginDao loginDao;

	public LogoutVo getLoginInfo(JSONObject jsonObj, HttpSession session) {

		String id = jsonObj.get("id").toString() != null ? jsonObj.get("id").toString() : "";
		LoginVo sessionLoginVo = null;
		LogoutVo logoutVo = null;
		// 세션 생성
		if (session.getAttribute("userInfo") != null && !id.equals("")) {
			sessionLoginVo = (LoginVo) session.getAttribute("userInfo");
			logoutVo = new LogoutVo();
			if (sessionLoginVo.getId().equals(id)) {
				log.debug("현재 Login 세션 종료:" + sessionLoginVo.getId());
				logoutVo.setId(sessionLoginVo.getId());
				logoutVo.setLogoutTime("");// 추후 로그아웃 시간 로직 추가
				logoutVo.setErrCode("200");
				logoutVo.setErrMsg("로그 아웃 성공");
				logoutVo.setNextPage("login");
				session.invalidate();
			} else {
				logoutVo.setId(sessionLoginVo.getId());
				logoutVo.setLogoutTime("");// 추후 로그아웃 시간 로직 추가
				logoutVo.setErrCode("-1");
				logoutVo.setErrMsg("로그 아웃 실패");
				logoutVo.setNextPage("#");
			}

		}

		return logoutVo;
	}
}
