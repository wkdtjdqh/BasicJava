package d_array;

public class NewScore {

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
		
		String[] name = {"강지원", "김동민", "김동희", "김민지", "김용진"};
		String[] subj = {"국어", "영어", "수학", "사회", "과학", "Oracle", "Java"};
		int[][] scores = new int[name.length][subj.length];
		
		//점수
		for (int i = 0; i < scores.length; i++) {
			for (int j = 0; j < scores[i].length; j++) {
				scores[i][j] = (int)(Math.random()*101);
			}
		}
		
		//합계, 평균
		int[] sum = new int[name.length];
		float[] avg = new float[name.length];
		for (int i = 0; i < scores.length; i++) {
			for (int j = 0; j < scores[i].length; j++) {
				sum[i] += scores[i][j];
				avg[i] = Math.round((float)sum[i] / subj.length * 100) / 100.0f;
			}
		}
		int[] sum2 = new int[subj.length];
		float[] avg2 = new float[subj.length];
		for (int i = 0; i < subj.length; i++) {
			for (int j = 0; j < name.length; j++) {
				sum2[i] += scores[j][i];
				avg2[i] = Math.round((float)sum2[i] / name.length * 100) / 100.0f;
			}
		}
		
		//석차
		int[] rank = new int[name.length];
		for (int i = 0; i < rank.length; i++) {
			rank[i] = 1;
		}
		for (int i = 0; i < rank.length; i++) {
			for (int j = 0; j < rank.length; j++) {
				if (avg[i] < avg[j]) {
					rank[i]++;
				}
			}
		}
		
		//정렬
		for (int i = 0; i < name.length; i++) {
			int min = i;
			for (int j = i + 1; j < name.length; j++) {
				if (avg[min] < avg[j]) {
					min = j;
				}
			}
			int[] temp1 = scores[i];
			scores[i] = scores[min];
			scores[min] = temp1;

			int temp2 = sum[i];
			sum[i] = sum[min];
			sum[min] = temp2;

			float temp3 = avg[i];
			avg[i] = avg[min];
			avg[min] = temp3;

			int temp4 = rank[i];
			rank[i] = rank[min];
			rank[min] = temp4;
			
			String temp5 = name[i];
			name[i] = name[min];
			name[min] = temp5;
		}
		
		
		//출력
		for (int i = 0; i < subj.length; i++) {
			System.out.print("\t" + subj[i]);
		} System.out.println("\t합계\t평균\t석차");
		for (int i = 0; i < scores.length; i++) {
			System.out.print(name[i]);
			for (int j = 0; j < scores[i].length; j++) {
				System.out.print("\t" + scores[i][j]);
			}
			System.out.println("\t" + sum[i] + "\t" + avg[i] + "\t" + rank[i]);
		}
		System.out.print("과목합계\t");
		for (int i = 0; i < sum2.length; i++) {
			System.out.print(sum2[i] + "\t");
		}
		System.out.print("\n과목평균\t");
		for (int i = 0; i < avg2.length; i++) {
			System.out.print(avg2[i] + "\t");
		}
	}

}
