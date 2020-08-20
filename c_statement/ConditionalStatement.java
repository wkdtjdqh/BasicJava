package c_statement;

import java.util.Scanner;

public class ConditionalStatement {

	public static void main(String[] args) {
		/*
		 * 조건문 - if문 - switch문
		 * 
		 * if문 - if(조건식){} : 조건식의 결과가 true이면 블럭안의 문장을 수행한다. - else if(조건식){}:
		 * 다수의 조건이 필요할 때 if 뒤에 추가하여 사용한다. - else{} : 결과가 true인 조건식이 하나도 없는 경우를
		 * 위해 추가한다.
		 */

		int a = 1;

		if (a == 1) {
			System.out.println("조건식의 연산결과가 true이면 실행된다.");
		}

		if (a == 0) {
			System.out.println("조건식의 연산결과가 false이면 실행되지 않는다.");
		}

		if (a == 1) {
			System.out.println("a가 1인 경우에 하고싶은 것");
		} else if (a == 2) {
			System.out.println("a가 2인 경우에 하고싶은 것");
		} else if (a == 3) {
			System.out.println("a가 3인경우에 하고싶은 것");
		} else
			System.out.println("이외의 경우에 하고싶은 것");

		// 조건을 한묶음으로 사용하기 위해서는 반드시 else if를 사용해야 한다.
		if (a < 10) {
			System.out.println("a가 10보다 작다.");
		} else if (a < 20) {
			System.out.println("a가 20보다 작다.");
		}

		// 시험점수가 60점 이상이면 합격 그렇지 않으면 불합격
		int score = 60;
		if (score >= 60) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		}

		// 성적에 등급을 부여하는 프로그램을 작성해주세요.
		score = 60;
		String grade = null;

		if (score > 100) {
			grade = "?";
		} else if (score >= 90) {
			grade = "A";
		} else if (score >= 80) {
			grade = "B";
		} else if (score >= 70) {
			grade = "C";
		} else if (score >= 60) {
			grade = "D";
		} else
			grade = "F";

		System.out.println("score : " + score + ", grade : " + grade);

		score = 79;
		grade = null;

		if (score >= 90) {
			grade = "A";
			if (97 <= score) {
				grade += "+";
			} else if (93 >= score) {
				grade += "-";
			}
		} else if (score >= 80) {
			grade = "B";
			if (87 <= score) {
				grade += "+";
			} else if (83 >= score) {
				grade += "-";
			}
		} else if (score >= 70) {
			grade = "C";
			if (77 <= score) {
				grade += "+";
			} else if (73 >= score) {
				grade += "-";
			}
		} else if (score >= 60) {
			grade = "D";
			if (67 <= score) {
				grade += "+";
			} else if (63 >= score) {
				grade += "-";
			}
		} else
			grade = "F";

		System.out.println("score : " + score + ", grade : " + grade);

		// 정렬 : Ctrl + Shift + F

		/*
		 * switch문 - switch(int/String){case: break;} - 조건식의 결과는 정수와
		 * 문자열만(JDK1.7부터 문자열 허용) 허용한다. - 조건식과 일치하는 case문 이후의 문장을 수행한다.
		 */

		a = 1;
		switch (a) {
		case 1:
			System.out.println("a가 1인 경우에 하고싶은 것");
			break;
		case 2:
			System.out.println("a가 2인 경우에 하고싶은 것");
			break;
		case 3:
			System.out.println("a가 3인 경우에 하고싶은 것");
			break;
		default:
			System.out.println("이외에 하고싶은 것");
			break; // 생략가능
		}

		String b = "A";
		switch (b) {
		case "A":
			System.out.println("b가 \"A\"인 경우에 하고싶은 것");
			break;
		case "B":
			System.out.println("b가 \"B\"인 경우에 하고싶은 것");
			break;
		default:
			System.out.println("외");
			break;
		}

		// 주어진 월에 해당하는 계절을 출력해봅시다.
		int month = 1;
		String season = null;

