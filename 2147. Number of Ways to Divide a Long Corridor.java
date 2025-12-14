class Solution {
    public int numberOfWays(String corridor) {
        long mod = 1_000_000_007;
        int seats = 0;
        long ways = 1;
        int plants = 0;
        boolean counting = false;

        for (char c : corridor.toCharArray()) {
            if (c == 'S') {
                seats++;
                if (seats % 2 == 0) {
                    counting = true;
                } else {
                    if (counting) {
                        ways = (ways * (plants + 1)) % mod;
                        plants = 0;
                        counting = false;
                    }
                }
            } else {
                if (counting) plants++;
            }
        }

        return seats >= 2 && seats % 2 == 0 ? (int) ways : 0;
    }
}
