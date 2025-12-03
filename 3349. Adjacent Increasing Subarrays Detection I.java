import java.util.*;
class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        for (int i = 0; i + 2 * k <= n; i++) {
            boolean first = isIncreasing(nums, i, i + k - 1);
            boolean second = isIncreasing(nums, i + k, i + 2 * k - 1);
            if (first && second) return true;
        }
        return false;
    }
    private boolean isIncreasing(List<Integer> nums, int l, int r) {
        for (int i = l; i < r; i++) {
            if (nums.get(i) >= nums.get(i + 1)) return false;
        }
        return true;
    }
}
