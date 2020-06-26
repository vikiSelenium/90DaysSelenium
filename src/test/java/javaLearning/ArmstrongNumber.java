package javaLearning;

public class ArmstrongNumber {

	public static void main(String[] args) {
		int sum = 0;
		int a = 0;
		for (int i=1;i<=1000;i++)
		{
			sum = sum + (i*i*i);
			a = sum/3;
		}
		System.out.println(a);

	}

}
