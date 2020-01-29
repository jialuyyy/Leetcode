class FindCircleNum {
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0)
            return 0;
        
        int rows = M.length;
        int cols = M[0].length;
        
        int count = 0;
        int[] visited = new int[M.length];
        
        for (int i = 0; i < rows; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }

        return count;
    }
    
    private void dfs(int[][] M ,int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            } 
        }
    }
}
class FindCircleNum {
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0)
            return 0;
        
        int count = 0;
        int[] visited = new int[M.length];
        Deque<Integer> queue = new ArrayDeque<>();
        
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                queue.offer(i);
                visited[i] = 1;
                while (!queue.isEmpty()) {
                    int cur = queue.poll();
                    
                    
                    for (int j = 0; j < M.length; j++) {
                        if (M[cur][j] == 1 && visited[j] == 0) {
                            queue.offer(j);
                            visited[cur] = 1;
                        }
                    }
                }
                count++;
            }
        }

        return count;
    }
    

}
