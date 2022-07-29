package com.example.vsii.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.vsii.entities.ClaimEntity;

@Repository
public interface ClaimRepository extends JpaRepository<ClaimEntity, Integer>{
//	@Query("select c from claim c where c.applicationNumber = :app")
//	ClaimModel findByApp(@Param("app") String param);
//	
	@Query(name = "SearchClaimByApp")
	public ClaimEntity findByApplication(@Param("app") String app);
	
}
