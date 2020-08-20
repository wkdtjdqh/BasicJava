package j_jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UtilTest {

	public static void main(String[] args) {
		JDBCUtil jd = JDBCUtil.getInstance();
		String sql = "select * from emp where empno = 7369";
		Map<String, Object> map = jd.selectOne(sql);
		System.out.println(map);
		
		sql = "select * from emp where empno in (7369, 7698)";
		List<Map<String, Object>> list = jd.selectList(sql);
		System.out.println(list);

		sql = "select * from emp where empno = ?";
		List<Object> list1 = new ArrayList<>();
		list1.add(7369);
		map = jd.selectOne(sql, list1);
		System.out.println(map);
	}

}
