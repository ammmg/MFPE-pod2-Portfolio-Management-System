package com.example.feignclient.FeignDemo.model;

public class MutualFundDetails {
	
	private String mutualFundId;
	private String mutualFundName;
	private int mutualFundValue;
	private int mutualFundUnits;
	public String getMutualFundId() {
		return mutualFundId;
	}
	public void setMutualFundId(String mutualFundId) {
		this.mutualFundId = mutualFundId;
	}
	public String getMutualFundName() {
		return mutualFundName;
	}
	public void setMutualFundName(String mutualFundName) {
		this.mutualFundName = mutualFundName;
	}
	public int getMutualFundValue() {
		return mutualFundValue;
	}
	public void setMutualFundValue(int mutualFundValue) {
		this.mutualFundValue = mutualFundValue;
	}
	public int getMutualFundUnits() {
		return mutualFundUnits;
	}
	public void setMutualFundUnits(int mutualFundUnits) {
		this.mutualFundUnits = mutualFundUnits;
	}
	public MutualFundDetails(String mutualFundId, String mutualFundName, int mutualFundValue, int mutualFundUnits) {
		super();
		this.mutualFundId = mutualFundId;
		this.mutualFundName = mutualFundName;
		this.mutualFundValue = mutualFundValue;
		this.mutualFundUnits = mutualFundUnits;
	}
	public MutualFundDetails() {
		super();
	}
	@Override
	public String toString() {
		return "MutualFundDetails [mutualFundId=" + mutualFundId + ", mutualFundName=" + mutualFundName
				+ ", mutualFundValue=" + mutualFundValue + ", mutualFundUnits=" + mutualFundUnits + "]";
	}

}
