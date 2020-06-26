package javaLearning;

public class AverageNumbers {

	public static void main(String[] args) {
		
int [] array= {20,30,25,-16,35,60,-100};
int sum = 0;
int length = array.length;

for (int i =0; i<=length-1;i++)
{
	sum = sum + array[i];
}
int avg = sum/length;
System.out.println(avg);
}
}