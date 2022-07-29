package com.example.vsii.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.vsii.entities.ClaimEntity;
import com.example.vsii.model.ClaimModel;
import com.example.vsii.repository.ClaimRepository;

@Controller
@RequestMapping("/claim")
public class ClaimController {

	@Autowired
	private ClaimRepository claimRepository;

	@PostMapping("/add")
	public String addUser(@Valid @RequestBody ClaimModel model, BindingResult result) {
		System.out.println(model.getApplicationNumber());
		ClaimEntity ca = this.claimRepository.findByApplication(model.getApplicationNumber());
		if (result.hasErrors() == true) {
			return "dữ liệu không hợp lệ";
		}
		if (ca != null) {
			System.out.println(this.claimRepository.findByApplication(model.getApplicationNumber()).getId());
			ClaimEntity claim = new ClaimEntity();
			claim.setId(ca.getId());
			claim.setApplicationNumber(model.getApplicationNumber());
			claim.setPolicyNumber(model.getPolicyNumber());
			claim.setDeleted(model.isDeleted());
			claimRepository.save(claim);
			return "Sửa thành công!";
		}
		ClaimEntity claim = new ClaimEntity();
		claim.setApplicationNumber(model.getApplicationNumber());
		claim.setPolicyNumber(model.getPolicyNumber());
		claim.setDeleted(model.isDeleted());
		claimRepository.save(claim);
		return "Thêm mới thành công!";

	}

}
