public class FindMaximumXOR {
    class TrieNode {
        //0 or 1
        TrieNode[] arr = new TrieNode[2];
    }
    public int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        TrieNode root = new TrieNode();
        
        for (int num: nums) {
            TrieNode cur = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >>> i) & 1;
                
                if (cur.arr[bit] == null) {
                    cur.arr[bit] = new TrieNode();
                }
                
                cur = cur.arr[bit];
            }
        }
        
        int max = Integer.MIN_VALUE;
        
        for (int num: nums) {
            TrieNode cur = root;
            int curSum = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >>> i) & 1;
                if (cur.arr[bit ^ 1] != null) {
                    curSum += (1 << i);
                    cur = cur.arr[bit ^ 1];
                } else {
                    cur = cur.arr[bit];
                }
            }
            
            max = Math.max(max, curSum);
        }
        
        return max;
    }
}
