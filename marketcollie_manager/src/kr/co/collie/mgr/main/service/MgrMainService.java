package kr.co.collie.mgr.main.service;

import java.security.NoSuchAlgorithmException;

import kr.co.collie.mgr.main.dao.MgrMainDAO;
import kr.co.collie.mgr.main.domain.MgrLoginDomain;
import kr.co.collie.mgr.main.vo.MgrLoginVO;
import kr.co.sist.util.cipher.DataEncrypt;

public class MgrMainService {
	
	/**
	 * 
	 * 관리자로 로그인한다.
	 * 
	 * @param loginVO 관리자 아이디, 비밀번호를 가지고 있는 VO
	 * @return  
	 * @throws NoSuchAlgorithmException 
	 */
	public MgrLoginDomain loginMgr(MgrLoginVO loginVO) throws NoSuchAlgorithmException {
		//비밀번호 암호화
		String encPass = DataEncrypt.messageDigest("MD5", loginVO.getPass());
		loginVO.setPass(encPass);
		
		return MgrMainDAO.getInstance().selectMgrLogin(loginVO);
	}
	
	
}
