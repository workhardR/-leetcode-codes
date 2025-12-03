class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for (int k = 1; k <= 60; k++) {   
            long s = (long) num1 - (long) k * num2;  
            if (s >= k && Long.bitCount(s) <= k) {
                return k;
            }
        }
        return -1;
    }
}
