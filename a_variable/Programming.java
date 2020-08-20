package a_variable;

public class Programming {

	public static void main(String[] args) {
		/*
		 * 1. 데이터
		 * 	- 기본형	:	숫자, 문자, 논리
		 * 	- 배열	:	같은 것끼리 묶어서 사용하는 것
		 * 	- 클래스	:	다른 것끼리 묶어서 사용하는 것
		 *  
		 * 2. 연산
		 * 	- 산술연산	:	+, -, *, /, %
		 * 	- 비교연산	:	>, <, >=, <=, ==, !=
		 * 	- 논리연산	:	&&, ||, !
		 * 	- 조건문 	:	if, switch
		 * 	- 반복문	:	for, while, do-while
		 */
		
		// 나온 숫자들의 각 자리의 값을 비교하여 최종적으로 가장 큰 숫자를 찾음
		 
		
		for(int i=0; i<10; i++){
			System.out.println((int)(Math.random() * 100) + " ");
		}
	}

}
