package j_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Date;
import java.util.Scanner;

/*
 * 오라클 데이터베이스에 게시판 테이블을 생성하고, 게시판 프로그램을 만들어주세요.
 * 테이블 : JDBC_BOARD
 * 컬럼 : BOARD_NO, TITLE, CONTENT, USER_ID, REG_DATE
 */

public class Board {
	static int input;
	static int pkNum;
	
	static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	static String user = "PC11";
	static String pass = "java";
	
//	static String url = "jdbc:oracle:thin:@localhost:1521:orcl";
//	static String user = "system";
//	static String pass = "java";

	static String titleInput;
	static String contentInput;
	static String userId;
	static int columnCount;

	static Connection con;
	static PreparedStatement ps;
	static ResultSet rs;
	static ResultSetMetaData md;
	static String sql;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String getTitle = null, getContent = null;

		while (true) {// 게시글 화면

			try {
				con = DriverManager.getConnection(url, user, pass);
				sql = "select * from jdbc_board";
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				md = rs.getMetaData();
				columnCount = md.getColumnCount();

				System.out.println("──────────────────────────────────────────────────────────");
				System.out.println("번호\t\t제목\t\t작성자\t\t작성일");
				System.out.println("──────────────────────────────────────────────────────────");
				while (rs.next()) {
					for (int i = 1; i <= columnCount; i++) {
						if (pkNum < rs.getInt(md.getColumnName(1))) {
							pkNum = rs.getInt(md.getColumnName(1));
						}
						Object obj = rs.getObject(md.getColumnName(i));
						if (i == 3) {
							continue ;
						}
						System.out.print(obj + "\t\t");
					}
					System.out.println();
				}

				System.out.println("pkn : " + pkNum);
				
				System.out.println("──────────────────────────────────────────────────────────");
			} catch (SQLException e) {
				e.printStackTrace();
			} 

			System.out.println("1.조회\t2.등록\t3.종료");
			input = Integer.parseInt(sc.nextLine());
			
			boolean ck = false;	//게시글의 존재여부 확인
			
			f: switch (input) {
			
			case 1: // 조회
				
				System.out.print("조회하실 게시글 번호를 입력해주세요 : ");
				int checkPk = Integer.parseInt(sc.nextLine());
				
				sql = "select board_no"
						+ " from jdbc_board";
				try {
					ps = con.prepareStatement(sql);
					
					rs = ps.executeQuery();
					md = rs.getMetaData();
					columnCount = md.getColumnCount();
					
					if (rs.next() == false) {
						System.out.println("────────────────");
						System.out.println("게시판에 글이 없습니다.");
						System.out.println("────────────────");
						break f;
					}
					
					System.out.println(rs.next());
					
					select : while (true) {
						
						for (int i = 1; i <= columnCount; i++) {
							sql = "select *"
									+ " from jdbc_board"
									+ " where board_no = ?";
							ps = con.prepareStatement(sql);

							ps.setInt(1, checkPk);
							
							rs = ps.executeQuery();
							md = rs.getMetaData();
							columnCount = md.getColumnCount();
							
							
							while(rs.next()) {
								if (checkPk == rs.getInt(md.getColumnName(1))) {
									ck = true;
									System.out.println("─────────────────────────────────────────────");
									System.out.println("제목 : " + rs.getObject(md.getColumnName(2)));
									System.out.println("─────────────────────내용─────────────────────");
									System.out.println("─────────────────────────────────────────────\n");
									System.out.println(rs.getObject(md.getColumnName(3)));
									System.out.println("\n─────────────────────────────────────────────");
									System.out.println("─────────────────────────────────────────────");
									System.out.println("작성자 : " + rs.getObject(md.getColumnName(4)) + "\t작성일 : "
											+ rs.getObject(md.getColumnName(5)));
									System.out.println("─────────────────────────────────────────────");
									
									titleInput = rs.getString(md.getColumnName(2));
									contentInput = rs.getString(md.getColumnName(3));
									break select;
								} 
							}
							if (ck == false) {
								System.out.println("───────────────");
								System.out.println("\n해당 게시글이 없습니다\n");
								System.out.println("───────────────");
								break f;
							}
							break;
						}
					}
					
					System.out.println("1.수정\t2.삭제\t3.뒤로가기");
					input = Integer.parseInt(sc.nextLine());
					
					ip: switch (input) {
					case 1:

						w : while(true) {
							System.out.println("수정할 항목을 선택해주세요.\n1.제목\t2.내용\t3.적용\t4.뒤로가기");
							int n = Integer.parseInt(sc.nextLine());

							if (n == 1) {
								System.out.println("제목을 입력해주세요.");
								getTitle = sc.nextLine();

							} else if (n == 2) {
								System.out.println("내용을 입력해주세요.");
								getContent = sc.nextLine();

							} else if (n == 3) {
								sql = "update jdbc_board set title = ?, content = ? where board_no = ?";
								ps = con.prepareStatement(sql);

								if (getTitle == null) {
									getTitle = titleInput;
								}
								if (getContent == null) {
									getContent = contentInput;
								}
								
								ps.setString(1, getTitle);
								ps.setString(2, getContent);
								ps.setInt(3, checkPk);
								ps.executeUpdate();
								
								break w;
							} else if (n == 4) {
								break w;
							}
						}

						break;
						
					case 2:
						sql = "delete jdbc_board where board_no = ?";
						ps = con.prepareStatement(sql);
						
						ps.setInt(1, checkPk);
						
						ps.executeUpdate();
						break;
						
					case 3:
						break ip;
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				break;
				
			case 2: // 등록
				System.out.println("─────────────────────────────────────────────");
				System.out.print("제목 : ");
				titleInput = sc.nextLine();
				System.out.println("─────────────────────내용─────────────────────");
				System.out.println("─────────────────────────────────────────────");
				contentInput = sc.nextLine();
				System.out.println("─────────────────────────────────────────────");
				System.out.println("작성자 : ");
				userId = sc.nextLine();
				System.out.println("─────────────────────────────────────────────");
				System.out.println("─────────────────────────────────────────────");
				System.out.println("1.등록\t2.취소");
				input = Integer.parseInt(sc.nextLine());
				
				
				if (input == 1) { // 등록
					try {
						pkNum++;
						sql = "insert into jdbc_board" + " values(?, ?, ?, ?, ?)";

						ps = con.prepareStatement(sql);
						ps.setObject(1, pkNum);
						ps.setString(2, titleInput);
						ps.setString(3, contentInput);
						ps.setString(4, userId);
						ps.setDate(5, new Date(new java.util.Date().getTime()));

						int result = ps.executeUpdate();
						System.out.println(result);
						
					} catch (SQLException e) {
						e.printStackTrace();
					} finally {
						if (rs != null) try { rs.close(); }  catch (Exception e) {}
						if (ps != null) try { ps.close(); }  catch (Exception e) {}
						if (con != null) try { con.close(); }  catch (Exception e) {}
					}
					
				}
				if (input == 2) { // 취소
					break f;
				}

				break;
				
			case 3: // 종료
				sc.close();
				if (rs != null) try { rs.close(); }  catch (Exception e) {}
				if (ps != null) try { ps.close(); }  catch (Exception e) {}
				if (con != null) try { con.close(); }  catch (Exception e) {}
				System.exit(0);
				break;
			}
			
		} // 게시글while종료
	}
}