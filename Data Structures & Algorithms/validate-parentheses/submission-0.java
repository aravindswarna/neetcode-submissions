class Solution {
    public boolean isValid(String s) {
      Deque<Character> dq = new ArrayDeque<>();
      char[] arr = s.toCharArray();
      for(char ele: arr){
        System.out.println(dq);
        switch(ele){
            case '}': 
                if(!dq.isEmpty() && dq.getLast() == '{') {
                    dq.removeLast();
                } else return false;
                break;
            case ')':
                if(!dq.isEmpty() && dq.getLast() == '(') {
                    dq.removeLast();
                } else return false;
                break;
            case ']':
                if(!dq.isEmpty() && dq.getLast() == '[') {
                    dq.removeLast();
                } else return false;
                break;
            default:
            dq.addLast(ele);
        }

      }  
      return dq.isEmpty();
    }
}
