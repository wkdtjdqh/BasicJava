package 장성보;

public class User {
	
	int cnt;
	String[] inHandCardNum;
	String[] inHandCardPattern;
	
	User(){
		cnt = 0;
		inHandCardPattern = new String[5];
		inHandCardNum = new String[5];
	}
	
	void myCard(String pattern, String num, int cnt){
		this.inHandCardPattern[cnt] = pattern;
		this.inHandCardNum[cnt] = num;
	}
}
