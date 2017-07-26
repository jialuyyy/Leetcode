/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class WeightDepthSum {
    private int depthSum = 0;
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        
        for (int i = 0; i < nestedList.size(); i++) {
            NestedInteger cur = nestedList.get(i);
            dfs(cur, 1);
        }
        

        return depthSum;
    }
    
    private void dfs(NestedInteger nestedInteger, int depth) {
        if (nestedInteger.isInteger()) {
            depthSum += nestedInteger.getInteger() * depth;
            return;
        }
        
        List<NestedInteger> cur = nestedInteger.getList();
        
        for (int i = 0; i < cur.size(); i++) {
            NestedInteger c = cur.get(i);
            dfs(c, 1 + depth);
        }
    }
}


/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    private int depthSum = 0;
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        
        return dfs(nestedList, 1);
    }
    
    private int dfs(List<NestedInteger> nestedList, int depth) {
        int ret = 0;
        
        for (int i = 0; i < nestedList.size(); i++) {
            ret += nestedList.get(i).isInteger() ? nestedList.get(i).getInteger() * depth : dfs(nestedList.get(i).getList(), depth + 1);
        }
        
        return ret;
    }
}
