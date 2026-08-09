class Solution {
    public List<List<Integer>> combine(int n, int k) {
        combinations(n, 1, k, new ArrayList<>());
        return ans;
    }

    // write a recursive method , which takes the current element
    // add it to the list and moves to next element , if no.of elements picked == k
    //add it to the answer

    List<List<Integer>> ans = new ArrayList<>();
    void combinations(int n, int i, int k, List<Integer> currList){
        if(k == currList.size()){
            //add to ans
            ans.add(new ArrayList<>(currList));
            return;
        }
        if(i > n ) return;

        for(int j = i; j<=n; j++){
            currList.add(j);
            combinations(n, j+1, k, currList);
            currList.remove(currList.size() - 1);
        }
    }


}