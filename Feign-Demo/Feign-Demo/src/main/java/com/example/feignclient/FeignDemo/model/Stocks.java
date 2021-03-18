package com.example.feignclient.FeignDemo.model;

public class Stocks {

	private String stockName;
	private int noOfStock;

	public Stocks() {
		super();
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public int getNoOfStock() {
		return noOfStock;
	}

	public void setNoOfStock(int noOfStock) {
		this.noOfStock = noOfStock;
	}

	@Override
	public String toString() {
		return "Stocks [stockName=" + stockName + ", noOfStock=" + noOfStock + "]";
	}

	public Stocks(String stockName, int noOfStock) {
		super();
		this.stockName = stockName;
		this.noOfStock = noOfStock;
	}

}
