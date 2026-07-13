class TimeMap {
    class Node {
        int t;
        String v;
        Node(int t, String v){
            this.t = t;
            this.v = v;
        }
    }
    Map<String, List<Node>> map = new HashMap<>();
    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        
        List<Node> node = map.getOrDefault(key, new ArrayList<Node>());
        node.add(new Node(timestamp, value));
        map.put(key, node);

    }
    
    public String get(String key, int timestamp) {
        List<Node> node = map.getOrDefault(key, new ArrayList<Node>());
        int l = 0;
        int r = node.size() - 1;
        String ans = "";
        while(l <= r){
            int m = l + (r - l)/2;
            if(node.get(m).t == timestamp){
                return node.get(m).v;
            } else if(node.get(m).t < timestamp){
                ans = node.get(m).v;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }
}
