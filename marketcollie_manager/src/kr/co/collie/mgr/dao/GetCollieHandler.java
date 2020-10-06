package kr.co.collie.mgr.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class GetCollieHandler {
	private static GetCollieHandler gch;
	private static SqlSessionFactory ssf;
	
	private GetCollieHandler() {
		
	}//CartDAO
	
	public static GetCollieHandler getInstance() {
		if(gch==null) {
			gch=new GetCollieHandler();
		}//end if
		return gch;
	}//getInstance
	
	public SqlSession getSqlSession() {
		SqlSession ss=null;
		
		try {
			if(ssf==null) {
				//1.xml과 연결(buildpath에서 included와 Excluded룰 모두 삭제 해야 함)
				String xmlConfig="kr/co/collie/mgr/dao/collie_config.xml";
				Reader reader=Resources.getResourceAsReader(xmlConfig);
				//2.MyBatis Framework 생성
				ssf=new SqlSessionFactoryBuilder().build(reader);
				reader.close();//xml을 읽어들인 스트림을 끊는다.
			}//end if
			ss=ssf.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return ss;
	}//getSqlSession
	
}//class
