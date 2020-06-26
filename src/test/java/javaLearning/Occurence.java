package javaLearning;

import java.util.HashMap;

public class Occurence {

	   public static void main(String[] args) {
		      String str = "Karma is Powerful than God";
		      System.out.println(str.charAt(2));
		      HashMap <Character, Integer> hMap = new HashMap<>();
		      for (int i = str.length()-1; i >= 0; i--) {
		         if (hMap.containsKey(str.charAt(i))) {
		            int count = hMap.get(str.charAt(i));
		            hMap.put(str.charAt(i), ++count);
		         } else {
		            hMap.put(str.charAt(i),1);
		         }
		      }
		      System.out.println(hMap);
		   }
		}