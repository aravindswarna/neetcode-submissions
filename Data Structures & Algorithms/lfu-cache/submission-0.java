class Node{
    Node prev;
    Node next;
    int key;
    int val;
    int cnt;
    Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}
class DLL {
    Node left;
    Node right;
    int size;
    DLL(){
        this.left = new Node(0,0);
        this.right = new Node(0,0);
        left.next = right;
        right.prev = left;
    }
    void addNode(Node node){
        //Update next pointer
        node.next = this.left.next;
        node.next.prev = node;

        //Update prev pointer
        this.left.next = node;
        node.prev = this.left;
        size++;
    }

    Node removeNode(Node node){
        //update prev pointer
        node.prev.next = node.next;

        //update next pointer
        node.next.prev = node.prev;
        size--;
        return node;

    }

    Node removeNode(){
        if(size == 0)return null;
        return removeNode(this.right.prev);
    }    
}
class LFUCache {

    //6 -> [----]
    //2 --> [L2]
    //1 -> [L2, L1] 

    //map [key , node]
    //[1-1]->[2]
    //[2, 1] -> [1, 2]

    //
    int c = 0;
    Map<Integer, DLL> cMap = new HashMap<>();
    Map<Integer, Node> nMap = new HashMap<>();
    int minCount = 0;
    public LFUCache(int capacity) {
        c = capacity;
    }
    
    public int get(int key) {
        if(!nMap.containsKey(key)) return -1;
        counter(nMap.get(key));
        return nMap.get(key).val;
    }

    private void counter(Node node){
        int c = node.cnt;
        cMap.get(c).removeNode(node);
        if(c == minCount && cMap.get(c).size == 0){
            minCount++;
        }
        node.cnt++;
        cMap.putIfAbsent(node.cnt, new DLL());
        cMap.get(node.cnt).addNode(node);
    }
    
    public void put(int key, int value) {
       if(c == 0) return;
       if(nMap.containsKey(key)){
        Node node = nMap.get(key);
        node.val = value;
        counter(node);
        return;
       }
       if(c == nMap.size()){
        Node node = cMap.get(minCount).removeNode();
        nMap.remove(node.key);
       }
       Node node = new Node(key, value);
       node.cnt = 1;
       nMap.put(key, node);
       cMap.putIfAbsent(node.cnt, new DLL());
       cMap.get(node.cnt).addNode(node);
       minCount = 1; 
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */