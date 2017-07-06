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
