package c_statement;

import java.util.Scanner;

public class NewBaseball {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);	

		int r1 = (int)(Math.random()*9) + 1;
		int r2 = (int)(Math.random()*9) + 1;
		int r3 = (int)(Math.random()*9) + 1;

		int cnt = 0;
		
		while(true){
			int strike = 0, ball = 0, out = 0;
			System.out.println("세자리의 정수를 입력해주세요.");
			int input = Integer.parseInt(sc.nextLine());
			
			int a3 = input % 10;			//   1
			int a2 = (input /= 10) % 10;	//  10
			int a1 = (input /= 10) % 10;	// 100
			
			if (r1 == a1) strike++;
			if (r2 == a2) strike++;
			if (r3 == a3) strike++;
			
			if (r1 == a2) ball++; else if (r1 == a3) ball++;
			if (r2 == a1) ball++; else if (r2 == a3) ball++;
			if (r3 == a1) ball++; else if (r3 == a2) ball++;
			
			out = 3 - strike - ball;
			
			++cnt;
			System.out.println(cnt + "번째 게임] " + strike + "S" + ball + "B" + out + "O");
			
			if (strike == 3) {
				System.out.println("정답입니다] " + r1 + "" + r2 + "" + r3 + "");
				break;
			}
		} 
	}
}
