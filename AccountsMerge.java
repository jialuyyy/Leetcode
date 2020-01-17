class AccountsMerge {
    class UnionFind {
        int[] father = null;
        
        public UnionFind() {
            father = new int[10000];
            
            for (int i = 0; i < father.length; i++) {
                father[i] = i;
            }
        }
        
        private int find(int x) {
            if (father[x] == x)
                return x;
            
            return father[x] = find(father[x]);
        }
        
        private void union(int x, int y) {
            int father_x = find(x);
            int father_y = find(y);
            
            if (father_x != father_y) {
                father[father_x] = father[father_y];
            }
        }
        
        
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        if (accounts == null || accounts.size() == 0)
            return accounts;
        
        Map<String, String> emailToName = new HashMap<>();
        Map<String, Integer> emailToId  = new HashMap<>();
        int idx = 0;
        UnionFind uf = new UnionFind();
        for (List<String> account : accounts) {
            String name = "";
            
            for (String email : account) {
                if (name.equals("")) {
                    name = email;
                    continue;
                }
                //build map between email and name
                emailToName.put(email, name);
                if (emailToId.get(email) == null)
                    emailToId.put(email, idx++);
                
                //union current email with the first one in the account
                uf.union(emailToId.get(account.get(1)), emailToId.get(email));
                
            }
        }
        
        Map<Integer, List<String>> ans = new HashMap<>();
        
        for (String email : emailToName.keySet()) {
            int index = uf.find(emailToId.get(email));
            ans.computeIfAbsent(index, x -> new ArrayList<>()).add(email);
        }
        
        for (List<String> component : ans.values()) {
            Collections.sort(component);
            //add name to the answer set
            component.add(0, emailToName.get(component.get(0)));
        }
        
        return new ArrayList(ans.values());
    }
}
