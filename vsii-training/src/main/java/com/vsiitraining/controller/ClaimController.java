package com.vsiitraining.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.vsiitraining.model.ClaimModel;
import com.vsiitraining.repository.ClaimRepository;

public class ClaimController {
	@Autowired
	private ClaimRepository claimRepository;
	
	@PostMapping("/add")
	public void addUser(@RequestBody ClaimModel model)  {
//		if(claimRepository.findByApp(model.getApplicationNumber()) != null) {
//			claimRepository.save(model);
//		};
		
	}
}
