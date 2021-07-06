package ProjectMain;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings({ "unchecked" ,"rawtypes"})
@RestController
public class RestCo {
	
	WuzzufDAOImpl Wuzzufobject= new WuzzufDAOImpl();
	
	@RequestMapping("/DisplaydataFrame")
	public List<List<String>>  DisplaydataFrame() {
		joinery.DataFrame df=Wuzzufobject.ReadAsJoineryDataFrame("Wuzzuf_Jobs.csv");
		List<List<String>> ls = new ArrayList<List<String>>();
		for(int i = 0 ; i<df.length(); i++) 
		{
			List<String> l = df.row(i);
			ls.add(l);
		}
	return ls;
	}
	
	@RequestMapping("/SummaryandStructure")
	public List SummaryandStructure() {
		List SummayStatisticsList= Wuzzufobject.Summary_Statistics("Wuzzuf_Jobs.csv");
	return SummayStatisticsList;
	}
	
	@RequestMapping("/DataCleaning")
	public List<List<String>> DataCleaning(){
		joinery.DataFrame df= Wuzzufobject.DataCleaning("Wuzzuf_Jobs.csv","Wuzzuf_JobsCleanedRest.csv");
		List<List<String>> ls = new ArrayList<List<String>>();
		for(int i = 0 ; i<df.length(); i++) 
		{
			List<String> l = df.row(i);
			ls.add(l);
		}
	return ls;
	}
	
	
	@RequestMapping("/TopDemandingCompaniesforJobs")
	public List TopDemandingCompaniesforJobs()
	{
		joinery.DataFrame df= Wuzzufobject.ReadAsJoineryDataFrame("Wuzzuf_JobsCleanedRest.csv");
		List TopDemandingCompanies= Wuzzufobject.DisplayTopDemandingCompaniesforJobsCharts(df,1,11);

	return TopDemandingCompanies;
	}
	
	@RequestMapping("/TopPopularJobTitles")
	public List TopPopularJobTitles()
	{
		joinery.DataFrame df= Wuzzufobject.ReadAsJoineryDataFrame("Wuzzuf_JobsCleanedRest.csv");
		List PopularJobTitles= Wuzzufobject.DisplayTopPopularJobTitlesCharts(df,0,6);
	return PopularJobTitles;
	}
	
	@RequestMapping("/TopPopularAreas")
	public List DisplayTopPopularAreas()
	{
		joinery.DataFrame df= Wuzzufobject.ReadAsJoineryDataFrame("Wuzzuf_JobsCleanedRest.csv");
		List PopularAreas= Wuzzufobject.DisplayTopPopularAreasCharts(df,0,6);
	return PopularAreas;
	}

	@RequestMapping("/Skills")
	public Map Skills()
	{
		joinery.DataFrame df= Wuzzufobject.ReadAsJoineryDataFrame("Wuzzuf_JobsCleanedRest.csv");
		Map skillsMap= Wuzzufobject.Skills(df);
	return skillsMap;
	}
	
	@RequestMapping("/YearsExpFactorization")
	public List<List<String>> YearsExpFactorization()
	{
		joinery.DataFrame df= Wuzzufobject.ReadAsJoineryDataFrame("Wuzzuf_JobsCleanedRest.csv");
		joinery.DataFrame Newdf= Wuzzufobject.YearsEXPcol_Factorization(df);
		List<List<String>> ls = new ArrayList<List<String>>();
		for(int i = 0 ; i<Newdf.length(); i++) 
		{
			List<String> l = Newdf.row(i);
			ls.add(l);
		}
	return ls;
	}
	
	@RequestMapping("/Kmeans")
	public double [][] Kmeans()
	{
		smile.data.DataFrame SimleDF= Wuzzufobject.ReadASSmileDateFrame("Wuzzuf_JobsCleanedRest.csv");
		double [][] KMEANS= Wuzzufobject.KmeanGraph(SimleDF);
		
	return KMEANS;
	}
}
