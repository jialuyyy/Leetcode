//brute force O(n ^ 2), for every element, check the elements on the right to see how many elements are smaller than it
// merge sort O(nlog(n))
//when doing the merge sort, when the right value is less than the left value, which means we find a target for the left value, so increase
//the count for the left value, and add the right value into the list, else, add the count to the left elements's count and add the left 
//element into the list
// when done the sorting, traverse over the whole list and based on the index of each element, put the value into the corresponding 
//position

public class CountSmaller {
    class Element {
        int index;
        int num;
        int count;
        
        public Element(int index, int num, int count) {
            this.index = index;
            this.num = num;
            this.count = count;
        }
    }
    
    public List<Integer> countSmaller(int[] nums) {
        Integer[] tmp = new Integer[nums.length];
        
        if (nums == null || nums.length == 0) {
            return new ArrayList<Integer>();
        }
        List<Element> list = mergeSort(nums, 0, nums.length - 1);
        
        for (int i = 0; i < list.size(); i++) {
            Element e = list.get(i);
            tmp[e.index] = e.count;
        }
        
        return Arrays.asList(tmp);
    }
    
    private List<Element> mergeSort(int[] nums, int start, int end) {
        if (start == end) {
            Element e = new Element(start, nums[start], 0);
            List<Element> list = new ArrayList<Element>();
            list.add(e);
            return list;
        }
        
        int mid = start + (end - start) / 2;
        
        List<Element> left = mergeSort(nums, start, mid);
        List<Element> right = mergeSort(nums, mid + 1, end);
        
        return merge(left, right);
    }
    
    private List<Element> merge(List<Element> left, List<Element> right) {
        List<Element> list = new ArrayList<Element>();
        
        int curRight = 0;
        int curLeft = 0;
        int rightCount = 0;
        
        while (curRight < right.size() && curLeft < left.size()) {
            if (left.get(curLeft).num > right.get(curRight).num) {
                rightCount++;
                list.add(right.get(curRight));
                curRight++;
            } else {
                left.get(curLeft).count += rightCount;
                list.add(left.get(curLeft));
                curLeft++;
            }
        }
        
        while (curRight < right.size()) {
            list.add(right.get(curRight));
            curRight++;
        }
        
        while (curLeft < left.size()) {
            left.get(curLeft).count += rightCount;
            list.add(left.get(curLeft));
            curLeft++;
        }
        
        return list;
            
    }
}
