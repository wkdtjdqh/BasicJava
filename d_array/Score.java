package d_array;

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
		
		int[][] scores = new int[25][10];
		String[] name = {"강지원", "김동민", "김동희", "김민지", "김용진", "김인혁", "김진용", "박범영", "박병규", "배현태", "심민규",
						 "여인욱", "이나정", "이승민", "이영섭", "이윤혜", "이지향", "임정혁", "장성보", "정선영", "정회립", "차경석",
						 "최준영", "허지영", "임형묵"};
		
		int[] sum_f = new int[7];
		double[] avg_f = new double[7];
		
		System.out.println("\t국어\t영어\t수학\t사회\t과학\tOracle\tJava\t합계\t평균\t석차");
		for (int i = 0; i < scores.length; i++) {
//			System.out.print(name[i] + "\t");
			scores[i][scores[i].length-1] = 1;
			for (int j = 0; j < scores[i].length-3; j++) {	//10
				scores[i][j] = (int)(Math.random()*101);
				scores[i][scores[i].length-3] += scores[i][j];	//합계
			}
			scores[i][scores[i].length-2] = (scores[i][scores[i].length-3]) / (scores[i].length-3);	//평균
		}
				
		//석차
		for (int i = 0; i < scores.length; i++) {	//25
			System.out.print(name[i] + "\t");
			for (int j = 0; j < scores[i].length; j++) {
				if (scores[i][scores[i].length-3] < scores[j][scores[j].length-3]) {	//석차계산
					scores[i][scores[i].length-1]++;
				}
				System.out.print(scores[i][j] + "\t");
			}
			System.out.println("");
		}
		
		//정렬
		for (int i = 0; i < scores.length; i++) {	//25
			int min = 1;
			for (int j = i+1; j < scores.length; j++) {
				if (scores[min][scores[i].length-1] > scores[j][scores[j].length-1]) {
					min = j;
				}
			}
			int temp = scores[i][scores[i].length-1];
			scores[i][scores[i].length-1] = scores[min][scores[i].length-1];
			scores[min][scores[i].length-1] = temp;
		}
		
		System.out.print("과목합계\t");
		for (int i = 0; i < scores.length; i++) {	//7
			for (int j = 0; j < sum_f.length; j++) {	//25
				sum_f[j] += scores[i][j];
			}
		}
		for (int i = 0; i < sum_f.length; i++) {
			System.out.print(sum_f[i] + "\t");
		} System.out.println("");
		
		System.out.print("과목평균\t");
		for (int i = 0; i < avg_f.length; i++) {
			avg_f[i] = (double)sum_f[i] / scores.length;
			System.out.print(avg_f[i] + "\t");
		}
	}

}
