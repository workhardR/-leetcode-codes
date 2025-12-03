import java.util.*;
class Solution {
    int[] parent, rank;

    int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
    void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;
        if (rank[a] < rank[b]) parent[a] = b;
        else if (rank[a] > rank[b]) parent[b] = a;
        else {
            parent[b] = a;
            rank[a]++;
        }
    }
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        parent = new int[c + 1];
        rank = new int[c + 1];
        for (int i = 1; i <= c; i++) parent[i] = i;

        for (int[] conn : connections)
            union(conn[0], conn[1]);

        Map<Integer, TreeSet<Integer>> gridOnline = new HashMap<>();
        for (int i = 1; i <= c; i++) {
            int root = find(i);
            gridOnline.computeIfAbsent(root, k -> new TreeSet<>()).add(i);
        }

        boolean[] offline = new boolean[c + 1];
        List<Integer> result = new ArrayList<>();

        for (int[] q : queries) {
            int type = q[0], x = q[1];
            int root = find(x);

            if (type == 1) {
                if (!offline[x]) result.add(x);
                else {
                    TreeSet<Integer> onlineSet = gridOnline.get(root);
                    if (onlineSet == null || onlineSet.isEmpty()) result.add(-1);
                    else result.add(onlineSet.first());
                }
            } else if (type == 2) {
                if (!offline[x]) {
                    offline[x] = true;
                    TreeSet<Integer> onlineSet = gridOnline.get(root);
                    if (onlineSet != null) onlineSet.remove(x);
                }
            }
        }
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) ans[i] = result.get(i);
        return ans;
    }
}
}
