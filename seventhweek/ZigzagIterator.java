//List has its iterator
//beats 70.98%
//use the list iterator of the two lists, if i1.hasNext(), swap the two iterator and return i2.next(); else, which means i1 already reached 
//to the end,so get the i2.next().
public class ZigzagIterator {
    private Iterator<Integer> i1 = null;
    private Iterator<Integer> i2 = null;
    private Iterator<Integer> tmp = null;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        i1 = v1.iterator();
        i2 = v2.iterator();
    }

    public int next() {
        if (i1.hasNext()) {
            tmp = i1;
            i1 = i2;
            i2 = tmp;
        }
        
        return i2.next();
    }
    

    public boolean hasNext() {
        return i1.hasNext() || i2.hasNext();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
