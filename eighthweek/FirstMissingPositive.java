//[3,4,-1,1]
//[1, -1, 3, 4]
//swap to put the element at the correct pos
//then iterate over the array to find the one that is not at the correct pos
// number i should be at the postion i - 1
//constant space
//Time Complexity: two pass iteration, O(n)
//beats 48%
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if (nums == null) {
            return 0;
        }
        
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1])
                swap(nums, i, nums[i] - 1);
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        
        return nums.length + 1;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
