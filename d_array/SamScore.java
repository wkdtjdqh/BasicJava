package d_array;

public class SamScore {

	public static void main(String[] args) {
		/*
		 * 우리반 모두의 국어, 영어, 수학, 사회, 과학, Oracle, Java 점수를
		 * 0 ~ 100까지 랜덤으로 생성해주시고, 아래와 같이 출력해주세요.
		 * 
		 * 			국어		영어		수학		사회		과학		Oracle	Java	합계		평균		석차
		 * 홍길동		90		90		90		90		90		90		90		630		90.00	1
		 * 홍길동		90		90		90		90		90		90		90		630		90.00	1
		 * 홍길동		90		90		90		90		90		90		90		630		90.00	1
		 * 홍길동		90		90		90		90		90		90		90		630		90.00	1
		 * 홍길동		90		90		90		90		90		90		90		630		90.00	1
		 * 과목합계	450		450		450		450		450		450		450
		 * 과목평균	90.00	90.00	90.00	90.00	90.00	90.00	90.00
		 */
		
		String[] names = {"허지영", "김민지", "김동민", "배현태", "여인욱", "김동희", "김인혁", "이영섭", "정선영", "이지향", "김용진"};
		String[] subjects = {"국어", "영어", "수학", "사회", "과학", "Oracle", "Java"};
		int[][] scores = new int[names.length][subjects.length];
		
		for(int i = 0; i < scores.length; i++){	//난수 점수 발생
			for(int j = 0; j < scores[i].length; j++){
				scores[i][j] = (int)(Math.random() * 101);
			}
		}
		
		int[] sum = new int[scores.length];	//합계
		float[] avg = new float[scores.length];	//평균
		for(int i = 0; i < scores.length; i++){
			for(int j = 0; j < scores[i].length; j++){
				sum[i] += scores[i][j];
			}
			avg[i] = Math.round((float)sum[i] / subjects.length * 100) / 100f;
		}
		
		int[] sum2 = new int[subjects.length];
		float[] avg2 = new float[subjects.length];
		for(int i = 0; i < subjects.length; i++){
			for(int j = 0; j < scores.length; j++){ 
				sum2[i] += scores[j][i];
			}
			avg2[i] = Math.round((float)sum2[i] / scores.length * 100) / 100f;
		}
		
		int[] rank = new int[scores.length];
		for(int i = 0; i < scores.length; i++){
			rank[i] = 1;
			for(int j = 0; j < scores.length; j++){
				if(sum[i] < sum[j]){
					rank[i]++;
				}
			}
		}
		
		for(int i = 0; i < sum.length - 1; i++){
			int min = i;
			for(int j = i + 1; j < sum.length; j++){
				if(sum[j] > sum[min]){
					min = j;
				}
			}
			int[] temp = scores[i];
			scores[i] = scores[min];
			scores[min] = temp;
			
			int temp2 = sum[i];
			sum[i] = sum[min];
			sum[min] = temp2;
			
			float temp3 = avg[i];
			avg[i] = avg[min];
			avg[min] = temp3;
			
			int temp4 = rank[i];
			rank[i] = rank[min];
			rank[min] = temp4;
			
			String temp5 = names[i];
			names[i] = names[min];
			names[min] = temp5;
		}
		
		for(int i = 0; i < subjects.length; i++){
			System.out.print("\t" + subjects[i]);
		}
		System.out.println("\t합계\t평균\t석차");
		for(int i = 0; i < scores.length; i++){
			System.out.print(names[i] + "\t");
			for(int j = 0; j < scores[i].length; j++){
				System.out.print(scores[i][j] + "\t");
			}
			System.out.println(sum[i] + "\t" + avg[i] + "\t" + rank[i]);
		}
		
		System.out.print("과목합계\t");
		for(int i = 0; i < sum2.length; i++){
			System.out.print(sum2[i] + "\t");
		}
		System.out.println();
		
		System.out.print("과목평균\t");
		for(int i = 0; i < avg2.length; i++){
			System.out.print(avg2[i] + "\t");
		}
	}

}









