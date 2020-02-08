class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0;
        
        int count = 0;
        while (i < flowerbed.length && count < n) {
            if (flowerbed[i] == 0) {
                if ((i == 0 || flowerbed[i - 1] == 0) && 
                   (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                    flowerbed[i] = 1;
                    count++;
                }
            }
        
            i++;
        }
        
        return count == n;
    }
}


