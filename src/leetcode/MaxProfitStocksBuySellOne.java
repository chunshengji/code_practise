package leetcode;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/#/description
 * @author hgupta
 * 
 * Follow this link to understand all the possible solutions for this problem:
 * http://keithschwarz.com/interesting/code/?dir=single-sell-profit
 * 
 */
public class MaxProfitStocksBuySellOne {

	public static void main(String[] args) {
		int[] nums= {10, 22, 5, 75, 65, 80};
		System.out.println(getMaxProfit(nums));
	}
	
	/**
	 * Returns max profit where nums is the price array
	 * @param nums
	 * @return maxProfit
	 */
	public static int getMaxProfit(int[] nums){
		if(nums == null || nums.length <= 1)  return 0;
		
		int minPrice = nums[0];
		int maxProfit = nums[1] - nums[0];
		for(int i=1; i<nums.length; i++){
			if(maxProfit < nums[i] - minPrice) maxProfit = nums[i] - minPrice;
			if(nums[i] < minPrice) minPrice = nums[i];
		}
		return maxProfit;
	}
	

}
