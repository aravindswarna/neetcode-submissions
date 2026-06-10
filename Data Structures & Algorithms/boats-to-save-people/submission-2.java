class Solution {
    public int numRescueBoats(int[] people, int limit) {
       //[1,2,4,5] 
       //

       int[] arr = new int[limit+1];
       for(int ele: people){
        arr[ele] = arr[ele]+1;
       }  
       int i = 0;
       int j = 0;
       while(j < arr.length){
        while(arr[j] > 0){
            people[i++] = j;
            arr[j]--;
        }
        j++;
       }
       System.out.println(Arrays.toString(people));
       int p1 = 0;
       int p2 = people.length - 1;
       int ans = 0;
       while(p1 < p2){
        int w1 = people[p1];
        int w2 = people[p2];
        if(w1+w2 <= limit){
            p1++;
            p2--;
            ans++;
        } else {
            p2--;
            ans++;
        }
        if(p2 == p1){
            ans++;
            p1++;
        }

       }
       return ans;
    }

}