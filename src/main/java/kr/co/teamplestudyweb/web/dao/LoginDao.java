package kr.co.teamplestudyweb.web.dao;

import kr.co.teamplestudyweb.web.vo.LoginVo;

public interface LoginDao {

	public int checkLoginInfo(LoginVo loginInfo) throws Exception;

	public int updateLastLoginDate(LoginVo loginInfo) throws Exception;

	public int updatePwErrCnt(LoginVo loginInfo) throws Exception;

	public int updateResetPwErrCnt(LoginVo loginInfo) throws Exception;

	public LoginVo getLoginInfo(LoginVo loginInfo) throws Exception;

	public int updateLoginInfo(LoginVo loginInfo) throws Exception;

}
