class Solution {
    public int minimumOperations(int[] nums) {
        int ans = 0;
        for (int x : nums) {
            int r = x % 3;
            if (r == 1 || r == 2) ans += 1;
        }
        return ans;
    }
}
