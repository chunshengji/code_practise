# Kadane's Algorithm / Max Sub Array

Kadane's Algorithm can be used to find out the maximum subarray out of provided array. It works on the principal of dp when we can find out the answer to the current problem if we have answer of its previous problem.

So if we have sum of a[i] when finding out max sum then we just need to find out that if a[i+1] is the part of the answer/sub-array or not by adding its value to existing running sum.

Java Code
```java
public static void main(String[] args){
    int[] arr = {3,2,-5,1,-7,9,3,-4,8,-12,5,6,0};
    int currSum = arr[0], maxSoFar = arr[0];
    for(int i=0; i<arr.length; i++){
        currSum = currSum + arr[i]  < 0? 0 :currSum + arr[i];
        maxSoFar = math.max(currSum, maxSoFar);
    }
}
```
Above algorithm can easily be modified to find start and end index of the array whose sum is maximum.
Code for tracing start and end of the sub array
```java
public static int Kadane(int[] arr){
		int start = 0, tempStart = 0, end =0;
		int maxEndingHere = arr[0], maxSoFar = arr[0];
	    for(int i=1; i<arr.length; i++){
	    	if (maxEndingHere == 0) {
	    		tempStart = i;
	    	}
	    	maxEndingHere = maxEndingHere+arr[i] < 0 ? 0 : maxEndingHere+arr[i];
	    	if(maxSoFar < maxEndingHere){
	    		maxSoFar = maxEndingHere;
	    		start = tempStart;
	    		end = i;
	    	}
	    }
	    System.out.println("start " + start + " end " + end);
	    return maxSoFar;
	}
```
