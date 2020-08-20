package e_oop;

public class TV {
	
	boolean power;	// 껐다키기버튼
	int volume;		// 소리올리기, 내리기
	int channel;	// 채널변경, 올리기, 내리기
	
	{
		power = false;
		volume = 15;
		channel = 1;
	}
	
	void power_switch(){
		if (power == false) {
			power = true;
		} else if (power == true) {
			power = false;
		}
	}
	
	int volume_up(){
		if (30 <= volume) {
			System.out.println("소리가 최대입니다.");
			return volume;
		}
		volume++;
		return volume;
	}
	
	int volume_down(){
		if (0 >= volume) {
			System.out.println("소리가 최소입니다.");
			return volume;
		}
		volume--;
		return volume;
	}
	
	void channel_change(int channel){
		this.channel = channel;
		System.out.println(this.channel + "번");
	}
	
	int channel_up(){
		channel++;
		return channel;
	}
	
	int channel_down(){
		channel--;
		return channel;
	}
}
