//dp use costs[n][3] as the two dimentional matrix to represent the total cost from 0 to n - 1 house
//and costs[n][0] denotes paint the current n - 1 house with red...
//result is the minimum value of cost[n - 1][0] cost[n - 1][1] cost[n - 1][2]
public class PaintHouseI {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        for (int i = 1; i < costs.length; i++) {
            costs[i][0] = costs[i][0] + Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i - 1][0], costs[i - 1][1]);
        }
        int n = costs.length;
        return Math.min(Math.min(costs[n - 1][0], costs[n - 1][1]), costs[n - 1][2]);
    }
}
