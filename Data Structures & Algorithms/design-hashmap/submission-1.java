
class MyHashMap {
    List container[];
    public MyHashMap() {
       container = new List[100000];
       
    }
    
    public void put(int key, int value) {
        int hash = key % 100000;
        if(container[hash] == null){
            List<int[]> set = new LinkedList<>();
            set.add(new int[]{key, value});
            container[hash] = set;
        } else {
            boolean found = false;
            List<int[]> set = container[hash];
            for(int[] ele: set){
                if(ele[0] == key){
                    found = true;
                    ele[1] = value;
                }
            }
            if(!found){
                set.add(new int[]{key, value});
            }
        }
        print();
        System.out.println("Hello");
    }
    public void print(){
        for(Object ele: container){
            if(ele != null){
                LinkedList<int[]> list = (LinkedList<int[]>)ele;
                for(int[] ele1: list){
                    System.out.println(Arrays.toString(ele1));
                }
            }
        }
    }
    public int get(int key) {
        int hash = key % 100000;
        if(container[hash] == null){
            return -1;
        } else {
            List<int[]> set = container[hash];
            for(int[] ele: set){
                if(ele[0] == key){
                    return ele[1];
                }
            }
        }
        return -1;

    }
    
    public void remove(int key) {
        int hash = key % 100000;
        if(container[hash] == null){
        } else {
            List<int[]> set = container[hash];
            Iterator itr = set.iterator();
            while(itr.hasNext()){
                int[] ele = (int[])itr.next();
                if(ele[0] == key){
                    itr.remove();
                }
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */