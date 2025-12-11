import java.util.*;

class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int m = buildings.length;

        int[] rowMin = new int[n + 1];
        int[] rowMax = new int[n + 1];
        int[] colMin = new int[n + 1];
        int[] colMax = new int[n + 1];

        Arrays.fill(rowMin, Integer.MAX_VALUE);
        Arrays.fill(colMin, Integer.MAX_VALUE);
        Arrays.fill(rowMax, -1);
        Arrays.fill(colMax, -1);

        for (int[] b : buildings) {
            int x = b[0], y = b[1];
            rowMin[x] = Math.min(rowMin[x], y);
            rowMax[x] = Math.max(rowMax[x], y);
            colMin[y] = Math.min(colMin[y], x);
            colMax[y] = Math.max(colMax[y], x);
        }

        int ans = 0;
        for (int[] b : buildings) {
            int x = b[0], y = b[1];
            if (rowMin[x] < y && y < rowMax[x] &&
                colMin[y] < x && x < colMax[y]) {
                ans++;
            }
        }
        return ans;
    }
}
