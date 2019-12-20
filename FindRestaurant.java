class FindRestaurant {
    public String[] findRestaurant(String[] list1, String[] list2) {
        if (list1 == null || list2 == null || list1.length == 0 || list2.length == 0) {
            return new String[]{};
        }
        
        int min = Integer.MAX_VALUE;
        Map<String, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < list1.length; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            map.put(list1[i], list);
        }

        
        for (int i = 0; i < list2.length; i++) {
            if (!map.containsKey(list2[i])) {
                List<Integer> list = new ArrayList<>();
                map.put(list2[i], list);
            } 
            map.get(list2[i]).add(i);
        }
        List<String> retList = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            List<Integer> value = entry.getValue();
            String key = entry.getKey();
           
            if (value.size() >= 2) {
                int sum = 0;
                for (int i : value) {
                    sum += i;
                }
                
                if (sum < min) {
                    min = sum;
                    retList = new ArrayList<>();
                    retList.add(key);
                } else if (sum == min) {
                    retList.add(key);
                }
            }
            
           
            
        }
        
        String[] ret = new String[retList.size()];
        for (int i = 0; i < retList.size(); i++) {
            ret[i] = retList.get(i);
        }
        return min == Integer.MAX_VALUE ? new String[]{} : ret;
            
            
    }
}


class FindRestaurant {
    public String[] findRestaurant(String[] list1, String[] list2) {
        if (list1 == null || list2 == null || list1.length == 0 || list2.length == 0) {
            return new String[]{};
        }
        
        int min = Integer.MAX_VALUE;
        Map<Integer, List<String>> map = new HashMap<>();
        
       
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    if (!map.containsKey(i + j)) {
                        map.put(i + j, new ArrayList<String>());
                    }
                        map.get(i + j).add(list1[i]);
                }
            }
        }
        
        int min_index = Integer.MAX_VALUE;
        for (int key : map.keySet())
            min_index = Math.min(min_index, key);
        
        String[] res = new String[map.get(min_index).size()];
        return map.get(min_index).toArray(res);
            
    }
}


class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        if (list1 == null || list2 == null || list1.length == 0 || list2.length == 0) {
            return new String[]{};
        }
       
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        
        List<String> res = new ArrayList<>();
        int min_sum = Integer.MAX_VALUE;
        int sum = 0;
        
        for (int i = 0; i < list2.length && i <= min_sum; i++) {
            if (map.containsKey(list2[i])) {
                sum = i + map.get(list2[i]);
                if (sum < min_sum) {
                    res.clear();
                    res.add(list2[i]);
                    min_sum = sum;
                } else if (sum == min_sum) {
                    res.add(list2[i]);
                }
            }
        }
        
        return res.toArray(new String[res.size()]);
    }
}
