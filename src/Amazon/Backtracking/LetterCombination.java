/**
 * 
 */
package Amazon.Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author ArunMannuru
 *
 */
/*
 * Letter Combinations of a Phone Number
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.


Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.


 * 
 * 
 */
public class LetterCombination {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "23";
		List<String> result = letterCombinations(input);
		for(String re : result){
			System.out.println(re);
		}
	}
	public static List<String> letterCombinations(String digits) {
	    HashMap<Integer, String> map = new HashMap<Integer, String>();
	    map.put(2, "abc");
	    map.put(3, "def");
	    map.put(4, "ghi");
	    map.put(5, "jkl");
	    map.put(6, "mno");
	    map.put(7, "pqrs");
	    map.put(8, "tuv");
	    map.put(9, "wxyz");
	    map.put(0, "");
	 
	    ArrayList<String> result = new ArrayList<String>();
	 
	    if(digits == null || digits.length() == 0)
	        return result;
	 
	    ArrayList<Character> temp = new ArrayList<Character>();
	    getString(digits, temp, result, map);
	 
	    return result;
	}
	 
	public static void getString(String digits, ArrayList<Character> temp, ArrayList<String> result,  HashMap<Integer, String> map){
	    if(digits.length() == 0){
	        char[] arr = new char[temp.size()];
	        for(int i=0; i<temp.size(); i++){
	            arr[i] = temp.get(i);
	        }
	        result.add(String.valueOf(arr));
	        return;
	    }
	 
	    Integer curr = Integer.valueOf(digits.substring(0,1));
	    String letters = map.get(curr);
	    for(int i=0; i<letters.length(); i++){
	        temp.add(letters.charAt(i));
	        getString(digits.substring(1), temp, result, map);
	        temp.remove(temp.size()-1);
	    }
	}

	
}