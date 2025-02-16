package com.cognizant.portfolio_management.DailyMutualFundNAV.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.portfolio_management.DailyMutualFundNAV.exception.MutualFundNotFoundException;
import com.cognizant.portfolio_management.DailyMutualFundNAV.model.MutualFund;
import com.cognizant.portfolio_management.DailyMutualFundNAV.repository.MutualFundRepository;

@Service
public class MutualFundService {
	
	
	@Autowired
	private MutualFundRepository repository;
	
	@Transactional
	public List<MutualFund> getAllMutualFund(){
		return repository.findAll();
	}
	
	@Transactional
	public MutualFund getMutualFundByName(String mutualFundName) throws MutualFundNotFoundException{
		if(repository.findByMutualFundName(mutualFundName)==null)
			throw new MutualFundNotFoundException("Mutual Fund Not Found");
		return repository.findByMutualFundName(mutualFundName);
	}

}
