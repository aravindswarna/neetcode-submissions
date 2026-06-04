class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> map = new HashSet<>();
        int ans = 0;
        for(int ele: nums){
            map.add(ele);
        }
        List<Integer> list = new ArrayList<>(map);

        for(int ele: list){
            int count = 0;
            int origEle = ele;
            while(!map.isEmpty() && map.contains(ele)){
                map.remove(ele);
                count++;
                ele--;
            }
            ele = origEle+1;
            while(!map.isEmpty() && map.contains(ele)){
                map.remove(ele);
                count++;
                ele++;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}
