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
