package com.mdmytriakha;

/**
 * @author by Mykhailo on 9/11/2016.
 */
public class ProteinData {
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

	private int total;
	private int goal;

	@Override
	public String toString() {
		return "ProteinData{" +
				"total=" + total +
				", goal=" + goal +
				'}';
	}
}
