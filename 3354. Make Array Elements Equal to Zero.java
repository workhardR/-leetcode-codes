class Solution {
    public int countValidSelections(int[] nums) {
        int ans = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (canZero(nums.clone(), i, 1)) ans++;
                if (canZero(nums.clone(), i, -1)) ans++;
            }
        }
        return ans;
    }

    private boolean canZero(int[] a, int curr, int dir) {
        int n = a.length;
        while (curr >= 0 && curr < n) {
            if (a[curr] == 0) curr += dir;
            else {
                a[curr]--;
                dir = -dir;
                curr += dir;
            }
        }
        for (int x : a) if (x != 0) return false;
        return true;
    }
}
