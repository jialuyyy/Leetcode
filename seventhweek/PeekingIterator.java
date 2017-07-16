// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

//the peek() method will get the next element but will not move the pointer, it just look at the next element, so we need to maintain a 
//variable used to keep the next element. and update it in the next() element, hasNext() will return true, if the varaible is not null.
class PeekingIterator implements Iterator<Integer> {
    
    private Integer tmp = null;
    private Iterator<Integer> i;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.i = iterator;
        if (i.hasNext())
            tmp = i.next();
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return tmp;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer res = tmp;
        
        tmp = i.hasNext() ? i.next() : null;
        return res;
	}

	@Override
	public boolean hasNext() {
	    return tmp != null;
	}
}
