class RangeModule {

    
/*addRange(10, 20): null
removeRange(14, 16): null
queryRange(10, 14): true (Every number in [10, 14) is being tracked)
queryRange(13, 15): false (Numbers like 14, 14.03, 14.17 in [13, 15) are not being tracked)
queryRange(16, 17): true (The number 16 in [16, 17) is still being tracked, despite the remove operation)*/
    class Interval implements Comparable<Interval> {
        int left;
        int right;
        
        public Interval(int left, int right) {
            this.left = left;
            this.right = right;
        }
        
        public int compareTo(Interval that) {
            if (this.right == that.right)
                return this.left - that.left;
            return this.right - that.right;
        }
    }
    
    TreeSet<Interval> ranges;
    
    public RangeModule() {
        ranges = new TreeSet<>();
    }
    
    public void addRange(int left, int right) {
        //all the intervals greater than the current one
        Iterator<Interval> itr = ranges.tailSet(new Interval(0, left - 1)).iterator();
        while(itr.hasNext()) {
            Interval iv = itr.next();
            if (right < iv.left)
                break;
            left = Math.min(left, iv.left);
            right = Math.max(right, iv.right);
            itr.remove();
        }
        
        ranges.add(new Interval(left, right));
    }
    
    public boolean queryRange(int left, int right) {
        //get the least element that is greater than 0, left
        Interval iv = ranges.higher(new Interval(0, left));
        return (iv != null && iv.left <= left && right <= iv.right);
        
    }
    
    public void removeRange(int left, int right) {
        Iterator<Interval> itr = ranges.tailSet(new Interval(0, left)).iterator();
        List<Interval> todo = new ArrayList<>();
        while(itr.hasNext()) {
            Interval iv = itr.next();
            if (right < iv.left)
                break;
            if (iv.left < left)
                todo.add(new Interval(iv.left, left));
            if (right < iv.right)
                todo.add(new Interval(right, iv.right));
            itr.remove();
        }
        for (Interval iv : todo)
            ranges.add(iv);
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
