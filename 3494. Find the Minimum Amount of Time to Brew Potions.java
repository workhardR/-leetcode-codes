class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length, m = mana.length;
        long[] prev = new long[n];
        for (int i = 0; i < n; i++) prev[i] = (long)skill[i] * mana[0] + (i > 0 ? prev[i - 1] : 0);
        long s = 0;
        for (int j = 1; j < m; j++) {
            long[] cur = new long[n];
            for (int i = 0; i < n; i++) cur[i] = (long)skill[i] * mana[j] + (i > 0 ? cur[i - 1] : 0);
            long maxDiff = Long.MIN_VALUE;
            long prefCurPrev = 0;
            for (int i = 0; i < n; i++) {
                long diff = prev[i] - prefCurPrev;
                if (diff > maxDiff) maxDiff = diff;
                prefCurPrev = cur[i];
            }
            if (maxDiff > 0) s += maxDiff;
            prev = cur;
        }
        return s + prev[n - 1];
    }
}
