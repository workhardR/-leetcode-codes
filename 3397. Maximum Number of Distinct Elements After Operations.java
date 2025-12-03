import java.util.*;
public class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        TreeSet<Long> set = new TreeSet<>();
        for (int x : nums) {
            long l = (long) x - k, r = (long) x + k;
            long val = l;
            if (!set.isEmpty()) {
                Long last = set.last();
                val = Math.max(l, last + 1);
            }
            if (val <= r) set.add(val);
        }
        return set.size();
    }
}
