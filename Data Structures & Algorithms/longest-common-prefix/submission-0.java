class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];

        String str = strs[0];
        for(int i = 1; i<strs.length; i++){
            char[] arr1 = str.toCharArray();
            char[] arr2 = strs[i].toCharArray();
            int j = 0;
            int k = 0;
            StringBuilder sb = new StringBuilder();
            while(j < arr1.length && k < arr2.length){
                if(arr1[j] == arr2[k]){
                    sb.append(arr1[j]);
                    j++;
                    k++;
                } else {
                    break;
                }
            }
            str = sb.toString();
        }
        return str;
    }
}