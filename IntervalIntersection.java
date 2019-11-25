//[[0,2],[5,10],[13,23],[24,25]]
//[[1,5],[8,12],[15,24],[25,26]]

//for [0,2] and [1,5], we will discard [0,2] after the first intersection action
//every time move the pointer forward if the ending point is smaller than the other one.
//pick the larger element of the start and the smaller element of the end to get the intersection
//Time Complexity: O(N) + O(M)
class IntervalIntersection {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if (A == null)
            return B;
        if (B == null)
            return A;
        
        int i = 0;
        int j = 0;
        
        List<int[]> ret = new ArrayList<>();
        while (i < A.length && j < B.length) {
            int max = Math.max(A[i][0], B[j][0]);
            int min = Math.min(A[i][1], B[j][1]);
            
            if (max <= min) {
                ret.add(new int[]{max, min});
            }
            
            if(A[i][1] < B[j][1])
                i++;
            else
                j++;
        }
        
        int[][] retArr = new int[ret.size()][2];
        for (i = 0; i < ret.size(); i++) {
            retArr[i] = ret.get(i);
        }
        
        return retArr;
    }
}
