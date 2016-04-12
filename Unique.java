import java.util.*;


public class Unique {

	
	public static boolean UniqueString(String unique){
		int i;
		boolean[] arr = new boolean[26];
		
		if(unique.length()>26){
			return false;
		}
		
		for(i = 0; i< unique.length(); i++){
			int val = unique.charAt(i) - 'a';	
			if (arr[val] != true){
				arr[val] = true;
			}
			else
				return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {

		System.out.println("The method result of Unique:" + UniqueString("abcdefghijklmnopqrstuvwxyzz"));
		
		
	}

}
