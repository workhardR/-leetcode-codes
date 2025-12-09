import java.util.*;

class Solution {
    public int specialTriplets(int[] nums) {
        long mod = 1_000_000_007L;
        Map<Integer, Long> right = new HashMap<>();
        Map<Integer, Long> left = new HashMap<>();

        for (int x : nums) {
            right.put(x, right.getOrDefault(x, 0L) + 1);
        }
        long ans = 0;
        for (int j = 0; j < nums.length; j++) {
            int v = nums[j];
            right.put(v, right.get(v) - 1);

            int doubled = v * 2;

            long cntLeft = left.getOrDefault(doubled, 0L);
            long cntRight = right.getOrDefault(doubled, 0L);

            ans = (ans + (cntLeft * cntRight) % mod) % mod;

            left.put(v, left.getOrDefault(v, 0L) + 1);
        }

        return (int) ans;
    }
}
