class KClosest {
    public int[][] kClosest(int[][] points, int K) {
        Queue<int[]> pq = new PriorityQueue<>((n1, n2) -> dist(n2) - dist(n1));
        //nlogk
        for (int[] point : points) {
            pq.offer(point);
            if (pq.size() > K)
                pq.poll();
        }
        
        int[][] ret = new int[K][2];
        int index = 0;
        //klogk
        while(!pq.isEmpty()) {
            ret[index] = pq.poll();
            index++;
        }
        
        return ret;
    }
    
    private int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}

//quick sort
class KClosest {
    public int[][] kClosest(int[][] points, int K) {
        if (points == null || points.length == 0 || points[0].length == 0)
            return new int[][]{};
        
        int[][] ret = new int[K][2];
        
        quickSort(points, 0, points.length - 1);
        
        return Arrays.copyOfRange(points, 0, K);
    }
    
    private void quickSort(int[][] points, int start, int end) {
        if (start >= end) 
            return;
        
        int cur = partition(points, start, end);
        quickSort(points, start, cur - 1);
        quickSort(points, cur + 1, end);
    }
    
    private int partition(int[][] points, int start, int end) {
        int low = start;
        int high = end + 1;
        int pivot = dist(points[start]);
        
        while (true) {
            while (dist(points[++low]) < pivot && low < end) {
                if (low == end) {
                    break;
                }
            }
            
            while (dist(points[--high]) > pivot && high > start) {
                if (high == start) {
                    break;
                }
            }
            
            if (low >= high) {
                break;
            }
            
            swap(points, low, high);
        }
        
        swap(points, start, high);
        return high;
    }
    
    private int dist(int[] i) {
        return i[0] * i[0] + i[1] * i[1];
    }
    
    private void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
}
