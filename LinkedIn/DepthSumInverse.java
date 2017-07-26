//get the level first
//then do the dfs to calculate the sum
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class DepthSumInverse {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        //get depth first
        
        int level = getLevel(nestedList);
        return helper(nestedList, level);
    }
    
    private int helper(List<NestedInteger> nestedList, int depth) {
        int ret = 0;
        for (int i = 0; i < nestedList.size(); i++) {
            NestedInteger cur = nestedList.get(i);
            
            if (cur.isInteger()) {
                ret += cur.getInteger() * depth;
            }
            
            else {
                ret += helper(cur.getList(), depth - 1);
            }
            
        }
        
        return ret;
    }
    
    private int getLevel(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < nestedList.size(); i++) {
            if (nestedList.get(i).isInteger()) {
                max = Math.max(max, 1);
            } else {
                max = Math.max(max, getLevel(nestedList.get(i).getList()) + 1);
            }
        }
        
        return max;
    }
}
