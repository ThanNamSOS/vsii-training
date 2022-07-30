package com.example.vsii.model;

import java.util.Date;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClaimModel {
	
	private int id;
	
	@Length(max = 1028)
	@NotBlank(message = "* Không để chống mục này")
	private String applicationNumber;
	
	@Length(max = 1028)
	@NotBlank(message = "* Không để chống mục này")
	private String policyNumber;
	
	@NotNull
	private boolean isDeleted;
	
	@JsonFormat(pattern="dd-MM-yyyy@HH:mm:ss.SSSZ", shape = JsonFormat.Shape.STRING)
	private Date createdDate;
}
