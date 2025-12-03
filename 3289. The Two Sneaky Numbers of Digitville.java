class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length;
        int[] freq = new int[n];
        int[] res = new int[2];
        int idx = 0;
        for (int num : nums) {
            if (++freq[num] == 2) res[idx++] = num;
        }
        return res;
    }
}
