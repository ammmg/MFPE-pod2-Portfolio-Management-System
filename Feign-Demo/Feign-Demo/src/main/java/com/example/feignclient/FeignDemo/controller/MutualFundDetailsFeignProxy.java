package com.example.feignclient.FeignDemo.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.feignclient.FeignDemo.model.MutualFundDetails;

@FeignClient(name="DailyMutualFundService",url="localhost:8091")
public interface MutualFundDetailsFeignProxy {
	
	@GetMapping("/dailyAllMutualFundNav")
	public List<MutualFundDetails> getAllMututalFunds();
	
	@GetMapping("/dailyMutualFundNav/{mutualFundName}")
	public MutualFundDetails getMutualDetails(@PathVariable(value="mutualFundName") String mutualFundName);

}
