import java.util.*;
class Solution {
    static final long MOD = 1000000007L;
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        long[] dp = new long[n + 1];
        long[] pref = new long[n + 1];
        dp[0] = 1;
        pref[0] = 1;
        Deque<Integer> mx = new ArrayDeque<>();
        Deque<Integer> mn = new ArrayDeque<>();
        int l = 0;
        for (int r = 1; r <= n; r++) {
            int idx = r - 1;
            while (!mx.isEmpty() && nums[mx.peekLast()] <= nums[idx]) mx.pollLast();
            mx.addLast(idx);
            while (!mn.isEmpty() && nums[mn.peekLast()] >= nums[idx]) mn.pollLast();
            mn.addLast(idx);
            while (!mx.isEmpty() && !mn.isEmpty() && nums[mx.peekFirst()] - nums[mn.peekFirst()] > k) {
                if (mx.peekFirst() == l) mx.pollFirst();
                if (mn.peekFirst() == l) mn.pollFirst();
                l++;
            }
            long leftPref = (l - 1 >= 0) ? pref[l - 1] : 0;
            dp[r] = (pref[r - 1] - leftPref + MOD) % MOD;
            pref[r] = (pref[r - 1] + dp[r]) % MOD;
        }
        return (int) dp[n];
    }
}
