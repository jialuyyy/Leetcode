class FullJustify {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int left = 0;
        while (left < words.length) {
            int right = findRight(left, words, maxWidth);
            result.add(justify(left, right, words, maxWidth));
            left = right + 1;
        }
        return result;
    }
    
    private int findRight(int left, String[] words, int maxWidth) {
        int right = left;
        int sum = words[right++].length();
        
        while (right < words.length && sum + 1 + words[right].length() <= maxWidth) {
            sum += 1 + words[right++].length();
        }
        
        return right - 1;
    }
    
    private String justify(int left, int right, String[] words, int maxWidth) {
        if (right - left == 0) {
            return padResult(words[left], maxWidth);
        }
        
        boolean isLastLine = right == words.length - 1;
        
        int numSpaces = right - left;
        int totalSpaces = maxWidth - wordsLength(left, right, words);
        
        String space = isLastLine ? " " : blank(totalSpaces / numSpaces);
        int remainder = isLastLine ? 0 : totalSpaces % numSpaces;
        
        StringBuilder sb = new StringBuilder();
        for (int i = left; i <= right; i++) {
            sb.append(words[i]).append(space).append(remainder-- > 0 ? " " : "");
        }
        
        return padResult(sb.toString().trim(), maxWidth);
    }
    
    private int wordsLength(int left, int right, String[] words) {
        int length = 0;
        for (int i = left; i <= right; i++) {
            length += words[i].length();
        }
        
        return length;
    }
    
    private String padResult(String ret, int maxWidth) {
        return new String(ret + blank(maxWidth - ret.length()));
    }
    
    private String blank(int length) {
        return new String(new char[length]).replace('\0', ' ');
    }
}
