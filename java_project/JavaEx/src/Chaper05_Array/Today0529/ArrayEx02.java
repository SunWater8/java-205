package Chaper05_Array.Today0529;

import java.util.Arrays;

public class ArrayEx02 {
	public static void main(String[] args) {
		int[] arr1 = new int[10];
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = i + 1;
			System.out.print(arr1[i] + ", ");
		}

		System.out.println();
		int[] arr2 = new int[10];
		for (int i = 0; i < arr2.length; i++) {
			arr2[i]=(int)(Math.random()*10);
			System.out.print(arr2[i] + ", ");
		}
		System.out.println();
		System.out.println(Arrays.toString(arr2));
		System.out.println(arr2);
		
		System.out.println();
		int[] arr3 = {100,95,80,70,60};
		for(int i=0; i<arr3.length;i++) {
			System.out.print(arr3[i]+", ");
		}
		System.out.println();
		System.out.println(Arrays.toString(arr3));
		
		System.out.println();
		char[] charr = {'a','b','c','d'};
		for(int i =0;i<charr.length;i++) {
			System.out.print(charr[i]+", ");
		}
		System.out.println();
		System.out.println(Arrays.toString(charr));
		
		
	}
}
