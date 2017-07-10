//the my number means the target number instead of the number you guess.
//easy binary search problem
/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class GuessGameEasy extends GuessGame {
    public int guessNumber(int n) {
        int start = 1;
        int end = n;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            
            int guess = guess(mid);
            
            if (guess == -1) {
                end = mid;
            } else if (guess == 1) {
                start = mid;
            } else {
                return mid;
            }
        }
        
        if (guess(start) == 0) {
            return start;
        } else {
            return end;
        }
    }
}
