package 장성보;

import e_oop.ScanUtil;

public class Card {

	String[][] cd = new String[4][13];
	String[] pattern;
	String[] num;
	static int sum;

	Card() {

		pattern = new String[] { "♠", "♥", "♣", "♦" };
		num = new String[] { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

		for (int i = 0; i < pattern.length; i++) {
			for (int j = 0; j < num.length; j++) {
				cd[i][j] = num[j]; // 0 : ♠, 1 : ♥, 2 : ♣, 3 : ㅁ
			}
		}
	}

	// 라인마다 print를 반복문으로 여러장 출력되도록 해보자 (showHandCard)

	void showCard(String[] CardNum, String[] CardPattern, int handCnt) {
		sum = 0;
		for (int i = 0; i < handCnt; i++) {
			switch (CardNum[i]) {
			case "A":
				sum += 1;
				break;
			case "J":
				sum += 10;
				break;
			case "Q":
				sum += 10;
				break;
			case "K":
				sum += 10;
				break;
			}

			if (!CardNum[i].equals("A") && !CardNum[i].equals("J") && !CardNum[i].equals("Q") && !CardNum[i].equals("K")
					&& !CardNum[i].equals("?")) {
				sum += Integer.parseInt(CardNum[i]);
			}
		}
		System.out.println("현재 점수는 : " + sum);

		for (int i = 0; i < handCnt; i++) { // 소유 카드 수 만큼 출력
			System.out.print("┌─────────────┐  ");
		}
		System.out.println();

		for (int i = 0; i < handCnt; i++) {
			System.out.print("│" + CardPattern[i] + "           " + CardPattern[i] + "│  ");
		}
		System.out.println();

		for (int j = 0; j < 2; j++) {
			for (int i = 0; i < handCnt; i++) {
				System.out.print("│             │  ");
			}
			System.out.println();
		}

		for (int i = 0; i < handCnt; i++) {
			if (CardNum[i].equals("A") || CardNum[i].equals("J") || CardNum[i].equals("Q") || CardNum[i].equals("K")
					|| CardNum[i].equals("?")) {

				System.out.print("│      " + CardNum[i] + "      │  ");

			} else if (CardNum[i].equals("A") || CardNum[i].equals("J") || CardNum[i].equals("Q")
					|| CardNum[i].equals("K") || CardNum[i].equals("?")) {

				System.out.print("│      " + CardNum[i] + "      │  ");

			} else if (Integer.parseInt(CardNum[i]) > 9) {

				System.out.print("│      " + CardNum[i] + "     │  ");

			} else {

				System.out.print("│      " + CardNum[i] + "      │  ");

			}
		}
		System.out.println();

		for (int j = 0; j < 2; j++) {
			for (int i = 0; i < handCnt; i++) {
				System.out.print("│             │  ");
			}
			System.out.println();
		}

		for (int i = 0; i < handCnt; i++) {
			System.out.print("│" + CardPattern[i] + "           " + CardPattern[i] + "│  ");
		}
		System.out.println();

		for (int i = 0; i < handCnt; i++) {
			System.out.print("└─────────────┘  ");
		}
		System.out.println();

		if (sum >= 35) {
			System.out.println("35점이 넘어서 패배했습니다.");
			System.out.println("재시작하시겠습니까?(Y/N)");
			String input = ScanUtil.nextLine();
			switch (input) {
			case "Y":
			case "y":
				String[] restart = null;
				MyGame.main(restart);
				break;
			case "N":
			case "n":
				System.out.println("\n종료합니다.");
				System.exit(0);
				break;
			}
		}
	}
}
