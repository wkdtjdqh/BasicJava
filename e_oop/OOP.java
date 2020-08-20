package e_oop;

import java.util.Scanner;

//패키지명에 .으로 하위패키지를 구분
public class OOP {

	public static void main(String[] args) {
		/*
		 * 객체지향 프로그래밍(Object Oriented Programming) - 프로그램을 단순히 코드의 연속으로 보는것이 아니라
		 * 객체간의 상호작용으로 보는것 - 코드의 재사용성이 높고 유지보수가 용이하다 여기서 객체는 Class를 말함
		 */

		SampleClass sc = new SampleClass(); // 객체 생성, 사용할 수 있게 메모리에 올리고 메모리의 주소를
											// sc라는 참조변수에 넣어줌

		System.out.println(sc.field);

		sc.method1();

		String returnValue = sc.method2(5);
		System.out.println(returnValue);

		sc.flowTest1();

		// 방금 만든 클래스의 객체를 생성하고 변수에 저장해주세요.
		ClassMaker cm = new ClassMaker();

		// 객체가 저장된 변수를 통해 메서드를 호출해주세요.
		// 파라미터가 있는 메서드는 타입에 맞는 값을 넘겨주시고,
		// 리턴타입이 있는 메서드는 리턴받은 값을 출력해주세요.
		cm.val1 = 3;
		cm.method1();

		int return_m2 = cm.method2();
		System.out.println(return_m2);

		cm.method3(20);

		int return_m4 = cm.method4(10, 34);
		System.out.println(return_m4);
//		System.err.println(cm.method4(500, 78));
		
		System.out.println("");
		//다음을 한줄씩 계산해서 최종 결과값을 출력해주세요.
		//1. 123456 + 654321
		//2. 1번 * 123456
		//3. 2번 / 123456
		//4. 3번 - 654321
		//5. 4번 % 123456
		
		Calculator cal = new Calculator();
		
		double add = cal.add(123456, 654321);
		double mul = cal.mul(add, 123456);
		double div = cal.div(mul, 123456);
		double min = cal.min(div, 654321);
		double rem = cal.rem(min, 123456);
		
		System.out.println(rem);
		
		/*
		 * 식당 예제와 같은 어떤 대상을 잡아 클래스를 구성해주세요.
		 * 대상이 가진 속성을 변수로 만들어주세요.
		 * 메서드의 내용을 자세히 만들 필요는 없고 파라미터와 리턴타입 위주로 만들어주세요.
		 * 만들어진 클래스를 main메서드에서 사용해주세요.
		 */
		Melon melon = new Melon();
		
		Scanner s = new Scanner(System.in);
		System.out.println("몇번째 노래를 재생할까요?");
//		while(true){
			
			melon.music_num(Integer.parseInt(s.nextLine()));
			
			System.out.println("---------------------------");
			System.out.println("volume up(8) volume down(2)\n"
					+ "재생(6) 중지(5) 다음곡(9) 이전곡(7)\n"
					+ "종료(4) 도움말(1)");
			
			int n = Integer.parseInt(s.nextLine());
			
			melon.melon_control(n);
			
			System.out.println("melon을 종료합니다.");
//			break;
//		}
	}

}
