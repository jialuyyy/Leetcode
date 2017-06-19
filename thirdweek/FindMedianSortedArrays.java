//Time Complexity: O(n), n is the total length of two arrays
//Space Complexity: O(n)
//Time limit exceed

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums3 = new int[nums1.length + nums2.length];
        
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                nums3[k++] = nums1[i++];
            } else {
                nums3[k++] = nums2[j++];
            }
        }
        
        while (i < nums1.length) {
            nums3[k++] = nums1[i++];
        }
        
        while (j < nums2.length) {
            nums3[k++] = nums2[j++];
        }
        
        if (k % 2 == 0) {
            return (nums3[k/2] + nums3[k/2 - 1]) / 2.0;
        } else {
            return (double)nums3[k/2];
        }
    }
}
