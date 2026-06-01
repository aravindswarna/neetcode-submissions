class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<List<Integer>> list = new ArrayList<>();
        for(int num: nums){
            list.add(new ArrayList<>());
        }
        list.add(new ArrayList<>());
        Map<Integer, Integer> map = new HashMap<>();
        for(int ele: nums){
            if(map.containsKey(ele)){
               int count = map.get(ele);
               map.put(ele, ++count);
            } else {
                map.put(ele, 1);
            }
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
           list.get(entry.getValue()).add(entry.getKey()); 
        }
        System.out.println(map);
        //[0=[],1=[1],2=[2],3=[3],4=[],5=[]]
        int j = 0;
        System.out.println(list);

        Set<Integer> ans = new HashSet<>();
        for(int i = nums.length;i>=0; i--){
            
            for(int ele: list.get(i)){
                if(k > 0){
                    ans.add(ele);
                    k--;
                }
            }
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
        
    }

}
