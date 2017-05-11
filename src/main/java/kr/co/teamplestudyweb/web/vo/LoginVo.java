package kr.co.teamplestudyweb.web.vo;

import java.io.Serializable;

import kr.co.teamplestudyweb.web.vo.common.CommonVo;

public class LoginVo extends CommonVo implements Serializable {
	private String id;// 아이디
	private String pw;// 패스워드
	private String userName;// 사용자 이름
	private String createDate;// 계정 생성날짜
	private String lastLoginDate;// 마지막 로그인 날짜
	private String pwErrCnt;// 오류 횟수
	private String authType;// 권한

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(String lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getPwErrCnt() {
		return pwErrCnt;
	}

	public void setPwErrCnt(String pwErrCnt) {
		this.pwErrCnt = pwErrCnt;
	}

	public String getAuthType() {
		return authType;
	}

	public void setAuthType(String authType) {
		this.authType = authType;
	}

}
