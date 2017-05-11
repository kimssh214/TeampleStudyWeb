package kr.co.teamplestudyweb.web.vo;

import java.io.Serializable;

import kr.co.teamplestudyweb.web.vo.common.CommonVo;

public class LogoutVo extends CommonVo implements Serializable {
	private String id;
	private String logoutTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLogoutTime() {
		return logoutTime;
	}

	public void setLogoutTime(String logoutTime) {
		this.logoutTime = logoutTime;
	}

}
