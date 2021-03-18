package com.example.feignclient.FeignDemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.feignclient.FeignDemo.model.MutualFundDetails;
import com.example.feignclient.FeignDemo.model.StockDetails;
import com.example.feignclient.FeignDemo.model.Stocks;

@RestController
public class StocksContoller {

	@Autowired
	private ShareDetailsFiegnProxy proxy;
	
	@Autowired
	private MutualFundDetailsFeignProxy mutualFundProxy;
	
	
	@GetMapping("/GetNetWorth/shares")
	public List<Stocks> getAllStocks(){
		List<Stocks> stockList = new ArrayList<>();
		List<StockDetails> shareslist = proxy.findAll();
		for(StockDetails s:shareslist)
		{
			stockList.add(new Stocks(s.getShareName(),1));
		}
		return stockList; 
	}
	
	@GetMapping("/GetNetWorth/pershare/{shareName}")
	public StockDetails getStcokName(@PathVariable(value="shareName") String shareName) {
		return proxy.finddailyShareByName(shareName);
	}
	
	@GetMapping("/GetNetWoth/mutualfunds")
	public List<MutualFundDetails> getAllMutualFunds(){
		return mutualFundProxy.getAllMututalFunds();
	}
	
	@GetMapping("/dailyMutualFundNav/{mutualFundName}")
	public MutualFundDetails getMutualDetails(@PathVariable(value="mutualFundName") String mutualFundName) {
		return mutualFundProxy.getMutualDetails(mutualFundName);
	}
	
}
