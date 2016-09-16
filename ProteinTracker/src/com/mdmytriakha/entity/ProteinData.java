package com.mdmytriakha.entity;

/**
 * @author by Mykhailo on 9/11/2016.
 */
public class ProteinData {
	private int id;
	private int total;
	private int goal;
	private User user;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getGoal() {
		return goal;
	}

	public void setGoal(int goal) {
		this.goal = goal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
