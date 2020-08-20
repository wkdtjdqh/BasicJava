package 장성보;

import java.util.Arrays;

public class Dealer {

	int cnt;
	Card card = new Card();
	String drowCard;
	String drowCardNum;
	String drowCardPat;

	Dealer() {
		cnt = 0;
		drowCard = null;
		drowCardNum = null;
		drowCardPat = null;
	}

	void shuffle() {
		
		for (int i = 0; i < card.cd.length; i++) {
			for (int j = 0; j < card.cd[i].length; j++) {
				int rnd = (int)(Math.random() * card.cd[i].length);
				
				String temp = card.cd[i][j];
				card.cd[i][j] = card.cd[i][rnd];
				card.cd[i][rnd] = temp;
			}
		}
	}

	void drow() {
		drow_card: for (int i = 0; i < card.cd[i].length; i++) {
			
			int rnd = (int)(Math.random()*4);
			
			if (!card.cd[rnd][i].equals("0")) {
				
				switch (rnd) {	// 카드 무늬 선택
				case 0: drowCardPat = "♠"; break;
				case 1: drowCardPat = "♥"; break;
				case 2: drowCardPat = "♣"; break;
				case 3: drowCardPat = "♦"; break;
				}
				
				drowCardNum = card.cd[rnd][i];
				card.cd[rnd][i] = "0";
				
				break drow_card;
			}
		}
	
	}
	
}
