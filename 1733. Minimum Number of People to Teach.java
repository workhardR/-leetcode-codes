import java.util.*;

class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;
        Set<Integer>[] known = new HashSet[m + 1];
        for (int i = 1; i <= m; i++) {
            known[i] = new HashSet<>();
            for (int lang : languages[i - 1]) {
                known[i].add(lang);
            }
        }
        
        Set<Integer> needTeach = new HashSet<>();
        for (int[] f : friendships) {
            int u = f[0], v = f[1];
            if (!canCommunicate(known[u], known[v])) {
                needTeach.add(u);
                needTeach.add(v);
            }
        } 
        if (needTeach.isEmpty()) return 0;
        int result = Integer.MAX_VALUE;
        for (int lang = 1; lang <= n; lang++) {
            int count = 0;
            for (int user : needTeach) {
                if (!known[user].contains(lang)) {
                    count++;
                }
            }
            result = Math.min(result, count);
        }
        
        return result;
    }
    private boolean canCommunicate(Set<Integer> a, Set<Integer> b) {
        for (int lang : a) {
            if (b.contains(lang)) return true;
        }
        return false;
    }
}
