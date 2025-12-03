import java.util.*;

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        for (int i = 0; i + k <= n; i++) {
            Map<Integer, Integer> freq = new HashMap<>();

            for (int j = i; j < i + k; j++) {
                freq.put(nums[j], freq.getOrDefault(nums[j], 0) + 1);
            }
            List<int[]> list = new ArrayList<>();
            for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
                list.add(new int[]{e.getKey(), e.getValue()});
            }
            list.sort(Comparator.comparingInt((int[] a) -> a[1])
                                .thenComparingInt(a -> a[0])
                                .reversed());
            int sum = 0;
            int count = 0;
            for (int[] pair : list) {
                if (count == x) break;
                sum += pair[0] * pair[1];
                count++;
            }
            ans[i] = sum;
        }

        return ans;
    }
}
