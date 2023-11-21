package com.it.dao;
// DBCP (톰캣)=> 웹에서만 사용이 가능 (웹애플리케이션의 데이터베이스 기본)
// 일반 JDBC 사용 
import java.util.*;
import java.sql.*;
/*
 *   MNO      NOT NULL NUMBER        
	CNO               NUMBER        
	TITLE    NOT NULL VARCHAR2(500) 
	GRADE    NOT NULL VARCHAR2(50)  
	RESERVE           VARCHAR2(20)  
	GENRE    NOT NULL VARCHAR2(200) 
	TIME              VARCHAR2(30)  
	REGDATE           VARCHAR2(200) 
	DIRECTOR NOT NULL VARCHAR2(100) 
	ACTOR             VARCHAR2(200) 
	SHOWUSER          VARCHAR2(20)  
	POSTER   NOT NULL VARCHAR2(260) 
	STORY             CLOB          
	KEY      NOT NULL VARCHAR2(50)  
	HIT               NUMBER        
	SCORE             NUMBER(3,2)   
 */
public class DataDAO {
	private Connection conn; // mysql로의 연결을 위한 변수 선언
    private PreparedStatement ps; // sql 문장을 전송하기 위한 변수 선언
    private final String URL = "jdbc:mysql://192.168.0.47/project?serverTimezone=Asia/Seoul"; // mysql과의 연결을 위한 경로
    private static DataDAO dao;

    // 드라이버 등록
    public DataDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    // 연결
    public void getConnection() {
        try {
            conn = DriverManager.getConnection(URL, "project", "project"); // 경로, id, pw
            System.out.println("연결완료");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // 연결 해제
    public void disConnection() {
        try {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
   // 싱글턴 => DAO를 한번만 사용이 가능 (메모리 공간을 1개만 생성) = 재사용
   // 스프링에서는 기본 (싱글턴) => 필요시에는 여러개 객체 생성 => prototype
   public static DataDAO newInstance()
   {
	   if(dao==null)
		   dao=new DataDAO();
	   return dao;
   }

   public void seoulLocationInsert(SeoulLocationVO vo)
   {
	   try
	   {
		   getConnection();
		   String sql="INSERT INTO item(itemnum, itemname, sale, mainImg ) VALUES(?, ?, ?, ?)";
		   ps=conn.prepareStatement(sql);
		   
		   ps.setInt(1, vo.getItemNum());
		   ps.setString(2, vo.getItemName());
		   ps.setInt(3, vo.getSale());
		   ps.setString(4, vo.getMainImg());
		   // 4. 전송된 값들을 엡데이트 및 커밋
		   ps.executeUpdate();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   // 자원 사용이 끝난 후에는 반드시 아래와 같이 자원 반환을 위한 연결 해제 메서드를 호출해야 함.
		   disConnection();
	   }
   }
   public void seoulLocationUpdate(ImgVO vo)
   {
	   try
	   {
		   getConnection();
		   String sql="update item set subimg1 = ?, subimg2 = ?, subimg3 = ?,subimg4 = ? "
		   		+ "where itemnum = 2041";
		   ps=conn.prepareStatement(sql);
		   
		   ps.setString(1, vo.getSubimg1());
		   ps.setString(2, vo.getSubimg2());
		   ps.setString(3, vo.getSubimg3());
		   ps.setString(4, vo.getSubimg4());


		   // 4. 전송된 값들을 엡데이트 및 커밋
		   ps.executeUpdate();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   // 자원 사용이 끝난 후에는 반드시 아래와 같이 자원 반환을 위한 연결 해제 메서드를 호출해야 함.
		   disConnection();
	   }
   }
}






