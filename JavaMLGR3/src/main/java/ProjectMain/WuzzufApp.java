package ProjectMain;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler.ChartTheme;

import joinery.DataFrame;
import smile.clustering.*;
import smile.plot.swing.ScatterPlot;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class WuzzufApp 
{

	
	public static void main(String[] args)
	{
		
		WuzzufDAOImpl Wuzzufobject= new WuzzufDAOImpl();
		
		joinery.DataFrame df=Wuzzufobject.ReadAsJoineryDataFrame("Wuzzuf_Jobs.csv");
		System.out.println("Display DataFrame"+"\n"+"-----------------------------------------------");
		System.out.println(df.head(10));
		
		System.out.println("Summary and Structure Before Cleaning"+"\n"+"-----------------------------------------------");
		List SummaryStatisticsList1= Wuzzufobject.Summary_Statistics("Wuzzuf_Jobs.csv");
		System.out.println("Shape: "+"\n\n"+SummaryStatisticsList1.get(0)+"\n\n");
		System.out.println("Structure: "+"\n\n"+SummaryStatisticsList1.get(1)+"\n\n");
		System.out.println("Summary: "+"\n\n"+SummaryStatisticsList1.get(2)+"\n\n");
		System.out.println("*******************************************************************************************");
		joinery.DataFrame dfCleaned= Wuzzufobject.DataCleaning("Wuzzuf_Jobs.csv","Wuzzuf_JobsCleaned.csv");
		
		System.out.println("Summary and Structure After Cleaning"+"\n"+"-----------------------------------------------");
		List SummaryStatisticsList2= Wuzzufobject.Summary_Statistics("Wuzzuf_JobsCleaned.csv");
		System.out.println("Shape: "+"\n\n"+SummaryStatisticsList2.get(0)+"\n\n");
		System.out.println("Structure: "+"\n\n"+SummaryStatisticsList2.get(1)+"\n\n");
		System.out.println("Summary: "+"\n\n"+SummaryStatisticsList2.get(2)+"\n\n");
		System.out.println("*******************************************************************************************");

		
		List<List<String>> List1= Wuzzufobject.DisplayTopDemandingCompaniesforJobsCharts(dfCleaned,1,11);
		List <String> names = Arrays.asList("Company","Count");
		
		DataFrame<String> dfTopCompanies = new DataFrame<>();
		for (int i = 0;i<names.size();i++) {dfTopCompanies.add(names.get(i),List1.get(i));}
		
		System.out.print(dfTopCompanies);
		System.out.println("*******************************************************************************************");
		
		List ListToPlot1= Wuzzufobject.DisplayTopDemandingCompaniesforJobsCharts(dfCleaned,1,11);
		List<String>  List11= (List<String>) ListToPlot1.get(0);
		List<Integer> List22= (List<Integer>) ListToPlot1.get(1);
		PieChart chart0 =new PieChartBuilder().width(800).height(600).title("Top_5_DemandingCompaniesforJobs").build();
		for (int i=0;i<List11.size();i++) {chart0.addSeries(List11.get(i),List22.get(i));}
		new SwingWrapper(chart0).displayChart(); 
		
		CategoryChart chart = new CategoryChartBuilder().width(800).height(600).title("Company vs. Count").xAxisTitle("Title").yAxisTitle("Count").theme(ChartTheme.GGPlot2).build();
	    chart.addSeries(".",List11,List22);
	    new SwingWrapper(chart).displayChart();
	    
		
		Map map=Wuzzufobject.Skills(dfCleaned);
		
		map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(20).forEach(System.out::println);
		
		smile.data.DataFrame SimleDF= Wuzzufobject.ReadASSmileDateFrame("Wuzzuf_JobsCleaned.csv");
		
		double [][] KMEANS=Wuzzufobject.KmeanGraph(SimleDF);
		
		KMeans clusters = PartitionClustering.run(100, () -> KMeans.fit(KMEANS,3));
		
		try 
		{ScatterPlot.of(KMEANS, clusters.y, '.').canvas().setAxisLabels("Companies", "Jobs").window();} 
		
		catch (InvocationTargetException | InterruptedException e) 
		{e.printStackTrace();}
		
		
		
		joinery.DataFrame df2= Wuzzufobject.YearsEXPcol_Factorization(dfCleaned);
		
		System.out.println(df2);
		
		joinery.DataFrame df3=Wuzzufobject.CountryColumnCleaning(df2);
		
		System.out.println(df3);
		 
		 

	}
	

}