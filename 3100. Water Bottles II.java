class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int drunk = numBottles;
        int full = numBottles;
        int empty = 0;

        while (true) {
            empty += full;
            full = 0;

            if (empty >= numExchange) {
                empty -= numExchange;
                full = 1;
                drunk += 1;
                numExchange++;
            } else {
                break;
            }
        }
        return drunk;
    }
}
