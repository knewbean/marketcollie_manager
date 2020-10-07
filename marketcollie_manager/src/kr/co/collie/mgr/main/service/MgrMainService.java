package kr.co.collie.mgr.main.service;

import java.security.NoSuchAlgorithmException;

import kr.co.collie.mgr.main.dao.MgrMainDAO;
import kr.co.collie.mgr.main.domain.MgrLoginDomain;
import kr.co.collie.mgr.main.vo.MgrLoginVO;
import kr.co.sist.util.cipher.DataEncrypt;

public class MgrMainService {
	
	/**
	 * 
	 * �����ڷ� �α����Ѵ�.
	 * 
	 * @param loginVO ������ ���̵�, ��й�ȣ�� ������ �ִ� VO
	 * @return  
	 * @throws NoSuchAlgorithmException 
	 */
	public MgrLoginDomain loginMgr(MgrLoginVO loginVO) throws NoSuchAlgorithmException {
		//��й�ȣ ��ȣȭ
		String encPass = DataEncrypt.messageDigest("MD5", loginVO.getPass());
		loginVO.setPass(encPass);
		
		return MgrMainDAO.getInstance().selectMgrLogin(loginVO);
	}
	
	
}
