package a_variable;

import java.util.Scanner;

public class Variable {

	public static void main(String[] args) {
		/*
		 * 데이터의 종류
		 * - 정수 : 1, -3
		 * - 실수 : 1.2, -3.4
		 * - 문자 : 'a', '3'
		 * - 논리 : true, false
		 * 
		 * 프로그래밍 언어의 기준으로 데이터의 종류를 나눠 놓은것 : 자료형(data type)
		 * 기본형 타입
		 * - 정수 : byte(1), short(2), int(4), long(8)
		 * - 실수 : float(4), double(8)
		 * - 문자 : char(2)
		 * - 논리 : boolean(1)
		 * 변수 생성시 사용
		 * 
		 * 데이터를 다룰때 일반적으로 변수라는 그릇에 담아서 사용
		 */
		
//		변수 : 하나의 데이터를 담을 수 있는 그릇
		int name;	// 변수 선언
		double name2;
		
//		= (대입연산자) : 오른쪽의 값을 왼쪽의 변수에게 저장
		name = 1;	// 초기화
		name2 = 4.3;	// 변수 타입에 맞는 값을 저장해야 함
		
		int a = 30;	// 보통 선언과 초기화를 동시에 함
		long l = 40L;	// 접미사 L을 붙여야 long타입이 됨
		float f = 5.5f;	// 접미사 f를 붙여야 float타입이 됨
		char c = 'a';	// 따옴표안에 한 글자만 넣어야 함
		boolean b = true;	// true, false
		
//		8가지 변수 생성
		byte bt = 4;
		short st = 10;
		int it = 3000;
		long l1 = 399L;
		float fl = 3.2f;
		double db = 4.5;
		char cr = 'c';
		boolean bl = false;
		
		System.out.println(bt + "," + st + "," + it + "," + l1 + "," + fl + "," + db + "," + cr + "," + bl);
		
//		8가지 변수 새로운 값 저장
		bt = 35;
		st = 1500;
		it = 1522214;
		l1 = 58L;
		fl = 7.7f;
		db = 1.2332;
		cr = 'a';
		bl = true;
		
		System.out.println(bt + "," + st + "," + it + "," + l1 + "," + fl + "," + db + "," + cr + "," + bl);
		
		/*
		 * 타입의 선택 기준
		 * 
		 * 정수
		 * - byte, short(약 -3만~3만) : 메모리를 절약해야 할 때
		 * - int(약 -20억~20억) : 기본
		 * - long : int의 범위를 벗어날 때
		 * 
		 * 실수
		 * - float(앞에서 7자리까지 정확) : 메모리를 절약해야 할 때 
		 * - double(앞에서 15자리까지 정확) : 기본 
		 */
		
		System.out.println("");
//		문자열
		String str = "문자열 입니다.";
		System.out.println(str);
		
//		형변환(type casting)
//		다른 타입의 값을 저장하기 위해서는 값의 타입을 변경해 주어야 하는데 이를 형변환이라고 함
		int small = 10;
		long big = 10L;
		small = (int)big;
		big = small;	// 표현 범위가 큰 타입에 작은 타입을 대입하려 할 때 자동적으로 형변환이 이루어짐, 생략 가능
		
		/*
		 * 명명규칙
		 * - 영문자 대소문자, 한글, 숫자, 특수문자를 사용할 수 있다.
		 * - 숫자로 시작할 수 없다.
		 * - 예약어는 사용할 수 없다.
		 * - [낙타식 표기법을 사용한다. (mySampleVariable)]
		 * - [클래스명의 첫글자는 대문자로 한다. (MySampleVariable)]
		 */
		
		/*
		 * 상수
		 * - 처음 담긴 값을 변경할 수 없는 그릇
		 * - 리터럴에 의미를 부여하기 위해 사용한다.
		 */
		final int MAX_NUMBER;
		MAX_NUMBER = 10;
//		MAX_NUMBER = 101; // 컴파일 에러 발생
		
//		출력
		System.out.print("");	// 줄바꿈을 안함
		System.out.println();
		
		System.out.printf("문자열 : %s, 숫자 : %d\n", "hi", 10);	// 출력 포맷을 지정
		
//		입력
		Scanner sc = new Scanner(System.in);	// 입력받기 위한 클래스 Scanner
		// import : Ctrl + Shift + o
		
//		System.out.println("입력해주세요");
//		String str2 = sc.nextLine();	// 입력을 받을 때까지 프로그램이 멈춤
//		System.out.println(str2);
//		
//		System.out.println("int input");
//		int number = Integer.parseInt(sc.nextLine());
//		System.out.println(number);
		
//		자신의 이름을 저장할 변수를 선언
		String myName;
		
//		변수를 초기화하기 위해 이름을 입력
		System.out.print("이름을 입력해주세요 : ");
		myName = sc.nextLine();
		
//		나이를 저장할 변수
		int myAge;
		System.out.print("나이를 입력해주세요 : ");
//		myAge = sc.nextInt();
		myAge = Integer.parseInt(sc.nextLine());
		
		System.out.println("이름 : " + myName + "\n나이 : " + myAge);
		
//		과제 9~25p 복습. 읽어보고 중간중간 문제, 연습문제 풀어보기
		System.out.println("1" + "2");
	}
	
}



