package javaLearning;

public class ReverseWords {

	public static void main(String[] args) {
	String str = "When the world realizes its own mistake, corona will dissolve automatically";
	String[] strSplit = str.split(" ");
	for(int i =0; i<strSplit.length;i++)
	{
		if(i%2!=0)
		{
			StringBuffer sb =  new StringBuffer(strSplit[i]);
		    strSplit[i] = sb.reverse().toString();
		}
	}
	for(int i =0; i<strSplit.length;i++)
	{
System.out.print(strSplit[i] + " ");
	}
	}

}
