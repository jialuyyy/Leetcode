//beats 61.68%
//Time Complexity: all of the three operations are O(1)
//use a hashmap to maintain key-value pair (val, index in the array)
//when doing the remove operation. if the element is not the element, in order to make sure the time complexity is O(1), need to put the last
//element in the array list into the index of the value need to be removed, and then simply remove the last element and update the hashmap
//put the last element and its new index into the hashmap

import java.util.Random;

public class RandomizedSet {

    /** Initialize your data structure here. */
    private Map<Integer, Integer> map = null;
    private List<Integer> list = null;
    private Random random;
    public RandomizedSet() {
        map = new HashMap<Integer, Integer>();
        list = new ArrayList<Integer>();
        random = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.get(val) == null) {
            map.put(val, list.size());
            list.add(val);
            return true;
        }
        
        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.get(val) != null) {
            int index = map.get(val);
            //put the last element to the index of the removed value
            if (index != list.size() - 1) {
                int last = list.get(list.size() - 1);
                list.set(index, last);
                map.put(last, index);
            } 
            //remove the last element both from the hashmao and the array list
            map.remove(val);
            list.remove(list.size() - 1);
            return true;
        }
        
        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int size = map.size();
        //get the index of 0 -> size - 1
        int rand = random.nextInt(size);
        
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
