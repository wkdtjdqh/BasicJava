package d_array;

import java.util.Arrays;

public class Sort {

	public static void main(String[] args) {
		/*
		 * 정렬
		 * - 석차구하기 : 점수를 비교해 작은 점수의 등수를 증가시키는 방식
		 * - 선택정렬 : 가장 작은 숫자를 찾아서 앞으로 보내는 방식
		 * - 버블정렬 : 바로 뒤의 숫자와 비교해서 큰 수를 뒤로 보내는 방식
		 * - 삽입정렬 : 두번째 숫자부터 앞의 숫자들과 비교해서 큰 수는 뒤로 밀고 중간에 삽입하는 방식
		 */
		
//		int[] arr = {76, 30, 20, 60, 43, 24, 56, 31, 78, 99};
		int[] arr = new int[10];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*100) + 1;
		}
		System.out.println(Arrays.toString(arr) + "\n");
		
//		printRank(arr);		// 석차구하기
//		selectSort(arr);	// 선택정렬 : 왼쪽에서 오름차순으로 정렬
//		bubbleSort(arr);	// 버블정렬
		insertSort(arr);	// 삽입정렬
		System.out.println(Arrays.toString(arr));
	}
	
	private static void insertSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j = 0;
			for (j = i-1; j >= 0; j--) {
				if (temp < arr[j]) {
					arr[j+1] = arr[j];
				} else break;
				System.out.println(Arrays.toString(arr));
			}
			arr[j+1] = temp;
		}
	}

	private static void bubbleSort(int[] arr) {	// 자리가 바뀌지않으면 정렬이 종료, 반복문을 종료??
		for (int i = 0; i < arr.length; i++) {
			boolean changed = false;
			for (int j = 0; j < arr.length - i -1; j++) {
				if (arr[j] > arr[j+1]) {
					int val = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = val;
					changed = true;
					System.out.println(Arrays.toString(arr));
				}
			}
			if (!changed) {
				break;
			}
		}
	}

	private static void selectSort(int[] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			int min = 1;
			for (int j = i+1; j < arr.length; j++) {
				if (arr[min] > arr[j]) {
					min = j;	// j만큼 반복해서 최솟값을 min에 저장
				}
			}
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
	}

	private static void printRank(int[] arr) {
		// 비교 전 모두 1등, 비교하는 순간 등수가 변함, 나머지 전부와 비교해서 더 큰 수를 만나면 등수를 증가시켜라, 같은 등수는 같은 점수
		// 등수 배열
		int[] rank = new int[10];
		for (int i = 0; i < rank.length; i++) {
			rank[i] = 1;
		}
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					rank[i]++;
				}
			}
		}
		System.out.println(Arrays.toString(rank));
		
//		for (int i = 0; i < arr.length; i++) {
//			int[] test = new int[10];
//			test[i] = arr[j];
//			
//		}
	}

}
