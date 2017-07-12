//very slow solution
//hashmap, key is the number of citation times and value is the number of papers that is citated more than or equal to key value
// for every citation number in the array, update the hashmap, for all the key less than current citation number , +1
//iterate from the last element of the map, because if there are many possible h index value, we need to pick the maximum
//Time Complexity: O(n * n), may need to do optimization

public class HIndex {
    public int hIndex(int[] citations) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int citation: citations) {
            for (int i = 0; i <= citation; i++) {
                if (map.get(i) == null) {
                    map.put(i, 0);
                }
                
                map.put(i, map.get(i) + 1);
            }
        }
        
        for (int i = map.size() - 1; i >= 0; i--) {
            if (map.get(i) >= i) {
                return i;
            }
        }
        
        return 0;
    }
}
