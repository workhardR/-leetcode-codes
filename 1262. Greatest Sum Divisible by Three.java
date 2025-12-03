class Solution {
    public int maxSumDivThree(int[] nums) {
        int NEG = Integer.MIN_VALUE / 2;
        int[] dp = new int[]{0, NEG, NEG};
        for (int x : nums) {
            int[] temp = dp.clone();
            for (int r = 0; r < 3; r++) {
                int nr = (r + x) % 3;
                temp[nr] = Math.max(temp[nr], dp[r] + x);
            }
            dp = temp;
        }
        return dp[0];
    }
}
