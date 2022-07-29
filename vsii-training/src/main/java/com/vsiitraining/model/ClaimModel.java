package com.vsiitraining.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "claim")
@NamedQueries(value = {
@NamedQuery(name = "Claim.SearchClaimByApp", 
			query = "SELECT cm From claim cm where cm.applicationNumber = :app"),
})
public class ClaimModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotBlank(message = "* Không để chống mục này")
	@Basic(optional = false)
	@Column(name = "applicationNumber")
	private String applicationNumber;
	
	@NotBlank(message = "* Không để chống mục này")
	@Column(name = "policyNumber")
	private String policyNumber;
	
	@Column(name = "isDeleted")
	private boolean isDeleted;
	
	@JsonFormat(pattern="yyyy-MM-dd@HH:mm:ss.SSSZ", shape = JsonFormat.Shape.STRING)
	@Column(name = "createdDate")
	private Date createdDate;
}