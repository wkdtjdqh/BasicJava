package b_operator;

public class ComparingOperator {

	public static void main(String[] args) {
		/*
		 * 비교연산자
		 * - <, >, <=, >=, ==, !=
		 * - 문자열 비교 : equals()
		 */
		boolean b = 10 < 20;	// 비교연산자의 연산결과는 boolean이다.
		System.out.println(b);	// true
		boolean c = 20 < 10;
		System.out.println(c);	// false
		
		b = 10 <= 20 - 15;		// 산술연산 후 비교연산을 수행한다.
		System.out.println(b);
		
		String str1 = "abc";
		String str2 = "123";
		b = str1 == str2;		// 문자열의 내용이 아닌 주소를 비교한 것이다.
		System.out.println(b);
		
//		String의 내용을 비교하기 위해서는 equals() method를 사용한다.
		b = str1.equals(str2);
		System.out.println(b);
		b = !str1.equals(str2);
		System.out.println(b);
		
//		int타입의 x, y를 만들고, 다음의 문장들을 코드로 작성해주세요.
		int x = 10, y = 20;
		
//		1. x가 y보다 크다
		boolean r = x > y;
		System.out.println("1. x가 y보다 크다 : " + r);
		
//		2. x는 y보다 작거나 같다.
		r = x <= y;
		System.out.println("2. x는 y보다 작거나 같다 : " + r);
		
//		3. x+5와 y는 같다
		r = x+5 == y;
		System.out.println("3. x+5와 y는 같다 : " + r);
		
//		4. x는 3의 배수이다.
		r = x%3 == 0;
		System.out.println("4. x는 3의 배수이다 : " + r);
		
//		5. y는 홀수이다.
		r = y%2 != 0;
		System.out.println("5. y는 홀수이다 : " + r);
		
//		6. x와 3y는 다르다.
		r = x != 3*y;
		System.out.println("6. x와 3y는 다르다 : " + r);
		
//		7. "변수"와 "데이터"는 같다.
		String s1 = "변수";
		String s2 = "데이터";
		r = s1.equals(s2);
		System.out.println("7. '변수'와 '데이터'는 같다 : " + r);
		
//		8. "기본형"과 "참조형"은 다르다.
		s1 = "기본형";
		s2 = "참조형";
		r = !s1.equals(s2);
		System.out.println("8. '기본형'과 '참조형'은 다르다 : " + r);
	}

}
