/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

/*
[1, 1] [2, 2] [3, 3]

2 - 1 / 2 - 1  == 3 - 2 / 3 - 2
the tricky part is how to store the slope
in order to get the same slope, we need to get the greatest common dividend of (x - x1) and (y - y1) 
for example  x - x1 and y - y1: 1, 2 and 2, 4, they should be the same, but if we keep the slope directly, the precision will be
a problem, so the key should be a string x : y

for the overlap point, we need to do the special operation

*/
public class MaxPoints {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        
        //key: (x : y)
        //value: count
        int overlap = 0;
        int max = 0;
        int result = 0;
        Map<String, Integer> map = null;
        for (int i = 0; i < points.length; i++) {
            
            map = new HashMap<String, Integer>();
            overlap = 0;
            max = 0;
            for (int j = i + 1; j < points.length; j++) {
                int x = points[i].x - points[j].x;
                int y = points[i].y - points[j].y;
                
                //overlap with the current point
                if (x == 0 && y == 0) {
                    overlap++;
                    continue;
                }
                
                int gcd = generateGcd(x, y);
                //negative case
                if (gcd != 0) {
                    x = x / gcd;
                    y = y / gcd;
                }
                
                String key = String.valueOf(x) + ":" + String.valueOf(y);
                if (map.get(key) == null) {
                    map.put(key, 1);
                } else {
                    map.put(key, map.get(key) + 1);
                }
                
                max = Math.max(max, map.get(key));
            }
            
            result = Math.max(result, max + overlap + 1);
        }
        
        return result;
    }
    
    private int generateGcd(int x, int y) {
        if (y == 0) return x;
        
        return generateGcd(y, x % y);
    }
}
