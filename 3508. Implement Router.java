import java.util.*;

class Router {
    private int memoryLimit;
    private Queue<int[]> queue;
    private Set<String> seen;
    private Map<Integer, TreeMap<Integer, Integer>> destMap;
    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        this.queue = new LinkedList<>();
        this.seen = new HashSet<>();
        this.destMap = new HashMap<>();
    }
    public boolean addPacket(int source, int destination, int timestamp) {
        String key = source + "#" + destination + "#" + timestamp;
        if (seen.contains(key)) return false;
        if (queue.size() == memoryLimit) {
            int[] old = queue.poll();
            String oldKey = old[0] + "#" + old[1] + "#" + old[2];
            seen.remove(oldKey);
            TreeMap<Integer, Integer> tm = destMap.get(old[1]);
            decrement(tm, old[2]);
            if (tm.isEmpty()) destMap.remove(old[1]);
        }
        queue.offer(new int[]{source, destination, timestamp});
        seen.add(key);
        destMap.putIfAbsent(destination, new TreeMap<>());
        increment(destMap.get(destination), timestamp);
        return true;
    }
    public int[] forwardPacket() {
        if (queue.isEmpty()) return new int[]{};
        int[] pkt = queue.poll();
        String key = pkt[0] + "#" + pkt[1] + "#" + pkt[2];
        seen.remove(key);
        TreeMap<Integer, Integer> tm = destMap.get(pkt[1]);
        decrement(tm, pkt[2]);
        if (tm.isEmpty()) destMap.remove(pkt[1]);
        return pkt;
    }
    public int getCount(int destination, int startTime, int endTime) {
        if (!destMap.containsKey(destination)) return 0;
        TreeMap<Integer, Integer> tm = destMap.get(destination);
        int upToEnd = prefixSum(tm, endTime);
        int beforeStart = prefixSum(tm, startTime - 1);
        return upToEnd - beforeStart;
    }
    private void increment(TreeMap<Integer, Integer> tm, int timestamp) {
        int prev = tm.isEmpty() ? 0 : tm.lastEntry().getValue();
        tm.put(timestamp, tm.getOrDefault(timestamp, prev) + 1);
        
        Map.Entry<Integer, Integer> higher = tm.higherEntry(timestamp);
        while (higher != null) {
            tm.put(higher.getKey(), higher.getValue() + 1);
            higher = tm.higherEntry(higher.getKey());
        }
    }
    private void decrement(TreeMap<Integer, Integer> tm, int timestamp) {
        Map.Entry<Integer, Integer> entry = tm.ceilingEntry(timestamp);
        while (entry != null) {
            tm.put(entry.getKey(), entry.getValue() - 1);
            if (tm.get(entry.getKey()) == 0 && entry.getKey() == timestamp) {
                tm.remove(entry.getKey());
            }
            entry = tm.higherEntry(entry.getKey());
        }
    }

    private int prefixSum(TreeMap<Integer, Integer> tm, int time) {
        Map.Entry<Integer, Integer> entry = tm.floorEntry(time);
        return (entry == null ? 0 : entry.getValue());
    }
}
