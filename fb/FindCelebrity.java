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


//optimized O(n) solution
//first pass, get the person that may be the celebrity, if the candidate knows one of the persons, then he is invalid, and update the candidate
//if the candidate does not know anyone behind, all of the persons behind are excluded
//so we just need to check the validation of the candidate in the second pass
//check every one wether knows him and he knows anyone

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i))
                candidate = i;
        }
        
        for (int i = 0; i < n; i++) {
            if (candidate != i && (!knows(i, candidate) || knows(candidate, i))) {
                return -1;
            }
        }
        
        return candidate;
    }
}
