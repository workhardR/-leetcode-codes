class Solution {
    public int countCollisions(String s) {
        int n = s.length();
        int i = 0, j = n - 1;
        while (i < n && s.charAt(i) == 'L') i++;
        while (j >= 0 && s.charAt(j) == 'R') j--;
        int ans = 0;
        for (int k = i; k <= j; k++) {
            if (s.charAt(k) != 'S') ans++;
        }
        return ans;
    }
}
