class Solution {
    public List<List<Integer>> fourSum(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length;
        for(int i = 0; i<n; i++){
             if (i > 0 && arr[i] == arr[i - 1]) continue;
            for(int j = i+1; j<n; j++){
                if (j > i + 1 && arr[j] == arr[j - 1]) continue;
                int p1 = j+1;
                int p2 = n-1;
                while(p1< p2){
                    long sum = (long) arr[i] + arr[j] + arr[p1] + arr[p2];
                    if(sum == target){
                        List<Integer> subAns = new ArrayList<>();
                        subAns.add(arr[i]);
                        subAns.add(arr[j]);
                        subAns.add(arr[p1]);
                        subAns.add(arr[p2]);
                        ans.add(subAns);
                        p1++;
                        p2--;
                        while (p1 < p2 && arr[p1] == arr[p1 - 1]) p1++;
                        while (p1 < p2 && arr[p2] == arr[p2 + 1]) p2--;
                    } else if(sum < target){
                        p1++;
                    } else {
                        p2--;
                    }

                }

            }


        }
        return ans;
    }
}