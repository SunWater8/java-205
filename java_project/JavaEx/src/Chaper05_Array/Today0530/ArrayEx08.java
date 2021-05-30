package Chaper05_Array.Today0530;

import java.util.Arrays;

public class ArrayEx08 {
	public static void main(String[] args) {

		System.out.println("****1~45 숫자를 모두 섞은 다음 5개 바열만 순서대로 출력하기");
		int[] num = new int[45];
		for(int i =0; i<num.length;i++) {
			num[i] = i+1;
		}
		System.out.println(Arrays.toString(num));
		for(int i=0; i<num.length;i++) {
			int n = (int)(Math.random()*100);
			if(n<45) {
				int temp = num[0];
				num[0]=num[n];
				num[n]=temp;
			}
		}
		System.out.println(Arrays.toString(num));
		
		for(int i=0;i<5;i++) {
			System.out.print(num[i]+", ");
		}
		
		
		System.out.println(); System.out.println();
		System.out.println("****앞의 배열만 섞어서 그것만 출력하기");
		int[] arr = new int[45];
		for(int i = 0;i<arr.length;i++) {
			arr[i]=i+1;
		}
		System.out.println(Arrays.toString(arr));
		
		int m = 0;
		int tmp = 0;
		for(int i=0; i<5;i++) {
			m=(int)(Math.random()*45);
			tmp =arr[0];
			arr[0]=arr[m];
			arr[m]=tmp;
		}
		System.out.println(Arrays.toString(arr));
		for(int i=0;i<5;i++) {
			System.out.println(arr[i]+", ");
		}
		
		
	}
	
}
