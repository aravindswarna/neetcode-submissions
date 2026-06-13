class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        int i = 0;
        int ans = 0;
        int j = 0;
        Map<Character, Integer> dup = new LinkedHashMap<>();
            while(i<arr.length){
                if(dup.containsKey(arr[i])){
                    int idx = dup.get(arr[i]);
                    while(j <= idx){
                        dup.remove(arr[j]);
                        j++;
                    }
                }
                dup.put(arr[i], i);
                ans =  Math.max(ans, dup.size());
                i++;
            }
            return ans;
    }
}
