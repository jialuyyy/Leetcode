/*0 -> 1, 2,3 
    
1 -> 0, 2
2 -> 0, 1, 3
3 -> 1, 2*/

/*
red - blue
 |     |
blue- red*/

/* 

/*  blue - red
     |      |
    red  - blue



*/

class IsBipartite {
    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0)
            return false;
        int[] colors = new int[graph.length];
        
        for(int i = 0; i < graph.length; i++) {
            if (colors[i] != 0)
                continue;
            Queue<Integer> q = new LinkedList<>();
            
            q.offer(i);
            colors[i] = 1;
            
            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int next : graph[cur]) {
                    if (colors[next] == 0) {
                        colors[next] = -colors[cur];
                        q.offer(next);
                    } else if (colors[next] != -colors[cur]){
                        return false;
                    }
                        
                } 
            }
        }
        
        return true;
        
    }
}
