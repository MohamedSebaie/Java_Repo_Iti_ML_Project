package ProjectMain;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.util.*;

import javax.swing.JFrame;

import joinery.DataFrame;
import tech.tablesaw.api.Table;
@SuppressWarnings({ "rawtypes"})
public interface WuzzufDAO {
	
	Table ReadAsTable(String csvFile) throws IOException;
	List Summary_Statistics(String csvFile) throws IOException;
	joinery.DataFrame DataCleaning(String InputCSV,String CleanedCSV) throws IOException;
	String WriteTabletoCSV(Table TableName,String CSVoutName) throws IOException;
	smile.data.DataFrame ReadASSmileDateFrame(String CSVFile)throws IOException, URISyntaxException;
	String WriteSmiletoCSV(smile.data.DataFrame SmileDf,String ProjectName,String CSVoutName) throws IOException;
	joinery.DataFrame ReadAsJoineryDataFrame(String csvFile) throws IOException;
	List DisplayTopDemandingCompaniesforJobsCharts(joinery.DataFrame df,int SlicingStart, int SlicingEnd);
	List DisplayTopPopularJobTitlesCharts(joinery.DataFrame df,int SlicingStart, int SlicingEnd);
	List DisplayTopPopularAreasCharts(joinery.DataFrame df,int SlicingStart, int SlicingEnd);
	Map Skills(joinery.DataFrame df);
	joinery.DataFrame YearsEXPcol_Factorization(DataFrame df);
	double[][] KmeanGraph(smile.data.DataFrame df) throws IOException, InvocationTargetException, InterruptedException;
	smile.data.DataFrame FactorizeData(smile.data.DataFrame df);
	int[] factorizeYears(smile.data.DataFrame df, String col_name);
	joinery.DataFrame CountryColumnCleaning(DataFrame df);

}
