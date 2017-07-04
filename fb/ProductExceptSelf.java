public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] ret = new int[nums.length];
        ret[0] = 1;
        //get the product of the values before nums[i]
        for (int i = 1; i < nums.length; i++) {
            ret[i] = ret[i - 1] * nums[i - 1];
        }
        
        //get the product of the values after nums[i]
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ret[i] = ret[i] * right;
            right = right * nums[i];
        }
        
        return ret;
    }
}
