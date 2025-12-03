import java.util.*;
class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(gain(b), gain(a))
        );
        for (int[] c : classes) {
            pq.add(c);
        }
        while (extraStudents-- > 0) {
            int[] c = pq.poll();
            c[0]++; 
            c[1]++;
            pq.add(c);
        }
        double sum = 0.0;
        for (int[] c : pq) {
            sum += (double) c[0] / c[1];
        }
        return sum / classes.length;
    }

    private double gain(int[] c) {
        double p = c[0], t = c[1];
        return (p + 1) / (t + 1) - p / t;
    }
}
