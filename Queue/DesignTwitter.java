
/*
 * Design a simplified version of Twitter where users can post tweets,
 * follow/unfollow another user, and is able to see the 10 most recent tweets in
 * the user's news feed.
 * 
 * Implement the Twitter class:
 * 
 * Twitter() Initializes your twitter object.
 * void postTweet(int userId, int tweetId) Composes a new tweet with ID tweetId
 * by the user userId. Each call to this function will be made with a unique
 * tweetId.
 * List<Integer> getNewsFeed(int userId) Retrieves the 10 most recent tweet IDs
 * in the user's news feed. Each item in the news feed must be posted by users
 * who the user followed or by the user themself. Tweets must be ordered from
 * most recent to least recent.
 * void follow(int followerId, int followeeId) The user with ID followerId
 * started following the user with ID followeeId.
 * void unfollow(int followerId, int followeeId) The user with ID followerId
 * started unfollowing the user with ID followeeId.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

// Time -> O(n * log(m)) //
// Space -> O(m) //

class Twitter {
    private static int timeStamp = 0;
    private static HashMap<Integer, User> userMap;

    private static class Tweet {
        public int id;
        public int time;
        public Tweet next;

        public Tweet(int id) {
            this.id = id;
            time = timeStamp++;
            next = null;
        }
    }

    public static class User {
        public int id;
        public HashSet<Integer> followed;
        public Tweet tweet_head;

        public User(int id) {
            this.id = id;
            followed = new HashSet<>();
            follow(id);
            tweet_head = null;
        }

        public void follow(int id) {
            followed.add(id);
        }

        public void unfollow(int id) {
            followed.remove(id);
        }

        public void post(int id) {
            Tweet tweet = new Tweet(id);
            tweet.next = tweet_head;
            tweet_head = tweet;
        }
    }

    public Twitter() {
        userMap = new HashMap<Integer, User>();
    }

    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            User user = new User(userId);
            userMap.put(userId, user);
        }
        userMap.get(userId).post(tweetId);
    }

    public ArrayList<Integer> getNewsFeed(int userId) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        if (!userMap.containsKey(userId)) {
            return res;
        }

        HashSet<Integer> users = userMap.get(userId).followed;
        PriorityQueue<Tweet> pq = new PriorityQueue<Tweet>(users.size(), (a, b) -> (b.time - a.time));

        for (int user : users) {
            Tweet tweet = userMap.get(user).tweet_head;
            if (tweet != null) {
                pq.add(tweet);
            }
        }

        int n = 0;

        while (!pq.isEmpty() && n < 10) {
            Tweet tweet = pq.poll();
            res.add(tweet.id);
            n++;

            if (tweet.next != null) {
                pq.add(tweet.next);
            }
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            User user = new User(followerId);
            userMap.put(followerId, user);
        }

        if (!userMap.containsKey(followeeId)) {
            User user = new User(followeeId);
            userMap.put(followeeId, user);
        }

        userMap.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId) || followerId == followeeId) {
            return;
        }

        userMap.get(followerId).unfollow(followeeId);
    }
}

class DesignTwitter {
    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        System.out.println(twitter.getNewsFeed(1));
        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1));
    }
}