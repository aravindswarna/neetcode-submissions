class Solution {
    public boolean exist(char[][] board, String word) {
        boolean ans = false;
        int[][] vis = new int[board.length][board[0].length];
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[i].length; j++){
                if(board[i][j] == word.charAt(0)){
                   vis[i][j] = 1; 
                   ans = ans || dfs(board, word, 1, i, j, vis);
                   if(ans) return true;
                   vis[i][j] = 0; 
                }
            }
        }
        return false;

    }

    int[] left = {-1, 1};

    public boolean dfs(char[][] board, String word,int c, int i, int j, int[][] vis) {
        if(c == word.length()) return true;
        boolean ans = false;
        for(int ele: left){
            int t = i + ele;
            if(t>=0 && t < board.length && vis[t][j] == 0){
                if(board[t][j] == word.charAt(c)){
                   vis[t][j] = 1; 
                   ans = ans || dfs(board, word, c+1, t, j, vis);
                   if(ans) return true;
                   vis[t][j] = 0; 
                }
            }
        }

        for(int ele: left){
            int b = j + ele;
            if(b >=0 && b < board[0].length && vis[i][b] == 0){
                if(board[i][b] == word.charAt(c)){
                    vis[i][b] = 1; 
                   ans = ans || dfs(board, word, c+1, i, b, vis);
                   if(ans) return true;
                    vis[i][b] = 0; 
                }
            }
        }
        return false;

    }

}
