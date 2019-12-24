class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int[] ret = new int[T.length];
        
        for (int i = 0; i < T.length; i++) {
            for (int j = i + 1; j < T.length; j++) {
                if (T[j] > T[i]) {
                    ret[i] = j - i;
                    break;
                }
            }
        }
        
        return ret;
    }
}
