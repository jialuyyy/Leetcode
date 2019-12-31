class FindClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ret = new ArrayList<>();
        if (arr == null || arr.length == 0)
            return ret;
        
        int start = 0;
        int end = arr.length - k;
        
        while (start < end) {
            int mid = start + (end - start) / 2;
            
            if (x - arr[mid] > arr[mid + k] - x)
                start = mid + 1;
            else
                end = mid;
        }
        
        for (int i = start; i < k + start; i++) {
            ret.add(arr[i]);
        }
        
        return ret;
    }
}
