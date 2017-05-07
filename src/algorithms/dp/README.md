# Regex Matching

This problem is similar to [WildCard Problem](https://github.com/himanshugpt/code_practise/blob/master/src/algorithms/dp/strings/WildCardPatternMatch.java). Full statememt of this problem can be found on [Leetcode](https://leetcode.com/problems/regular-expression-matching).

Its easy to solve this problem using recursive method. We need to understand the nuances of elements which can be used in pattern string. 

A pattern can be formed of following elements:
```
1. `[a-z]*` or `.*` : [a-z]* means 0 or more repetitions of preceding character and `.*` means 0 or more repetitions of any chaarcter. 
2. `[a-z]` : Single character from a to z.
3. `'.'` : Means any character
```
### Comparision Rules:
1. If we get `[a-z]*` then we have two options to take:
	* We don't take the pattern into consideration and go ahead for matching remaining text and pattern. 
	* If we condider then we just consider the character in `text` if it is equal to the `[a-z]` in `[a-z]*` pattern. If yes then we call for next text position. 
2. if text character is equal to pattern character then we skip both characters. This also takes care of `.` as it means any character. 
```java
if(patternPosition+1 < pattern.length && pattern[patternPosition+1] == '*'){
	boolean result = false;
	if(text[textPosition] == pattern[patternPosition] || pattern[patternPosition] == '.' )
		 result = isMatchRecursive(text, pattern, textPosition+1, patternPosition);
	return result || isMatchRecursive(text, pattern, textPosition, patternPosition+2);// we skip current pattern
}
```
3. else two character in text is not equal to the character in pattern and its not a match. 
```java
if((pattern[patternPosition] == '.' || pattern[patternPosition] == text[textPosition]))
	return isMatchRecursive(text, pattern, textPosition+1, patternPosition+1);
```java
else{ //pattern[patternPosition] != text[textPosition]
	return false;
}
```

So to solve this problem we can keep two pointers one for pattern string and other for text string and keep progressing according to mentioned cases. 

```java
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
```

This whole approach can be converted to Dynamic programming. Same rule applies here. We just need to maintian an 2-D array 
```java
boolean[][] dp = new boolean[text.length()+1][pattern.length()+1];
```
0 row means null `text` and 0 column means null `pattern`. As null pattern equals null text so 
`dp[0][0] = true`

To handle [a-z]* in begining of pattern
```java
for(int i=1; i<dp[0].length; i++){
	if(patternArr[i-1] == '*') dp[0][i] = dp[0][i-2];
}
```

We populate the dp table now as per discussed rules above:
```java
for(int i=1; i<dp.length; i++){
	for(int j=1; j<dp[i].length; j++){
		if(patternArr[j-1] == '*'){
			dp[i][j] = dp[i][j-2]; // without taking pattern, means 0 occurance of [a-z]*
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
```
