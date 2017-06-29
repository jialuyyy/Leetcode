//brute force solution, two levels loops
//for every persons in the party, check it with others, if this person knows one of others, break from the inner loop and continue checking 
//the next one, and if the one of others do not know the person, break too, when out of the inner loop, check whether j is equal to n,
//if it is, which means current i is the celebrity, if not, continue the outer loop
//Time Complexity: O(n ^ 2)
//need to do the optimization

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class FindCelebrity extends Relation {
    public int findCelebrity(int n) {
        for (int i = 0; i < n; i++) {
            int j = 0;
            for (; j < n; j++) {
                if (i != j) {
                    if (knows(i, j)) {
                        break;
                    } else {
                        if (!knows(j, i)) {
                            break;
                        }
                    }
                }
            }
            
            if (j == n) {
                return i;
            }
        }
        
        return -1;
    }
}
