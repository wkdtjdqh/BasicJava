package e_oop;

public class Control {

	public static void main(String[] args) {
		TV tv = new TV();

		while(true){
			System.out.println("------------------------------------");
			System.out.println("기능선택");
			System.out.println("전원(1) 채널선택(2) 채널올리기(3) 채널내리기(4)\n"
					+ "소리올리기(5) 소리내리기(6)");
			System.out.println("------------------------------------");
			int tv_con = ScanUtil.nextInt();
			System.out.println(tv_con);

			int channel = 0;
			int vol = 0;
			
			if (tv_con == 1) {
				tv.power_switch();
				System.out.println("ON");
				if (tv.power == false) {
					System.out.println("OFF");
					break;
				}
			} else if (tv_con == 2) {
				System.out.println("채널을 입력해주세요.");
				channel = ScanUtil.nextInt();
				tv.channel_change(channel);
			} else if (tv_con == 3) {
				channel = tv.channel_up();
				System.out.println(channel + "번");
			} else if (tv_con == 4) {
				channel = tv.channel_down();
				System.out.println(channel + "번");
			} else if (tv_con == 5) {
				vol = tv.volume_up();
				System.out.println(vol);
			} else if (tv_con == 6) {
				vol = tv.volume_down();
				System.out.println(vol);
			} else {
				System.out.println("잘못된 선택입니다.");
			}
		}
	}
}
