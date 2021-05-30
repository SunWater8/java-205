package Chaper05_Array.Today0530;

import java.util.Arrays;

public class ArrayEx07 {
	public static void main(String[] args) {
		int[] arr = new int[10];
		for(int i=0; i<arr.length; i++) {
			arr[i]=i;
			System.out.print(arr[i]+", ");
		}
		System.out.println();
		System.out.println("--------------------------------");
		System.out.println("숫자가 섞였어도 중복되는 예");
		for(int i=0; i<arr.length;i++) {
			int r = (int)(Math.random()*10);
			int temp = arr[0];
			arr[0]=arr[r];
			arr[r]=temp;
			System.out.print(arr[i]+", ");
		}
		System.out.println();
		System.out.println("--------------------------------");
		System.out.println("숫자가 골고루 섞이는 경우");
		System.out.println(Arrays.toString(arr)); //섞이는 for문 바깥에다가 배열을 나열 해야 숫자가 중복되지 않는다.
	}
}
