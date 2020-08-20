package b_operator;

import java.util.Scanner;

public class SimpleCalculator {

	public static void main(String[] args) {
		// 두개의 숫자와 연산자를 입력받아 연산결과를 알려주는 프로그램을 만들어주세요. (사칙연산 수행)
		Scanner sc = new Scanner(System.in);
		double num1, num2;
		String op;

		System.out.println("첫번째 숫자를 입력하세요.");
		num1 = Double.parseDouble(sc.nextLine());
		System.out.println("두번째 숫자를 입력하세요.");
		num2 = Double.parseDouble(sc.nextLine());
		System.out.println("연산자를 입력하세요.");
		op = sc.nextLine();

		System.out.println(op.equals("+") ? num1 + num2
							: (op.equals("-") ? num1 - num2 : op.equals("*") ? num1 * num2
							: (op.equals("/") ? num1 / num2 : "error")));
	}

}