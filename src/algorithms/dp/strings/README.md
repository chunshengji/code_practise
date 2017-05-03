# String related DP Problems

## Wildcard Matching
This problem can be solved using dynamic programming approach. Key being if we already know if the previous pattern matches to previous substring then we can decide if current character matches to the pattern being used. 
_Example pattern:_ a*b?d which can match strings like abcd, adbrg, abdd but *not* zacd, abd. 

Pointer to how to use DP table is to use dp[i][j] which means if first i chars of string `text` matches first j chars of string `pattern`

Pattern is composed of alphabets and wildcars ('?' and '*'). It is easy to think about `?` as it means any char can take its value so 
```
'?' == '[a...z][0...9]' is true 
```
Handling `*` can go in two different ways:
1. We can completely ignore `*` and move to next chaarcter in pattern. This means string `text` have no character for this. eg: _a*b == ab_ is true where * means nothing. 
```
// here j-1 means take result from previous match till j-1 char of pattern. 
dp[i][j] = dp[i][j-1];
```
2. `*` matches to one or more characters in text. For this to happen we need to keep moving to next character in text string. eg: _a*b == aaaab_. Here * is _aaa_ 
 ```
// here i-1 means take result from matching * to i th chat
dp[i][j] = dp[i-1][j];
```
We can combine these two and write as 
```java
if(pattern[j-1] == '*')
	dp[i][j] = dp[i][j-1] || dp[i-1][j]; // just take whatever matches
```
**Core logic can be summed here as**:
```java
for(int i=1; i<dp.length; i++){
	for(int j=1; j<dp[i].length; j++){
		if(pattern[j-1] == '?' || pattern[j-1] == text[i-1])    dp[i][j] = dp[i-1][j-1];
		else if(pattern[j-1] == '*')                            dp[i][j] = dp[i][j-1] || dp[i-1][j];
		else                                                    dp[i][j] = false;
	}
}
```
## String Interleaving

## Regex Matching


