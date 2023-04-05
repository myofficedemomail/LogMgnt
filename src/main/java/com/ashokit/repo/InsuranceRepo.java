package com.ashokit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ashokit.entity.InsuranceEntity;

public interface InsuranceRepo extends JpaRepository<InsuranceEntity, Integer>{
	//@Query("from InsuranceEntity where planName=:planName and planStatus=:planStatus and gender:=gender and startDate<=:startDate")
	//public List<InsuranceEntity> getAllInsuranceEntity();
}
