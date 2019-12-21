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
