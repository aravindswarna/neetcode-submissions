class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //[4,2,1,2]
        //4,2,1
        int l = 0;
        int r = l+(k-1);
        for(int i = r; i<arr.length; i++){
           int val = Math.abs(arr[i] - x);
           if(val < Math.abs(arr[l] - x)){
            l = (i - k)+1;
            r = i;
           }
        }
        List<Integer> ans = new ArrayList<>();
        
        while(l <= (r) && l<arr.length){
           System.out.println("r-->"+r+"l-->"+l);

            ans.add(arr[l++]);
        }
        return ans;
    }
}