import java.util.*;
class Solution {
    static final long MOD = 1000000007L;
    public int countTrapezoids(int[][] points) {
        Map<Integer,Integer> cnt = new HashMap<>();
        for (int[] p : points) cnt.put(p[1], cnt.getOrDefault(p[1],0)+1);
        long sum = 0;
        long sumSq = 0;
        for (int m : cnt.values()) {
            if (m < 2) continue;
            long c = (long)m * (m - 1) / 2 % MOD;
            sum = (sum + c) % MOD;
            sumSq = (sumSq + c * c) % MOD;
        }
        long res = ( ( (sum * sum - sumSq) % MOD + MOD ) % MOD ) * ((MOD + 1) / 2) % MOD;
        return (int) res;
    }
}
