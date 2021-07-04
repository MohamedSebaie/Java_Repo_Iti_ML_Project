package ProjectMain;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;


import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler.ChartTheme;

public class WuzzufApp {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws IOException, URISyntaxException  {
		
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

		
		List List1= object1.DisplayTopDemandingCompaniesforJobsCharts(dfCleaned,1,11);
		List<String>  List11= (List<String>) List1.get(0);
		List<Integer> List22=(List<Integer>) List1.get(1);
		
		PieChart chart0 =new PieChartBuilder().width(800).height(600).title("Top_5_DemandingCompaniesforJobs").build();
		for (int i=0;i<List11.size();i++) {chart0.addSeries(List11.get(i),List22.get(i));}
		new SwingWrapper(chart0).displayChart(); 
		
		CategoryChart chart = new CategoryChartBuilder().width(800).height(600).title("Company vs. Count").xAxisTitle("Title").yAxisTitle("Count").theme(ChartTheme.GGPlot2).build();
	    chart.addSeries(".",List11,List22);
	    new SwingWrapper(chart).displayChart();
	    
		
		Map map=object1.Skills(dfCleaned);
		
		map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(20).forEach(System.out::println);
		
		
		joinery.DataFrame df2= object1.YearsEXPcol_Factorization(dfCleaned);
		
		joinery.DataFrame df3=object1.CountryColumnCleaning(df2);
		 
		 df3.writeCsv("Wuzzuf_JobsOUTFinal.csv");
		 

	}
	

}
