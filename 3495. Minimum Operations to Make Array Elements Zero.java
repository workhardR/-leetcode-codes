class Solution {
    public long minOperations(int[][] queries) {
        long ans = 0;
        for (int[] q : queries) {
            long totalSteps = getSteps(q[1]) - getSteps(q[0] - 1);
            ans += (totalSteps + 1) / 2;
        }
        return ans;
    }
    private long getSteps(long n) {
        if (n <= 0) return 0;
        long total = 0;
        long start = 1;
        int k = 1;
        while (start <= n) {
            long end = Math.min(n, (1L << (2 * k)) - 1);
            long count = end - start + 1;
            total += count * k;
            start <<= 2;
            k++;
        }
        return total;
    }
}
