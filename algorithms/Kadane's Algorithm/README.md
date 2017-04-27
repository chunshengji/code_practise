# Kadane's Algorithm / Max Sub Array

Kadane's Algorithm can be used to find out the maximum subarray out of provided array. It works on the principal of dp when we can find out the answer to the current problem if we have answer of its previous problem. 

So if we have sum of a[i] when finding out max sum then we just need to find out that if a[i+1] is the part of the answer/sub-array or not by adding its value to existing running sum. 

Java Code 
```java
public static void main(String[] args){
    int[] arr = {3,2,-5,1,-7,9,3,-4,8,-12,5,6,0};
    int maxSum = Integer.MIN_VALUE;
    for(int num: arr){
        maxSum = Math.max(maxSum+num, maxSum);
    }
}

```


