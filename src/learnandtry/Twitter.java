package learnandtry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * Your Twitter object will be instantiated and called as such: Twitter obj =
 * new Twitter(); obj.postTweet(userId,tweetId); List<Integer> param_2 =
 * obj.getNewsFeed(userId); obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */

public class Twitter {

	// hashmap to store user as a key, followers are values
	HashMap<Integer, ArrayList<Integer>> followers;

	// Stack to store twitters
	Stack<Pair<Integer>> stack;

	// id of new twitter, but according to postTweet method, it may not need.
	// static int count = 0;

	/** Initialize your data structure here. */
	public Twitter() {
		followers = new HashMap<Integer, ArrayList<Integer>>();
		stack = new Stack<Pair<Integer>>();
	}

	/** Compose a new tweet. */
	public void postTweet(int userId, int tweetId) {

		Pair<Integer> newPost = new Pair<Integer>(userId, tweetId);

		stack.push(newPost);
	}

	/**
	 * Retrieve the 10 most recent tweet ids in the user's news feed. Each item
	 * in the news feed must be posted by users who the user followed or by the
	 * user herself. Tweets must be ordered from most recent to least recent.
	 */
	public List<Integer> getNewsFeed(int userId) {

		List<Integer> result = new ArrayList<Integer>();

		// tweets amount
		int count = 0;

		// pointer of current reading position
		int i = stack.size() - 1;
		Pair<Integer> temp;

		// get user's followers and userid to the list
		ArrayList<Integer> list = followers.get(userId);
		if (list == null) {
			list = new ArrayList<Integer>();

		}
		list.add(userId);

		while (!stack.isEmpty() && count < 10 && i >= 0) {

			temp = stack.get(i);

			if (list.contains(temp.p1)) {
				result.add(temp.p2);
				count++;
			}
			// read next;
			i--;
		}

		return result;
	}

	/**
	 * Follower follows a followee. If the operation is invalid, it should be a
	 * no-op.
	 */
	public void follow(int followerId, int followeeId) {

		ArrayList<Integer> list = followers.get(followerId);
		if (list == null) {
			list = new ArrayList<Integer>();
		} else if (list.contains(followeeId)) // operation is invalid, if has
												// already followed
			return;

		list.add(followeeId);

		followers.put(followerId, list);

		// remove duplicate values in hashmap
		// Collection<ArrayList<Integer>> objs = followers.values();
		// for (Iterator<ArrayList<Integer>> itr = objs.iterator();
		// itr.hasNext();) {
		// if (Collections.frequency(objs, itr.next()) > 1) {
		// itr.remove();
		// }
		// }

	}

	/**
	 * Follower unfollows a followee. If the operation is invalid, it should be
	 * a no-op.
	 */
	public void unfollow(int followerId, int followeeId) {

		ArrayList<Integer> list = followers.get(followerId);

		list.remove(new Integer(followeeId));
	}

	// public static void main(String[] args) {
	// Twitter obj = new Twitter();
	// obj.postTweet(userId, tweetId);
	// List<Integer> param_2 = obj.getNewsFeed(userId);
	// obj.follow(followerId, followeeId);
	// obj.unfollow(followerId, followeeId);
	// }
}

class Pair<T> {
	T p1, p2;

	Pair(T p1, T p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
}
