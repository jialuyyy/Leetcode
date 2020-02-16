class FindMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0 || points[0].length == 0)
            return 0;
        
        //sort by the ending points from small to large
        //increaing order
        Arrays.sort(points, new Comparator<int[]>(){
            public int compare(int[] i1, int[] i2) {
                return i1[1] - i2[1];
            }
        });
        
        int lastEnd = points[0][1];
        int ans = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > lastEnd) {
                ans++;
                lastEnd = points[i][1];
            }
        }
        
        return ans;
    }
}
