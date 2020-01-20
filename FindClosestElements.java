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


class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //find the first number >= target
        //left < x  right >= x
        if (arr == null || arr.length == 0)
            return null;
        
        int right = findUpperClosest(arr, x);
        int left = right - 1;
        
        List<Integer> ret = new ArrayList<>();
        
        for (int i = 0; i < k; i++) {
            if (isLeftCloser(arr, x, left, right)) {
                ret.add(arr[left]);
                left--;
            } else {
                ret.add(arr[right]);
                right++;
            }
        }
        Collections.sort(ret);
        return ret;
    }
    private boolean isLeftCloser(int[] arr, int x, int left, int right) {
        if (left < 0) {
            return false;
        }
        
        if (right >= arr.length) {
            return true;
        }
        
        
       return x - arr[left]  <= arr[right] - x;
       
    }
    private int findUpperClosest(int[] arr, int x) {
        int start = 0;
        int end = arr.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            
            if (arr[mid] > x) {
                end = mid;
            } else if (arr[mid] < x){
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (arr[start] >= x) {
            return start;
        }
        
        if (arr[end] >= x) {
            return end;
        }
        
        return arr.length;
            
    }
}
