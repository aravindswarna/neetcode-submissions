class Solution {
    public int shipWithinDays(int[] weights, int days) {
      int weightSum = 0;
      int minWeight = 0;
      for(int ele: weights){
        minWeight = Math.max(minWeight, ele);
        weightSum+=ele;
      }  
      int l = minWeight;
      int r = weightSum;
      int ans = weightSum;
      while(l <= r){
        int m = l + (r - l)/2;
        int reqDays = canShip(weights, m, days);
        if(reqDays <= days){
            ans = m;
            r = m - 1;
        } else {
            l = m+1;
        }
      }
      return ans;
    }

    int canShip(int[] weights, int cap, int days){
        int sum = 0;
        int reqDays = 0; //3
        for(int ele: weights){
            
            sum+=ele; 
            if(sum > cap){ //9 > 4 
                reqDays++;
                sum = ele; //5
            } else if(sum == cap){
                reqDays++;
                sum = 0;
            }
        }
        if(sum != 0) reqDays++;
        if(sum > cap) reqDays++;

        System.out.println(reqDays+"--"+cap);
        return reqDays;
    }
}