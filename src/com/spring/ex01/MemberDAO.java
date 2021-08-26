package com.spring.ex01;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAO {
	public static SqlSessionFactory sqlMapper = null;

	// 오잉
	private static SqlSessionFactory getInstance() {
		if (sqlMapper == null) {
			try {
				
				//해당 xml를 읽어서 DB연동 준비를한다
				String resource = "mybatis/SqlMapConfig.xml";
				Reader reader = Resources.getResourceAsReader(resource);
				
				//마이바티스를 이용하면 sqlMapper 객체를 가져온다
				sqlMapper = new SqlSessionFactoryBuilder().build(reader);
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sqlMapper;

	}

//	public List<MemberVO> selectAllMemberList() {
//		
//		sqlMapper = getInstance();
//		
//		//실제 member.xml의 SQL문을 호출하는 데 사용되는 SqlSesion 객체를 가져온다
//		SqlSession session = sqlMapper.openSession();
//		List<MemberVO> memlist = null;
//		
//		//실행^~^
//		memlist = session.selectList("mapper.member.selectAllMemberList");
//		return memlist;
//	}
	
	 public List<HashMap<String, String>> selectAllMemberList() { 
		
		sqlMapper = getInstance(); 
     	
		SqlSession session = sqlMapper.openSession();
		
		List<HashMap<String, String>> memlist = null; 
		
		memlist = session.selectList("mapper.member.selectAllMemberList"); 
		
		return memlist; 
	 }
	
}
