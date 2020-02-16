class Maze {
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, -1, 1};
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || maze[0].length == 0)
            return false;
        //keep track of the new starting point, becaue the ball will only stop when hitting the wall
        boolean[][] starting = new boolean[maze.length][maze[0].length];
        return dfs(maze, starting, start, destination);
    }
    
    private boolean dfs(int[][] maze, boolean[][] starting, int[] start, int[] destination) {
        //the starting point is already visited so return false
        if (starting[start[0]][start[1]])
            return false;
        if (start[0] == destination[0] && start[1] == destination[1])
            return true;
        
        starting[start[0]][start[1]] = true;
        
        //four directions
        for (int i = 0; i < 4; i++) {
            
            int[] newStart = roll(maze, start[0], start[1], dx[i], dy[i]);
            if(dfs(maze, starting, newStart, destination))
                return true;
        }
        
        return false;
        
    }
    
    private int[] roll(int[][] maze, int row, int col, int rowDir, int colDir) {
        while (canRoll(maze, row + rowDir, col + colDir)) {
            row += rowDir;
            col += colDir;
        }
        
        return new int[]{row, col};
    }
    
    private boolean canRoll(int[][] maze, int row, int col) {
        if (row >= maze.length || row < 0 || col >= maze[0].length || col < 0)
            return false;
        
        return maze[row][col] != 1;
    }
}

class Solution {
    private int[] dx = {0, 0, -1, 1};
    private int[] dy = {-1, 1, 0, 0};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || maze[0].length == 0)
            return false;
        
        if (start[0] == destination[0] && start[1] == destination[1])
            return true;
        
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        
        Deque<int[]> queue = new ArrayDeque<>();
        
        queue.offer(new int[]{start[0], start[1]});
        visited[start[0]][start[1]] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            if (cur[0] == destination[0] && cur[1] == destination[1])
                return true;
            
            for (int k = 0; k < 4; k++) {
                int index_x = cur[0] + dx[k];
                int index_y = cur[1] + dy[k];
                
                while (index_x >= 0 && index_x < maze.length && index_y >= 0 && index_y < maze[0].length && maze[index_x][index_y] != 1) {
                    index_x += dx[k];
                    index_y += dy[k];
                }
                index_x -= dx[k];
                index_y -= dy[k];
                
                if (!visited[index_x][index_y]) {
                    queue.offer(new int[]{index_x, index_y});
                    visited[index_x][index_y] = true;
                }
            }
        }
        
        return false;
        
    }
}
