package e_oop;

public class UserDefinedDataType {

	public static void main(String[] args) {
		/*
		 * 사용자 정의 데이터 타입 (Class)
		 * - 데이터의 최종 진화 형태이다. (변수 → 배열 → 클래스)
		 * - 서로 다른 타입의 데이터를 묶어서 사용하는 것이다.
		 * - 변수와 메서드로 구성할 수 있다.
		 */
		
		int kor;
		int eng;
		int math;
		int sum;
		double avg;
		String name;
		
		int[] scores;
		double avg2;
		String name2;
		
		Student student;	//선언	→	Student클래스의 객체를 참조하기 위한 참조변수student 선언
		
		student = new Student();	//객체 생성, 인스턴스화	→	클래스의 객체를 생성 후, 객체의 주소를 참조변수에 저장
		
		student.name = "홍길동";	// .은 참조연산자, student클래스 안에 name이라는 변수를 호출해 홍길동을 저장
		student.kor = 80;
		
		System.out.println(student.name);
		System.out.println(student.kor);
	}

}

class Student{
	int kor;
	int eng;
	int math;
	int sum;
	double avg;
	String name;
}