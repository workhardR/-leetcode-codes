class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int xa = points[i][0], ya = points[i][1];
                int xb = points[j][0], yb = points[j][1];
                if (xa <= xb && ya >= yb) {
                    boolean valid = true;
                    for (int k = 0; k < n; k++) {
                        if (k == i || k == j) continue;
                        int xc = points[k][0], yc = points[k][1];
                        if (xc >= xa && xc <= xb && yc <= ya && yc >= yb) {
                            valid = false;
                            break;
                        }
                    }
                    if (valid) count++;
                }
            }
        }
        return count;
    }
}
