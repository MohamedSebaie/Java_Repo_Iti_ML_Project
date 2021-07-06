package ProjectMain;

import java.util.List;
import java.util.Map;
import joinery.DataFrame;
import tech.tablesaw.api.Table;

@SuppressWarnings({"rawtypes"})
public interface WuzzufDAO {
	
	Table ReadAsTable(String csvFile);
	List<String> Summary_Statistics(String csvFile);
	joinery.DataFrame DataCleaning(String InputCSV,String CleanedCSV);
	String WriteTabletoCSV(Table TableName,String CSVoutName);
	smile.data.DataFrame ReadASSmileDateFrame(String CSVFile);
	String WriteSmiletoCSV(smile.data.DataFrame SmileDf,String ProjectName,String CSVoutName);
	joinery.DataFrame ReadAsJoineryDataFrame(String csvFile);
	List<List<String>> DisplayTopDemandingCompaniesforJobsCharts(joinery.DataFrame df,int SlicingStart, int SlicingEnd);
	List<List<String>> DisplayTopPopularJobTitlesCharts(joinery.DataFrame df,int SlicingStart, int SlicingEnd);
	List<List<String>> DisplayTopPopularAreasCharts(joinery.DataFrame df,int SlicingStart, int SlicingEnd);
	Map<String,Integer> Skills(joinery.DataFrame df);
	joinery.DataFrame YearsEXPcol_Factorization(DataFrame df);
	double[][] KmeanGraph(smile.data.DataFrame df);
	smile.data.DataFrame FactorizeData(smile.data.DataFrame df);
	int[] ColFactorize(smile.data.DataFrame df, String col_name);
	joinery.DataFrame CountryColumnCleaning(DataFrame df);

}
