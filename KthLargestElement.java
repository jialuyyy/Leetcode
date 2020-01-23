//use a smalllest heap
//Time Complexity : O(Nlog(K))
//K is the size of the heap and N is the total number of the elements in the array
class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        //small priority queue
        Queue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2) {
                return i1 - i2;
            }
        });
        
        //nlog(k)
        //if using large priority queue, time complexity should be nlog(n)
        for (int i = 0; i < nums.length; i++) {
            if (pq.size() < k) {
                pq.offer(nums[i]);
            } else {
                if (pq.peek() < nums[i]) {
                    pq.poll();
                    pq.offer(nums[i]);
                }
            }
        }
        
        return pq.poll();
    }
}

class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
        
        return helper(nums, 0, nums.length - 1, nums.length - k);
    }
    
    private int helper(int[] nums, int start, int end, int k) {
        
        
        while (start < end) {
            int p = partition(nums, start, end);
            if (p < k) {
                start = p + 1;
            } else if (p > k) {
                end = p - 1;
            } else {
                return nums[p];
            }
        }
        
        
        return nums[k];
    }
    
    private int partition(int[] nums, int start, int end) {
        int low = start;
        int high = end + 1;
        
        int pivot = nums[start];
        
        while (true) {
            while (nums[++low] <= pivot) {
                if (low >= end) {
                    break;
                }
            }
            
            while (nums[--high] >= pivot) {
                if (high <= start) {
                    break;
                }
            }
            
            if (low >= high) {
                break;
            }
            
            swap(nums, low, high);
        }
        
        swap(nums, high, start);
        
        return high;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
