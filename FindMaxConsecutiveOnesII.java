class FindMaxConsecutiveOnesII {
    public int findMaxConsecutiveOnesII(int[] nums) {
        int l = 0;
        int h = 0;
        int zeroCount = 0;
        int max = 0;
        int k = 1;
        for (; h < nums.length; h++) {
            if (nums[h] == 0) {
                zeroCount++;
            }
            
            while (zeroCount > k) {
                if (nums[l++] == 0)
                    zeroCount--;
            }
            
            max = Math.max(max, h - l + 1);
        }
        
        return max;
    }
}

class FindMaxConsecutiveOnesII {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int k = 1;
        Deque<Integer> queue = new ArrayDeque<>();
        
        for (int l = 0, h = 0; h < nums.length; h++) {
            if (nums[h] == 0) {
                queue.offer(h);
            }
            
            //only need to keep the index of num[index] = 0
            //instead of keep all of the records
            if (queue.size() > k) {
                l = queue.poll() + 1;
            }
            
            max = Math.max(max, h - l + 1);
        }  
        
        return max;
    }
}
