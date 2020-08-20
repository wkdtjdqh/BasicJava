package d_array;

import java.util.Arrays;
import java.util.Scanner;

public class Array {

	public static void main(String[] args) {
		/*
		 * 배열
		 * - 여러개의 값을 하나의 변수에 저장해서 사용하는 것이다.
		 * - 참조형 타입이다.
		 * - 인덱스로 값을 구분한다.
		 * - 길이를 변경할 수 없다.
		 */
		
		int[] array;	//배열의 주소를 저장할 공간이 만들어진다. | 배열을 저장할 변수를 만듬
		array = new int[5];	//5 → 배열의 길이 | 배열이 생성되고 그 주소가 저장된다.
		//배열 초기화시 기본값이 저장된다. 정수, 실수 = 0, boolean = false, 참조형 = null, 문자열 = 0 : 공백
		
		array = new int[]{1, 2, 3, 4, 5};
		//array = {1, 2, 3, 4, 5};	
		//선언과 초기화를 동시에 해야한다. 따로하게 되면 컴파일 에러가 발생한다.
		int[] arr = {1, 2, 3, 4, 5};
		System.out.println(arr[0]);	//인덱스는 0부터 시작한다. 0은 배열의 첫번째 값을 나타냄
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		System.out.println(arr[4]);
		
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		arr[3] = 40;
		arr[4] = 50;
		
		int sum = 0;
		for (int i = 0; i < arr.length; i++) { // 배열의 길이를 저장하는 변수
			sum += arr[i];
		}
		System.out.println("sum : " + sum);

		// 10개의 정수를 저장할 수 있는 배열을 선언 및 초기화해주세요.
		int[] ar;
		ar = new int[10];

		// 배열의 모든 인덱스에 1~100사이의 랜덤한 값을 저장해주세요.
		for (int i = 0; i < ar.length; i++) {
			ar[i] = (int) (Math.random() * 100) + 1;
		}
		System.out.println(Arrays.toString(ar));	//배열 안에있는 값을 출력해준다.

		// 배열에 저장된 모든 값의 합계와 평균을 구해주세요.
		sum = 0;
		for (int i = 0; i < ar.length; i++) {
			sum += ar[i];
		}
		double avg = (double) sum / ar.length;
		System.out.println("sum : " + sum + ", avg : " + avg);
		
		//배열에 저장된 값들 중 최소값과 최대값을 출력해주세요.
		int min = ar[0], max = ar[0];
		for (int i = 0; i < ar.length; i++) {
			if (max <= ar[i]) {
				max = ar[i];
			}
			if (ar[i] <= min) {
				min = ar[i];
			}
		}
		System.out.println("min : " + min + ", max : " + max);
		
		//배열에 저장된 값 섞기
		int[] shuffle = new int[10];
		for (int i = 0; i < shuffle.length; i++) {
			shuffle[i] = i + 1;
		}
		System.out.println(Arrays.toString(shuffle));
		int temp = 0;
		for (int i = 0; i < shuffle.length; i++) {
			int rand_idx = (int)(Math.random()*shuffle.length);
			temp = shuffle[i];
			shuffle[i] = shuffle[rand_idx];
			shuffle[rand_idx] = temp;
		}
		System.out.println(Arrays.toString(shuffle));
		
		//1~10사이의 랜덤값을 500번 생성하고, 각 숫자가 생성된 횟수를 출력해주세요.
		int[] randA = new int[500];
		for (int i = 0; i < randA.length; i++) {
			randA[i] = (int)(Math.random()*10)+1;
		}
		int[] e = new int[10];
		for (int i = 0; i < e.length; i++) {
			e[i] = i + 1;
		}
		System.out.println(Arrays.toString(randA));
		sum = 0;
		for (int i = 0; i < e.length; i++) {
			int cnt = 0;
			for (int j = 0; j < randA.length; j++) {
				if (e[i] == randA[j]) {
					cnt++;
				}
			}
			System.out.println(i + ") 생성된 횟수 : " + cnt);
			sum+=cnt;
		}
		System.out.println("횟수들의 합 : " + sum);
		
		/*
		int[] count = new int [10];
		for (int i = 0; i < 500; i++) {
			int random = (int)(Math.random()*10)+1;
			count[random - 1]++;
		}
		for (int i = 0; i < counts.length; i++) {
			System.out.println(i + 1  + " : " + count);
		}
		*/
		
		//위 문제를 최소값, 최대값, 반복횟수를 입력받아 각 숫자가 생성된 횟수를 출력해주세요.
		Scanner sc = new Scanner(System.in);
		System.out.println("최소값을 입력해주세요.");
		int min_n = Integer.parseInt(sc.nextLine());
		System.out.println("최대값을 입력해주세요.");
		int max_n = Integer.parseInt(sc.nextLine());
		System.out.println("반복횟수를 입력하세요.");
		int n = Integer.parseInt(sc.nextLine());
		
		int[] arr_n = new int[n];		//최소값, 최대값, 반복횟수를 이용한 배열생성 
		for (int i = 0; i < arr_n.length; i++) {	
			arr_n[i] = (int)(Math.random()*(max_n - min_n + 1)) + min_n;
		}
		System.out.println("랜덤배열 : " + Arrays.toString(arr_n));
		
		int[] e2 = new int[max_n - min_n +1];	//비교를 위한 최소값, 최대값 기반의  배열생성
		for (int i = 0; i < e2.length; i++) {
			e2[i] = min_n;
			min_n++;
		}
		System.out.println("비교배열 : " + Arrays.toString(e2));
		
		sum = 0;
		for (int i = 0; i < e2.length; i++) {	//랜덤배열과 비교배열을 비교하여 숫자 카운트
			int cnt = 0;
			for (int j = 0; j < arr_n.length; j++) {
				if (e2[i] == arr_n[j]) {
					cnt++;
				}
			}
			System.out.println(i + ") 생성된 횟수 : " + cnt);
			sum+=cnt;
		}
		System.out.println("횟수의 합 : " + sum);
	}
}
