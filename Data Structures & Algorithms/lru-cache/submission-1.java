class Node {
    int val;
    int key;
    Node next;
    Node prev;
    Node(int key, int val){
        this.val = val;
        this.key = key;
    }
}

class LRUCache {
    int c = 0; // Capacity
    Map<Integer, Node> map = null;
    Node head = null;
    Node last = null;
    int s = 0; // Current size

    public LRUCache(int capacity) {
        c = capacity;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node == null) return -1;

        // If it's already the head, no need to move it!
        if(node == head) return node.val;

        Node prev = node.prev;
        Node next = node.next;

        // Detach node from its current position
        if(prev != null) prev.next = next;
        if(next != null) next.prev = prev;

        // If it was the last node, update 'last'
        if(node == last) last = prev;

        // Move node to the head (MRU)
        node.prev = null;
        node.next = head;
        if(head != null) head.prev = node;
        head = node;

        return node.val;
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)){
            if(s == c){
                // Evict LRU (last)
                map.remove(last.key);
                last = last.prev;
                if(last != null) {
                    last.next = null;
                } else {
                    head = null; // List became empty
                }
                s--; // Size decreases temporarily until new node is added
            }

            Node node = new Node(key, value);
            map.put(key, node);

            if(head == null){
                head = node;
                last = node;
            } else {
                node.next = head;
                head.prev = node;
                head = node;
            }
            s++;
        } else {
            // Key exists: update value and mark as Most Recently Used
            Node node = map.get(key);
            node.val = value;
            get(key); // Reuses the get logic to move it to head
        }
    }
}