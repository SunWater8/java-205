package Chaper05_Array.Today0530;
import java.util.Arrays;

public class ArrayEx10 {
	public static void main(String[] args) {
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*10);
			System.out.print(arr[i]);
		}

		System.out.println("\nbubble sorting");
		for (int i = 0; i < arr.length - 1; i++) {
			boolean changed = false;
			for (int j = 0; j < arr.length - 1-i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					changed = true;
				}
			}
			if(!changed) {
				break;
			}
			for(int k=0; k<arr.length;k++) {
				System.out.print(arr[k]);
			}
			System.out.println();
		}


	}
}
