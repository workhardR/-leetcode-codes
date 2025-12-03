class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ?
                b[0] - a[0] : a[1] - b[1]);
        int a = -1, b = -1, ans = 0;
        for (int[] in : intervals) {
            int l = in[0], r = in[1];
            if (l > b) {
                ans += 2;
                a = r - 1;
                b = r;
            } else if (l > a) {
                ans++;
                a = b;
                b = r;
            }
        }
        return ans;
    }
}
