package j_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class JDBC {
	public static void main(String[] args) {
		/*
		 * JDBC(Java Database Connectivity)
		 * - 자바와 데이터베이스를 연결해주는 라이브러리
		 * - ojdbc : 오라클 JDBC
		 * 
		 * JDBC 작성 단계
		 * 1. Connection 생성
		 * 2. Statement 생성(쿼리)
		 * 3. Query 실행
		 * 4. ResultSet에서 결과 추출(select인 경우)
		 * 5. ResultSet, Statement, Connection 닫기
		 */
		
		//데이터베이스 접속 정보
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "PC11";
		String password = "java";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		//연결
		try {
			//DriverManager : 데이터베이스에 접속하기 위한 드라이버를 관리해주는 클래스
			con = DriverManager.getConnection(url, user, password);
			//getConnection에서 드라이버를 자동 로드
			
			String sql = "select deptno, count(*) from emp group by deptno order by deptno";
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();	//select 쿼리 실행
			
//			int result = ps.executeUpdate();	//insert, update, delete
			//쿼리로 인해 영향을 받은 row가 얼마나되는지 int타입으로 반환
			while(rs.next()) {	//rs.next() : 다음 줄이 있는지 없는지 반환
//				String memId = rs.getString(1);	//파라미터는 두가지 종류 : 컬럼의 순서, 컬럼의 이름
//				String memPass = rs.getString("MEM_PASS");
//				System.out.println("MEM_ID : " + memId + " / MEM_PASS : " + memPass);
				int deptno = rs.getInt(1);
				int cnt = rs.getInt(2);
				System.out.println("deptno : " + deptno + " cnt : " + cnt);
				
				//타입에 맞춰서 사용
//				rs.getInt(1)
//				rs.getDate(1)
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {	//사용한 것의 역순으로 닫아줘야 한다.
			if (rs != null) try { rs.close(); }  catch (Exception e) {}
			if (ps != null) try { ps.close(); }  catch (Exception e) {}
			if (con != null) try { con.close(); }  catch (Exception e) {}
			}
		}
		
	}

