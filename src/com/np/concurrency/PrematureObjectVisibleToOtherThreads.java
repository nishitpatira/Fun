package com.np.concurrency;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class PrematureObjectVisibleToOtherThreads {
	
	public static List<PrematureObjectVisibleToOtherThreads> instancesList = new LinkedList<>();
	
	private String name;
	private BigDecimal amount;
	
	public PrematureObjectVisibleToOtherThreads(String name, BigDecimal amount){
		this.name = name;
		this.amount = amount;
		instancesList.add(this);
	}

	public static List<PrematureObjectVisibleToOtherThreads> getInstancesList() {
		return instancesList;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getAmount() {
		return amount;
	}	
}
