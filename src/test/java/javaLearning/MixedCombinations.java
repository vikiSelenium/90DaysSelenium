package javaLearning;

public class MixedCombinations {

	public static void main(String[] args) {
		String str = "1. It is Work from Home not Work for Home";
		
	System.out.println("The total number of Digits are " + str.chars().filter((a)->Character.isDigit(a)).count());
	System.out.println("The total number of UpperCase are " + str.chars().filter((c)->Character.isUpperCase(c)).count());
	System.out.println("The total number of LowerCase are " + str.chars().filter((c)->Character.isLowerCase(c)).count());
	System.out.println("The total number of Spaces are " + str.chars().filter((c)->Character.isSpaceChar(c)).count());
	

	}

}
