class Solution {
    public String decodeString(String s) {
        char[] arr = s.toCharArray();
        Deque<String> DQ = new ArrayDeque<>();
        for(char ele: arr){
                System.out.println(DQ);

            if(ele == ']'){
                List<String> tokens = new ArrayList<>();
                while(!DQ.isEmpty() && !"[".equals(DQ.getLast())){
                    tokens.add(DQ.removeLast());
                }
                DQ.removeLast();
                StringBuilder num = new StringBuilder();
                while(!DQ.isEmpty()){
                    char[] arr1 = DQ.getLast().toCharArray();
                    System.out.println("Arr:"+DQ.getLast());
                    if(Character.isDigit(arr1[0])){
                        num.append(arr1[0]);
                        DQ.removeLast();
                    } else {
                        break;
                    }
                }
                num.reverse();
                int number = Integer.parseInt(num.toString());
                Collections.reverse(tokens);
                StringBuilder token = new StringBuilder();
                for(String t: tokens){
                    token.append(t);
                }
                String currToken = token.toString();
                for(int i = 0; i<number-1; i++){
                    token.append(currToken);
                }
                DQ.addLast(token.toString());

            } else {
                DQ.addLast(ele+"");
            }
        }
        StringBuilder finalAns = new StringBuilder();
        for(String ele: DQ){
            finalAns.append(ele);
        }
        return finalAns.toString();
    }
}