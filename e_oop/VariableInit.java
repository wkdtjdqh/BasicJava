package e_oop;

public class VariableInit {

	// 명시적 초기화
	int var = 10;
	static int staticVar = 20;

	// 초기화 블럭
	{ // 인스턴스 변수 초기화
		var = 30;
	}

	static { // 클래스 변수 초기화
		staticVar = 40;
	}

	/*
	 * 생성자 - 클래스와 같은 이름의 메서드 - 인스턴스 변수를 초기화하기 위해 사용한다. - 클래스에 생성자는 반드시 하나 이상
	 * 존재해야 한다. - 직접 선언해주지 않으면 컴파일러가 기본 생성자를 만들어준다. - 생성자는 리턴타입이 없다.
	 */

	VariableInit() { // 생성자, 인스턴스 변수를 초기화하기 위해서 사용
		var = 50;
		// staticVar = 60;
		// 값은 공유해야 하는 클래스 변수가 객체 생성 시 마다 계속 초기화되기 때문에 클래스 변수를 생성자에서 초기화하는 것은 좋지
		// 않다.

		// 생성자 사용 이유
		// 초기화에 여러줄의 코드가 필요할 때
		// 초기화에 파라미터가 필요할 때
	}

	public static void main(String[] args) {
		Init i = new Init();
		i.a = 10;
		i.b = 20;
		i.c = 30;

		Init i2 = new Init();
		i2.a = 40;
		i2.b = 50;
		i2.c = 60;

		Init i3 = new Init(70, 80, 90);

	}

}

class Init {
	int a;
	int b;
	int c;

	Init(int a, int b, int c) { // 변수 이름이 같은 경우 지역변수가 우선적으로 사용된다.
		this.a = a;
		this.b = b;
		this.c = c;
		// this : 클래스에 객체를 가르키는 변수, 객체의 주소를 저장하고있는 하나의 변수
		// 인스턴스 변수와 지연변수의 이름이 같을 때 둘을 구분하기 위해 사용한다.
	}

	Init() {
//		a = 10;
//		b = 20;
//		c = 30;
		this(10, 20, 30);
		//this() : 생성자에서 다른 생성자를 호출할 때 사용한다.
	}
	// 오버로딩 : 같은 이름의 메서드를 여러개 정의하는 것 :ex) println
	// 이름이 같은 메서드는 파라미터의 개수, 타입으로 구분한다.
}