class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        for (int i = n - 1; i >= 0; i--) {
            int j = i + k;
            if (j < n) energy[i] += energy[j];
        }
        int ans = Integer.MIN_VALUE;
        for (int v : energy) ans = Math.max(ans, v);
        return ans;
    }
}
