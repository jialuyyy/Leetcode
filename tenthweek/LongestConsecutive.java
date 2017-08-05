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
