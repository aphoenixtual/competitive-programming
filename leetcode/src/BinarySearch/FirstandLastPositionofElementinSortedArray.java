package BinarySearch;

public class FirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int index = BinarySearch(nums, 0, nums.length-1, target);

        if(index==-1)
            return new int[] {-1, -1};

        int start = index;
        int end = index;

        int lo = 0;
        int hi = index-1;

        while(true){
            int temp = BinarySearch(nums, lo, hi, target);
            if(temp != -1) {
                start = temp;
                lo = 0;
                hi = start -1;
            }
            else{
                break;
            }
        }

        lo = index+1;
        hi = nums.length-1;

        while(true){
            int temp = BinarySearch(nums, lo, hi, target);
            if(temp != -1) {
                end = temp;
                lo = temp + 1;
                hi = nums.length-1;
            }
            else{
                break;
            }
        }

        return new int[] {start, end};
    }

    public static int BinarySearch(int[] nums, int lo, int hi, int target){
        while(lo<=hi){
            int mid = lo + ((hi-lo)/2);
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] > target){
                hi = mid -1;
            }
            else {
                lo = mid + 1;
            }
        }

        return -1;
    }
}
