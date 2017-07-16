//use a inner iterator and an outer iterator to iterate over the 2D lists, always move the inner iterator to the non empty sub list

public class Vector2D implements Iterator<Integer> {
    
    private Iterator<List<Integer>> outer = null;
    private Iterator<Integer> inner = null;
    public Vector2D(List<List<Integer>> vec2d) {
        this.outer = vec2d.iterator();
    }

    @Override
    public Integer next() {
        
        return inner.next();
    }

    @Override
    public boolean hasNext() {
        //[[], [3]], use while, because some of the list may be empty, we need to iterate over the lists
        //to the one that contains elements in it.
        
        while ((inner == null || !inner.hasNext()) && outer.hasNext()) {
            inner = outer.next().iterator();
        }
        
        return inner != null && inner.hasNext();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
