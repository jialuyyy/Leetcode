/*Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.*/

//[1,1] -> [1,2]
//[1,9] -> [2, 0]
//[9,9,9] -> [1,0,0,0]
//iterate over the digits array from the end， if the digit is less than, digits[i]++ and return;
//if the digits[i] = 9, set the digits[i] to 0;
//if getting out of the loop, which means need one more position to store the carry.

//Time Complexity: O(n)
public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null)
            return new int[]{};
            
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            }
            
            digits[i] = 0;
        }
        
        int[] ret = new int[digits.length + 1];
        ret[0] = 1;
        
        return ret;
    }
}
