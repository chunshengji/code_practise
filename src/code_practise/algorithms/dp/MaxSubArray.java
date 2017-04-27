package code_practise.algorithms.dp;

/**
 * Wiki Link: https://en.wikipedia.org/wiki/Maximum_subarray_problem
 * 
 * @author hgupta
 */
public class MaxSubArray {

	public static void main(String[] args) {
		int[] arr = { 1, 2, -1, 3, -4, 5, 6, 7, -11, -12, 10 };
		System.out.println(Kadane(arr));
	}

	/**
	 * Gives subarray in O(n)
	 * 
	 * @param arr
	 * @return
	 */
	public static int Kadane(int[] arr) {
		int start = 0, tempStart = 0, end = 0;
		int maxEndingHere = arr[0], maxSoFar = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (maxEndingHere == 0) {
				tempStart = i;
			}
			maxEndingHere = maxEndingHere + arr[i] < 0 ? 0 : maxEndingHere + arr[i];
			if (maxSoFar < maxEndingHere) {
				maxSoFar = maxEndingHere;
				start = tempStart;
				end = i;
			}

		}
		System.out.println("start " + start + " end " + end);
		return maxSoFar;
	}
}
