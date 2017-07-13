//use linkedhashset to improve the performance
public class PhoneDirectory {

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    private Set<Integer> set;
    public PhoneDirectory(int maxNumbers) {
        set = new LinkedHashSet<Integer>();
        for (int i = 0; i < maxNumbers; i++) {
            set.add(i);
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (set.isEmpty()) {
            return -1;
        }
        
        Iterator it = set.iterator();
        int val = (int) it.next();
        set.remove(val);
        return val;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return set.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        set.add(number);
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */
