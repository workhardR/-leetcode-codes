import java.util.*;

public class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int count = 0;       
        Arrays.sort(points, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return b[1] - a[1];
        });
        for (int i = 0; i < n; i++) {
            int aliceX = points[i][0], aliceY = points[i][1];
            for (int j = i + 1; j < n; j++) {
                int bobX = points[j][0], bobY = points[j][1];                
                if (aliceX <= bobX && aliceY >= bobY) {
                    boolean valid = true;
                    for (int k = i + 1; k < j; k++) {
                        int x = points[k][0], y = points[k][1];
                        if (x >= aliceX && x <= bobX && y <= aliceY && y >= bobY) {
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
