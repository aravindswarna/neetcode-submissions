class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();

    }

    public List<String> decode(String str) {
        
        System.out.println(str);
        char[] arr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        List<String> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < arr.length){
            
            if(arr[i] == '#'){
                String len = "";
                while(j < i){
                    len+=arr[j];
                    j++;
                }
                int length = Integer.parseInt(len);
                i++;
                while(i < arr.length && length > 0){
                    sb.append(arr[i]);
                    i++;
                    length--;
                }
                j = i;
                System.out.println(i+". "+j);
                ans.add(sb.toString());
                sb.setLength(0);
                continue;
            }
            i++;
        }
        return ans;
    }
}
