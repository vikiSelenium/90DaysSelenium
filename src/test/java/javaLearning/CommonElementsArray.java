package javaLearning;

import java.util.Arrays;

public class CommonElementsArray {

	public static void main(String[] args) {
		int[] array1 = {1,2,5,7,99,80,40};
		int [] array2 = { 1,7,96,69,84,183};
		for (int i=0;i<=array1.length-1;i++)
		{
			for(int j=0;j<=array2.length-1;j++)
			{
				if(array1[i]==array2[j])
				{
					System.out.print(" " + (array1[i]));
				}
			}
		}

}
}
