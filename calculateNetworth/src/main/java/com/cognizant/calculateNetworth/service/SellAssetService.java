package com.cognizant.calculateNetworth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.calculateNetworth.model.Asset;
import com.cognizant.calculateNetworth.reposotory.AssetRepository;
@Service
public class SellAssetService {
	
	@Autowired
	private AssetRepository repository;
	
	public void deleteAssetByAssetId(int portfolioId,String assetId,String type) {
		Asset a = repository.findByPortfolioidAndAssetidAndType(portfolioId,assetId, type);
		repository.delete(a);
	}

}
