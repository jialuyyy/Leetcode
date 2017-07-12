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

//O(n) solution reading from discussion
//use a temp array to keep the number of papers for every times, times is from 0 to length of the paper, and if the citation times is larger
//then the total paper number, add the value to the last element of the array.
//iterate from the last element of the array, and if the total citation times is larger than current i, which means we find the h index value
// am not able to come up with this solution by myself
//beats 50%
public class Solution {
    public int hIndex(int[] citations) {
        
        int[] arrayTimes = new int[citations.length + 1];
        
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] > citations.length) {
                arrayTimes[citations.length]++;
            } else {
                arrayTimes[citations[i]]++;
            }
        }
        
        int cur = 0;
        int ret = 0;
        
        for (int i = citations.length; i >= 0; i--) {
            cur = cur + arrayTimes[i];
            
            if (cur >= i) {
                return i;
            }
        }
        
        return 0;
    }
}
