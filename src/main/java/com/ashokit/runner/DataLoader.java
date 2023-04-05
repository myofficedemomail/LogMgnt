package com.ashokit.runner;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ashokit.entity.InsuranceEntity;
import com.ashokit.repo.InsuranceRepo;
@Component
public class DataLoader implements CommandLineRunner {
	@Autowired
	private InsuranceRepo repo;
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");
		List<InsuranceEntity> insuranceList=Arrays.asList(new InsuranceEntity("Cash","Approved","Male",format.parse("01-01-1998"),format.parse("01-07-1998")),
				new InsuranceEntity("Cash","Approved","Female",format.parse("01-01-1999"),format.parse("01-07-1999")),
				new InsuranceEntity("Cash","Denied","Male",format.parse("01-01-2000"),format.parse("01-07-2000")),
				new InsuranceEntity("Cash","Denied","Female",format.parse("01-01-2001"),format.parse("01-07-2001")),
				new InsuranceEntity("Cash","Terminated","Male",format.parse("01-01-2002"),format.parse("01-07-2002")),
				new InsuranceEntity("Cash","Terminated","Female",format.parse("01-01-2003"),format.parse("01-07-2003")),
				
				new InsuranceEntity("Food","Approved","Male",format.parse("01-01-2004"),format.parse("01-07-2004")),
				new InsuranceEntity("Food","Approved","Female",format.parse("01-01-2005"),format.parse("01-07-2005")),
				new InsuranceEntity("Food","Denied","Male",format.parse("01-01-2006"),format.parse("01-07-2006")),
				new InsuranceEntity("Food","Denied","Female",format.parse("01-01-2007"),format.parse("01-07-2007")),
				new InsuranceEntity("Food","Terminated","Male",format.parse("01-01-2008"),format.parse("01-07-2008")),
				new InsuranceEntity("Food","Terminated","Female",format.parse("01-01-2009"),format.parse("01-07-2009")),
				
				new InsuranceEntity("Medical","Approved","Male",format.parse("01-01-2010"),format.parse("01-07-2010")),
				new InsuranceEntity("Medical","Approved","Female",format.parse("01-01-2011"),format.parse("01-07-2011")),
				new InsuranceEntity("Medical","Denied","Male",format.parse("01-01-2012"),format.parse("01-07-2012")),
				new InsuranceEntity("Medical","Denied","Female",format.parse("01-01-2013"),format.parse("01-07-2013")),
				new InsuranceEntity("Medical","Terminated","Male",format.parse("01-01-2014"),format.parse("01-07-2014")),
				new InsuranceEntity("Medical","Terminated","Female",format.parse("01-01-2015"),format.parse("01-07-2015")),
				
				new InsuranceEntity("Employment","Approved","Male",format.parse("01-01-2016"),format.parse("01-07-2016")),
				new InsuranceEntity("Employment","Approved","Female",format.parse("01-01-2017"),format.parse("01-07-2017")),
				new InsuranceEntity("Employment","Denied","Male",format.parse("01-01-2018"),format.parse("01-07-2018")),
				new InsuranceEntity("Employment","Denied","Female",format.parse("01-01-2019"),format.parse("01-07-2019")),
				new InsuranceEntity("Employment","Terminated","Male",format.parse("01-01-2020"),format.parse("01-07-2020")),
				new InsuranceEntity("Employment","Terminated","Female",format.parse("01-01-2021"),format.parse("01-07-2021"))
				);
		repo.saveAll(insuranceList);
	}

}
