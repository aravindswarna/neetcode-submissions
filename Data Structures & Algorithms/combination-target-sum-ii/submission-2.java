class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
       Arrays.sort(candidates); 
       sum(candidates, 0, target, 0, new ArrayList<>());
       return ans; 
    }
    List<List<Integer>> ans = new ArrayList<>();
    
    void sum(int[] candidates, int i, int target, int sumSoFar, List<Integer> num){
        //System.out.println(sumSoFar);
        if(target == sumSoFar){
            List<Integer> list = new ArrayList<>(num);
            //Collections.sort(list);
            ans.add(list);
            return;
        }
        if(i >= candidates.length || sumSoFar >  target) return;

        num.add(candidates[i]);
        sum(candidates, i+1, target, sumSoFar+candidates[i], num);
        num.remove(num.size() - 1);
        while(i+1 < candidates.length && candidates[i]==candidates[i+1]){
            i++;
        }

        sum(candidates, i+1, target, sumSoFar, num);
       
        
    }
}
