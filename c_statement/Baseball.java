package c_statement;

import java.util.Scanner;

public class Baseball {

	public static void main(String[] args) {
		/* 과제
		 * 1 3 5
		 * 서로 비교
		 * 1 2 3 : 1S 1B 1O
		 */
		
		Scanner sc = new Scanner(System.in);
		// 정답입력
		
		int one = 0, two = 0, thr = 0;
		int ans1 = 0, ans2 = 0, ans3 = 0;
		int s = 0, b = 0, o = 0;
		
		while(s < 3){
			// 초기화
			s = 0;
			b = 0;
			o = 0;
			
			System.out.println("첫번째 숫자를 입력하세요.");
			one = Integer.parseInt(sc.nextLine());
			System.out.println("두번째 숫자를 입력하세요.");
			two = Integer.parseInt(sc.nextLine());
			System.out.println("세번째 숫자를 입력하세요.");
			thr = Integer.parseInt(sc.nextLine());
			
			ans1 = (int)(Math.random()*9) + 1;
			ans2 = (int)(Math.random()*9) + 1;
			ans3 = (int)(Math.random()*9) + 1;
//			int i1 = input % 10;
//			input /= 10;
			
			//test
//			ans1 = 2;
//			ans2 = 4;
//			ans3 = 1;
			
			// 첫번째 자리
			if (one == ans1){
				s += 1;
			} else if (one == ans2){
				b += 1;
			} else if (one == ans3){
				b += 1;
			} else o += 1;
			
			// 두번째 자리
			if (two == ans2){
				s += 1;
			} else if (two == ans1){
				b += 1;
			} else if (two == ans3){
				b += 1;
			} else o += 1;
			
			// 세번째 자리
			if (thr == ans3){
				s += 1;
			} else if (thr == ans1){
				b += 1;
			} else if (thr == ans2){
				b += 1;
			} else o += 1;
			
			System.out.println("결과 : " + s + "S " + b + "B " + o + "O");
		}
		System.out.println("정답 : " + ans1 + ans2 + ans3);
		
		
	}

}
