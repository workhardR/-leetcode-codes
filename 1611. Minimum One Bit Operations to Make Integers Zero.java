class Solution {
    public int minimumOneBitOperations(int n) {
        if (n == 0) return 0;
        int highest = 31 - Integer.numberOfLeadingZeros(n);
        int mask = (1 << (highest + 1)) - 1;
        return mask ^ minimumOneBitOperations(n ^ (1 << highest));
    }
}
