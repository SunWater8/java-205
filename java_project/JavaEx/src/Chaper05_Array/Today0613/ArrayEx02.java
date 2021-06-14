package Chaper05_Array.Today0613;

import java.util.Arrays;

public class ArrayEx02 {
	public static void main(String[] args) {
		int[] arr = new int[10];
		for(int i=0;i<arr.length;i++) {
			arr[i]=i;
			System.out.print(arr[i]);
		}
		
		int temp=0;
		for(int i=1;i<arr.length-1;i++) {
			temp = arr[0];
			arr[0]=arr[i];
			arr[i]=temp;
			
		}
		System.out.println();
		System.out.println( Arrays.toString(arr));
		
		
	}
}