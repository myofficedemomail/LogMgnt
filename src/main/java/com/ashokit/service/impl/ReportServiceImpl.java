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
		//List<InsuranceEntity> listInsuranceEntity=repo.findAll(Example.of(new InsuranceEntity(searchForm.getPlanName(),searchForm.getPlanStatus(),searchForm.getGender(),format.parse(searchForm.getStartDate()),format.parse(searchForm.getEndDate()))));
		//return listInsuranceEntity;
		return null;
	}

}
