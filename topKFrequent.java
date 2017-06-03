/*Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note: 
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.*/

//beats 46.01%
//thoughts
//1.use a hashmap to store the <number, times> pair
//2.use a priority queue to store Pair objects which represents the <key,value> pair of the hashMap. The sequence should be the 
//descending order of the values.
//3.pop the k Pairs from the queue and add the key value into the result list.

//Time Complexity: 
//O(n):iterate over the nums array to put them into the hashMap , n is the length of the array
//O(nlog(k)): priorityQueue

public class Solution {
    class Pair {
        int key;
        int val;
        
        public Pair (int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ret = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return ret;
        }
        
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int num: nums) {
            if (hashMap.get(num) != null) {
                hashMap.put(num, hashMap.get(num) + 1);
            } else {
                hashMap.put(num, 1);
            }
        }
        
        Queue<Pair> pq = new PriorityQueue<Pair>(k, new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2) {
                return p2.val - p1.val;
            }
        });
        
        for (Map.Entry<Integer, Integer> entry: hashMap.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            
            Pair pair = new Pair(key, val);
            pq.offer(pair);
        }
        
        for (int i = 0; i < k; i++) {
            Pair p = pq.poll();
            ret.add(p.key);
        }
        
        return ret;
    }
}

//beats 74.96%
//bucket sort method from the leetcode discussion
//1.use a hashmap to maintain the number and its frequency.
//2.create a list array and its index is corresponding to the frequency. put the keys into the corresponding list according to its frequency.
//Time Complexity: O(n)
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ret = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return ret;
        }
        
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int num: nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        
        List[] buckets = new List[nums.length + 1];
        
        for (int key: hashMap.keySet()) {
            int frequency = hashMap.get(key);
            
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<Integer>();
            }
            
            buckets[frequency].add(key);
        }
        
        for (int i = buckets.length - 1; i >= 0 && ret.size() < k; i--) {
            if (buckets[i] != null)
                ret.addAll(buckets[i]);
        }
        
        return ret.subList(0, k);
    }
}
