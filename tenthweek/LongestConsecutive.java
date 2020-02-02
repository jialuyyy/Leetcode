public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        Set<Integer> set = new HashSet<Integer>();
        
        for (int num: nums) {
            set.add(num);
        }
        
        int max = Integer.MIN_VALUE;
        for (int num: nums) {
            int down = num - 1;
            while (set.contains(down)) {
                set.remove(down);
                down--;
            }
            
            int up = num + 1;
            while (set.contains(up)) {
                set.remove(up);
                up++;
            }
            
            max = Math.max(up - down - 1, max);
        }
        
        return max == Integer.MIN_VALUE? 1: max;
    }
}

//sort firstly
//1,2,3,4 100 ,200
//special case duplciate value
//[0,1,1,2]
//O(nlog(n))
class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        
        //O(nlog(n))
        Arrays.sort(nums);
        
        int maxLen = 1;
        int currentLen = 1;
        
        for (int i = 1; i < nums.length; i++) {
            //skip the same value
            if (nums[i] != nums[i - 1]) {
                if (nums[i] - nums[i - 1] == 1) {
                    currentLen += 1;
                } else {
                    maxLen = Math.max(currentLen, maxLen);
                    currentLen = 1;
                }
                
            }
        }
        
        return Math.max(maxLen, currentLen);
    }
}
