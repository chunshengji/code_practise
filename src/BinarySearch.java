
public class BinarySearch{
	
	public static void main(String[] args){
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		int num = 3;
		System.out.println(bs1(arr, num, 0, arr.length-1));

	  System.out.println(-1 ==  bs1(new int[]{},3, 0, 0));
	  System.out.println(-1 == bs1(new int[]{1},3, 0, 0));
	  System.out.println(0 ==  bs1(new int[]{1},1, 0, 0));

	  System.out.println(0 ==  bs1(1, new int[]{1, 3, 5}));
	  System.out.println(1 ==  bs1(3, new int[]{1, 3, 5}));
	  System.out.println(2 ==  bs1(5, new int[]{1, 3, 5}));
	  System.out.println(-1 == bs1(0, new int[]{1, 3, 5}));
	  System.out.println(-1 == bs1(2, new int[]{1, 3, 5}));
	  System.out.println(-1 == bs1(4, new int[]{1, 3, 5}));
	  System.out.println(-1 == bs1(6, new int[]{1, 3, 5}));
	 
	  System.out.println(0==  bs1(1, new int[]{1, 3, 5, 7}));
	  System.out.println(1== bs1(3, new int[]{1, 3, 5, 7}));
	  System.out.println(2==  bs1(5, new int[]{1, 3, 5, 7}));
	  System.out.println(3==  bs1(7, new int[]{1, 3, 5, 7}));
	  System.out.println(-1== bs1(0, new int[]{1, 3, 5, 7}));
	  System.out.println(-1== bs1(2, new int[]{1, 3, 5, 7}));
	  System.out.println(-1== bs1(4, new int[]{1, 3, 5, 7}));
	  System.out.println(-1== bs1(6, new int[]{1, 3, 5, 7}));
	  System.out.println(-1== bs1(8, new int[]{1, 3, 5, 7}));

	}

    public static int bs1(int num, int[] arr){
	    return bs1( arr, num, 0, arr.length-1);
	}

	public static int bs1(int[] arr, int num, int start, int end){
		if(null == arr || arr.length  == 0) return -1;
		while(start <= end){
			int mid  = start + (end-start)/2;
			if(arr[mid] == num) return mid;
			if(arr[mid] > num){
				end = mid-1;
				bs1(arr,num, start,end);
			}else {
				start = mid+1;
				bs1(arr,num,start,end);
			}

		}
		return -1;
	}

}
