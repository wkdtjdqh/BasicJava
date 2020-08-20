package b_operator;

public class ArithmeticOperator {

	public static void main(String[] args) {
		/*
		 * 산술 연산자
		 * - 사칙연산		:	+, -, *, /, %
		 * - 복합연산자		:	+=, -=, *=, /=, %=
		 * - 증감연산자 	:	++, --
		 */
		
		int result = 10 + 20 - 30 * 40 / 50 % 60;
//		곱하기와 나누기가 더하기 빼기보다 우선순위가 높다.
		
//		나머지 연산
		result = 10 % 4;
		System.out.println(result);
		
//		5개의 산술연산자를 사용해 5개의 연산을 수행 후 출력해주세요.
		result = 10 + 20;
		System.out.println(result);
		result = 20 - 30;
		System.out.println(result);
		result = 30 * 40; 
		System.out.println(result);
		result = 40 / 5;
		System.out.println(result);
		result = 60 % 7;
		System.out.println(result);
		
//		복합연산자
//		변수에 저장되어 있는 값에 연산을 수행할 때 수행할 연산자와 대입연산자를 결합해 사용할 수 있다.
		result = result + 3;
		System.out.println(result);
		
		result += 3;
		System.out.println(result);
		result -= 3;
		System.out.println(result);
		result *= 3;
		System.out.println(result);
		
//		아래의 문장을 복합연산자를 사용한 문장으로 만들어주세요.
//		result = result + 10;
		result += 10;
		System.out.println(result);
		
//		result = result - 2 * 3;
		result -= 2 * 3;
		System.out.println(result);
		
//		result = result % 5;
		result %= 5;
		System.out.println(result);
		
//		증감연산자
//		증가연산자 ++ : 변수 값을 1 증가시킨다.
//		감소연산자 -- : 변수 값을 1 감소시킨다.
		int i = 0;
		++i;	// 전위형 : i의 값을 증가시킨 후 읽어들임
		i++;	// 후위형 : i의 값을 읽어들인 후 증가시킴
		--i;
		i--;
		
		i = 0;
		System.out.println("++i : " + ++i);
		i = 0;
		System.out.println("i++ : " + i++);
		System.out.println("i : " + i);
		
//		피연산자의 타입이 서로 같아야만 연산이 가능하다.
		int _int = 10;
		double _double = 3.14;
		double result2 = _int + _double; // 표현범위가 더 큰 타입으로 형변환된다.
		System.out.println(result2);
		
		byte _byte = 5;
		short _short = 10;
		int result3 = _byte + _short;	// int보다 작은 타입은 int로 형변환된다.
		System.out.println(result3);
		
//		오버플로우, 언더플로우
//		표현범위를 벗어나는 값을 표현할 때 발생하는 현상
		byte b = 127;
		b++;
		System.out.println(b);	// 언더플로우
		b--;
		System.out.println(b);	// 오버플로우
		
//		타입을 선택할 때 연산의 범위를 고려해야한다.
		
//		다음을 한줄씩 계산해서 최종결과값을 출력해주세요.
//		1. 123456 + 654321
		long res = 123456 + 654321;
//		2. 1번 * 123456
		res *= 123456;
//		3. 2번 / 123456
		res /= 123456;
//		4. 3번 - 654321
		res -= 654321;
//		5. 4번 % 123456
		res %= 123456;
		System.out.println(res);
		
//		3개의 int형 변수를 선언 및 초기화 후 합계와 평균을 구해주세요.
		int first = 45;
		int second = 33;
		int third = 77;
		int sum = first + second + third;
		double avg = sum / 3.0;
		System.out.println("합 : " + (first + second + third) + " 평균 : " + (double)(first + second + third) / 3);
		System.out.println("합 : " + sum + " 평균 : " + avg);
		
//		반올림(Math.round method 사용) : 소수점 첫째자리에서 반올림
//		avg = Math.round(avg);
//		System.out.println(avg);
		avg = Math.round(avg*100);
		System.out.println(avg/100);
		
//		랜덤(Math.random() method 사용) : 0 ~ 0.99 .. 사이의 값
		System.out.println(Math.random());
		System.out.println((int)(Math.random()*100) + 1/*시작 값*/);
	}

}
