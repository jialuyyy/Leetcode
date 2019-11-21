class KthGrammar {
    public int kthGrammar(int N, int K) {
        
        int[] ret = new int[1 << N];
        
        for (int i = 1; i < N; i++) {
            for (int j = (1 << (i - 1)) - 1; j >= 0; j--) {
                ret[2 * j] = ret[j];
                ret[2 * j + 1] = 1 - ret[j];
            }
        }
        
        return ret[K - 1];
        
    }
}

class KthGrammar {
    public int kthGrammar(int N, int K) {
        if (N == 1) return 0;
        return (~K & 1) ^ kthGrammar(N-1, (K+1)/2);
    }
}

class KthGrammar {
    public int kthGrammar(int N, int K) {
        return Integer.bitCount(K - 1) % 2;
    }
}

//0
//01
//0110
//01101001
//N=4 K=6
