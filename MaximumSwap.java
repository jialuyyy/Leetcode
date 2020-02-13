class MaximumSwap {
    public int maximumSwap(int num) {
        char[] charNum = String.valueOf(num).toCharArray();
        int[] last = new int[10];
        
        //get the index for every digit from 0-9
        for (int i = 0; i < charNum.length; i++)
            last[charNum[i] - '0'] = i;
        
        for (int i = 0; i < charNum.length; i++) {
            
            //no need to swap, if the value behind nums[i] smaller than nums[i]
            for (int d = 9; d > charNum[i] - '0'; d--) {
                //if the digit's index behind i, swap
                if (last[d] > i) {
                    char temp = charNum[i];
                    charNum[i] = charNum[last[d]];
                    charNum[last[d]] = temp;
                    
                    return Integer.parseInt(String.valueOf(charNum));
                }
            }
        }
        
        return num;
    }
}
