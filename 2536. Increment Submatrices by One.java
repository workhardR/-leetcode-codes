class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] diff = new int[n + 1][n + 1];
        for (int[] q : queries) {
            int r1 = q[0], c1 = q[1], r2 = q[2], c2 = q[3];
            diff[r1][c1]++;
            diff[r1][c2 + 1]--;
            diff[r2 + 1][c1]--;
            diff[r2 + 1][c2 + 1]++;
        }
        int[][] res = new int[n][n];

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += diff[i][j];
                diff[i][j] = sum;
            }
        }
        for (int j = 0; j < n; j++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += diff[i][j];
                res[i][j] = sum;
            }
        }

        return res;
    }
}
