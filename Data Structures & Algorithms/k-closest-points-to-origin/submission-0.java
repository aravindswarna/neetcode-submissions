class Solution {
    class Point {
        int x, y;
        double d;
    }
    public int[][] kClosest(int[][] points, int k) {
        Queue<Point> Q = new PriorityQueue<>((a,b) -> Double.compare(b.d, a.d));

        for(int[] ele: points){
            Point point = new Point();
            point.x = ele[0];
            point.y = ele[1];
            point.d = Math.sqrt(Math.pow(ele[0], 2)+ Math.pow(ele[1], 2));
            Q.offer(point);
            if(Q.size() > k){
                Q.poll();
            }
        }
        int[][] ans = new int[k][2];
        int i = 0;
        for(Point p: Q){
            ans[i][0] = p.x;
            ans[i][1] = p.y;
            i++;
        }
        return ans;



    }
}
