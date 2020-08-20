package i_collection;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Board {
	
	static int pkNum;
	static String myName;
	static Scanner sc = new Scanner(System.in);
	static String titleInput;
	static String contentsInput;
	static boolean checking;
	
	Board() {
		checking = false;
	}
	
	public static void main(String[] args) {
		pkNum = 1;
		/*
		 * ArrayList와 HashMap을 사용해 게시판 테이블을 만들고(테이블에 PK가 존재해야 함)
		 * 조회, 등록, 수정, 삭제가 가능한 게시판을 만들어주세요.
		 * 
		 * 내용 : 번호(PK), 제목, 내용, 작성자, 작성일
		 */
		
		/*
		 * 해쉬맵 구성
		 * 번호		pk, 변수를 만들어서 증가연산자 사용
		 * 제목		사용자가 입력
		 * 내용		사용자가 입력
		 * 작성자		프로그램 시작하면 입력
		 * 작성일		날짜포맷사용해서 현재 날짜 출력 07/23
		 */
		
		ArrayList<HashMap<String, Object>> table = new ArrayList<>();
		
		System.out.println("─────────────────────────────");
		System.out.println("게시판을 이용하려면 사용자 이름이 필요합니다.");
		System.out.print("이름 : ");
		myName = sc.nextLine();
		System.out.println("─────────────────────────────");
		
		
		
		while (true) {
			HashMap<String, Object> map = new HashMap<>();
			
			System.out.println("─────────────────────────────────────────────");
			System.out.println(" 번호\t\t제목\t\t작성자\t작성일");
			System.out.println("─────────────────────────────────────────────");
			
			if (0 < table.size()) {
					
				for (int i = table.size()-1; 0 <= i; i--) {
					HashMap hm = table.get(i);
					System.out.println(" " + hm.get("pk") + "\t\t" + hm.get("title") + "\t\t" + hm.get("name") + "\t" + hm.get("date"));
				}
				
			} else 
				System.out.println("\n");
			
			System.out.println("─────────────────────────────────────────────");
			
			System.out.println(" 1.조회\t2.등록\t3.종료");
			int input = Integer.parseInt(sc.nextLine());
			
			ug : switch (input) {
			
			case 1:	//조회, 게시글 읽기
				boolean c  = false;
				System.out.print("조회할 게시글 번호를 입력하세요 : ");
				int pkCheck = Integer.parseInt(sc.nextLine());
				if (0 < table.size()) {
					for (int i = 0; i < table.size(); i++) {
						checking = true;
						
						if (pkCheck == (int)table.get(i).get("pk")) {
							c = true;
							System.out.println("─────────────────────────────────────────────");
							System.out.println("제목 : " + table.get(i).get("title"));
							System.out.println("─────────────────────내용─────────────────────");
							System.out.println("─────────────────────────────────────────────");
							System.out.println(" " + table.get(i).get("contents"));
							System.out.println("─────────────────────────────────────────────");
							System.out.println("작성자 : " + table.get(i).get("name") + "\t작성일 : " + table.get(i).get("date"));
							System.out.println("─────────────────────────────────────────────");
							System.out.println("1.수정\t2.삭제\t3.뒤로가기");
							input = Integer.parseInt(sc.nextLine());
							
							sw : switch (input) {
							case 1:	//수정
								int switchCnt = 0;
								System.out.println("─────────────────────────────────────────────");
								System.out.println("제목 : " + table.get(i).get("title"));
								System.out.println("─────────────────────내용─────────────────────");
								System.out.println("─────────────────────────────────────────────");
								System.out.println(" " + table.get(i).get("contents"));
								System.out.println("─────────────────────────────────────────────");
								System.out.println("작성자 : " + table.get(i).get("name") + "\t작성일 : " + table.get(i).get("date"));
								System.out.println("─────────────────────────────────────────────");
								
								w : while (true) {
									if (switchCnt == 1) {
										System.out.println("─────────────────────────────────────────────");
										System.out.println("제목 : " + titleInput);
										System.out.println("─────────────────────내용─────────────────────");
										System.out.println("─────────────────────────────────────────────");
										System.out.println(" " + table.get(i).get("contents"));
										System.out.println("─────────────────────────────────────────────");
										System.out.println("작성자 : " + table.get(i).get("name") + "\t작성일 : " + table.get(i).get("date"));
										System.out.println("─────────────────────────────────────────────");
									} else if (switchCnt == 2) {
										System.out.println("─────────────────────────────────────────────");
										System.out.println("제목 : " + titleInput);
										System.out.println("─────────────────────내용─────────────────────");
										System.out.println("─────────────────────────────────────────────");
										System.out.println(" " + contentsInput);
										System.out.println("─────────────────────────────────────────────");
										System.out.println("작성자 : " + table.get(i).get("name") + "\t작성일 : " + table.get(i).get("date"));
										System.out.println("─────────────────────────────────────────────");
									} else if (switchCnt == 3) {
										System.out.println("─────────────────────────────────────────────");
										System.out.println("제목 : " + titleInput);
										System.out.println("─────────────────────내용─────────────────────");
										System.out.println("─────────────────────────────────────────────");
										System.out.println(" " + contentsInput);
										System.out.println("─────────────────────────────────────────────");
										System.out.println("작성자 : " + table.get(i).get("name") + "\t작성일 : " + table.get(i).get("date"));
										System.out.println("─────────────────────────────────────────────");
									}
									System.out.println("수정할 항목을 선택하세요.");
									System.out.println("1.제목\t2.내용\t3.저장\t4.종료");
									input = Integer.parseInt(sc.nextLine());
									switch (input) {
									case 1:	//제목부분 수정
										System.out.println("─────────────────────────────────────────────");
										System.out.print("제목 : ");
										titleInput = sc.nextLine();
										
										switchCnt++;
										break;
									case 2:	//내용부분 수정
										System.out.println("─────────────────────내용─────────────────────");
										System.out.println("─────────────────────────────────────────────");
										contentsInput = sc.nextLine();
										
										switchCnt++;
										break;
									case 3:	//수정내용 저장
										System.out.println("수정사항을 저장하시겠습니까?.");
										System.out.println("1.네\t2.아니오");
										input = Integer.parseInt(sc.nextLine());
										if (input == 1) {
											table.get(i).put("title", titleInput);
											table.get(i).put("contents", contentsInput);	
											break ug;
										} else if (input == 2) {
											break sw;
										}
										break;
									case 4:	//수정 취소
										System.out.println("게시글 수정을 취소합니다.");
										break w;
									}
								}
								break;
							case 2:	//삭제
								System.out.println("정말 삭제하시겠습니까?");
								System.out.println(" 1.네\t2.아니오");
								input = Integer.parseInt(sc.nextLine());
								switch (input) {
								case 1:
									table.remove(i);
									break;
								case 2:
									System.out.println("삭제를 취소하셨습니다.");
									break;
								}
								
								break;
							case 3: //뒤로가기
								break ug;
							}
							
						} 
						
					}
					
					if (!c) {
						System.out.println("해당 게시글이 존재하지 않습니다.");
					}
					
				} else 
					System.out.println("게시글이 아무것도 존재하지 않습니다.");
				
				break;
				
			case 2:	//등록, 해쉬맵 내용 작성
				map.put("pk", pkNum++);
				
				System.out.print("─────────────────────────────────────────────\n제목 : ");
				titleInput = sc.nextLine();
				System.out.println("─────────────────────내용─────────────────────");
				System.out.println("─────────────────────────────────────────────");
				contentsInput = sc.nextLine();
				System.out.println("─────────────────────────────────────────────");
				System.out.println("작성자 : " + myName);
				System.out.println("─────────────────────────────────────────────");
				
				map.put("contents", contentsInput);
				map.put("title", titleInput);
				map.put("name", myName);
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
				map.put("date", sdf.format(new Date()));
				
				table.add(map);
				break;
				
			case 3:	//종료
				System.out.println("종료합니다");
				System.exit(0);
				break;
			}
		}
	}
}
