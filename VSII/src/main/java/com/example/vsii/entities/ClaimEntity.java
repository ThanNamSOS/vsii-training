package com.example.vsii.entities;

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
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data
@Entity
@Table(name = "claim")
@NamedQueries(value = {
@NamedQuery(name = "SearchClaimByApp", 
			query = " SELECT cm From ClaimEntity cm where cm.applicationNumber = :app ")
})
public class ClaimEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Basic(optional = false)
	@Column(name = "applicationNumber")
	private String applicationNumber;
	
	
	@Column(name = "policyNumber")
	private String policyNumber;
	
	@Column(name = "isDeleted")
	private boolean isDeleted;
	
	
	@Column(name = "createdDate")
	private Date createdDate;
}
