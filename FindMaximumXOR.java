class FindMaximumXOR {
    class TrieNode {
        TrieNode one;
        TrieNode zero;
    }
    public int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        
        TrieNode root = new TrieNode();
        
        for (int i : nums) {
            TrieNode node = root;
            for (int j = 31; j >= 0; j--) {
                int bit = (i >> j) & 1;
                if (bit == 1) {
                    if (node.one == null) {
                        node.one = new TrieNode();
                    }
                    node = node.one;
                } else {
                    if (node.zero == null) {
                        node.zero = new TrieNode();
                    }
                    
                    node = node.zero;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        
        for (int i : nums) {
            TrieNode node = root;
            int XOR = 0;
            
            for (int j = 31; j >= 0; j--) {
                int bit = (i >> j) & 1;
                if (bit == 1) {
                    if (node.zero != null) {
                        node = node.zero;
                        XOR += 1 << j;
                    } else {
                        node = node.one;
                        XOR += 0 << j;
                    }
                } else {
                    if (node.one != null) {
                        node = node.one;
                        XOR += 1 << j;
                    } else {
                        node = node.zero;
                        XOR += 0 << j;
                    }
                }
            }
            max = max > XOR ? max : XOR;
        }
        
        return max;
    }
}
