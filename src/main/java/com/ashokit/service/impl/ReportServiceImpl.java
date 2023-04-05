package com.ashokit.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.ashokit.entity.InsuranceEntity;
import com.ashokit.form.SearchRequest;
import com.ashokit.repo.InsuranceRepo;
import com.ashokit.service.ReportService;
@Service
public class ReportServiceImpl implements ReportService {
	@Autowired
	private InsuranceRepo repo;
	@Override
	public List<InsuranceEntity> getReportDtls(SearchRequest searchForm) throws Exception {
		SimpleDateFormat format=new SimpleDateFormat("MM/dd/yyyy");
		InsuranceEntity insuranceEntity=new InsuranceEntity();
		if(!searchForm.getPlanName().equalsIgnoreCase("")) {
			insuranceEntity.setPlan_name(searchForm.getPlanName());
		}
		if(!searchForm.getPlanStatus().equalsIgnoreCase("")) {
			insuranceEntity.setPlan_status(searchForm.getPlanStatus());
		}
		if(!searchForm.getGender().equalsIgnoreCase("")) {
			insuranceEntity.setGender(searchForm.getGender());
		}
		if(!searchForm.getStartDate().equalsIgnoreCase("") && searchForm.getStartDate()!=null)
			insuranceEntity.setPlan_start_date(format.parse(searchForm.getStartDate()));
		if(!searchForm.getEndDate().equalsIgnoreCase("") && searchForm.getEndDate()!=null)
			insuranceEntity.setPlan_end_date(format.parse(searchForm.getEndDate()));
		List<InsuranceEntity> listInsuranceEntity=repo.findAll(Example.of(insuranceEntity));
		return listInsuranceEntity;
	}

}
