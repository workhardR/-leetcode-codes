class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] best = new long[k];
        Arrays.fill(best, Long.MAX_VALUE);
        best[0] = 0;
        long pref = 0;
        long ans = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            pref += nums[i];
            int r = (i + 1) % k;
            if (best[r] != Long.MAX_VALUE) ans = Math.max(ans, pref - best[r]);
            best[r] = Math.min(best[r], pref);
        }
        return ans;
    }
}
