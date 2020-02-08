class MinCost {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0)
            return 0;
        
        int len = costs.length;
        
        for (int i = 1; i < len; i++) {
            //paint the (i + 1)th house red
            costs[i][0] = costs[i][0] + Math.min(costs[i - 1][1], costs[i - 1][2]);
                
            //paint the (i + 1)th house blue
            costs[i][1] = costs[i][1] + Math.min(costs[i - 1][0], costs[i - 1][2]);
                
            //paint the (i + 1)th house green
            costs[i][2] = costs[i][2] + Math.min(costs[i - 1][0], costs[i - 1][1]);     
        }
        
        return Math.min(Math.min(costs[len - 1][0], costs[len - 1][1]), costs[len - 1][2]);
        
    }
}
