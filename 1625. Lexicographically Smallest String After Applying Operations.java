class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> seen = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        String res = s;
        q.add(s);
        seen.add(s);
        int n = s.length();
        while (!q.isEmpty()) {
            String cur = q.poll();
            if (cur.compareTo(res) < 0) res = cur;
            char[] ch = cur.toCharArray();
            for (int i = 1; i < n; i += 2) {
                ch[i] = (char)((ch[i] - '0' + a) % 10 + '0');
            }
            String added = new String(ch);
            if (seen.add(added)) q.add(added);
            String rotated = cur.substring(n - b) + cur.substring(0, n - b);
            if (seen.add(rotated)) q.add(rotated);
        }
        return res;
    }
}
