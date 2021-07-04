package Test;
import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
@SuppressWarnings({ "unchecked" ,"rawtypes"})
public class Consumer {
	
	@Autowired
	RestTemplate restTemplate = new RestTemplate();
	
	public List<List<String>> DisplaydataFrame() {
		List<List<String>> df = restTemplate.getForObject("http://localhost:8080/DisplaydataFrame", List.class);
		return df;
		}
	
	
	public List SummaryandStructure() {
		List df = restTemplate.getForObject("http://localhost:8080/SummaryandStructure", List.class);
		return df;
		}
	
	public List<List<String>> DataCleaning() {
		
		List<List<String>> dfCleaned = restTemplate.getForObject("http://localhost:8080/DataCleaning", List.class);
		return dfCleaned;
		}
	
	public List TopDemandingCompaniesforJobs() {
		List TopCompanies = restTemplate.getForObject("http://localhost:8080/TopDemandingCompaniesforJobs", List.class);
		return TopCompanies;
		}
	
	public List TopPopularJobTitles() {
		List PopularJobTitles = restTemplate.getForObject("http://localhost:8080/TopPopularJobTitles", List.class);
		return PopularJobTitles;
		}
	
	public List TopPopularAreas() {
		List PopularAreas = restTemplate.getForObject("http://localhost:8080/TopPopularAreas", List.class);
		return PopularAreas;
		}
	
	public Map Skills() {
		Map skillsMap = restTemplate.getForObject("http://localhost:8080/Skills", Map.class);
		return skillsMap;
		}
	
	public List<List<String>> YearsExpFactorization() {
		List<List<String>> df = restTemplate.getForObject("http://localhost:8080/YearsExpFactorization", List.class);
		return df;
		}
	
	public double [][] Kmeans() {
		double [][] KMEANS = restTemplate.getForObject("http://localhost:8080/Kmeans", double [][].class);
		return KMEANS;
		}
	
}
