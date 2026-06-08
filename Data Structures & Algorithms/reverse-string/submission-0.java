class Solution {
    public void reverseString(char[] s) {
        // [1,2,3,4] = 2
        //[1,2,3,4,5] = 2
        for(int i = 0; i<s.length/2; i++){
            char temp = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i] = temp;
        }
    }
}