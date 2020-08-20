package f_oop2;

public abstract class SampleAbstarctParent {
	
	void method() {
		
	}
	
	//추상 메서드 : 선언부만 있고 구현부는 없는 메서드
	abstract void abstarctMethod();	// 어떤 메서드를 만들어야 하는지 가이드 역할을 한다.
	
}

class SampleAbstractChild extends SampleAbstarctParent{
	
	@Override
	void abstarctMethod(){
		
	}
	
	
}