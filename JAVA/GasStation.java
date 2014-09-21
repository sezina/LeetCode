public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int index = 0, tank = 0, totalGas = 0, totalCost = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i];
            if (tank < 0) {
                index = i + 1;
                tank = 0;
            }
        }
        if (totalCost > totalGas || index == gas.length) return -1;
        return index;
    }
}