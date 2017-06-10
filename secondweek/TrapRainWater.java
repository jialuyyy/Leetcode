//smaller height moves toward higher height
//Time Complexity: O(n)
public class TrapRainWater {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        
        int left = 0;
        int right = height.length - 1;
        int leftHeight = height[left];
        int rightHeight = height[right];
        int res = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                left++;
                if (leftHeight < height[left]) {
                    leftHeight = height[left];
                } else {
                    res += leftHeight - height[left];
                }
            } else {
                right--;
                if (rightHeight < height[right]) {
                    rightHeight = height[right];
                } else {
                    res += rightHeight - height[right];
                }
            }
        }
        
        return res;
    }
}
