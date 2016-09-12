package com.mdmytriakha;

import java.util.Date;

/**
 * @author by Mykhailo on 9/11/2016.
 */
public class UserHistory {
	private Date entryTime;
	private String entry;
	private User user;
	private int id;

	@Override
	public String toString() {
		return "UserHistory{" +
				"entryTime=" + entryTime +
				", entry='" + entry + '\'' +
				", user=" + user +
				", id=" + id +
				'}';
	}

	public UserHistory() {
	}

	public UserHistory(Date entryTime, String entry) {
		this.entryTime = entryTime;
		this.entry = entry;
	}

	public Date getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}

	public String getEntry() {
		return entry;
	}

	public void setEntry(String entry) {
		this.entry = entry;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
