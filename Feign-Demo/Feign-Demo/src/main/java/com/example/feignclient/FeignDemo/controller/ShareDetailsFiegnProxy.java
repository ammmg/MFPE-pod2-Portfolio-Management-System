package com.example.feignclient.FeignDemo.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.feignclient.FeignDemo.model.StockDetails;

@FeignClient(name="ShareDetailsService",url="localhost:8090")
public interface ShareDetailsFiegnProxy {
	
	@GetMapping("/dailyAllSharePrice")
	public List<StockDetails> findAll();
	
	@GetMapping("/dailySharePrice/{shareName}")
	public StockDetails finddailyShareByName(@PathVariable(value="shareName") String shareName);
	

}
