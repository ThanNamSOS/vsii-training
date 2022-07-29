package com.example.vsii.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClaimModel {
	
	private int id;
	
	@NotBlank(message = "* Không để chống mục này")
	private String applicationNumber;
	
	@NotBlank(message = "* Không để chống mục này")
	private String policyNumber;
	
	
	private boolean isDeleted;
	
	@JsonFormat(pattern="yyyy-MM-dd@HH:mm:ss.SSSZ", shape = JsonFormat.Shape.STRING)
	private Date createdDate;
}
