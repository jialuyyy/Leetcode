class SlidingPuzzle {
    private int[] d = {-1, 1, 3, -3};
    public int slidingPuzzle(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return -1;
        
        int rows = board.length;
        int cols = board[0].length;
        
        String begin = "";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                begin += board[i][j];
            }
        }
        
        String target = "123450";
        Deque<String> queue = new ArrayDeque<>();
        queue.offer(begin);
        
        Set<String> visited = new HashSet<>();
        visited.add(begin);
        
        int level = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(target)) {
                    return level;
                }
                
                int zeroIndex = cur.indexOf("0");
                for (int j = 0; j < 4; j++) {
                    int swapIndex = zeroIndex + d[j];
                    
                    if (swapIndex >= 0 && swapIndex < 6) {
                        //edge cases have to be considered
                        //123
                        //045   -1 will be invalid becuase 3 is not at the 
                        //same row as 0
                        int curRow = zeroIndex / cols;
                        int curCol = zeroIndex % cols;
                        
                        int nextRow = swapIndex / cols;
                        int nextCol = swapIndex % cols;
                        
                        if (j == 0 && nextRow != curRow)
                            continue;
                        
                        if (j == 1 && nextRow != curRow)
                            continue;
                        String next = getNext(swapIndex, zeroIndex, cur);
                        if (!visited.contains(next)) {
                            queue.offer(next);
                            visited.add(next);
                        }
                    }
                }
                
            }
            level++;
        }
        
        return -1;
    }
    
    private String getNext(int i, int j, String cur) {
        char[] ch = cur.toCharArray();
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        return String.valueOf(ch);
    }
}
