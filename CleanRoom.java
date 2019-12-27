/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */
class CleanRoom {
    public void cleanRoom(Robot robot) {
        Set<String> visited = new HashSet<>();
        backtracking(robot, visited, 0, 0, 0);
    }
    
    int[][] dir = {{1, 0}, {0, 1}, {-1, 0},{0, -1}};
    
    private void backtracking(Robot robot, Set<String> visited, int x, int y, int arrow) {
        String path = x + "-" + y;
        if (visited.contains(path))
            return;
        visited.add(path);
        robot.clean();
        
        for (int i = 0; i < 4; i++) {
            if (robot.move()) {
                int index_x = x + dir[arrow][0];
                int index_y = y + dir[arrow][1];
                
                backtracking(robot, visited, index_x, index_y, arrow);
                
                robot.turnLeft();
                robot.turnLeft();
                robot.move();
                robot.turnRight();
                robot.turnRight();
                
            }
            
            robot.turnRight();
            arrow = (arrow + 1) % 4;
        }
        
    }
}
