//iterate over a hashmap is too slow
// so use a list to maintain the key of the hashmap
public class TwoSum {

    /** Initialize your data structure here. */
    private Map<Integer, Integer> map = null;
    private List<Integer> list = null;
    public TwoSum() {
        map = new HashMap<Integer, Integer>();
        list = new ArrayList<Integer>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        list.add(number);
        
        if (map.get(number) == null) {
            map.put(number, 0);
        }
        map.put(number, map.get(number) + 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int i = 0; i < list.size(); i++) {
            if (map.containsKey(value - list.get(i))) {
                if ((value - list.get(i) == list.get(i) && map.get(list.get(i)) >= 2) || (value - list.get(i) != list.get(i))) {
                    return true;
                }
            }
        }
        
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
