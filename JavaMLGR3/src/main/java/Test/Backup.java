//package Test;
//import java.lang.reflect.InvocationTargetException;
//import java.util.*;
//
//import javax.swing.JFrame;
//
//import joinery.DataFrame;
//import smile.clustering.KMeans;
//import smile.clustering.PartitionClustering;
//import smile.plot.swing.ScatterPlot;
//
//public class Backup {
//		@SuppressWarnings({ "unchecked", "rawtypes" })
//		public static void main(String[] args) throws InvocationTargetException, InterruptedException {
//			Consumer consumer= new Consumer();
//			
//			// 1) Read CSV and Display Some of DataFrame..
//			List<List<String>> ls1 = consumer.DisplaydataFrame();
//			List <String> names1 = Arrays.asList("Title","Company","Location","Type","Level","YearsExp","Country","Skills");
//			
//			DataFrame<String> df1 = new DataFrame<>(names1);
//			for (int i = 0;i<ls1.size();i++) {
//				df1.append(ls1.get(i));
//			}
//			System.out.println("Read CSV and Display it As DataFrame"+"\n"+"-----------------------------------------------");
//			System.out.print(df1.head(10));
//			System.out.println("*******************************************************************************************");
//			
//			
//			// 2) Structure and Summary..
//			List ls2 = consumer.SummaryandStructure();
//			System.out.println("Summary and Structure Before Cleaning"+"\n"+"-----------------------------------------------");
//			System.out.println("Shape: "+"\n\n"+ls2.get(0)+"\n\n");
//			System.out.println("Structure: "+"\n\n"+ls2.get(1)+"\n\n");
//			System.out.println("Summary: "+"\n\n"+ls2.get(2)+"\n\n");
//			System.out.println("*******************************************************************************************");
//			
//			// 3) DataCleaning..
//			List<List<String>> lsCleaned = consumer.DataCleaning();
//			List <String> names2 = Arrays.asList("Title","Company","Location","Type","Level","YearsExp","Country","Skills");
//			
//			DataFrame<String> dfCleaned = new DataFrame<>(names2);
//			for (int i = 0;i<lsCleaned.size();i++) {
//				dfCleaned.append(lsCleaned.get(i));
//			}
//			
//			System.out.print(dfCleaned.head(10));
//			
//			// 4) Top Demanding Companies..
//			List TopCompanies = consumer.TopDemandingCompaniesforJobs();
//			List <String> names3 = Arrays.asList("Company","Count");
//			
//			DataFrame<String> dfTopCompanies = new DataFrame<>();
//			for (int i = 0;i<names3.size();i++) {
//				dfTopCompanies.add(names3.get(i),TopCompanies.get(i));
//			}
//			
//			System.out.print(dfTopCompanies.head());
//			System.out.println("*******************************************************************************************");
//			// 5) Plot Top Demanding Companies..
//			ChartsFunctionToDisplay.displayPie(TopCompanies, "Companies Vs Count");
//			
//			// 6) Top Popular JobTitles..
//			List PopularJobTitles = consumer.TopPopularJobTitles();
//			List <String> names4 = Arrays.asList("Title","Count");
//			
//			DataFrame<String> dfPopularJobTitles = new DataFrame<>();
//			for (int i = 0;i<names4.size();i++) {
//				dfPopularJobTitles.add(names4.get(i),PopularJobTitles.get(i));
//			}
//			
//			System.out.print(dfPopularJobTitles.head());
//			System.out.println("*******************************************************************************************");
//			// 7) Plot Top Popular JobTitles..
//			ChartsFunctionToDisplay.displayBar(PopularJobTitles, "JobTitle Vs Count", "JobTitle", "Count");
//			
//			// 8) Top Popular Areas..
//			List PopularAreas = consumer.TopPopularAreas();
//			List <String> names5 = Arrays.asList("Company","Count");
//			
//			DataFrame<String> dfPopularAreas = new DataFrame<>();
//			for (int i = 0;i<names5.size();i++) {
//				dfPopularAreas.add(names5.get(i),PopularAreas.get(i));
//			}
//			
//			System.out.print(dfPopularAreas.head());
//			System.out.println("*******************************************************************************************");
//			// 9) Plot Top Popular Areas..
//			ChartsFunctionToDisplay.displayBar(PopularAreas, "Location Vs Count", "Location", "Count");
//			
//			// 10) Skills one by one and Print The Top Skills Required..
//			System.out.println("30 Skills One By One"+"\n"+"-----------------------------------------------");
//			Map skillsMap= consumer.Skills();
//			skillsMap.entrySet().stream().limit(30).forEach(System.out::println);
//			System.out.println("*******************************************************************************************");
//			System.out.println("Top 10 Skills One By One"+"\n"+"-----------------------------------------------");
//			skillsMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(10).forEach(System.out::println);
//			System.out.println("*******************************************************************************************");
//			
//			// 11) YearsEXP Column Factorization..
//			List<List<String>> ls5 = consumer.YearsExpFactorization();
//			List <String> names6 = Arrays.asList("Title","Company","Location","Type","Level","YearsExp","Country","Skills");
//			
//			DataFrame<String> df5 = new DataFrame<>(names6);
//			for (int i = 0;i<ls5.size();i++) {
//				df5.append(ls5.get(i));
//			}
//			System.out.println("DataFrame After Factorization YearsEXP Column"+"\n"+"-----------------------------------------------");
//			System.out.print(df5.head(10));
//			System.out.println("*******************************************************************************************");
//			
//			// 12) K-Means for Job Title and Companies ..
//			double [][] KMEANS = consumer.Kmeans();
//			KMeans clusters = PartitionClustering.run(100, () -> KMeans.fit(KMEANS,3));
//			ScatterPlot.of(KMEANS, clusters.y, '.').canvas().setAxisLabels("Companies", "Jobs").window();
//			
//		}
//		
//		
//	//  KMeans clusters = PartitionClustering.run(100, () -> KMeans.fit(kmean.toArray(),3));
//	//  JFrame Image= ScatterPlot.of(kmean.toArray(), clusters.y, '.').canvas().setAxisLabels("Companies", "Jobs").window();
//		
////		private static void abdullah() {
////			Consumer consumer= new Consumer();
////			// 1) Read CSV and Dispaly Some of DataFrame
////			List<List<String>> ls = consumer.DisplaydataFrame();
////			List <String> names = Arrays.asList("Title","Company","Location","Type","Level","YearsExp","Country","Skills");
////			
////			DataFrame<String> df = new DataFrame<>(names);
////			for (int i = 0;i<ls.size();i++) {
////				df.append(ls.get(i));
////			}
////			
////			System.out.print(df.head(10));
////			
////		}
//	}
//
//
//}
