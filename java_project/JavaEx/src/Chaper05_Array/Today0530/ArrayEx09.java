package Chaper05_Array.Today0530;

import java.util.Arrays;

public class ArrayEx09 {
	public static void main(String[] args) {
		int[] arr = {-4, -1, 3, 6, 11};
		int[] arr2 = new int[10];
		
//		int n = (int)(Math.random()*5);
		
		for(int i = 0; i<arr2.length;i++) {
			int n = (int)(Math.random()*arr.length);
			arr2[i]=arr[n];
		}
		System.out.println();
		System.out.println(Arrays.toString(arr2));
		
	}
}
