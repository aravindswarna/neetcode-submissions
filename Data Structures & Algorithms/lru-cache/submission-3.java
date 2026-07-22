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
        String pre = prev == null ? "**": prev.val+"";
        String nex = next == null ? "**": next.val+"";
        return "["+pre+"]-->["+val+"]-->["+nex+"]";
    }

}

class LRUCache {

    int c = 0;

    Map<Integer, Node> map = null;

    Node head = null;

    Node last = null;

    int s = 0;

    public LRUCache(int capacity) {

        c = capacity;

        map = new HashMap<>();

    }

   

    public int get(int key) {

        Node node = map.get(key);

        if(node == null) return -1;

        if(node == head) return node.val;

        Node prev = node.prev; //prev LL

        Node next = node.next; //next LL

        if(prev != null){

            prev.next = next;

        }

        if(next != null){

            next.prev = prev;

        }

        if(node == last){

            last = prev;

        }

       

        node.prev = null;

        node.next = head;
        head.prev = node;

        head = node;

       //System.out.println("++"+head+" "+last +"--"+key);
       //printList(head);
 

        return node.val;

       

    }

   

    public void put(int key, int value) {

        Node node = null;

        if(!map.containsKey(key)){

            if(s == c){
                
                map.remove(last.key);
                //System.out.println("Removed-->"+last.key);
                last = last.prev;

                s--;



                if(s == 0 || last == null) {

                    head = null;

                    last = null;

                }

            }

            s++;

            node = new Node(key, value);

            map.put(key,node);

            if(head == null){

                head = node;

                last = node;

            } else {

                node.next = head;

                head.prev = node;

                head = node;

            }

        } else {

            map.get(key).val = value;
            get(key);

        }
        //printList(head);

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

