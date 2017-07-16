//use a hashmap to keep the key value pair key is the message and value is the timestamp, if the coming message is not in the hashmap
//put it into the hashmap; if it is in the hashmap, check whether the current timestamp and the existed timestamp is larger than or equal
//to 10, if it is , put the new timestamp into the hashmap and return true, else, return false.
//beats 40.91%
public class Logger {

    /** Initialize your data structure here. */
    Map<String, Integer> map = null;
    public Logger() {
        map = new HashMap<String, Integer>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (map.get(message) == null) {
            map.put(message, timestamp);
            return true;
        } else {
            if ((timestamp - map.get(message)) >= 10) {
                map.put(message, timestamp);
                return true;
            }
        }
        
        return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
