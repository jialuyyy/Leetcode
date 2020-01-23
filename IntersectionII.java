class IntersectionII {
    public int[] intersectionII(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return new int[]{};
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> ret = new ArrayList<>();
        for (int num : nums2) {
            if (map.get(num) != null && map.get(num) > 0) {
                ret.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        int[] res = new int[ret.size()];
        for (int i = 0; i < ret.size(); i++)
            res[i] = ret.get(i);
        return res;
        
    }
}


class IntersectionII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        int k = 0;
        
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                nums1[k++] = nums1[i++];
                j++;
            }
        }
        
        return Arrays.copyOf(nums1, k);
    }
}
