//1, 2, 4, 8
//dp[i] denotes the size of the largest subset ending in index i
//dp[0] = 1 [1]
//dp[1] = 2 [1, 2]
//dp[2] = 3 [1, 2, 4]
//dp[3] = 4 [1, 2, 4, 8]


//1, 5, 9 ,10

//dp[0] = 1; [1]
//dp[1] = 2; [1, 5]
//dp[2] = 2; [1, 9]
//dp[3] = 3; [1, 5, 10]

//In order to populate the result in the end, need to keep the parent index of every elementfor example, for element 10, the parent 
//index should be 1.

public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return ret;
        }
    
        /*Input:
         [3,4,16,8]
         Output:
         [4,16]
          Expected:
         [4,8,16]*/
//parent [-1 0 2]
        Arrays.sort(nums);
        int[] parent = new int[nums.length];
        Arrays.fill(parent, -1);
        int[] dp = new int[nums.length];
        
        dp[0] = 1;
        int maxSize = 1;
        int lastIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                
                if (nums[i] % nums[j] == 0) {
                    //更新dp[i] and parent[i]
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        parent[i] = j;
                    }
                }
                
            }
            
            //update maxsize and lastIndex
            if (maxSize < dp[i]) {
                maxSize = dp[i];
                lastIndex = i;
            }
        }
        
        while (lastIndex >= 0) {
            ret.add(0, nums[lastIndex]);
            lastIndex = parent[lastIndex];
        }
        
        return ret;
    }
}
