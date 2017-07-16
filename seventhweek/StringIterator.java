//"L1e2t1C1o1d1e1"
//we need to use a data structure to denote the character with its appearing times.
//if we use hashmap, the sequence is not able to maintain, so we need to use a linear data structure to maintain the sequence of 
//the characters. we keep a pair class in the queue Pair<char, number>, in the constructor method, we need to construct the queue
//iterator over the compressed string and push every character pair into the queue.
//if the queue is empty, which means there is no characters left
//for the next() method, every time peek the head element, and decrease its count, when the count reaches 0, poll it from the queue.
//Time Complexity: constructor: O(n); next(): O(1); hasNext(): O(1)
//Space Complexity: O(n)
//beats 43.29%
public class StringIterator {
    
    class Pair {
        char c;
        int number;
        
        public Pair (char c, int number) {
            this.c = c;
            this.number = number;
        }
    }
    
    private Deque<Pair> queue = null;
    public StringIterator(String compressedString) {
        queue = new ArrayDeque<Pair>();
        int i = 0;
        
        while (i < compressedString.length()) {
            int j = i + 1;
            
            while (j < compressedString.length() - 1 && compressedString.charAt(j + 1) <= '9' && compressedString.charAt(j + 1) >= '0') {
                j++;
            }
            
            Pair  p = new Pair(compressedString.charAt(i), Integer.parseInt(compressedString.substring(i + 1, j + 1)));
            queue.offer(p);
            
            i = j + 1;
        }
    }
    
    public char next() {
        if (!hasNext()) {
            return ' ';
        }
        Pair p = queue.peek();
        char cur = p.c;
        int  count =  p.number - 1;
        
        p.number = count;
        if (count == 0) {
            queue.poll();
        }
        
        return cur;
    }
    
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
