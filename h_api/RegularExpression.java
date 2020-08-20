package h_api;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {
	public static void main(String[] args) {
		/*
		 * 정규표현식 : 문자열의 패턴을 검사하는 표현식(회원가입에서 많이 사용한다.)
		 * 
		 * ^	뒷 문자로 시작(ex : ^A)
		 * $	앞 문자로 종료(ex : A$)
		 * .	임의의 문자(줄바꿈 제외)
		 * *	앞 문자가 0개 이상
		 * +	앞 문자가 1개 이상
		 * ?	앞 문자가 없거나 1개
		 * []	문자의 집합이나 범위([a-z] : a부터 z까지, [^a-z] : a부터 z가 아닌 것)
		 * {} 	앞 문자의 개수({2} : 2개, {2,4} : 2개 이상 4개 이하
		 * ()	그룹화(1개의 문자처럼 인식)
		 * |	OR 연산
		 * \s	공백, 탭, 줄바꿈
		 * \S	공백, 탭, 줄바꿈이 아닌 문자
		 * \w	알파벳이나 숫자
		 * \W	알파벳이나 숫자가 아닌 문자
		 * \d	숫자
		 * \D	숫자가 아닌 문자
		 * (?i)	뒷 문자의 대소문자 구분 안함
		 * \	정규표현식에서 사용되는 특수문자 표현(\? : 위 ?의 역할로 사용되는 것이 아닌 특수문자 ?로 사용할 수 있다.)
		 */
		
		//정규표현식의 범위는 좁게만드는 것이 좋은 표현식이라고 볼 수 있다.
		String str = "abc123";
//		String regex = "[a-z]{3}[0-9]{1,3}";	//정규표현식은 문자열로 만든다.
//		String regex = "[a-z0-9]+";	//a에서 z까지 0에서 9까지가 1개 이상이다.
//		String regex = "\\w*";	//알파벳이나 숫자가 0개 이상, JAVA에서는 \하나를 표현하기 위해서 \\를 사용한다.
		String regex = ".*";
		
		Pattern P = Pattern.compile(regex);	//Pattern이라는 객체를 돌려준다.
		Matcher m = P.matcher(str);	//확인할 문자열을 파라미터로 넣어준다. (패턴과 문자열을 매치시켜 확인 후 매처를 돌려준다.)
		System.out.println(m.matches());	//일치할 시 true, 불일치 false
		
		//아이디, 전화번호, 이메일주소의 유효성을 검사하는 정규표현식을 만들어주세요.
		String id = "wkdtjdqh95_26";
		String num = "010-5045-1742";
		String email = "wkdtjdqh17@gmail.com";
		
		String idRegex = "([a-z0-9]_*-*){5,20}";
		String numRegex = "^0\\d{1,3}-\\d{4}-\\d{4}";
		String mailRegex = "[[a-z0-9]_*-*]{5,20}@{1}[a-z]+\\.{1}[a-z]{3}";
//		String mailRegex = "[a-z0-9_-]{5,20}@[a-zA-Z]+\\.(?i)(com|net|org|([a-z]{2}\\.kr))$";
		
		Pattern P1 = Pattern.compile(idRegex);
		Pattern P2 = Pattern.compile(numRegex);
		Pattern P3 = Pattern.compile(mailRegex);
		
		Matcher m1 = P1.matcher(id);
		Matcher m2 = P2.matcher(num);
		Matcher m3 = P3.matcher(email);
		
		System.out.println("ID : " + m1.matches());
		System.out.println("PN : " + m2.matches());
		System.out.println("Mail : " + m3.matches());
	}
}
