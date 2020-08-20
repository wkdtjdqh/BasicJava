package 장성보;

import java.util.Arrays;

import e_oop.ScanUtil;

public class MyGame {	// 텍사스 홀덤 포커

	static int money;
	int bettingCnt;		// 베팅횟수
	int betMoney;		// 게임에 베팅된 총 금액
	int bettingMoney;	// 내 돈에서 빠져나갈 베팅금액
	String dealerCard;
	String cn;
	String pt;

	MyGame() {
		betMoney = 0;
		bettingCnt = 0;
		bettingMoney = 0;
		dealerCard = null;
	}

	public static void main(String[] args) {
		MyGame mg = new MyGame();
		
		if (money < 500) {			// 초기자금 500원보다 적으면 1000원으로 채운다.
			money += 500 - money;
		}
		
		while (true) {
			System.out.println("┌──────────────────────────┐");
			System.out.println("│    1.게임시작  2.지갑  3.종료        │");
			System.out.println("└──────────────────────────┘");
			int input = ScanUtil.nextInt();

			switch (input) {
			case 1:
				mg.startGame();
				break;

			case 2:
				System.out.println("소유금액 : " + money + "\n");
				break;

			case 3:
				System.out.println("종료");
				System.exit(0);
				break;
			}
		}

	}
	
	void startGame() {
		Card card = new Card();
		User user = new User();
		Dealer deal = new Dealer();

		System.out.println("┌───────────────┐\n│딜러 : 카드를 섞습니다	│\n└───────────────┘");
		deal.shuffle();
		
		for (int i = 0; i < user.inHandCardNum.length; i++) {
			
			if (i == 0) {
				System.out.println("┌──────────────────────┐\n│딜러 : 첫번째 카드를 분배합니다   │\n└──────────────────────┘");
			} else if (i == 1) {
				
				System.out.println("┌───────────────────────┐\n│딜러 : 두번째 카드를 분배합니다	│\n└───────────────────────┘");
			}
			
			if (i < 2) {
				deal.drow();
				pt = deal.drowCardPat;
				cn = deal.drowCardNum;
				user.myCard(pt, cn, user.cnt);
				switch (cn) {	// 점수계산을 위해 숫자로 변환
				case "A": cn = "1"; break;
				case "J": cn = "10"; break;
				case "Q": cn = "10"; break;
				case "K": cn = "10"; break;
				}
				
			} else if (i >= 2) {	// 비공개 카드
				user.myCard("?", "?", user.cnt);
			}

			user.cnt++;
		}
		
		while(true){
			
			System.out.println("┌───────────────────────┐\n│딜러 : 배팅을 진행해주세요	│\n└───────────────────────┘");
			System.out.println("1. 카드확인  2. 포기(fold)  3. 베트(bet)");
			int betting = ScanUtil.nextInt();
			switch (betting) {
			case 1:
				card.showCard(user.inHandCardNum, user.inHandCardPattern, user.cnt);
				break;
				
			case 2:
				System.out.println("게임을 포기하셨습니다. 재시작하시겠습니까?(Y/N)");
				String[] restart = null;
				String input = ScanUtil.nextLine();
				switch (input) {
				case "Y":
				case "y":
					main(restart);
					break;
				case "N":
				case "n":
					System.out.println("\n종료합니다.");
					System.exit(0);
					break;
				}
				break;

			case 3:
				loop : while (true) {
					System.out.println("얼마를 베팅하시겠습니까? (취소 : 9)");
					bettingMoney = ScanUtil.nextInt();
					
					if (bettingMoney == 9 || bettingMoney == 9) {
						break loop;
					}
					
					if (bettingMoney <= money) {
						bettingCnt++;	//횟수 1증가
						money -= bettingMoney;
						betMoney += bettingMoney;
						System.out.println(bettingMoney + "원을 베팅하셨습니다.\n남은 금액은 " + money + "원 입니다.");
						
						switch (bettingCnt) {
						case 1:
							System.out.println("┌───────────────────────┐\n│딜러 : 두장의 카드를 공개합니다.	│\n└───────────────────────┘");
							
							for (int i = 2; i < user.cnt-1; i++) {	// 3, 4번째 카드 공개
								deal.drow();
								pt = deal.drowCardPat;
								cn = deal.drowCardNum;
								user.myCard(pt, cn, i);
								switch (cn) {
								case "A": cn = "1"; break;
								case "J": cn = "10"; break;
								case "Q": cn = "10"; break;
								case "K": cn = "10"; break;
								}
							}
							break;
							
						case 2:	// 5번째 카드 공개
							System.out.println("┌───────────────────────┐\n│딜러 : 마지막 카드를 공개합니다.	│\n└───────────────────────┘");
							
							deal.drow();
							
							pt = deal.drowCardPat;
							cn = deal.drowCardNum;
							user.myCard(pt, cn, user.cnt-1);
							switch (cn) {
							case "A": cn = "1"; break;
							case "J": cn = "10"; break;
							case "Q": cn = "10"; break;
							case "K": cn = "10"; break;
							}
							card.showCard(user.inHandCardNum, user.inHandCardPattern, user.cnt);
							if (card.sum < 35) {
								betMoney = betMoney * 2;
								System.out.println("당신은 " + card.sum + "점으로 이기셨습니다.");
								System.out.println("베팅금액의 두배인 " + betMoney + "를 얻습니다!");
								money += betMoney;
							}
							restart = null;
							System.out.println("재시작하시겠습니까?(Y/N)");
							input = ScanUtil.nextLine();
							switch (input) {
							case "Y":
							case "y":
								main(restart);
								break;
							case "N":
							case "n":
								System.out.println("\n종료합니다.");
								System.exit(0);
								break;
							}
							
							break;
						}
						break ;
					}
					
					System.out.println("돈이 부족합니다. 현재 금액 : " + money);
				}
				break;
				
//			case 4:
//				rule();
//				break;
			}
			
		}
		
	}

	
}
