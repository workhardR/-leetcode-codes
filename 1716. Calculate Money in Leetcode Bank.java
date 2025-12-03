class Solution {
    public int totalMoney(int n) {
        int ans = 0, start = 1;
        while (n > 0) {
            for (int i = 0; i < Math.min(7, n); i++) ans += start + i;
            n -= 7;
            start++;
        }
        return ans;
    }
}
