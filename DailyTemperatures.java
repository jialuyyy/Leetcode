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


class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int[] ret = new int[T.length];
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()])
                stack.pop();
            
            ret[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        
        return ret;
    }
}
