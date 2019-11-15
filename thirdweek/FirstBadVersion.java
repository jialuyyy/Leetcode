//beats 33%
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class FirstBadVersion extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        
        while (start + 1 < end) {
            int mid = (start + end) >>> 1;
            
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (isBadVersion(start)) {
            return start;
        }
        
        return end;
    }
}


/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
//TLE
//when the input is the Integer.MAX_VALUE and the first bad version is also Integer.MAX_VALUE;
//when mid = Integer.MAX_VALUE - 1;
//start will be Integer.MAX_VALUE
//then start + 1 will exceed the Integer range
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        
        return isBadVersion(start) ? start : end;
    }
}
