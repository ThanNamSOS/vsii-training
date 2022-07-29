package com.example.vsii.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vsii.constant.MessageConstant;
import com.example.vsii.entities.ClaimEntity;
import com.example.vsii.model.ClaimModel;
import com.example.vsii.repository.ClaimRepository;

@Service
public class ClaimService implements IService{

	@Autowired
	private ClaimRepository claimRepository;
	
	@Autowired
	private MessageConstant messageConstant;
	
	@Override
	public List<ClaimEntity> getAll() {
		return claimRepository.findAll();
	}

	@Override
	public void insert(ClaimModel model) {
		ClaimEntity claim = new ClaimEntity();
		claim.setApplicationNumber(model.getApplicationNumber());
		claim.setPolicyNumber(model.getPolicyNumber());
		claim.setDeleted(model.isDeleted());
		claimRepository.save(claim);
	}

	@Override
	public void update(ClaimModel model) {
		ClaimEntity claim = new ClaimEntity();
		claim.setId(claimRepository.findByApplication(model.getApplicationNumber()).getId());
		claim.setApplicationNumber(model.getApplicationNumber());
		claim.setPolicyNumber(model.getPolicyNumber());
		claim.setDeleted(model.isDeleted());
		claimRepository.save(claim);
	}

	@Override
    public ClaimEntity findByApp(String app) {
        return claimRepository.findByApplication(app);
    }
}
