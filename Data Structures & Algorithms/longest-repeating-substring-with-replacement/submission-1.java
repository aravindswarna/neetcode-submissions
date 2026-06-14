class Solution {
    public int characterReplacement(String s, int k) {
        char[] arr = s.toCharArray();
        int res = 0;
        int max = 0;
        int l = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<arr.length; i++){
            int count = map.getOrDefault(arr[i], 0)+1;
            map.put(arr[i], count);
            max = Math.max(max, count);
            while(((i - l) + 1)-max > k){
                map.put(arr[l], map.get(arr[l]) - 1);
                l++;
            }
            res = Math.max(res, (i - l) +1);
        }
        return res;
    }
}
