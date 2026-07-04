class Solution {
    public String simplifyPath(String path) {
        path = path+"/";
        char[] arr = path.toCharArray();
        Deque<String> DQ = new ArrayDeque<String>();
        StringBuilder content = new StringBuilder();
        for(char ele: arr){

            if(ele == '/'){

                if("..".equals(content.toString())){
                   if(DQ.size() > 0)
                    DQ.removeLast();
                    content = new StringBuilder();
                } else if(".".equals(content.toString())){
                    content = new StringBuilder();
                }else {
                     if(content.length() > 0){
                        DQ.add(content.toString());
                        content = new StringBuilder();
                     }
                }
            } else {
                content.append(ele);
            }

        }
        StringBuilder ans = new StringBuilder();
        for(String token: DQ){
            ans.append("/");
            ans.append(token);
        }

        return (ans.length() > 0 ? ans.toString(): "/");

    }
}