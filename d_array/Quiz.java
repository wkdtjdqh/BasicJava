package d_array;

import java.util.Arrays;

public class Quiz {

	public static void main(String[] args) {
//		quiz1();	//거스름돈 동전 갯수
//		quiz2();	//그래프 그리기
//		quiz3();	//같은 숫자는 싫어
		quiz4();	//나누어 떨어지는 숫자 배열
	}

	private static void quiz4() {
		int[] arr = new int[100];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*100) + 1;
		}
		/*
		 * 2~5사이의 랜덤한 수로 나누어 떨어지는 숫자로만 이루어진 배열을 정렬하여 출력해주세요.
		 * 5
		 * [5, 10, 15, 20, 25]
		 */
		int rand = (int)(Math.random()*4) + 2;	// 2~5의 난수발생
		int[] dum = new int[100];	// 나누어 떨어지는 수를 넣기위한 배열 생성
		System.out.println(Arrays.toString(arr));
		System.out.println("난수 : " + rand);
		int arr_size = 0;	// 배열의 크기를 정해줄 변수
		int cnt = 0;	// 배열의 인덱스 카운터
		// 나누어 떨어지는 수를 배열에 삽입
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % rand == 0) {
				arr_size++;
				dum[cnt++] = arr[i];
			}
		}
		System.out.println(Arrays.toString(dum));
		System.out.println("생성할 배열의 크기 : " + arr_size);
		int[] arr_res = new int[arr_size];	// 위에서 구한 크기를 바탕으로 새로운 배열 생성
		
		cnt = 0;
		// 새로운 배열에 0을 제외한 수 삽입
		for (int i = 0; i < dum.length; i++) {
			if (dum[i] > 0) {
				arr_res[cnt++] = dum[i];
			}
		} System.out.println(Arrays.toString(arr_res));
		
		// 오름차순 정렬
		for (int i = 0; i < arr_res.length; i++) {
			for (int j = 0; j < arr_res.length; j++) {
				if (arr_res[i] < arr_res[j]) {
					int temp = arr_res[i];
					arr_res[i] = arr_res[j];
					arr_res[j] = temp;
				}
			}
		} System.out.println(Arrays.toString(arr_res));
	}

	private static void quiz3() {
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*5) + 1;
		}
		System.out.println(Arrays.toString(arr));
		/*
		 * 1~5사이의 랜덤값이 10개 저장된 배열에서 중복된 값이 제거된 배열을 만들어주세요.
		 * [1, 3, 3, 2, 1, 4, 5, 5, 1, 3]
		 * [1, 3, 2, 4, 5]
		 */
		// 새로운 배열 크기는 어떻게?
		// 비교해서 같은 수가 없을 때 새로운 배열에 추가
		// 같은 수가 있을 때? 숫자를 새로운 변수에 넣어서 배열로 추가?

		// 배열 사이즈 측정 및 중복된 값 0처리
		int size = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					arr[j] = 0;
				} 
			}
			if (arr[i] > 0) {
				size++;
			}
		}
		System.out.println("Array size : " + size + ", " + Arrays.toString(arr));
		// 새로운 배열 생성 및 중복되지 않은 값 삽입
		int[] arr_del = new int[size];
		int num = 0;
		for (int i = 0; i < arr.length; i++) {
				if (arr[i] > 0) {
					arr_del[num++] = arr[i];
				}
		}
		System.out.println(Arrays.toString(arr_del));
	}

	private static void quiz2() {
		int[] arr = new int[20];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*5) + 1;
		}
		System.out.println(Arrays.toString(arr));
		/*
		 * 발생된 각 숫자의 갯수만큼 *을 사용해 그래프를 그려주세요.
		 * 1 : *** 3
		 * 2 : **** 4
		 * 3 : ** 2
		 * 4 : ***** 5
		 * 5 : * 1
		 */
		int[] b = {1, 2, 3, 4, 5};
		
		for (int i = 0; i < b.length; i++) {
			String star = "";
			int star_cnt = 0;
			for (int j = 0; j < arr.length; j++) {
				if (b[i] == arr[j]) {
					star += "*";
					star_cnt++;
				}
			}
			System.out.println(b[i] + " : " + star + " " + star_cnt);
		}
		
		/* sam code
		int[] cnt = new int[5];
		for (int i = 0; i < arr.length; i++) {
			cnt[arr[i] - 1]++;
		}
		for (int i = 0; i < cnt.length; i++) {
			System.out.println(i + 1 + " : ");
			for (int j = 0; j < cnt[i]; j++) {
				System.out.println("*");
			}
			System.out.println(" " + cnt[i]);
		}
		*/
	}

	private static void quiz1() {
		int money = (int)(Math.random()*500) * 10;
		int[] coin = { 500, 100, 50, 10 };
		
		System.out.println("거스름돈 : " + money + "원");
		
		/*
		 * 거스름돈에 동전의 단위마다 몇개의 동전이 필요한지 출력해주세요.
		 * 거스름돈 : 2860원
		 * 500원 : 5개, 100원 : 3개, 50원 : 1개, 10원 : 1개
		 */
		
		for (int i = 0; i < coin.length; i++) {
			int cnt = money / coin[i];	// 동전의 개수
			System.out.println(coin[i] + "원 : " + cnt + "개");
			money %= coin[i];	// 앞의 돈을 계산하고 남은 돈으로 초기화
		}
	}

}
