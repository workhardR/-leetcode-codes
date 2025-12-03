class Solution {
    public int nextBeautifulNumber(int n) {
        for (int i = n + 1; ; i++) {
            if (isBalanced(i)) return i;
        }
    }
    private boolean isBalanced(int num) {
        int[] count = new int[10];
        for (char c : String.valueOf(num).toCharArray()) count[c - '0']++;
        for (int i = 0; i < 10; i++) if (count[i] != 0 && count[i] != i) return false;
        return true;
    }
}
