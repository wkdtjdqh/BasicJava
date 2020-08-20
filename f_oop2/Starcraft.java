package f_oop2;

public class Starcraft {

	public static void main(String[] args) {
		Marine marine = new Marine();
		Tank tank = new Tank();
		Dropship dropship = new Dropship();
		SCV scv = new SCV();
		
		scv.repair(tank);
		scv.repair(dropship);
	}
	
}

class Unit{	//부모로 사용
	int hp;	//현재 체력
	final int MAX_HP;	//최대 체력
	
	Unit(int hp){
		MAX_HP = hp;
		this.hp = MAX_HP;
	}
	
}

class Marine extends Unit{
	Marine() {
		super(40);
	}
}

class Tank extends Unit implements Repairable{
	Tank() {
		super(150);
	}
}

class Dropship extends Unit implements Repairable{
	Dropship() {
		super(125);
	}
}

class SCV extends Unit {
	SCV() {
		super(60);
	}
	void repair(Repairable r) {
		if (r instanceof Unit) {	//Unit으로 형변환이 가능한지 확인 : true or false
			Unit u = (Unit) r;
			
			while(u.hp < u.MAX_HP) {
				u.hp++;
			}
		}
	}
}

interface Repairable {
	
}