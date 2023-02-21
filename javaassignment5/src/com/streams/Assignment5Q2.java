package com.streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class News {
	private int newsId;
	private String postedByUser;
	private String commentByUser;
	private String comment;

	public News(int newsId, String postedByUser, String commentByUser, String comment) {
		this.newsId = newsId;
		this.postedByUser = postedByUser;
		this.commentByUser = commentByUser;
		this.comment = comment;
	}

	public int getNewsId() {
		return newsId;
	}

	public String getPostedByUser() {
		return postedByUser;
	}

	public String getCommentByUser() {
		return commentByUser;
	}

	public String getComment() {
		return comment;
	}
}

public class Assignment5Q2 {
	public static int maxComments(List<News> news) {
		Map<Integer, Integer> commentCount = new HashMap<>();
		for (News n : news) {
			int count = commentCount.getOrDefault(n.getNewsId(), 0);
			commentCount.put(n.getNewsId(), count + 1);
		}
		return Collections.max(commentCount.values());
	}

	public static int budgetCount(List<News> news) {
		int count = 0;
		for (News n : news) {
			if (n.getComment().contains("budget")) {
				count++;
			}
		}
		return count;
	}

	public static String maxCommentsByUser(List<News> news) {
		Map<String, Integer> commentCount = new HashMap<>();
		for (News n : news) {
			int count = commentCount.getOrDefault(n.getCommentByUser(), 0);
			commentCount.put(n.getCommentByUser(), count + 1);
		}
		return Collections.max(commentCount.entrySet(), Map.Entry.comparingByValue()).getKey();
	}

	public static Map<String, Integer> sortMaxCommentsByUser(List<News> news) {
		Map<String, Integer> commentCount = new HashMap<>();
		for (News n : news) {
			int count = commentCount.getOrDefault(n.getCommentByUser(), 0);
			commentCount.put(n.getCommentByUser(), count + 1);
		}
		return commentCount.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	}

	public static void main(String[] args) {
		List<News> news = new ArrayList<>();
		news.add(new News(1, "John", "Adam", "This is a budget news"));
		news.add(new News(1, "Mary", "Adam", "I think it's a good budget"));
		news.add(new News(1, "Peter", "Bob", "I don't care about budget"));
		news.add(new News(2, "Bob", "Mary", "Great job!"));
		news.add(new News(2, "Alice", "Bob", "I agree with you"));
		news.add(new News(3, "David", "Mary", "Interesting news"));

		System.out.println("NewsId with maximum comments: " + maxComments(news));
		System.out.println("Count of 'budget' in comments: " + budgetCount(news));
		System.out.println("User with maximum comments: " + maxCommentsByUser(news));
		System.out.println("Comments by user sorted by number: " + sortMaxCommentsByUser(news));
	}
}
