//Time Complexity: O(n)
//beats:12.00%
//Area = (right - left) * Math.min(height(right) - height(left));
//as the right and left pointer move closer, the (right-left) is decreasing, if we want to find the max value, we need to increase the
//Math.min(height(right) - height(left)), so we need to move the smaller height toward the higher height.
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while (left < right) {
            res = Math.max(res, (right - left) * Math.min(height[right], height[left]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return res;
    }
}
