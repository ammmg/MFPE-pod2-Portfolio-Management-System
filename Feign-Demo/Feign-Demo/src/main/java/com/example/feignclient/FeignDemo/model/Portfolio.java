package com.example.feignclient.FeignDemo.model;

import java.util.List;

public class Portfolio {
	
	private int portfolioId;
	
	private List<Stocks> stockList;
	
	private List<MutualFundDetails> mutualFundList;

	public int getPortfolioId() {
		return portfolioId;
	}

	public void setPortfolioId(int portfolioId) {
		this.portfolioId = portfolioId;
	}

	public List<Stocks> getStockList() {
		return stockList;
	}

	public void setStockList(List<Stocks> stockList) {
		this.stockList = stockList;
	}

	public List<MutualFundDetails> getMutualFundList() {
		return mutualFundList;
	}

	public void setMutualFundList(List<MutualFundDetails> mutualFundList) {
		this.mutualFundList = mutualFundList;
	}

	public Portfolio(int portfolioId, List<Stocks> stockList, List<MutualFundDetails> mutualFundList) {
		super();
		this.portfolioId = portfolioId;
		this.stockList = stockList;
		this.mutualFundList = mutualFundList;
	}

	public Portfolio() {
		super();
	}

	@Override
	public String toString() {
		return "Portfolio [portfolioId=" + portfolioId + ", stockList=" + stockList + "]";
	}
	
	

}
