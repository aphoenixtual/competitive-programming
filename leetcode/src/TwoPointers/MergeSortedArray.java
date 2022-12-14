package TwoPointers;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m--; n--;
        while (m >= 0 || n >= 0) {
            if (m >= 0 && n >= 0) {
                nums1[m + n + 1] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
            } else if (m < 0) { // n > 0
                nums1[n] = nums2[n--];
            } else if (n < 0) {
                break;
            }
        }
    }
}
