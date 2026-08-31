class Solution {
    public List<List<String>> partition(String s) {
        partition(s.toCharArray(), 0, new ArrayList<>());
        
        return ans;
        

    }
    List<List<String>> ans = new ArrayList<>();

    public void partition(char[] arr, int si, List<String> str) {
        
        if(si == arr.length){
            ans.add(new ArrayList<>(str));
        }
        String str1 = "";
        for(int i = si; i<arr.length; i++){
           str1+=arr[i];
           boolean isP = isPalindrome(str1);
        
           if(isP){
            str.add(str1);
            partition(arr, i+1, str);
            str.remove(str.size() - 1);
           }
           
        }  

    }


    private boolean isPalindrome(String s){
        int l = 0;
        int r = s.length()-1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
