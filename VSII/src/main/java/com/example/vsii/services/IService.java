package com.example.vsii.services;

import java.util.List;

import com.example.vsii.entities.ClaimEntity;
import com.example.vsii.model.ClaimModel;

public interface IService {
	public List<ClaimEntity> getAll();
    public void insert(ClaimModel account);
    public void update(ClaimModel account);
    public ClaimEntity findByApp(String app);
}
