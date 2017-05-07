package algorithms.dp;

/**
 * Problem Source: https://leetcode.com/problems/regular-expression-matching
 * 
 * Implement regular expression matching with support for '.' and '*'.
 * 
 * 		'.' Matches any single character.
 * 		'*' Matches zero or more of the preceding element.
 * 		
 * 		The matching should cover the entire input string (not partial).
 * 		
 * 		The function prototype should be:
 * 		bool isMatch(const char *s, const char *p)
 * 		
 * 		Some examples:
 * 		isMatch("aa","a") → false
 * 		isMatch("aa","aa") → true
 * 		isMatch("aaa","aa") → false
 * 		isMatch("aa", "a*") → true
 * 		isMatch("aa", ".*") → true
 * 		isMatch("ab", ".*") → true
 * 		isMatch("aab", "c*a*b") → true
 * 
 * @author hgupta
 *
 */
public class RegexMatch {

	public static void main(String[] args) {
		String text = "aa", pattern = ".*";
		System.out.println(isMatchRecursive(text.toCharArray(), pattern.toCharArray(), 0, 0));
		System.out.println(isMatch(text,pattern));
	}
	
	/**
	 * Uses Dynamic Programming approach to find out that provided 
	 * text matches given pattern or not. 
	 * @param text
	 * @param pattern
	 * @return boolean
	 */
	public static boolean isMatch(String text, String pattern){
		boolean[][] dp = new boolean[text.length()+1][pattern.length()+1];
		char[] textArr = text.toCharArray();
		char[] patternArr = pattern.toCharArray();
		
		dp[0][0] = true;// null pattern with null text is true
		
		for(int i=1; i<dp[0].length; i++){
			if(patternArr[i-1] == '*') dp[0][i] = dp[0][i-2];
		}
		
		for(int i=1; i<dp.length; i++){
			for(int j=1; j<dp[i].length; j++){
				if(patternArr[j-1] == '*'){
					dp[i][j] = dp[i][j-2]; // without taking pattern
					if(patternArr[j-2] == '.' || patternArr[j-2] == textArr[i-1]){
						dp[i][j] = dp[i][j] || dp[i-1][j];
					}
				}else if(textArr[i-1] == patternArr[j-1] || patternArr[j-1] == '.'){
					dp[i][j] = dp[i-1][j-1];
				}else {
					dp[i][j] = false;
				}
			}
		}
		return dp[text.length()][pattern.length()];
	}
	
	/**
	 * Uses recursion to find out that if text matches pattern or not
	 * @param text
	 * @param pattern
	 * @param textPosition
	 * @param patternPosition
	 * @return boolean
	 */
	public static boolean isMatchRecursive(char[] text, char[] pattern, int textPosition, int patternPosition){
		 if(patternPosition == pattern.length && textPosition == text.length)    return true;
			if(patternPosition >= pattern.length) return false; 
			if(textPosition >= text.length){
				// tokenize remaining pattern .. 
				// if it has all star then return true else false
				for(int i=patternPosition; i<pattern.length;){
					if(pattern[i] == '*'){
						i=i+1;
					}else if(i+1<pattern.length && pattern[i+1] == '*'){
						i = i+2;
					}else{
						return false;
					}
				}
				return true;
			}
			
			if(patternPosition+1 < pattern.length && pattern[patternPosition+1] == '*'){
				boolean result = false;
				if(text[textPosition] == pattern[patternPosition] || pattern[patternPosition] == '.' )
					 result = isMatchRecursive(text, pattern, textPosition+1, patternPosition);
				return result || isMatchRecursive(text, pattern, textPosition, patternPosition+2);// we skip current pattern
			}else if((pattern[patternPosition] == '.' || pattern[patternPosition] == text[textPosition]) ){
				return isMatchRecursive(text, pattern, textPosition+1, patternPosition+1);
			}else{ //pattern[patternPosition] != text[textPosition]
				return false;
			}
	}
}
