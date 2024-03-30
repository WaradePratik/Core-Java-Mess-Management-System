package com.mess;

public enum Plan {
MONTHLY(3000),QUARTERLY(11700),HALFYEAR(17500),YEAR(32000);
	
	private double fees;
	private Plan(double fees) {
		this.fees=fees;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	
	
}
