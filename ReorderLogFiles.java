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


class Solution {
    public String[] reorderLogFiles(String[] logs) {
        if (logs == null || logs.length == 0)
            return logs;
        
        String[] ret = new String[logs.length];
        List<String> list = new ArrayList<>();
        int index = ret.length - 1;
        for (int i = logs.length - 1; i >= 0; i--) {
            String substring = logs[i].substring(logs[i].indexOf(" ") + 1);
            
            if (Character.isDigit(substring.charAt(0))) {
                ret[index--] = logs[i];
            } else {
                list.add(logs[i]);
            }
        }
        
        Collections.sort(list, new LogComparator());
        
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        
        return ret;
    }
    
    public class LogComparator implements Comparator<String> {
        public int compare(String s1, String s2) {
            String substring1 = s1.substring(s1.indexOf(" ") + 1);
            String substring2 = s2.substring(s2.indexOf(" ") + 1);
            
            if (!substring1.equals(substring2)) {
                return substring1.compareTo(substring2);
            } else {
                return s1.substring(0, s1.indexOf(" ")).compareTo(s2.substring(0, s2.indexOf(" ")));
            }
        }
    }
}
