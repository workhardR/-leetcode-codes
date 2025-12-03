import java.util.*;
class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        HashMap<Integer, Integer> full = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                dryDays.add(i);
                ans[i] = 1;
            } else {
                int lake = rains[i];
                if (full.containsKey(lake)) {
                    Integer dry = dryDays.higher(full.get(lake));
                    if (dry == null) return new int[0];
                    ans[dry] = lake;
                    dryDays.remove(dry);
                }
                full.put(lake, i);
                ans[i] = -1;
            }
        }
        return ans;
    }
}
