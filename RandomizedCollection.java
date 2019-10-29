class RandomizedCollection {
    
    /** Initialize your data structure here. */
    
    List<Integer> list;
    Map<Integer, Set<Integer>> map;
    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            map.get(val).add(list.size());
        } else {
            Set<Integer> set = new HashSet<>();
            set.add(list.size());
            map.put(val, set);
        }
        list.add(val);
        return map.get(val).size() == 1;
        
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (map.get(val) != null) {
            Set<Integer> set = map.get(val);
            int index = set.iterator().next();
            //have to remove first from the set, if add first then remove, it will remove twice
            
            set.remove(index);
            if (set.size() == 0) {
                map.remove(val);
            }
            
            int last = list.get(list.size() - 1);
            if (index != (list.size() - 1)) {
                list.set(index, last);
                map.get(last).add(index);
                map.get(last).remove(list.size() - 1);
            }
            
            
            list.remove(list.size() - 1);
            return true;
        } else {
            return false;
        }
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(new Random().nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
