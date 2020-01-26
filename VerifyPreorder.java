class VerifyPreorder {
    
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE;
        Deque<Integer> path = new ArrayDeque<>();
        for (int p : preorder) {
            if (p < low)
                return false;
            
            //on right tree
            while (!path.isEmpty() && p > path.peek()) {
                low = path.pop();
            }
            
            path.push(p);
        }
        
        return true;
    }
}
