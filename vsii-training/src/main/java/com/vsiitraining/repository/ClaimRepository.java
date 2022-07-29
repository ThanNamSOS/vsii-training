package com.vsiitraining.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vsiitraining.model.ClaimModel;

@Repository
public interface ClaimRepository extends JpaRepository<ClaimModel, Integer>{

//	@Query(name = "Claim.SearchClaimByApp")
//	public ClaimModel SearchClaimByApp(@Param("app") String app);
	
}
