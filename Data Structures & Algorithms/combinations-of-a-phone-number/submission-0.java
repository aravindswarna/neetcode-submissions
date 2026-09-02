class Solution {
    Map<Character, List<String>> map = new HashMap<>();
    void init(){
        map.put('2', Arrays.asList("a", "b", "c"));
        map.put('3', Arrays.asList("d", "e", "f"));
        map.put('4', Arrays.asList("g", "h", "i"));
        map.put('5', Arrays.asList("j", "k", "l"));
        map.put('6', Arrays.asList("m", "n", "o"));
        map.put('7', Arrays.asList("p", "q", "r", "s"));
        map.put('8', Arrays.asList("t", "u", "v"));
        map.put('9', Arrays.asList("w", "x", "y", "z"));
    }
    public List<String> letterCombinations(String digits) {
        init();
        comb(digits.toCharArray(), 0, new StringBuilder());
        return ans;
    }
    List<String> ans = new ArrayList<>();

    public void comb(char[] arr, int i, StringBuilder sb){
        if(arr.length == i){
            if(arr.length > 0)
            ans.add(sb.toString());
            return;
        }
        for(String str: map.get(arr[i])){
            sb.append(str);
            comb(arr, i+1, sb);
            sb.setLength(sb.length()-1);
        }
    }


}
