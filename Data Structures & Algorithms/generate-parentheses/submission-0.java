class Solution {
    public List<String> generateParenthesis(int n) {
        generateParenthesis1(n, 0, "");
        return new ArrayList<>(set);
    }

    public boolean valid(String s) {
        int open = 0;
        for (char c : s.toCharArray()) {
            open += c == '(' ? 1 : -1;
            if (open < 0) return false;
        }
        return open == 0;
    }
    Set<String> set = new HashSet<>();
    public void generateParenthesis1(int n, int c, String sb) {
        
        if(c == n*2) {
            if(valid(sb))
            set.add(sb);
            return;
        } 

        generateParenthesis1(n, c+1, sb+"(");
        
        generateParenthesis1(n, c+1, sb+")");


        
       
    }


}
