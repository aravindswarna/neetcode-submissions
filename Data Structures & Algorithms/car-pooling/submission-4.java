class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        
       int[] arr = new int[1001];

       for(int[] trip: trips){
        arr[trip[1]]+=trip[0];
        arr[trip[2]]-=trip[0];
       }
       int sum = 0;
       for(int i = 0; i<arr.length; i++){
        arr[i]+=sum;
        sum = arr[i];
        if(sum > capacity)return false;
       }
       return true;


    }
}