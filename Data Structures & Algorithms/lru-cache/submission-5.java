class Node {

    int val;

    int key;

    Node next;

    Node prev;

    Node(int key, int val){

        this.val = val;

        this.key = key;

    }
    public String toString(){
        String pre = prev == null ? "**": prev.key+"";
        String nex = next == null ? "**": next.key+"";
        return "["+pre+"]-->["+key+"]-->["+nex+"]";
    }

}

class LRUCache {
    int c;
    Node head = new Node(-1, -1);
    Node last = new Node(-1, -1);
    Map<Integer, Node> map;
    public LRUCache(int capacity) {
        c = capacity;
        map = new HashMap<>();
        head.next = last;
        last.prev = head;
    }

   

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);

        //remove the link
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;

        //add at the head
        next = head.next; 
        //correct next link
        node.next = next;
        next.prev = node;
        //correct prev link
        head.next = node;
        node.prev = head;
        return node.val;

    }

   

    public void put(int key, int value) {

        if(map.containsKey(key)){
            map.get(key).val = value;
            get(key);
        } else {
            Node newNode = new Node(key, value);
            if(map.size() == c){
                Node node = last.prev;
                Node prev = node.prev;
                prev.next = last;
                last.prev = prev;
                map.remove(node.key);
            }
            map.put(key, newNode);
            Node next = head.next;

            newNode.next = next;
            next.prev = newNode;

            head.next = newNode;
            newNode.prev = head;
        }
        printList(head);
      
    }

    public void printList(Node head){
        System.out.println("start");
        while(head != null){
            System.out.println(head);
            head = head.next;
        }
        System.out.println("end");

    }

} 

