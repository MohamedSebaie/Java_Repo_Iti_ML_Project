package Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import joinery.DataFrame;
import smile.clustering.KMeans;
import smile.clustering.PartitionClustering;
import smile.plot.swing.ScatterPlot;
@SuppressWarnings({ "unchecked", "rawtypes" })
public class ConsumerTest {
	
	static Consumer consumer= new Consumer();
	public static void main(String[] args) throws InvocationTargetException, InterruptedException {
		while(true) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please Choose from Below");
		System.out.println("1 - Display data\n2 - Display structure and summary\n3 - Clean Data"
				+ "\n4 - Display most demanding companies\n5 - Pie chart for most demanding companies"
				+ "\n6 - Display most popular job titles\n7 - Bar chart for most popular job titles"
				+ "\n8 - Display most popular areas\n9 - Bar chart for most popular areas"
				+ "\n10 - Display most important skills\n11 - Factorize years of experience"
				+ "\n12 - Kmeans\n13 - Run All WebServices\n14 - Quit");
		
		int x = in.nextInt();
		
		switch (x){
		
		case 1: ReadCSVandDisplayDataFrame(); break;
		case 2: StructureandSummary(); break;
		case 3: DataCleaning(); break;
		case 4: TopDemandingCompaniesforJobs(); break;
		case 5: PlotTopDemandingCompanies(); break;
		case 6: TopPopularJobTitle(); break;
		case 7: PlotTopPopularJobTitles(); break;
		case 8: TopPopularAreas(); break;
		case 9: PlotTopPopularAreas(); break;
		case 10:TopSkills(); break;
		case 11:YearsExpFactorization(); break;
		case 12:Kmeans(); break;
		case 13: 
				ReadCSVandDisplayDataFrame();
				StructureandSummary(); 
				DataCleaning(); 
				TopDemandingCompaniesforJobs();
				PlotTopDemandingCompanies(); 
				TopPopularJobTitle(); 
				PlotTopPopularJobTitles(); 
				TopPopularAreas(); 
				PlotTopPopularAreas();
				TopSkills(); 
				YearsExpFactorization(); 
				Kmeans(); 
				break;
		case 14: return;
		default: System.out.println("Please Enter the Right Number \n");
			
		}
		}
	}
	
	
	// 1) Read CSV and Display Some of DataFrame..
	 static void ReadCSVandDisplayDataFrame() {
		System.out.println("***************************1)ReadCSVandDisplayDataFrame*****************************");
		List<List<String>> ls1 = consumer.DisplaydataFrame();
		List <String> names1 = Arrays.asList("Title","Company","Location","Type","Level","YearsExp","Country","Skills");
		
		DataFrame<String> df1 = new DataFrame<>(names1);
		for (int i = 0;i<ls1.size();i++) {
			df1.append(ls1.get(i));
		}
		System.out.println("Read CSV and Display it As DataFrame"+"\n"+"-----------------------------------------------");
		System.out.print(df1.head(10));
		System.out.println("*******************************************************************************************");
		
	}
	
	
	
	// 2) Structure and Summary..
	 static void StructureandSummary() {
		System.out.println("***************************2)StructureandSummary*****************************");
		List ls2 = consumer.SummaryandStructure();
		System.out.println("Summary and Structure Before Cleaning"+"\n"+"-----------------------------------------------");
		System.out.println("Shape: "+"\n\n"+ls2.get(0)+"\n\n");
		System.out.println("Structure: "+"\n\n"+ls2.get(1)+"\n\n");
		System.out.println("Summary: "+"\n\n"+ls2.get(2)+"\n\n");
		System.out.println("*******************************************************************************************");
		
	}
	
	
	// 3) DataCleaning..
	 static void DataCleaning() {
		System.out.println("***************************3)DataCleaning*****************************");
		List<List<String>> lsCleaned = consumer.DataCleaning();
		List <String> names2 = Arrays.asList("Title","Company","Location","Type","Level","YearsExp","Country","Skills");
		
		DataFrame<String> dfCleaned = new DataFrame<>(names2);
		for (int i = 0;i<lsCleaned.size();i++) {
			dfCleaned.append(lsCleaned.get(i));
		}
		
		System.out.print(dfCleaned.head(10));
		
	}
	
	
	// 4) Top Demanding Companies..
	 static void TopDemandingCompaniesforJobs() {
		System.out.println("***************************4)TopDemandingCompaniesforJobs*****************************");
		List<List<String>> TopCompanies = consumer.TopDemandingCompaniesforJobs();
		List <String> names3 = Arrays.asList("Company","Count");
		
		DataFrame<String> dfTopCompanies = new DataFrame<>();
		for (int i = 0;i<names3.size();i++) {
			dfTopCompanies.add(names3.get(i),TopCompanies.get(i));
		}
		
		System.out.print(dfTopCompanies.head());
		System.out.println("*******************************************************************************************");
		
	}
	
	// 5) Plot Top Demanding Companies..
	 static void PlotTopDemandingCompanies() {
		System.out.println("***************************5)PlotTopDemandingCompanies*****************************");
		List<List<String>> TopCompanies = consumer.TopDemandingCompaniesforJobs();
		ChartsFunctionToDisplay.displayPie(TopCompanies, "Companies Vs Count");
		
	}
	
	
	// 6) Top Popular JobTitles..
	 static void TopPopularJobTitle() {
		System.out.println("***************************6)TopPopularJobTitle*****************************");
		List<List<String>> PopularJobTitles = consumer.TopPopularJobTitles();
		List <String> names4 = Arrays.asList("Title","Count");
		
		DataFrame<String> dfPopularJobTitles = new DataFrame<>();
		for (int i = 0;i<names4.size();i++) {
			dfPopularJobTitles.add(names4.get(i),PopularJobTitles.get(i));
		}
		
		System.out.print(dfPopularJobTitles.head());
		System.out.println("*******************************************************************************************");
		
	}
	
	// 7) Plot Top Popular JobTitles..
	 static void PlotTopPopularJobTitles() {
		System.out.println("***************************7)PlotTopPopularJobTitles*****************************");
		List<List<String>> PopularJobTitles = consumer.TopPopularJobTitles();
		ChartsFunctionToDisplay.displayBar(PopularJobTitles, "JobTitle Vs Count", "JobTitle", "Count");
		
	}
	
	// 8) Top Popular Areas..
	 static void TopPopularAreas() {
		System.out.println("***************************8)TopPopularAreas*****************************");
		List<List<String>> PopularAreas = consumer.TopPopularAreas();
		List <String> names5 = Arrays.asList("Company","Count");
		
		DataFrame<String> dfPopularAreas = new DataFrame<>();
		for (int i = 0;i<names5.size();i++) {
			dfPopularAreas.add(names5.get(i),PopularAreas.get(i));
		}
		
		System.out.print(dfPopularAreas.head());
		System.out.println("*******************************************************************************************");
		
	}
	
	// 9) Plot Top Popular Areas..
	 static void PlotTopPopularAreas() {
		System.out.println("***************************9)PlotTopPopularAreas*****************************");
		List<List<String>> PopularAreas = consumer.TopPopularAreas();
		ChartsFunctionToDisplay.displayBar(PopularAreas, "Location Vs Count", "Location", "Count");
		
	}
	
	
	// 10) Skills one by one and Print The Top Skills Required..
	 static void TopSkills() {
		System.out.println("***************************10)TopSkills*****************************");
		System.out.println("30 Skills One By One"+"\n"+"-----------------------------------------------");
		Map skillsMap= consumer.Skills();
		skillsMap.entrySet().stream().limit(30).forEach(System.out::println);
		System.out.println("*******************************************************************************************");
		System.out.println("Top 10 Skills One By One"+"\n"+"-----------------------------------------------");
		skillsMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(10).forEach(System.out::println);
		System.out.println("*******************************************************************************************");
		
	}
	
	
	// 11) YearsEXP Column Factorization..
	 static void YearsExpFactorization() {
		System.out.println("***************************11)YearsExpFactorization*****************************");
		List<List<String>> ls5 = consumer.YearsExpFactorization();
		List <String> names6 = Arrays.asList("Title","Company","Location","Type","Level","YearsExp","Country","Skills","FactorizeYearsExp");
		
		DataFrame<String> df5 = new DataFrame<>(names6);
		for (int i = 0;i<ls5.size();i++) {
			df5.append(ls5.get(i));
		}
		System.out.println("DataFrame After Factorization YearsEXP Column"+"\n"+"-----------------------------------------------");
		System.out.print(df5.head(10));
		System.out.println("*******************************************************************************************");
		
	}
	
	
	// 12) K-Means for Job Title and Companies ..
	 static void Kmeans() {
		System.out.println("***************************12)Kmeans*****************************");
		double [][] KMEANS = consumer.Kmeans();
		KMeans clusters = PartitionClustering.run(100, () -> KMeans.fit(KMEANS,3));
		try {
			ScatterPlot.of(KMEANS, clusters.y, '.').canvas().setAxisLabels("Companies", "Jobs").window();
		} catch (InvocationTargetException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
