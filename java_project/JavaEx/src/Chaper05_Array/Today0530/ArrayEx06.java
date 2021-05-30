package Chaper05_Array.Today0530;

public class ArrayEx06 {
	public static void main(String[] args) {
		int[] arr = new int[8];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 10.0);
			System.out.println("arr[" + i + "] = " + arr[i]);
		}

		int min = arr[0];
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {

			if (min > arr[i]) {
				min = arr[i];
			}
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		System.out.println("min : "+min);
		System.out.println("max : "+max);
	}
}
