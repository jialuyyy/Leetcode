//the area of the small rectangle should be equal to the area of the largest area outside
//create a hashset and add all of the coordinates into the set, all of the inside coordinates should appear more than once
//so we should remove it if we found a duplicate and eventually the set size should be 4 and the 4 should be the outside four 
//coordinates of the largest rectangle
class IsRectangleCover {
    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles == null || rectangles.length == 0 || rectangles[0].length == 0)
            return false;
        
        Set<String> set = new HashSet<>();
        int x1 = Integer.MAX_VALUE;
        int y1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y2 = Integer.MIN_VALUE;
        int area = 0;
        for (int[] rectangle : rectangles) {
            x1 = Math.min(rectangle[0], x1);
            y1 = Math.min(rectangle[1], y1);
            x2 = Math.max(rectangle[2], x2);
            y2 = Math.max(rectangle[3], y2);
            
            area += (rectangle[2] - rectangle[0]) * (rectangle[3] - rectangle[1]);
            
            //for the coordinate inside the largest rectangle, need to appear
            //more than once and in the end there will be only the four boundary 
            //coordinate in the set, otherwise it would be invalid
            String coordinate1 = rectangle[0] + " " + rectangle[1];
            String coordinate2 = rectangle[0] + " " + rectangle[3];
            String coordinate3 = rectangle[2] + " " + rectangle[3];
            String coordinate4 = rectangle[2] + " " + rectangle[1];
            
            if (!set.add(coordinate1)) set.remove(coordinate1);
            if (!set.add(coordinate2)) set.remove(coordinate2);
            if (!set.add(coordinate3)) set.remove(coordinate3);
            if (!set.add(coordinate4)) set.remove(coordinate4);   
        }
        if (!set.contains(x1 + " " + y1) || !set.contains(x1 + " " + y2) ||
           !set.contains(x2 + " " + y1) ||
           !set.contains(x2 + " " + y2) || set.size() != 4)
            return false;
        
        return area == (x2 - x1) * (y2 - y1);
    }
}
