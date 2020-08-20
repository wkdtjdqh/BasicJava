package i_collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

public class HashMapClass {
	public static void main(String[] args) {
		/* 
		 * Object put(Object key, Object value) : 지정된 키와 값을 저장한다.
		 * Object remove(Object key) : 지정된 키로 저장된 값을 제거한다.
		 * Object get(Object key) : 지정된 키의 값(없으면 null)을 반환한다.
		 * Set keySet() : 저장된 모든 키를 Set으로 반환한다.
		 * 
		 * 해시맵은 인덱스가 아닌 키로 저장한다. 키는 주로 String Type으로 저장한다.
		 */
		
		HashMap<String, Object> map = new HashMap<>();	//제네릭에 키와 값의 타입을 지정한다.
		
		map.put("a", 10);
		map.put("b", "홍길동");
		map.put("c", new Date());
		
		//해시맵에는 순서가 없다.
		System.out.println(map);
		
		//하나의 키로는 하나의 값만 갖게된다.
		map.put("b", "이순신");	//기존에 있던 b의 값에 덮어쓴다.
		System.out.println(map);
		
		map.remove("a");	//삭제할 값의 키를 파라미터로 넘긴다.
		
		Object obj = map.get("b");	//리턴타입은 제네릭에 지정해준 타입이다.
		
		System.out.println(obj);
		
		Set<String> keys = map.keySet();
		System.out.println(keys);
		
		//향상된 for문을 이용해서 값을 읽어야 한다.
		for(String key : keys){	//변수 : 읽을 값(배열과같이 다수의 값으 가진 것)
			System.out.println(key + " : " + map.get(key));
		}
		
		//회원 테이블
		//아이디, 비밀번호, 이름, 전화번호
		/*	key		:	 value
		 * 아이디		: admin
		 * 비밀번호	: admin123
		 * 이름		: 관리자
		 * 전화번호	: 010-1234-5678
		 */
		System.out.println();
		HashMap<String, String> user = new HashMap<>();
		user.put("id", "admin");
		user.put("password", "admin123");
		user.put("name", "관리자");
		user.put("tel", "010-1234-5678");
		keys = user.keySet();
		for(String key : keys){
			System.out.println(key + " : " + user.get(key));
		}
		
		//회원 1명의 데이터가 담긴 HashMap을 하나 더 만들어주세요.
		HashMap<String, String> user1 = new HashMap<>();
		user1.put("id", "jsb5045");
		user1.put("password", "jsb50451742");
		user1.put("name", "장성보");
		user1.put("tel", "010-5045-1742");
		
		//ArrayList에 HashMap 두개를 넣게되면 ArrayList가 Table이 된다.
		//실제 아래와 같이 Table을 저장한다.
		ArrayList<HashMap<String, String>> table = new ArrayList<>();
		table.add(user);
		table.add(user1);
		System.out.println(table);
	}
}
