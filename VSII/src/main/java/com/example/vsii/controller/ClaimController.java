package com.example.vsii.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.vsii.constant.MessageConstant;
import com.example.vsii.entities.ClaimEntity;
import com.example.vsii.model.ClaimModel;
import com.example.vsii.services.IService;
import com.example.vsii.utils.MessageUtils;

@Controller
@RequestMapping("/claim")
public class ClaimController {

	@Autowired
	private IService serviceClaim;

	@Autowired
	private MessageConstant message;

	@PostMapping("/add")
	public ResponseEntity<MessageUtils> addUser(@Valid @RequestBody ClaimModel model, BindingResult result,
			Model model2) {
		ClaimEntity ca = this.serviceClaim.findByApp(model.getApplicationNumber());
		if (result.hasErrors() == true) {
			model2.addAttribute("massage", "dữ liệu không hợp lệ");
			return ResponseEntity.status(HttpStatus.OK)
					.body(new MessageUtils(message.INVALID_ERRO, message.INVALID_ERRO_CODE));
		}
		if (ca != null) {
			serviceClaim.update(model);
			return ResponseEntity.status(HttpStatus.OK)
					.body(new MessageUtils(message.SUCCESSFUL_UPDATE, message.SUCCESSFUL_CODE));
		}
		serviceClaim.insert(model);
		return ResponseEntity.status(HttpStatus.OK)
				.body(new MessageUtils(message.SUCCESSFUL_INSERT, message.SUCCESSFUL_CODE));

	}

}
