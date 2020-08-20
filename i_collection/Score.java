package i_collection;

import java.util.ArrayList;

public class Score {
	
	public static void main(String[] args) {
		/*
		 * 우리반 모두의 국어, 영어, 수학, 사회, 과학, Oracle, Java 점수를 0~100까지
		 * 랜덤으로 생성하고, 아래와 같이 출력해주세요.
		 * 
		 * 			국어		영어		수학		사회		과학		Oracle	Java	합계		 평균		석차
		 * 홍길동		90		90		90		90		90		90		90		630		90.0 	1	
		 * 홍길동		90		90		90		90		90		90		90		630		90.0 	1	
		 * 홍길동		90		90		90		90		90		90		90		630		90.0 	1	
		 * 홍길동		90		90		90		90		90		90		90		630		90.0 	1
		 * 홍길동		90		90		90		90		90		90		90		630		90.0 	1	
		 * 과목합계	450		450		450		450		450		450		450
		 * 과목평균	90.00	90.00	90.00	90.00	90.00	90.00	90.00
		 * 
		 */
		
		ArrayList<String> stdNames = new ArrayList<>();
		stdNames.add("장성보");
		stdNames.add("김진용");
		stdNames.add("강지원");
		stdNames.add("이윤혜");
		stdNames.add("박병구");
		
		//과목별 점수 난수로 생성
		ArrayList<Integer> score1 = new ArrayList<>();
		for (int i = 0; i < stdNames.size(); i++) { score1.add((int)(Math.random()*101)); }
		
		ArrayList<Integer> score2 = new ArrayList<>();
		for (int i = 0; i < stdNames.size(); i++) { score2.add((int)(Math.random()*101)); }
		
		ArrayList<Integer> score3 = new ArrayList<>();
		for (int i = 0; i < stdNames.size(); i++) { score3.add((int)(Math.random()*101)); }
		
		ArrayList<Integer> score4 = new ArrayList<>();
		for (int i = 0; i < stdNames.size(); i++) { score4.add((int)(Math.random()*101)); }
		
		ArrayList<Integer> score5 = new ArrayList<>();
		for (int i = 0; i < stdNames.size(); i++) { score5.add((int)(Math.random()*101)); }
		
		ArrayList<Integer> score6 = new ArrayList<>();
		for (int i = 0; i < stdNames.size(); i++) { score6.add((int)(Math.random()*101)); }
		
		ArrayList<Integer> score7 = new ArrayList<>();
		for (int i = 0; i < stdNames.size(); i++) { score7.add((int)(Math.random()*101)); }
		
		//전체 학생 점수
		ArrayList<ArrayList<Integer>> stdScores = new ArrayList<>();
		stdScores.add(score1);
		stdScores.add(score2);
		stdScores.add(score3);
		stdScores.add(score4);
		stdScores.add(score5);
		stdScores.add(score6);
		stdScores.add(score7);
		
		//학생별 점수, 평균 계산
		ArrayList<Integer> stdSum = new ArrayList<>();
		ArrayList<Double> stdAvg = new ArrayList<>();
		int sum = 0; 
		for (int i = 0; i < stdNames.size(); i++) {	//학생 수 만큼
			for (int j = 0; j < stdScores.size(); j++) {	//과목 수 만큼
				sum += stdScores.get(j).get(i);
			}
			stdSum.add(sum);
			stdAvg.add(Math.round((double)sum / stdScores.size() * 100) / 100.00);
			sum = 0;
		}
		stdScores.add(stdSum);
		
		//과목별 점수, 평균 계산
		ArrayList<Integer> subjSum = new ArrayList<>();
		ArrayList<Double> subjAvg = new ArrayList<>();
		sum = 0;
		for (int i = 0; i < stdScores.size(); i++) {
			for (int j = 0; j < stdNames.size(); j++) {
				sum += stdScores.get(i).get(j);
			}
			subjSum.add(sum);
			subjAvg.add(Math.round((double)sum / stdNames.size() * 100) / 100.00);
			sum = 0;
		}
		
		//석차
		ArrayList<Integer> rank = new ArrayList<>();
		int ranki = 1;
		for (int i = 0; i < stdNames.size(); i++) {	//학생 수만큼 순위 생성
			rank.add(ranki++);
		}
		System.out.println(rank);
		
		//성적 출력
		System.out.println("\t국어\t영어\t수학\t사회\t과학\tOracle\tJava\t합계\t평균");
		for (int i = 0; i < stdNames.size(); i++) {
			System.out.print(stdNames.get(i) + "\t");
			for (int j = 0; j < stdScores.size(); j++) {
				System.out.print(stdScores.get(j).get(i) + "\t");	//학생 점수
			}
//			System.out.print(stdSum.get(i) + "\t" + stdAvg.get(i));	//학생 합계, 평균
			System.out.print(stdAvg.get(i));
			System.out.println();
		}
		
		//과목합계, 평균
		System.out.print("과목합계\t");
		for (int i = 0; i < stdScores.size()-1; i++) {	//학생별 합계를 제외
			System.out.print(subjSum.get(i) + "\t");
		} System.out.println();
		
		System.out.print("과목평균\t");
		for (int i = 0; i < stdScores.size()-1; i++) {
			System.out.print(subjAvg.get(i) + "\t");
		} System.out.println();
		
	}
}
