package ProjectMain;


import java.io.IOException;
import java.util.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings({ "unchecked" ,"rawtypes"})
@RestController
public class RestCo {
	
	@RequestMapping("/MSebaie")
    public String Sebaiefunc(){

        return "Hello Sebaie";
    }
	
	WuzzufDAOImpl object1= new WuzzufDAOImpl();
	
	@RequestMapping("/DisplaydataFrame")
	public List<List<String>>  DisplaydataFrame() throws IOException{
		joinery.DataFrame df=object1.ReadAsJoineryDataFrame("Wuzzuf_Jobs.csv");
		List<List<String>> ls = new ArrayList<List<String>>();
		for(int i = 0 ; i<df.length(); i++) 
		{
			List<String> l = df.row(i);
			ls.add(l);
		}
	return ls;
	}
	
	@RequestMapping("/SummaryandStructure")
	public List SummaryandStructure() throws IOException{
		List SummayStatisticsList= object1.Summary_Statistics("Wuzzuf_Jobs.csv");
	return SummayStatisticsList;
	}
	
	@RequestMapping("/DataCleaning")
	public List<List<String>> DataCleaning() throws IOException{
		joinery.DataFrame df= object1.DataCleaning("Wuzzuf_Jobs.csv","Wuzzuf_JobsCleanedRest.csv");
		List<List<String>> ls = new ArrayList<List<String>>();
		for(int i = 0 ; i<df.length(); i++) 
		{
			List<String> l = df.row(i);
			ls.add(l);
		}
	return ls;
	}
	
	
	@RequestMapping("/TopDemandingCompaniesforJobs")
	public List TopDemandingCompaniesforJobs() throws IOException{
		joinery.DataFrame df= object1.ReadAsJoineryDataFrame("Wuzzuf_JobsCleanedRest.csv");
		List TopDemandingCompanies= object1.DisplayTopDemandingCompaniesforJobsCharts(df,1,11);

	return TopDemandingCompanies;
	}
	
	@RequestMapping("/TopPopularJobTitles")
	public List TopPopularJobTitles() throws IOException{
		joinery.DataFrame df= object1.ReadAsJoineryDataFrame("Wuzzuf_JobsCleanedRest.csv");
		List PopularJobTitles= object1.DisplayTopPopularJobTitlesCharts(df,0,6);
	return PopularJobTitles;
	}
	
	@RequestMapping("/TopPopularAreas")
	public List DisplayTopPopularAreas() throws IOException{
		joinery.DataFrame df= object1.ReadAsJoineryDataFrame("Wuzzuf_JobsCleanedRest.csv");
		List PopularAreas= object1.DisplayTopPopularAreasCharts(df,0,6);
	return PopularAreas;
	}

	@RequestMapping("/Skills")
	public Map Skills() throws IOException{
		joinery.DataFrame df= object1.ReadAsJoineryDataFrame("Wuzzuf_JobsCleanedRest.csv");
		Map skillsMap= object1.Skills(df);
	return skillsMap;
	}
	
	@RequestMapping("/YearsExpFactorization")
	public List<List<String>> YearsExpFactorization() throws IOException{
		joinery.DataFrame df= object1.ReadAsJoineryDataFrame("Wuzzuf_JobsCleanedRest.csv");
		joinery.DataFrame Newdf= object1.YearsEXPcol_Factorization(df);
		List<List<String>> ls = new ArrayList<List<String>>();
		for(int i = 0 ; i<Newdf.length(); i++) 
		{
			List<String> l = Newdf.row(i);
			ls.add(l);
		}
	return ls;
	}
}
