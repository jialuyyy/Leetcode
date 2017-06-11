//beats: 48.50%
//iterate over the string array and every time create a string that is the alphabetical order of the characters in the string
//use a hashmap to store the key-value pair in which key is the new String created using the alphebatical order and value is the list of the 
//strings
//Time Complexity: nklog(k), n is the length of the whole array and k is the average length of each string.
//Space Complexity: O(n)
public class GroupAnagrams {
    public List<List<String>>  groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<List<String>>();
        if (strs == null || strs.length == 0) {
            return ret;
        }
        
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str: strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            
            if (!map.containsKey(key)) 
                map.put(key, new ArrayList<String>());
            
            map.get(key).add(str);
        }
        
        for (List<String> val : map.values()) {
            ret.add(val);
        }
        
        return ret;
    }
}
