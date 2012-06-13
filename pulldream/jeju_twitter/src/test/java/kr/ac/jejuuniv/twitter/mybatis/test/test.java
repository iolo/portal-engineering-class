//package kr.ac.jejuuniv.twitter.mybatis.test;
//
//import java.util.HashMap;
//
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionManager;
//
//public class test {
//	public void testProc() {
//	    HashMap<String, String> param = new HashMap<String, String>();
//	    param.put("id", "aaaaaaa");
//	    param.put("userSeq", "222222222");
//	    param.put("resultMsg", "");
//	    
//	    session.selectOne("Proc.testProc", param);
//	    
//	    System.out.println("resultMsg => " + param.get("resultMsg"));
//	}
//}
