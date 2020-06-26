package javaLearning;

public class AdditionString {
	public static void main(String[] args) {
	String str = "asdf1qwer9as8d7";
	int app = 0;
	int reminder =0;
	int result = 0;
	
	String expOutput = str.replaceAll("\\D", "");
	//char[] ch = expOutput.toCharArray();
	//long count = str.chars().filter((c)->Character.isDigit(c)).count();
	System.out.println(expOutput);
	int inputNumbr = Integer.parseInt(expOutput);
	
	while(inputNumbr!=0)
	{
		
		reminder = inputNumbr%10;
		result = result + reminder;
		inputNumbr = inputNumbr/10;
	}
	
	System.out.println(result);
	
	
	
	
	}

	}
