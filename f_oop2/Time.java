package f_oop2;

public class Time {
	
	private int hour;
	private int minute;
	private int second;
	
	String getTime() {
		return hour + ":" + minute + ":" + second;
	}
	
	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		if (hour >= 0 && hour < 24) {
			this.hour = hour;
		} else this.hour = 0;
	}
	
	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		if (minute >= 0 && minute < 60) {
			this.minute = minute;
		} else this.minute = 0;
	}
	
	public int getSecond() {
		return second;
	}
	
	public void setSecond(int second) {
		if (second >= 0 && second < 60) {
			this.second = second;
		} else this.minute = 0;
	}
	
	void clock() {
		while (true) {
			System.out.println(getTime());
			stop(1000);
			setSecond(second + 1);
		}
	}
	
	private void stop(int interval) {
		try {
			Thread.sleep(interval);	//ms : 1/1000s
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
