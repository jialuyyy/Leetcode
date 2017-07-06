//primitive idea
//use a hashmap to maintain a key-value pair key is the number and value is the list of indexes of the number in the array
//when doing the pick operation, use math.random to get a random number between [0, list.size())
//Time limit exceed as too much extra space is used.

public class RandomPickIndex {
    Map<Integer, List<Integer>> map = null;
    public Solution(int[] nums) {
        map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], new ArrayList<Integer>());
            }
            map.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        List<Integer> indexList = map.get(target);
        int size = indexList.size();
        int random = (int) (Math.random() * size);
        
        return indexList.get(random);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */

//optimized solution, no need to use the hasmap to store the index of every element appearing in the array.
//use rand.nextInt(current total number of the target number) to get the random index from 0 to total, and total is excluded in the range
//so for the latest appearing element, the probability of selected it is 1/total, for the previous element, the total probability of 
//selecting them is 1 - 1/total and for each of them, the probability should be (1 - 1/total) * 1/(total - 1) is also 1/total.
//so there is no need to use extra space.

public class RandomPickIndex {
    int[] nums;
    Random rand;
    public Solution(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }
    
    public int pick(int target) {
        int total = 0;
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                //get an int in the range of [0, i), so for the latest appearing element, the probability for it to get selected
                //is 1/total, and for every previous element, the probability is equal
                int nextInt = rand.nextInt(++total);
                res = nextInt == 0 ? i : res;
            }
        }
        
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
