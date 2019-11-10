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

//1 2 3
//1 3 2
//2 1 3
//2 3 1 
//3 1 2 
//3 2 1


// 1 2 3 4
// 1 2 4 3
// 1 3 2 4
// 1 3 4 2
// 1 4 2 3
// 1 4 3 2
// 2 1 3 4
// 2 1 4 3
// 2 3 1 4
// 2 3 4 1
// 2 4 1 3
// 2 4 3 1

//scan from the end
//find the first element that is smaller than its next element
//find the first element that is larger than the element found in first step
//swap the two elements
//reverse the elements from i + 1
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        
        int i = nums.length - 2;
        
        //
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        
        if (i >= 0) {
            int j = nums.length - 1;
            //find the first element that is larger than current element
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            
            swap(i, j, nums);
        }
        
        //if the array is decreasing 
        //just reverse
        //4321 -> 1234
        reverse(nums, i + 1, nums.length - 1);
    }
    
    private void reverse(int[] nums, int start, int end) {
        int i = start;
        int j = end;
        
        while (i < j) {
            swap(i, j, nums);
            i++;
            j--;
        }
    }
    
    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
