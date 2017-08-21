//难题，得再做
//用max heap维护高度
//如果是起始点，加入max heap, 并且如果当前高度大于栈顶高度则加入结果；
//如果是结束点，首先删除栈中高度，如果棧空，说明当前为最后一个结束点，把最后一个点加入结果；如果棧不为空，比较当前高度和栈顶高度，如果大于栈顶高度
//将当前坐标与栈顶高度加入结果。

class Skyline {
    
    class Edge {
        int x;
        int height;
        boolean isStart;
        
        public Edge(int x, int height, boolean isStart) {
            this.x = x;
            this.height = height;
            this.isStart = isStart;
        }
    }
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> ret = new ArrayList<int[]>();
        if (buildings == null || buildings.length == 0) {
            return ret;
        }
        
        List<Edge> list = new ArrayList<Edge>();
        
        for (int[] building : buildings) {
            Edge startEdge = new Edge(building[0], building[2], true);
            list.add(startEdge);
            
            Edge endEdge = new Edge(building[1], building[2], false);
            list.add(endEdge);
        }
        
        Collections.sort(list, new Comparator<Edge>(){
            public int compare(Edge e1, Edge e2) {
                if (e1.x != e2.x) {
                    return e1.x - e2.x;
                //高的在前
                } else if (e1.isStart && e2.isStart) {
                    return e2.height - e1.height;
                //矮的在前
                } else if (!e1.isStart && !e2.isStart) {
                    return e1.height - e2.height;
                //结束在前
                } else {
                    return e1.isStart? -1 : 1;
                }
            }
        });
        
        Queue<Integer> queue = new PriorityQueue<Integer>(buildings.length, Collections.reverseOrder());
        
        for (Edge edge: list) {
            if (edge.isStart) {
                if (queue.isEmpty() || edge.height > queue.peek()) {
                    ret.add(new int[]{edge.x, edge.height});
                }
                queue.offer(edge.height);
            } else {
                queue.remove(edge.height);
                
                if (queue.isEmpty()) {
                    ret.add(new int[]{edge.x, 0});
                } else if (edge.height > queue.peek()){
                    ret.add(new int[]{edge.x, queue.peek()});
                }
                
            }
        }
        
        return ret;
    }
}
