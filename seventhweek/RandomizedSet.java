public class RandomizedSet {

    /** Initialize your data structure here. */
    List<Integer> list = null;
    //<key, value> <number, index in the list>
    Map<Integer, Integer> map = null;
    public RandomizedSet() {
        list = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.get(val) == null) {
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }
        
        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.get(val) == null) {
            return false;
        }
        
        int index = map.get(val);
        
        if (index != list.size() - 1) {
            int last = list.get(list.size() - 1);
            list.set(index, last);
            map.put(last, index);
        }
        
        list.remove(list.size() - 1);
        map.remove(val);
            
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        
        int rand = random.nextInt(list.size());
        
        return list.get(rand);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
