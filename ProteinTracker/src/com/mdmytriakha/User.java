package com.mdmytriakha;

import java.util.HashSet;
import java.util.Set;

/**
 * @author by Mykhailo on 9/8/2016.
 */
public class User {

	private int id;
	private String name;
	private ProteinData proteinData = new ProteinData();
	private Set<UserHistory> history = new HashSet<>();

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", proteinData=" + proteinData +
				", history=" + history +
				'}';
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProteinData getProteinData() {
		return proteinData;
	}

	public void setProteinData(ProteinData proteinData) {
		this.proteinData = proteinData;
	}

	public Set<UserHistory> getHistory() {
		return history;
	}

	public void setHistory(Set<UserHistory> history) {
		this.history = history;
	}
}
