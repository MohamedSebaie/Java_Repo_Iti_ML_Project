package ProjectMain;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import com.google.common.collect.Lists;

import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler.ChartTheme;

import joinery.DataFrame;
import smile.clustering.KMeans;
import smile.clustering.PartitionClustering;
import smile.plot.swing.ScatterPlot;

public class WuzzufApp {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws IOException, URISyntaxException, InvocationTargetException, InterruptedException  {
		
		WuzzufDAOImpl object1= new WuzzufDAOImpl();
		
		joinery.DataFrame df=object1.ReadAsJoineryDataFrame("Wuzzuf_Jobs.csv");
		System.out.println("Display DataFrame"+"\n"+"-----------------------------------------------");
		System.out.println(df.head(10));
		
		System.out.println("Summary and Structure Before Cleaning"+"\n"+"-----------------------------------------------");
		List SummaryStatisticsList1= object1.Summary_Statistics("Wuzzuf_Jobs.csv");
		System.out.println("Shape: "+"\n\n"+SummaryStatisticsList1.get(0)+"\n\n");
		System.out.println("Structure: "+"\n\n"+SummaryStatisticsList1.get(1)+"\n\n");
		System.out.println("Summary: "+"\n\n"+SummaryStatisticsList1.get(2)+"\n\n");
		System.out.println("*******************************************************************************************");
		joinery.DataFrame dfCleaned= object1.DataCleaning("Wuzzuf_Jobs.csv","Wuzzuf_JobsCleaned.csv");
		
		System.out.println("Summary and Structure After Cleaning"+"\n"+"-----------------------------------------------");
		List SummaryStatisticsList2= object1.Summary_Statistics("Wuzzuf_JobsCleaned.csv");
		System.out.println("Shape: "+"\n\n"+SummaryStatisticsList2.get(0)+"\n\n");
		System.out.println("Structure: "+"\n\n"+SummaryStatisticsList2.get(1)+"\n\n");
		System.out.println("Summary: "+"\n\n"+SummaryStatisticsList2.get(2)+"\n\n");
		System.out.println("*******************************************************************************************");

		
		List<List<String>> List1= object1.DisplayTopDemandingCompaniesforJobsCharts(dfCleaned,1,11);
		List<String>  List11= (List<String>) List1.get(0);
		List<String> List22= List1.get(1);
		
		List <String> names3 = Arrays.asList("Company","Count");
		
		DataFrame<String> dfTopCompanies = new DataFrame<>();
		for (int i = 0;i<names3.size();i++) {
			dfTopCompanies.add(names3.get(i),List1.get(i));
		}
		
		System.out.print(dfTopCompanies);
		System.out.println("*******************************************************************************************");
		
		PieChart chart0 =new PieChartBuilder().width(800).height(600).title("Top_5_DemandingCompaniesforJobs").build();
		for (int i=0;i<List11.size();i++) {chart0.addSeries(List11.get(i),Lists.transform(List22, Integer::parseInt).get(i));}
		new SwingWrapper(chart0).displayChart(); 
		
		CategoryChart chart = new CategoryChartBuilder().width(800).height(600).title("Company vs. Count").xAxisTitle("Title").yAxisTitle("Count").theme(ChartTheme.GGPlot2).build();
	    chart.addSeries(".",List11,Lists.transform(List22, Integer::parseInt));
	    new SwingWrapper(chart).displayChart();
	    
		
		Map map=object1.Skills(dfCleaned);
		
		map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(20).forEach(System.out::println);
		
		smile.data.DataFrame SimleDF= object1.ReadASSmileDateFrame("Wuzzuf_JobsCleaned.csv");
		
		double [][] KMEANS=object1.KmeanGraph(SimleDF);
		
		KMeans clusters = PartitionClustering.run(100, () -> KMeans.fit(KMEANS,3));
		ScatterPlot.of(KMEANS, clusters.y, '.').canvas().setAxisLabels("Companies", "Jobs").window();
		
		
		
		joinery.DataFrame df2= object1.YearsEXPcol_Factorization(dfCleaned);
		
		joinery.DataFrame df3=object1.CountryColumnCleaning(df2);
		 
//		 df3.writeCsv("Wuzzuf_JobsOUTFinal.csv");
		 

	}
	

}
