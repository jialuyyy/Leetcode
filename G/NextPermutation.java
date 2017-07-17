//1,4,3,2
//find the first number that is less than its next element
//in this case, find 1
//then from the end, to find the element that is larger than current element, and swap them
//2,4,3,1
//reverse the elements from the pos + 1
//2,1,3,4

//3,2,4,1

public class nextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i + 1] > nums[i]) {
                for (int j = nums.length - 1; j > i; j--) {
                        if (nums[j] > nums[i]) {
                            swap(nums, i, j);
                            reverse(nums, i + 1, nums.length - 1);
                            break;
                        }
                }
                
                return;
            }
            
        }
        
        reverse(nums, 0, nums.length - 1);
    }
    
    
    private void swap (int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
