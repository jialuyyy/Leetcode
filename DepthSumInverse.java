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
class DepthSumInverse {
    private int ans = 0;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) 
            return 0;
        int h = helper(nestedList);
        int res = getSum(nestedList, h);
        
        return res;
       
    }
    
    private int getSum(List<NestedInteger> nestedList, int level) {
        int sum = 0;
        for (int i = 0; i < nestedList.size(); i++) {
            NestedInteger nestedInteger = nestedList.get(i);
            
            if (nestedInteger.getInteger() != null) {
                sum += nestedInteger.getInteger() * level;
            } else {
                sum += getSum(nestedInteger.getList(), level - 1);
            }
        }
        
        return sum;
    }
    
    private int helper(List<NestedInteger> l) {
        if (l == null || l.size() == 0)
            return 0;
        
        int max = 0;
        for (NestedInteger n : l) {
            if (n.isInteger())
                max = Math.max(max, 1);
            else
                max = Math.max(max, helper(n.getList()) + 1);
        }
        
        return max;
    }
}
