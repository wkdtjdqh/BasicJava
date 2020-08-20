package e_oop.score;

import java.util.Arrays;

public class Score {
	
	public static void main(String[] args) {
		Student[] students = new Student[10];	// null이 기본값, null이 10개 들어있음
		
		for (int i = 0; i < students.length; i++) {
			Student student = new Student();	// 기본값이 생성됨
			
			student.name = "학생" + (i+  1);	// 초기화
			student.rank = 1;
			student.kor = (int)(Math.random()*101);
			student.eng = (int)(Math.random()*101);
			student.math = (int)(Math.random()*101);
			student.sum = student.kor + student.eng + student.math;
			student.avg = Math.round((double)student.sum / 3 * 100) / 100.0;
			
			students[i] = student;
		}
		
		//석차
		for (int i = 0; i < students.length; i++) {
			for (int j = 0; j < students.length; j++) {
				if (students[i].avg < students[j].avg) {
					students[i].rank++;
				}
			}
		}
		
		//선택정렬(이상하게 됨)
//		for (int i = 0; i < students.length; i++) {
//			int min = i;
//			for (int j = i+1; j < students.length; j++) {
//				if (students[min].rank > students[j].rank) {
//					
//					min = j;
//				}
//				Student temp = students[i];
//				students[i] = students[min];
//				students[min] = temp;
//			}
//		}
		
		//버블정렬
		for (int i = 0; i < students.length; i++) {
			boolean changed = false;
			for (int j = 0; j < students.length - i -1; j++) {
				if (students[j].avg < students[j+1].avg) {
					Student temp = students[j];
					students[j] = students[j+1];
					students[j+1] = temp;
					changed = true;
				}
			}
			if (!changed) {
				break;
			}
		}
		
		//출력
		System.out.println("\tkor\teng\tmath\t합계\t평균\t석차");
		for (int i = 0; i < students.length; i++) {
			System.out.println(students[i].name + "\t" + students[i].kor + "\t" + students[i].eng + "\t" 
					+ students[i].math + "\t" + students[i].sum + "\t" + students[i].avg + "\t" + students[i].rank);
		}
	}
}
