class Solution {

    //[1,4]
    //[4,1]
    //1 -> 5 -> 8
    //4 -> 5 -> 8
    class Node {
        int p;
        double t;
        int s;
        Node(int p, int s, double t){
            this.p = p;
            this.t = t;
            this.s = s;
        }
        public String toString(){
            return "p="+this.p+":t="+this.t+":s="+this.s;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        
            List<Node> nodes = new ArrayList<>();
            for(int i = 0; i<position.length;i++){
                double t =  (target - position[i])/(double)speed[i];
                Node n = new Node(position[i], speed[i], t);
                nodes.add(n);
            }

            //[
            //{p = 0, t = 10, s = 1},{p = 1, t = 4, s = 2} 
            //{p = 4, t = 3, s = 2} {p = 7, t = 3, s = 1}]

            Collections.sort(nodes, (a,b)->Double.compare(a.p, b.p));
            System.out.println(nodes);
            int fleet  = 1;
            double start = nodes.get(nodes.size()-1).t;
            for(int i = nodes.size()-2; i>=0; i--){

                if(nodes.get(i).t > start){
                    start = nodes.get(i).t;
                    fleet++;
                }    
            }
            return fleet;
    }
}
