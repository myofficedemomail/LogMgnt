package com.ashokit.runner;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ashokit.entity.InsuranceEntity;
import com.ashokit.repo.InsuranceRepo;
//@Component
public class DataLoader implements CommandLineRunner {
	@Autowired
	private InsuranceRepo repo;
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");
		List<InsuranceEntity> insuranceList=Arrays.asList(new InsuranceEntity("Cash","Approved","Male",format.parse("01-01-2018"),format.parse("01-07-2018"),"Adam",50000,null,null,null),
				new InsuranceEntity("Cash","Approved","Female",format.parse("01-01-2020"),format.parse("01-07-2020"),"Rubic",60000,null,null,null),
				new InsuranceEntity("Cash","Denied","Male",format.parse("01-01-2021"),format.parse("01-07-2021"),"Santra",50000,"No Source Of Income",null,null),
				new InsuranceEntity("Cash","Denied","Female",format.parse("01-01-2022"),format.parse("01-07-2022"),"Amrune",100000,"No Source Of Income",null,null),
				new InsuranceEntity("Cash","Terminated","Male",format.parse("01-01-2023"),format.parse("01-07-2023"),"Camelin Ranze",50000,null,format.parse("01-07-2024"),"Not Renewal"),
				new InsuranceEntity("Cash","Terminated","Female",format.parse("01-01-2019"),format.parse("01-07-2019"),"Green",500000,null,format.parse("01-07-2024"),"Not Renewal"),
				
				new InsuranceEntity("Food","Approved","Male",format.parse("01-01-2020"),format.parse("01-07-2020"),"Zordan",50000,null,null,null),
				new InsuranceEntity("Food","Approved","Female",format.parse("01-01-2021"),format.parse("01-07-2021"),"Lagrin",50000,null,null,null),
				new InsuranceEntity("Food","Denied","Male",format.parse("01-01-2022"),format.parse("01-07-2022"),"Jacoca",50000,"No Source Of Income",null,null),
				new InsuranceEntity("Food","Denied","Female",format.parse("01-01-2023"),format.parse("01-07-2023"),"Desuzza",50000,"No Source Of Income",null,null),
				new InsuranceEntity("Food","Terminated","Male",format.parse("01-01-2019"),format.parse("01-07-2019"),"Domajoaa",50000,null,format.parse("01-07-2024"),"Not Renewal"),
				new InsuranceEntity("Food","Terminated","Female",format.parse("01-01-2018"),format.parse("01-07-2018"),"Hatric Niss",50000,null,format.parse("01-07-2024"),"Not Renewal"),
				
				new InsuranceEntity("Medical","Approved","Male",format.parse("01-01-2020"),format.parse("01-07-2020"),"Martin",50000,null,null,null),
				new InsuranceEntity("Medical","Approved","Female",format.parse("01-01-2021"),format.parse("01-07-2021"),"Holo",50000,null,null,null),
				new InsuranceEntity("Medical","Denied","Male",format.parse("01-01-2022"),format.parse("01-07-2022"),"Cadvod",50000,"No Source Of Income",null,null),
				new InsuranceEntity("Medical","Denied","Female",format.parse("01-01-2023"),format.parse("01-07-2023"),"Ligurin",50000,"No Source Of Income",null,null),
				new InsuranceEntity("Medical","Terminated","Male",format.parse("01-01-2019"),format.parse("01-07-2019"),"Binhis",50000,null,format.parse("01-07-2024"),"Not Renewal"),
				new InsuranceEntity("Medical","Terminated","Female",format.parse("01-01-2018"),format.parse("01-07-2018"),"Eriko",50000,null,format.parse("01-07-2024"),"Not Renewal"),
				
				new InsuranceEntity("Employment","Approved","Male",format.parse("01-01-2020"),format.parse("01-07-2020"),"Zordan",50000,null,null,null),
				new InsuranceEntity("Employment","Approved","Female",format.parse("01-01-2021"),format.parse("01-07-2021"),"Zordan",50000,null,null,null),
				new InsuranceEntity("Employment","Denied","Male",format.parse("01-01-2022"),format.parse("01-07-2022"),"Hisuskih",50000,"No Source Of Income",null,null),
				new InsuranceEntity("Employment","Denied","Female",format.parse("01-01-2023"),format.parse("01-07-2023"),"Lorasil",50000,"No Source Of Income",null,null),
				new InsuranceEntity("Employment","Terminated","Male",format.parse("01-01-2018"),format.parse("01-07-2018"),"Wohan",50000,null,format.parse("01-07-2024"),"Not Renewal"),
				new InsuranceEntity("Employment","Terminated","Female",format.parse("01-01-2019"),format.parse("01-07-2019"),"Pojulika",50000,null,format.parse("01-07-2024"),"Not Renewal")
				);
		repo.saveAll(insuranceList);
	}

}
