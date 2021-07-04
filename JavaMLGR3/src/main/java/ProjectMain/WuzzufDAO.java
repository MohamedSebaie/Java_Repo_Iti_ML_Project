package ProjectMain;

import java.io.IOException;
import java.util.*;


import joinery.DataFrame;
import tech.tablesaw.api.Table;
@SuppressWarnings({ "rawtypes"})
public interface WuzzufDAO {
	
	Table ReadAsTable(String csvFile) throws IOException;
	List Summary_Statistics(String csvFile) throws IOException;
	joinery.DataFrame DataCleaning(String InputCSV,String CleanedCSV) throws IOException;
	String WriteTabletoCSV(Table TableName,String CSVoutName) throws IOException;
	smile.data.DataFrame SmileDateFrame(Table TableName);
	String WriteSmiletoCSV(smile.data.DataFrame SmileDf,String ProjectName,String CSVoutName) throws IOException;
	joinery.DataFrame ReadAsJoineryDataFrame(String csvFile) throws IOException;
	List DisplayTopDemandingCompaniesforJobsCharts(joinery.DataFrame df,int SlicingStart, int SlicingEnd);
	List DisplayTopPopularJobTitlesCharts(joinery.DataFrame df,int SlicingStart, int SlicingEnd);
	List DisplayTopPopularAreasCharts(joinery.DataFrame df,int SlicingStart, int SlicingEnd);
	Map Skills(joinery.DataFrame df);
	joinery.DataFrame YearsEXPcol_Factorization(DataFrame df);
	joinery.DataFrame CountryColumnCleaning(DataFrame df);

}
