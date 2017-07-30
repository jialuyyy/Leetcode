public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) {
            return 0.0;
        }
        
        int totalLen = nums1.length + nums2.length;
        
        if (totalLen % 2 == 0) {
            return (findMedian(nums1, nums2, 0, 0, totalLen / 2) + findMedian(nums1, nums2, 0, 0, totalLen / 2 + 1)) / 2.0;
        } else {
            return findMedian(nums1, nums2, 0, 0, totalLen / 2 + 1);
        }
    }
    
    private int findMedian(int[] nums1, int[] nums2, int h1, int h2, int k) {
        if (h1 >= nums1.length) {
            return nums2[h2 + k - 1];
        }
        
        if (h2 >= nums2.length) {
            return nums1[h1 + k - 1];
        }
        
        if (k == 1) {
            return Math.min(nums1[h1], nums2[h2]);
        }
        
        int m1 = h1 + k / 2 - 1;
        int m2 = h2 + k / 2 - 1;
        
        int mid1 = m1 < nums1.length ? nums1[m1] : Integer.MAX_VALUE;
        int mid2 = m2 < nums2.length ? nums2[m2] : Integer.MAX_VALUE;
        
        if (mid1 < mid2) {
            return findMedian(nums1, nums2, m1 + 1, h2, k - k / 2);
            
        } else {
            return findMedian(nums1, nums2, h1, m2 + 1, k - k / 2);
        }
    }
}
