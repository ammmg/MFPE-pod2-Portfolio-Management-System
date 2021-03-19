package com.cognizant.calculateNetworth.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.calculateNetworth.model.Asset;
import com.cognizant.calculateNetworth.model.MutualFundDetails;
import com.cognizant.calculateNetworth.model.SellObject;
import com.cognizant.calculateNetworth.model.StockDetails;
import com.cognizant.calculateNetworth.service.AssetService;
import com.cognizant.calculateNetworth.service.SellAssetService;

@RestController
@RequestMapping("/NetWorth")
public class StocksContoller {

	@Autowired
	private ShareDetailsFiegnProxy proxy;
	
	@Autowired
	private MutualFundDetailsFeignProxy mutualFundProxy;
	
	@Autowired
	private AssetService assetservice;
	
	@Autowired
	private SellAssetService sellService;
	
	@GetMapping("/calculateNetworth/{id}")
	public double getAsset(@PathVariable(value="id") int id){
		
		double netWorth = 0.0; 
		List<Asset> assets = assetservice.getAllAssetForPortfolio(id);
		//List<StockDetails> shareslist = proxy.findAll();
		for(Asset i:assets) {
			if(i.getType().equals("Share")) {
				StockDetails s = proxy.finddailyShareById(i.getAssetid());
				netWorth+=(s.getShareValue()*i.getUnits());
			}else {
				MutualFundDetails m = mutualFundProxy.getMutualDetailsById(i.getAssetid());
				netWorth+=(m.getMutualFundValue() *i.getUnits());
			}
		}
		return netWorth;
		
	}
	
//	@PostMapping("/SellAseets/{portfolioId}/{assetId}/{assetType}")
//	public double calculateBalancePostSell(@PathVariable(value="portfolioId") int portfolioId,@PathVariable(value="assetId") String assetId,@PathVariable(value="assetType") String assetType) {
//		sellService.deleteAssetByAssetId(portfolioId,assetId, assetType);
//		return getAsset(portfolioId);
//	}
	
	@PostMapping("/SellAseets")
	public double calculateBalancePostSell(@RequestBody SellObject sell) {
//		SellObject sell =(SellObject) obj; 
		List<String> assetlist = sell.getAid();
		for(String s:assetlist) {
			sellService.deleteAssetByAssetId(sell.getPid(),s,sell.getAtype());
		}
		return getAsset(sell.getPid());
	}
	
	@GetMapping("/shares")
	public List<Asset> getAllStocks(){
		List<Asset> stockList = new ArrayList<>();
		List<StockDetails> shareslist = proxy.findAll();
		for(StockDetails s:shareslist)
		{
			stockList.add(new Asset(10,s.getShareId(),1,"share",10));
		}
		return stockList;
	}
	
	@GetMapping("/pershare/{shareName}")
	public StockDetails getStcokName(@PathVariable(value="shareName") String shareName) {
		return proxy.finddailyShareByName(shareName);
	}
	
	@GetMapping("/mutualfunds")
	public List<MutualFundDetails> getAllMutualFunds(){
		return mutualFundProxy.getAllMututalFunds();
	}
	
	@GetMapping("/dailyMutualFundNav/{mutualFundName}")
	public MutualFundDetails getMutualDetails(@PathVariable(value="mutualFundName") String mutualFundName) {
		return mutualFundProxy.getMutualDetails(mutualFundName);
	}
	
}
