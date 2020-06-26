package javaLearning;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "Vikivijay7%$@gMail.co.in";
		String comp ="[a-zA-z0-9%$]+@[a-zA-Z]+.[a-z]+.[a-z]+";
		Pattern compiler = Pattern.compile(comp);
		Matcher matcher = compiler.matcher(str);
		System.out.println(matcher.matches());

	}

}
