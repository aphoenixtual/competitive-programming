package BinarySearch;

public class BinarySearch {
    public int search(int[] nums, int item) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {

            int mid = (lo + hi) / 2;

            if (nums[mid] < item) {
                lo = mid + 1;
            } else if (nums[mid] > item) {
                hi = mid - 1;
            } else {
                return mid;
            }

        }

        return -1;
    }
}