		switch (month) {
		case 3:
		case 4:
		case 5:
			season = "봄";
			break;
		case 6:
		case 7:
		case 8:
			season = "여름";
			break;
		case 9:
		case 10:
		case 11:
			season = "가을";
			break;
		case 12:
		case 1:
		case 2:
			season = "겨울";
			break;
		default:
			break;
		}
		System.out.println(month + "월, " + season);

		score = 100;
		grade = null;
		switch (score / 10) {
		case 10:
			grade = "A+";
			break;
		case 9:
			grade = "A";
			break;
		case 8:
			grade = "B";
			break;
		case 7:
			grade = "C";
			break;
		case 6:
			grade = "D";
			break;

		default:
			grade = "F";
			break;
		}
		System.out.println("score : " + score + ", grade : " + grade);

		// 숫자를 입력받아 그 숫자가 0인지 0이 아닌지 출력해주세요.
		Scanner sc = new Scanner(System.in);

		// System.out.println("숫자를 입력해주세요.");
		// double num = Double.parseDouble(sc.nextLine());
		//
		// if (num == 0) {
		// System.out.println("입력하신 숫자는 0이 맞습니다.");
		// }else {
		// System.out.println("입력하신 숫자는 0이 아닙니다.");
		// }

		// 숫자를 입력받아 그 숫자가 홀수인지 짝수인지 출력해주세요.
		System.out.println("숫자를 입력해주세요.");
		// int in = Integer.parseInt(sc.nextLine());
		// if (in%2 == 0) {
		// System.out.println("짝수");
		// } else System.out.println("홀수");

		// 점수 3개를 입력받아 총점, 평균, 등급을 출력해주세요.
		int num1 = Integer.parseInt(sc.nextLine());
		int num2 = Integer.parseInt(sc.nextLine());
		int num3 = Integer.parseInt(sc.nextLine());
//		
//		grade = null;
//		int sum = num1 + num2 + num3;
//		double avg = sum / 3;
//
//		if (avg <= 100 && 90 <= avg) {
//			grade = "A";
//			if (97 <= avg) {
//				grade += "+";
//			} else if (avg <= 93) {
//				grade += "-";
//			}
//		} else if (80 <= avg) {
//			grade = "B";
//			if (87 <= avg) {
//				grade += "+";
//			} else if (avg <= 83) {
//				grade += "-";
//			}
//		} else if (70 <= avg) {
//			grade = "C";
//			if (77 <= avg) {
//				grade += "+";
//			} else if (avg <= 73) {
//				grade += "-";
//			}
//		} else if (60 <= avg) {
//			grade = "D";
//			if (67 <= avg) {
//				grade += "+";
//			} else if (avg <= 63) {
//				grade += "-";
//			}
//		} else
//			grade = "F";
//
//		System.out.println("avg : " + avg + ", grade : " + grade);
		
		//숫자 3개를 입력받아 오름차순으로 출력해주세요.
		
//		if (num1 <= num2) {
//			if (num2 <= num3) {
//				System.out.println(num1 + "\n" + num2 + "\n" + num3);
//			} else if (num3 <= num2) {
//				System.out.println(num1 + "\n" + num3 + "\n" + num2);
//			}
//		} else if (num2 <= num1) {
//			if (num1 <= num3) {
//				System.out.println(num2 + "\n" + num1 + "\n" + num3);
//			} else if (num3 <= num1) {
//				System.out.println(num2 + "\n" + num3 + "\n" + num1);
//			}
//		} else if (num3 <= num1) {
//			if (num1 <= num2) {
//				System.out.println(num3 + "\n" + num1 + "\n" + num2);
//			} else if (num2 <= num1) {
//				System.out.println(num3 + "\n" + num2 + "\n" + num1);
//			}
//		} 
		
		int s = 0;
		if (num1 > num2) {	// 1, 2 비교
			s = num1;
			num1 = num2;
			num2 = s;
		}
		if (num1 > num3) {	// 1, 3 비교
			s = num1;
			num1 = num3;
			num3 = s;
		}
		if (num2 > num3) {	// 2, 3 비교
			s = num2;
			num2 = num3;
			num3 = s;
			System.out.println(num1 + "\n" + num2 + "\n" + num3);
		}
	}
}

