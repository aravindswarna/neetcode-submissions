class Solution {
    public int evalRPN(String[] tokens) {
      Deque<Integer> DQ = new ArrayDeque<>();
      for(int i = 0; i<tokens.length;i++){
        switch(tokens[i]){

            case "+": int op2 = DQ.removeLast();
                    int op1 = DQ.removeLast();
                    DQ.addLast(op1+op2); break;
            case "-":
             op2 = DQ.removeLast();
                     op1 = DQ.removeLast();
                    DQ.addLast(op1-op2);break;
            case "*":
             op2 = DQ.removeLast();
                     op1 = DQ.removeLast();
                    DQ.addLast(op1*op2);break;
            case "/":              op2 = DQ.removeLast();
                     op1 = DQ.removeLast();
                    DQ.addLast(op1/op2);break;
            default: DQ.addLast(Integer.parseInt(tokens[i]));
        }
      }  
        return DQ.removeLast();

    }
}
