package algorithms.dp.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a text and a wildcard pattern, implement wildcard pattern matching algorithm that finds 
 * if wildcard pattern is matched with text. The matching should cover the entire text (not partial text).
 * 	
 * 	The wildcard pattern can include the characters ‘?’ and ‘*’
 * 	‘?’ – matches any single character
 * 	‘*’ – Matches any sequence of characters (including the empty sequence)
 * 	
 * 	For example,
 * 	
 * 	Text = "baaabab",
 * 	Pattern = “*****ba*****ab", output : true
 * 	Pattern = "baaa?ab", output : true
 * 	Pattern = "ba*a?", output : true
 * 	Pattern = "a*ab", output : false 
 * 
 * http://www.geeksforgeeks.org/wildcard-pattern-matching/
 * @author hgupta
 *
 */
public class WildCardPatternMatch {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("abcdedsfds", "*d?");
		map.put("abcddsfds", "*");
		map.put("abcdedfds", "abc*d");
		map.put("himanshu", "h*sh?");
		map.put("abcdedsfds", "*******************");
		map.put("computer", "????????");
		
		map.forEach((text, pattern) -> 
		System.out.println(
				wildcardMatchRecurrsive(text.toCharArray(), pattern.toCharArray(), 0, 0) == wildcardMatch(text, pattern)
				)
		);
	}
	
	/**
	 * Recursive implementation of wild card matching problem.
	 * @param text
	 * @param pattern
	 * @param i start position for text
	 * @param j start position for pattern
	 * @return true if they match else false
	 */
	public static boolean wildcardMatchRecurrsive(char[] text, char[] pattern, int i, int j){
		if(i == text.length && j == pattern.length) return true;
		if(i >= text.length) return false;
		
		if(pattern[j] == '*'){ 	// take  * 
			if(j == pattern.length-1){ // if last is * then return true as everything will match after that
				return true;
			}
			return wildcardMatchRecurrsive(text, pattern, i, j+1) || wildcardMatchRecurrsive(text, pattern, i+1, j);
		}else if(pattern[j] == '?' || pattern[j] == text[i]){
			if(j == pattern.length-1 && i != text.length-1)	{
				return false; // this means that last char isn't `*` and also text is not matched till end. 
			}
			return wildcardMatchRecurrsive(text, pattern, i+1, j+1); // move to next char in text and pattern
		}else{
			return false;
		}
	}
	
	/**
	 * 
	 * @param text
	 * @param pattern
	 * @return
	 */
	public static boolean wildcardMatch(String textStr, String patternStr){
		char[] text = textStr.toCharArray();
		char[] pattern = patternStr.toCharArray();
		boolean[][] dp = new boolean[text.length+1][pattern.length+1];
		//initialize dp table
		dp[0][0] = true;
		
		for(int i=1; i<dp[0].length; i++){
			if(pattern[i-1] == '*')	dp[0][i] = dp[0][i-1];// pattern is null
		}
		
		for(int i=1; i<dp.length; i++){
			for(int j=1; j<dp[i].length; j++){
				if(pattern[j-1] == '?' || pattern[j-1] == text[i-1]){
					dp[i][j] = dp[i-1][j-1];
				}else if(pattern[j-1] == '*'){
					dp[i][j] = dp[i][j-1] || dp[i-1][j];
				}else {
					dp[i][j] = false;
				}
			}
		}
		
		return dp[text.length][pattern.length];
	}
}
