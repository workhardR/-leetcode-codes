import java.util.*;
class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Map<Integer,Integer> cnt = new HashMap<>();
        TreeMap<Long,Integer> d = new TreeMap<>();

        for (int v : nums) {
            cnt.put(v, cnt.getOrDefault(v,0) + 1);
            long start = (long)v - k;
            long endExclusive = (long)v + k + 1;
            d.put(start, d.getOrDefault(start,0) + 1);
            d.put(endExclusive, d.getOrDefault(endExclusive,0) - 1);
           
            if (!d.containsKey((long)v)) {
                d.put((long)v, d.getOrDefault((long)v,0));
            }
        }
        int ans = 1;
        long s = 0;
        for (Map.Entry<Long,Integer> entry : d.entrySet()) {
            long x = entry.getKey();
            s += entry.getValue();

            int originalCount = cnt.getOrDefault((int)x, 0);
            
            int possible = (int)Math.min(s, (long)originalCount + numOperations);
            ans = Math.max(ans, possible);
        }
        return ans;
    }
}
