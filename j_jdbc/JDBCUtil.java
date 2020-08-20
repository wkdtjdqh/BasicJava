package j_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCUtil {

	//싱글톤 패턴 : 인스턴스의 생성을 제한하여 하나의 인스턴스만 사용하는 디자인 패턴
	//객체 생성을 못하게(생성자를 호출하지 못하게 private)
	//클레스 자체에서 객체를 생성해서 빌려줌
	//생성한 객체를 보관할 메서드 필요
	
	private JDBCUtil() {
		
	}
	
	//인스턴스를 보관할 변수
	private static JDBCUtil instance;
	
	//인스턴스를 빌려주는 메서드
	public static JDBCUtil getInstance() {
		if (instance == null) {
			instance = new JDBCUtil();
		}
		return instance;
	}
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "PC11";
	String password = "java";
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	ResultSetMetaData md = null;
	
	/*
	 * Map<String, Object> selectOne(String sql)	row 하나만 조회, where절이 없는 쿼리, 컬럼명 컬럼값 리턴
	 * Map<String, Object> selectOne(String sql, List<Object> param)	where절이 필요, ?가 있는 쿼리, ?가 여러개 -> List에 순서대로
	 * List<Map<String, Object>> selectList(String sql)
	 * List<Map<String, Object>> selectList(String sql, List<Object> param)
	 * int update(String sql)
	 * int update(String sql, List<Object> param)
	 */
	
	Map<String, Object> selectOne(String sql) {	//row 하나, ?이 없음, 컬러명과 컬럼값(해쉬맵)을 리턴
		Map<String, Object> map = new HashMap<>();
		
		try {
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			md = rs.getMetaData();
			int colCnt = md.getColumnCount();
			
			while(rs.next()) {
				for (int i = 1; i < colCnt; i++) {
					String key = md.getColumnName(i);
					Object val = rs.getObject(i);
					map.put(key, val);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); }  catch (Exception e) {}
			if (ps != null) try { ps.close(); }  catch (Exception e) {}
			if (con != null) try { con.close(); }  catch (Exception e) {}
		}
		
		return map;
	}
	
	Map<String, Object> selectOne(String sql, List<Object> param) {
		Map<String, Object>map = new HashMap<>();
		
		try {
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(sql);
			
			//리스트
			for (int i = 0; i < param.size(); i++) {
				ps.setObject(i+1, param.get(i));
			}
			rs = ps.executeQuery();
			
			ResultSetMetaData md = rs.getMetaData();
			int colCnt = md.getColumnCount();
			while(rs.next()) {
				for (int i = 1; i < colCnt; i++) {
					String key = md.getColumnName(i);
					Object val = rs.getObject(i);
					map.put(key, val);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); }  catch (Exception e) {}
			if (ps != null) try { ps.close(); }  catch (Exception e) {}
			if (con != null) try { con.close(); }  catch (Exception e) {}
		}
		
		return map;
	}
	
	List<Map<String, Object>> selectList(String sql) {
		List<Map<String, Object>>list = new ArrayList<>();
		Map<String, Object> map;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			md = rs.getMetaData();
			int colCnt = md.getColumnCount();
			
			while(rs.next()) {
				map = new HashMap<>();
				for (int i = 1; i < colCnt; i++) {
					String key = md.getColumnName(i);
					Object val = rs.getObject(i);
					map.put(key, val);
				}
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); }  catch (Exception e) {}
			if (ps != null) try { ps.close(); }  catch (Exception e) {}
			if (con != null) try { con.close(); }  catch (Exception e) {}
		}
		
		return list;
	}
	
	List<Map<String, Object>> selectList(String sql, List<Object> param) {
		List<Map<String, Object>>list = new ArrayList<>();
		Map<String, Object> map;
				
		try {
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(sql);
			
			//리스트
			for (int i = 0; i < param.size(); i++) {
				ps.setObject(i+1, param.get(i));
			}
			rs = ps.executeQuery();
			
			ResultSetMetaData md = rs.getMetaData();
			int colCnt = md.getColumnCount();
			while(rs.next()) {
				map = new HashMap<>();
				for (int i = 1; i < colCnt; i++) {
					String key = md.getColumnName(i);
					Object val = rs.getObject(i);
					map.put(key, val);
				}
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); }  catch (Exception e) {}
			if (ps != null) try { ps.close(); }  catch (Exception e) {}
			if (con != null) try { con.close(); }  catch (Exception e) {}
		}
		
		return list;
	}
	
	int update(String sql) {
		int result = 0;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(sql);
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (ps != null) try { ps.close(); }  catch (Exception e) {}
			if (con != null) try { con.close(); }  catch (Exception e) {}
		}
		
		return result;
	}
	
	int update(String sql, List<Object> param) {
		int result = 0;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(sql);
			for (int i = 0; i < param.size(); i++) {
				ps.setObject(i+1, param.get(i));
			}
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (ps != null) try { ps.close(); }  catch (Exception e) {}
			if (con != null) try { con.close(); }  catch (Exception e) {}
		}
		
		return result;
	}
}
