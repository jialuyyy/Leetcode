class FindCheapestPrice {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();
        
        //map => {flightsrc, {flightdst, price}}
        for (int[] flight : flights) {
            if (!prices.containsKey(flight[0]))
                prices.put(flight[0], new HashMap<>());
            
            prices.get(flight[0]).put(flight[1], flight[2]);
        }
        
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        queue.offer(new int[]{0, src, K + 1});
        
        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            int price = top[0];
            int city = top[1];
            int stops = top[2];
            
            if (dst == city)
                return price;
            
            if (stops > 0) {
                Map<Integer, Integer> neighbors = prices.getOrDefault(city, new HashMap<>());
                for (int neighbor : neighbors.keySet()) {
                    queue.offer(new int[]{price + neighbors.get(neighbor), neighbor, stops - 1});
                }
            }
        }
        
        return -1;
    }
}
