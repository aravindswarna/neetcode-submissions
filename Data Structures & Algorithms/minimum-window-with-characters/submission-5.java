class Solution {
    public String minWindow(String s1, String s2) {
        if(s2.length() > s1.length()) return "";

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Map<Character, Integer> c1 = new HashMap<>();
        Map<Character, Integer> c2 = new HashMap<>();

        for(int i = 0; i<arr2.length; i++){
            c1.put(arr1[i], c1.getOrDefault(arr1[i],0)+1);
            c2.put(arr2[i], c2.getOrDefault(arr2[i],0)+1);
        }
        if(isEq(c1,c2)) return s1.substring(0, s2.length());

        int l = 0;
        int p1 = 0;
        int p2 = s1.length()+1;
        for(int i = arr2.length; i<arr1.length; i++){
            c1.put(arr1[i], c1.getOrDefault(arr1[i],0)+1);

            while(isEq(c1,c2)) {
                if(p2-p1 > i-l){
                    p1 = l;
                    p2 = i;
                }
                c1.put(arr1[l], c1.getOrDefault(arr1[l],0)-1);
                l++;
            }
            
        }

        return (p2 == s1.length()+1)? "" : s1.substring(p1, p2+1);


    }

    public boolean isEq( Map<Character, Integer> c1, Map<Character, Integer> c2){
       for(Map.Entry<Character, Integer> entry: c2.entrySet()){
        if(!c1.containsKey(entry.getKey()) || 
        !(c1.get(entry.getKey()) >= entry.getValue())) {
            System.out.println(c1 +"--"+c2);         

            return false;
        }
       }
       return true;
    }
}
