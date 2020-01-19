class Solution {
    
    class Point {
        private int x;
        private int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    private int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    private int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
    public int minKnightMoves(int x, int y) {
        //the chessboard is symmetric
        x = Math.abs(x);
        y = Math.abs(y);
        Deque<Point> queue = new ArrayDeque<>();
        
        Set<String> visited = new HashSet<>();
        Point p = new Point(0, 0);
        queue.offer(p);
        //have to store strings in the hashset instead of object new Point(x, y)
        //as default hashcode and equals in java for object will be comparing location in memory
        //for two new Point(x, y) it will be different only if you override the equals and hashcode
        //but for strings, it is already overrided
        visited.add("0,0");
        
        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point cur = queue.poll();
                if (cur.x == x && cur.y == y) {
                    return dist;
                }
                
                for (int k = 0; k < 8; k++) {
                    int index_x = cur.x + dx[k];
                    int index_y = cur.y + dy[k];
                    
                    //if out of bound, continue
                    //(2, -1) -> (1, 1)
                    //we can not get rid of all the negative values
                    if (index_x < -1 || index_y < -1 || index_x >= 310 || index_y >= 310)
                        continue;
                    
                    //otherwise
                    Point newP = new Point(index_x, index_y);
                    
                    if (!visited.contains(index_x + "," + index_y)) {
                        queue.offer(newP);
                        visited.add(index_x + "," + index_y);
                    }
                }
            }
            
            dist += 1;
        }
        
        return dist;
    }
}

/*
@Override
public boolean equals(Object obj) {
    if (obj == null) return false;
    if (!(obj instanceof Student))
        return false;
    if (obj == this)
        return true;
    return this.getId() == ((Student) obj).getId();
}

public class Student {
    private int id;
    private String name;
    public Student(int id, String name) {
        this.name = name;
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

HashSet stores its elements in memory buckets. Each bucket is linked to a particular hash code. When calling students.add(alex1), Java stores alex1 inside a bucket and links it to the value of alex1.hashcode(). Now any time an element with the same hash code is inserted into the set, it will just replace alex1. However, since alex2 has a different hash code, it will be stored in a separate bucket and will be considered a totally different object.

Now when HashSet searches for an element inside it, it first generates the element's hash code and looks for a bucket which corresponds to this hash code.

Here comes the importance of overriding hashcode(), so let's override it in Student and set it to be equal to the ID so that students who have the same ID are stored in the same bucket:

@Override
public int hashCode() {
    return id;
}


Conclusion
In order to achieve a fully working custom equality mechanism, it is mandatory to override hashcode() each time you override equals(). Follow the tips below and you'll never have leaks in your custom equality mechanism:

If two objects are equal, they MUST have the same hash code.
If two objects have the same hash code, it doesn't mean that they are equal.
Overriding equals() alone will make your business fail with hashing data structures like: HashSet, HashMap, HashTable ... etc.
Overriding hashcode() alone doesn't force Java to ignore memory addresses when comparing two objects.

*/
