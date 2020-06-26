package javaLearning;

import java.util.Arrays;
import java.util.Collections;

public class ArraySorting {

	public static void main(String[] args) {
		int[] array = {51,33,79,22,11,45};
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
		
		//Descending Order
		int length = array.length;
		for(int i=length-1;i>=0;i--)
		{
			System.out.print(" " + array[i]);
		}
		
		//Descending Order another method
		
		//Arrays.sort(array, Collections.reverseOrder()); 

	}

}
