class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans = new ArrayList<>();
        int val = 0;
        for (int x : nums) {
            val = ((val << 1) + x) % 5;
            ans.add(val == 0);
        }
        return ans;
    }
}
