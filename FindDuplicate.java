class FindDuplicate {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> ret = new ArrayList<>();
        if (paths == null || paths.length == 0)
            return ret;
        
        //build a content Directory map to get the result
        Map<String, List<String>> contentDirMap = new HashMap<>();
        
        for (String path : paths) {
            String[] values = path.split(" ");
            String prefix = values[0];
            
            for (int i = 1; i < values.length; i++) {
                //"3.txt"
                String fileName = values[i].substring(0, values[i].indexOf("("));
                
                //file content "efgs"
                String content = values[i].substring(values[i].indexOf("(") + 1, values[i].length() - 1);
                
                if (!contentDirMap.containsKey(content)) {
                    contentDirMap.put(content, new ArrayList<String>());
                }
                
                //add the dir into the map
                String dir = prefix + "/" + fileName;
                contentDirMap.get(content).add(dir);
            }
        }
        
        //iterate over the keyset of the hashmap
        for(String key : contentDirMap.keySet()) {
            if (contentDirMap.get(key).size() > 1) {
                ret.add(contentDirMap.get(key));
            }
            
        }
        
        return ret;
    }
}
