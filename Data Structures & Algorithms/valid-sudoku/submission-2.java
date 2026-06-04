class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> rSet = new HashSet<>();
        Set<Character> cSet = new HashSet<>();
        for(int i = 0; i<board.length;i++){

            for(int j = 0; j<board.length;j++){
               if(board[i][j] != '.') { 
                if(!rSet.add(board[i][j]) )
                {
                    return false; 
                }
               }
               if(board[j][i] == '.') continue; 
                if(!cSet.add(board[j][i]) ){
                    return false; 
                }
            }
            rSet.clear();
            cSet.clear();
        }

        Set<Character> sSet = new HashSet<>();
        int kl = 0;
        while(kl<=2){
            int kc = 0;
            while(kc <= 2){
                int i = kl*3;
                int iMax = i+2;
                while(i<= iMax){
                    int j = kc*3;
                    int jMax = j+2;
                    while(j<=jMax){
                         if(board[i][j] == '.') {
                            j++;
                            continue; 
                         }
                        if(!sSet.add(board[i][j]))
                        return false;
                        j++;

                    }
                    i++;
                }
                System.out.println(sSet);
                sSet.clear();
                kc++;
            }
            kl++;
        }
           
        return true;
    }
}
