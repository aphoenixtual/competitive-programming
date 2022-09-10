package HashTable;

import java.util.HashMap;
import java.util.Map;

public class FindingPairsWithaCertainSum {
    /* First Solution
    int[] nums1, nums2;
    HashMap<Integer, Integer> freq = new HashMap<>();

    public FindingPairsWithaCertainSum(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        for (int x : nums2) increaseFreq(x, 1);
    }
    private void increaseFreq(int key, int inc) {
        freq.put(key, freq.getOrDefault(key, 0) + inc);
    }
    public void add(int index, int val) {
        increaseFreq(nums2[index], -1);  // Remove old one
        nums2[index] += val;
        increaseFreq(nums2[index], 1);  // Count new one
    }
    public int count(int tot) {
        int ans = 0;
        for (int a : nums1)
            ans += freq.getOrDefault(tot - a, 0); // a + b = tot -> b = tot - a
        return ans;
    }

    */

    // Second Optimal Solution
    Map<Integer, Integer> map = new HashMap<>();
    int[] nums1, nums2;

    public FindingPairsWithaCertainSum(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        for(int num: nums2)
            map.put(num, map.getOrDefault(num, 0) + 1);
    }

    public void add(int index, int val) {
        map.put(nums2[index], map.get(nums2[index]) - 1);
        nums2[index] += val;
        map.put(nums2[index], map.getOrDefault(nums2[index], 0) + 1);
    }

    public int count(int tot) {
        int result =0;
        for(int num: nums1)
            if(map.containsKey(tot - num))
                result += map.get(tot - num);
        return result;
    }
}
