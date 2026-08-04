
class Twitter {

    Map<Integer, Set<Integer>> userGraph = new HashMap<>();
    Map<Integer, List<int[]>> userTweetMap = new HashMap<>();
    int globalTimeStamp = 0;
    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
       List<int[]> list = userTweetMap.getOrDefault(userId, new ArrayList<int[]>());
       list.add(new int[]{tweetId, globalTimeStamp++});
       userTweetMap.put(userId, list);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> followers = userGraph.getOrDefault(userId, new HashSet<Integer>());
        List<int[]> followerTweets = new ArrayList<>();
        for(Integer follower: followers){
            if(userTweetMap.containsKey(follower))
            followerTweets.addAll(userTweetMap.get(follower));
        }
        if(userTweetMap.containsKey(userId))
        followerTweets.addAll(userTweetMap.get(userId));

        Collections.sort(followerTweets, (a,b)->Integer.compare(a[1], b[1]));

        List<Integer> newsFeed = new ArrayList<>();
        int i = followerTweets.size();
        while(i>0 && i>followerTweets.size()-10){
            //System.out.println(followerTweets.size() +"--"+i);

           i--; 
           newsFeed.add(followerTweets.get(i)[0]); 
        }

        return newsFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
       Set<Integer> set = userGraph.getOrDefault(followerId, new HashSet<Integer>());
       set.add(followeeId);
       userGraph.put(followerId, set);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId) return;

        Set<Integer> set = userGraph.get(followerId);
        if(set == null || set.isEmpty()) return;
        set.remove(followeeId);
    }
}
