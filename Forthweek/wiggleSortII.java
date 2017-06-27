//use extra space and arrays.sort()
//Time Complexity: O(nlog(n))
//Space Complexity: O(n)
//beats 78%, not satisfy the problem requirements
//maintain some pointers, then iterate over the tmp array and put one small, one large element respectively into the original array

public class wiggleSortII {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        
        Arrays.sort(nums);
        
        int[] numsTmp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsTmp[i] = nums[i];
        }
        
        int mid = (0 + nums.length - 1) / 2 + 1;
        
        int i = mid - 1;
        int k = 0;
        int j = nums.length - 1;
        
        while (i >= 0 && j >= mid) {
            nums[k++] = numsTmp[i--];
            nums[k++] = numsTmp[j--];
        }
        
        if (i >= 0) {
            nums[nums.length - 1] = numsTmp[i];
        }
    }
}
