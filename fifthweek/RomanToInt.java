//use a hashmap to keep the key-value pair of the character to its int value
//iterate over the input string and if the current value less than the previous value, deduct the current value from the sum; else, add
//the current value to the sum
//return the result
//Space Complexity: O(1), as the length of the map won't change as the input size increases
//Time Compelxity: O(n), n is the length of the input string

public class RomanToInt {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    
        int sum = 0;
        sum += map.get(s.charAt(s.length() - 1));
        
        for (int i = s.length() - 2; i >= 0; i--) {
            char cur = s.charAt(i);
            char prev = s.charAt(i + 1);
            if (map.get(cur) < map.get(prev)) {
                sum -= map.get(cur);
            } else {
                sum += map.get(cur);
            }
        }
        
        return sum;
        
    }
}
