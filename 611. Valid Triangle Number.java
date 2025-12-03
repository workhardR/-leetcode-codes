import java.util.Arrays;
public class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int count = 0;

        for (int k = n - 1; k >= 2; k--) {
            int left = 0, right = k - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[k]) {
                    count += (right - left);
                    right--;
                } else {
                    left++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.triangleNumber(new int[]{2, 2, 3, 4}));
        System.out.println(sol.triangleNumber(new int[]{4, 2, 3, 4}));
    }
}
