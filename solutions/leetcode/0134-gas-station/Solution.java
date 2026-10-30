class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, tank = 0, s = 0;
        for (int i = 0; i < gas.length; i++) {
            int net = gas[i] - cost[i];
            total += net;
            tank += net;
            if (tank < 0) {
                s = i + 1;
                tank = 0;
            }
        }
        return total < 0 ? -1 : s;
    }
}
