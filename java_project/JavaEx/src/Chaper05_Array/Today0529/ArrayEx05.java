package Chaper05_Array.Today0529;

import java.util.*;

public class ArrayEx05 {
	public static void main(String[] args) {
		
		int[] score = new int[5];
		
		System.out.println("다음 과목의 점수를 입력해 주세요 >");
		System.out.print("국어 : ");
		Scanner scanner = new Scanner(System.in);		
		score[0] = scanner.nextInt();
		System.out.print("수학 : ");
		score[1] = scanner.nextInt();
		System.out.print("영어 : ");
		score[2] = scanner.nextInt();
		System.out.print("사회 : ");
		score[3] = scanner.nextInt();
		System.out.print("과학 : ");
		score[4] = scanner.nextInt();
		
		System.out.println("-------------------");
		System.out.println("국어 수학 영어 사회 과학");
		int sum=0;
		for(int i=0; i<score.length;i++) {
			System.out.print(score[i]+"  ");
			sum += score[i];
		}
		System.out.println();System.out.println("-------------------");
		System.out.println("총점 : "+sum);
		System.out.println("평균 : "+(float)sum/score.length);
		
		
		
	}
}
