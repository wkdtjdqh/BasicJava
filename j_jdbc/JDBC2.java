package j_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Date;

public class JDBC2 {
	public static void main(String[] args) {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "PC11";
		String password = "java";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "select *"
					+ " from cart"	//공백이 들어가야 한다.
					+ " where cart_member = ?";	//값을 동적으로 넣어주고 싶을 때 ?를 사용한다.
			
			ps = con.prepareStatement(sql);
			ps.setString(1, "a001");
			
		
//			ps.setInt(parameterIndex, x);
//			ps.setObject(parameterIndex, x);
//			ps.setDate(1, new Date(new java.util.Date().getTime()));
			rs = ps.executeQuery();
			
			ResultSetMetaData md = rs.getMetaData();	//컬럼을 한번에 보기위해서는 rs에 대한 메타데이터가 필요하다
														//메타데이터 : 데이터에 대한 데이터
			int columnCount = md.getColumnCount();
			
			while (rs.next()) {
//				rs.getString(1);
				for (int i = 1; i <= columnCount; i++) {
//					rs.getObject(i);
					Object value = rs.getObject(md.getColumnName(i));
					System.out.println(value + "\t");
				}
				System.out.println();
				
			}
			
			String sql2 = "insert into dept_test3(deptno, dname, loc) values(?, ?, ?)";
			
			ps = con.prepareStatement(sql2);
			ps.setInt(1, 99);
			ps.setString(2, "JJ");
			ps.setString(3, "DAEJEON");
			
			int result = ps.executeUpdate();
			System.out.println(result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); }  catch (Exception e) {}
			if (ps != null) try { ps.close(); }  catch (Exception e) {}
			if (con != null) try { con.close(); }  catch (Exception e) {}
		}
	}
}
