//O(1) + O(N)
class NumFriendRequests {
    public int numFriendRequests(int[] ages) {
        if (ages == null || ages.length <= 1)
            return 0;
        
        int[] count = new int[121];
        for (int age : ages) {
            count[age]++;
        }
        int ans = 0;
        
        for (int ageA = 0; ageA <= 120; ageA++) {
            int countA = count[ageA];
            for (int ageB = 0; ageB <= 120; ageB++) {
                int countB = count[ageB];
                if (ageA * 0.5 + 7 >= ageB) 
                    continue;
                if (ageA < ageB)
                    continue;
                if (ageA < 100 && ageB > 100)
                    continue;
                ans += countA * countB;
                if (ageA == ageB)
                    //delete the request with him/herself
                    ans -= countA;
            }
            
        }
        return ans;
    }
}
