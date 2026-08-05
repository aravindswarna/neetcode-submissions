class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> PQ = new PriorityQueue<>((d,e)->Integer.compare(e[0], d[0]));
        if(a > 0)
        PQ.offer(new int[]{a, 'a'-'0'});
        if(b > 0)
        PQ.offer(new int[]{b, 'b'-'0'});
        if(c > 0)
        PQ.offer(new int[]{c, 'c'-'0'});

        StringBuilder sb = new StringBuilder();
        int consecCnt = 1;
        char prev = 'A';
        while(!PQ.isEmpty()){
            int[] ele = PQ.poll();
            char curr = (char)(ele[1]+'0');
            //System.out.println(curr);
            if(prev == curr){
                consecCnt++;
            } else {
                consecCnt = 1;
            }

            if(consecCnt == 3 && !PQ.isEmpty()){
                int[] nextEle = PQ.poll(); 
                curr = (char)(nextEle[1]+'0');
                consecCnt = 1;
                sb.append(curr);
                nextEle[0]--;
                PQ.offer(ele);
                if(nextEle[0] > 0)
                PQ.offer(nextEle);
            } else if(consecCnt < 3){
                sb.append(curr);
                ele[0]--;
                if(ele[0] > 0)
                PQ.offer(ele);
            } else {
                break;
            }

            
            prev = curr;
            
        }
        return sb.toString();



    }
}