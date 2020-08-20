package b_operator;

import java.util.Scanner;

public class Etc {

	public static void main(String[] args) {
		/*
		 * 비트 연산자
		 * - |, &, ^, ~, <<, >>
		 * - 비트단위로 연산한다.
		 * 
		 * 기타 연산자
		 * - .(참조연산자) : 특정 범위 내에 속해있는 멤버를 지칭할 때 사용한다.
		 * - (type) 	: 형변환
		 * - ?(삼항연산자) : 조건식 ? 조건식이 참일 경우 수행할 문장 : 조건이 거짓일 경우 수행할 문장 
		 */
//		1byte : 01010101
//		1바이트는 8개의 비트(0또는 1)를 표현할 수 있다.
//		비트단위로 연산을 수행하는 연산자가 비트 연산자이다.
		System.out.println(10 | 15);	// | : 둘다 0인경우 0 그외 1
//		10 : 00001010
//		15 : 00001111
//			 00001111 : 15
		
		int x = 10, y = 20;
		int result = (x < y) ? x : y;
		System.out.println(result);
		
//		주민등록번호 뒷자리의 첫번째 숫자가 1이면 남자 2면 여자
		int regNo = 3;
		String gender = (regNo == 1) ? "남자" : "여자";
		System.out.println("당신의 성별은 " + gender + " 입니다.");
		
		gender = regNo == 1 ? "남자" : (regNo == 2 ? "여자" : "확인불가");
		System.out.println("당신의 성별은 " + gender + " 입니다.");
		
//		2개의 숫자를 입력받고, 둘 중 더 큰 숫자를 출력해주세요.
		Scanner sc = new Scanner(System.in);
		
//		System.out.print("첫번째 숫자를 입력 : ");
//		int f_num = Integer.parseInt(sc.nextLine());
//		System.out.print("두번째 숫자를 입력 : ");
//		int s_num = Integer.parseInt(sc.nextLine());
//		
//		System.out.println("둘 중 더 큰 숫자는 " + ((f_num > s_num) ? f_num : s_num) + "입니다"); 
		
//		숫자를 입력받고 그 숫자가 1이나 3이면 남자를 2나 4면 여자를 출력해주세요.
		System.out.print("숫자를 입력 : ");
		int num = Integer.parseInt(sc.nextLine());
		System.out.println((num == 1) || (num == 3) ? "남자" : ((num == 2) || (num == 4) ? "여자" : "확인불가"));
	}

}
