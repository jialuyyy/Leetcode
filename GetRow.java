//O(k) extra space solution
class Solution {
    public List<Integer> getRow(int rowIndex) {
        Integer[] ret = new Integer[rowIndex + 1];
        Arrays.fill(ret, 0);
        ret[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                 ret[j] = ret[j] + ret[j - 1];   
            }
        }
        
        return Arrays.asList(ret);
    }
}
