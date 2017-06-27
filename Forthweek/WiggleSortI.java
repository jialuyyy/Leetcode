//beats 67.38%
//iterate over the array and make swap operations based on the conditions.
public class WiggleSortI {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        
        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 1 && nums[i] < nums[i - 1]) {
                swap(nums, i, i - 1);
            } else if (i % 2 == 0 && nums[i] > nums[i - 1]) {
                swap(nums, i, i - 1);
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
