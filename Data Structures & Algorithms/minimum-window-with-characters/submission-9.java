class Solution {
    public String minWindow(String s1, String s2) {
        if(s2.length() > s1.length()) return "";

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Map<Character, Integer> c1 = new HashMap<>();
        Map<Character, Integer> c2 = new HashMap<>();
        int have = 0;
        for(int i = 0; i<arr2.length; i++){
            int c = c2.getOrDefault(arr2[i],0)+1;
            c2.put(arr2[i], c);
        }
        int need = c2.size();

        int l = 0;
        int p1 = 0;
        int p2 = s1.length()+2;
        for(int i = 0; i<arr1.length; i++){
            c1.put(arr1[i], c1.getOrDefault(arr1[i],0)+1);

            if(c2.containsKey(arr1[i])){
                if(c1.get(arr1[i]).equals(c2.get(arr1[i]))){
                    have++;
                }

            }
            System.out.println(c1+"--"+have+"--"+need);
            while(have ==  need){
                if(i - l < p2-p1){
                    p1 = l;
                    p2 = i;
                }
                c1.put(arr1[l], c1.getOrDefault(arr1[l],0)-1);
                if(c2.containsKey(arr1[l])){
                    if(c1.get(arr1[l]) < c2.get(arr1[l])){
                        have--;
                        System.out.println(have+"--"+need+"--"+l);

                    }
                }
                l++;
                
            }

            
        }

        return (p2 == s1.length()+2)? "" : s1.substring(p1, p2+1);


    }
}
