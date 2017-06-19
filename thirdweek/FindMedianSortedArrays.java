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


//find the kth element in two sorted arrays
//k = (nums1.length + nums2.length) / 2;
//beats 73.77%
//Time complexity: O(log(n))
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int k = nums1.length + nums2.length;
        if (k % 2 == 0) {
            return (findKthElement(k / 2, nums1, nums2, 0, 0) + findKthElement(k / 2 + 1, nums1, nums2, 0, 0)) / 2.0;
        }
        
        return findKthElement(k / 2 + 1, nums1, nums2, 0, 0);
    }
    
    private int findKthElement(int k, int[] nums1, int[] nums2, int h1, int h2) {
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
        
        //find k-2/k element in the remaining elements
        if (mid1 < mid2) {
            return findKthElement(k - k / 2, nums1, nums2, m1 + 1, h2);
        } else {
            return findKthElement(k - k / 2, nums1, nums2, h1, m2 + 1);
        }
        
    }
}
