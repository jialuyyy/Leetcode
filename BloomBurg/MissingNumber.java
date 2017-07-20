//brute force solution:
// sort the array first O(nlog(n))
//iterate over the array to find the missing one 

//Time Complexity: O(n)
public class MissingNumber {
    //use XOR operation on the index and the value
    // 0 ^ 0 = 0
    // 1 ^ 1 = 0
    
    //0 ^ anyNumber = anyNumber
    public int missingNumber(int[] nums) {
        int ret = 0;
        int i = 0;
        for (i = 0; i < nums.length; i++) {
            ret = ret ^ i ^ nums[i];
        }
        
        return ret ^ i;
    }
}
