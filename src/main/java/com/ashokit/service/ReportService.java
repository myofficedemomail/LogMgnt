package com.ashokit.service;

import java.util.List;

import com.ashokit.entity.InsuranceEntity;
import com.ashokit.form.SearchRequest;

public interface ReportService {
	public List<InsuranceEntity> getReportDtls(SearchRequest searchForm) throws Exception;
}
