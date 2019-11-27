class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        
        List<Integer> ret = new ArrayList<>();
        for (int num : nums2) {
            if (set.contains(num) && !ret.contains(num)) {
                ret.add(num);
            }
        }
        
        int[] retArr = new int[ret.size()];
        
        for (int i = 0; i < ret.size(); i++) {
            retArr[i] = ret.get(i);
        }
        
        return retArr;
    }
}


class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        
        Set<Integer> intersect = new HashSet<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                intersect.add(num);
            }
        }
        
        int[] ret = new int[intersect.size()];
        int idx = 0;
        for (Integer i : intersect) {
            ret[idx++] = i;
        }
        
        return ret;
    }
}
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i = 0;
        int j = 0;
        
        Set<Integer> set = new HashSet<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                set.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        } 
        
        int[] ret = new int[set.size()];
        int idx = 0;
        for (Integer num : set) {
            ret[idx++] = num;
        }
        
        return ret;
    }
}
