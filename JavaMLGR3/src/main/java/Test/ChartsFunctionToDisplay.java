package Test;

import java.util.List;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.Styler.ChartTheme;
@SuppressWarnings({ "unchecked" ,"rawtypes"})
public class ChartsFunctionToDisplay {

	public static void displayPie(List LIST, String PieTitle) {
		
		List<String>  List1= (List<String>) LIST.get(0);
		List<Integer> CountList=(List<Integer>) LIST.get(1);
		
		PieChart chart0 =new PieChartBuilder().width(800).height(600).title(PieTitle).build();
		for (int i=0;i<List1.size();i++) {chart0.addSeries(List1.get(i),CountList.get(i));}
		new SwingWrapper(chart0).displayChart(); 
		

	}
	
	public static void displayBar(List LIST, String BarTitle, String xAxisTitle, String yAxisTitle) {
		List<String>  List1= (List<String>) LIST.get(0);
		List<Integer> CountList=(List<Integer>) LIST.get(1);
		 // Create Chart
		CategoryChart chart = new CategoryChartBuilder().width(800).height(600).title(BarTitle).xAxisTitle(xAxisTitle).yAxisTitle(yAxisTitle).theme(ChartTheme.GGPlot2).build();
	    chart.addSeries(".",List1,CountList);
	    new SwingWrapper(chart).displayChart();

	}

}
