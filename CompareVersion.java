class CompareVersion {
    //. means any character
    //\. means .
    public int compareVersion(String version1, String version2) {
        String[] strs1 = version1.split("\\.");
        String[] strs2 = version2.split("\\.");
        
        int length = Math.max(strs1.length, strs2.length);
        
        for (int i = 0; i < length; i++) {
            Integer v1 = i < strs1.length ? Integer.parseInt(strs1[i]) : 0;
            Integer v2 = i < strs2.length ? Integer.parseInt(strs2[i]) : 0;
            
            int compare = v1.compareTo(v2);
            
            if (compare != 0) {
                return compare;
            }
        }
        
        return 0;
    }
}
