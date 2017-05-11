package kr.co.teamplestudyweb.web.service;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.co.teamplestudyweb.web.dao.LoginDao;
import kr.co.teamplestudyweb.web.vo.LoginVo;

@Service
public class LoginService {
	private static final Logger log = LoggerFactory.getLogger(LoginService.class);

	@Autowired
	LoginDao loginDao;

	public LoginVo getLoginInfo(JSONObject jsonObj, HttpSession session) {

		LoginVo loginVo = new LoginVo();

		String id = jsonObj.get("id").toString() != null ? jsonObj.get("id").toString() : "";
		String pw = jsonObj.get("pw").toString() != null ? jsonObj.get("pw").toString() : "";

		try {
			if (id.length() > 0 && pw.length() > 0) {
				loginVo.setId(id);
				loginVo.setPw(pw);

				int checkLoginInfo = loginDao.checkLoginInfo(loginVo);
				log.debug("checkLoginInfo: "+checkLoginInfo);
				if (checkLoginInfo == 1) {
					loginVo.setErrCode("200");
					loginVo.setErrMsg("로그인 인증 성공");
					loginVo.setNextPage("main");

					loginDao.updateLastLoginDate(loginVo);// 로그인 시간 업데이트
					loginDao.updateResetPwErrCnt(loginVo);// 로그인 실패 횟수 초기화
					// 세션 생성
					if (session.getAttribute("userInfo") != null) {
						LoginVo sessionTest1 = (LoginVo) session.getAttribute("userInfo");
						log.debug("현재 Login 세션:" + sessionTest1.getId());

					} else {
						session.setAttribute("userInfo", loginVo);
						LoginVo sessionTest2 = (LoginVo) session.getAttribute("userInfo");
						log.debug("새로운 Login 세션생성:" + sessionTest2.getId());
					}
				} else {

					loginDao.updatePwErrCnt(loginVo);// 로그인 실패 횟수 증가

					loginVo.setErrCode("-1");
					loginVo.setErrMsg("로그인 정보 없음");
					loginVo.setNextPage("#");

					// 세션 초기화
					session.setAttribute("userInfo", null);
				}
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return loginVo;
	}
}
