class ReorderLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new Comparator<String>(){
            public int compare(String s1, String s2) {
                String sub1 = s1.substring(s1.indexOf(" ") + 1);
                String sub2 = s2.substring(s2.indexOf(" ") + 1);
                boolean isDigit1 = Character.isDigit(sub1.charAt(0));
                boolean isDigit2 = Character.isDigit(sub2.charAt(0));
                
                //if both string1 and string2 are strings
                if (!isDigit1 && !isDigit2) {
                    int comp = sub1.compareTo(sub2);
                    if (comp != 0)
                        return comp;
                    
                    return s1.substring(0, s1.indexOf(" "))
                        .compareTo(s2.substring(0, s2.indexOf(" ")));
                }
                
                
                return isDigit1? (isDigit2 ? 0 : 1) : -1;
            }
        });
        
        return logs;
    }
}
