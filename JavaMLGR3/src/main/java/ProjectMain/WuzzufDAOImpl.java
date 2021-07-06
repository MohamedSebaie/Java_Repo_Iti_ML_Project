package ProjectMain;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.*;
import org.apache.commons.csv.CSVFormat;
import joinery.DataFrame;
import smile.data.measure.NominalScale;
import smile.data.vector.IntVector;
import smile.io.*;
import tech.tablesaw.api.Table;

@SuppressWarnings({ "unchecked" ,"rawtypes"})
public class WuzzufDAOImpl implements WuzzufDAO
{

	@Override
	public Table ReadAsTable(String csvFile)
	{
		Table table1 = null;
		try 
		{table1 = Table.read().csv(csvFile);} 
		catch (IOException e) 
		{e.printStackTrace();}
		
		return table1;
	}
	
	@Override
	public List<String> Summary_Statistics(String csvFile)
	{
		Table table1 = ReadAsTable(csvFile);
		String Shape= table1.shape().toString();
		String Structure= table1.structure().toString();
		String Summary= table1.summary().toString();
		List<String> list= new ArrayList<>();
		list.add(Shape);
		list.add(Structure);
		list.add(Summary);
		return list;
	}

	@Override
	public joinery.DataFrame DataCleaning(String InputCSV, String CleanedCSV) 
	{
		Table table1 = ReadAsTable(InputCSV);
		Table table2=table1.dropDuplicateRows().dropRowsWithMissingValues();
		WriteTabletoCSV(table2,CleanedCSV);
		joinery.DataFrame dfJoinery= ReadAsJoineryDataFrame(CleanedCSV);
		
		return dfJoinery;
	}

	@Override
	public String WriteTabletoCSV(Table TableName,String CSVoutName)
	{
		
		try 
		{TableName.write().csv(CSVoutName);} 
		
		catch (IOException e) 
		{e.printStackTrace();}
		
		return CSVoutName;
	}

	@Override
	public smile.data.DataFrame ReadASSmileDateFrame(String CSVFile) 
	{
		
		CSVFormat format = CSVFormat.DEFAULT.withFirstRecordAsHeader().withDelimiter(',');
		smile.data.DataFrame dfSmile = null;
		
		try 
		{dfSmile = Read.csv(CSVFile,format);} 
		
		catch (IOException | URISyntaxException e) 
		{e.printStackTrace();}
		
		return dfSmile;
	}
	
	@Override
	public String WriteSmiletoCSV(smile.data.DataFrame SmileDf, String Path, String CSVoutName)
	{
		Path path = Paths.get(Path);
		
		
		try 
		{Write.csv(SmileDf, path);} 
		
		catch (IOException e) 
		{e.printStackTrace();}
		
		return CSVoutName;
	}

	@Override
	public joinery.DataFrame ReadAsJoineryDataFrame(String csvFile)
	{

		DataFrame dfJoinery = null;
		try 
		{dfJoinery = DataFrame.readCsv(csvFile);} 
		
		catch (IOException e) 
		{e.printStackTrace();}
		
		return dfJoinery;
	}

	@Override
	public List<List<String>> DisplayTopDemandingCompaniesforJobsCharts(joinery.DataFrame df, int SlicingStart, int SlicingEnd) 
	{
		joinery.DataFrame dfJoinery= df.retain("Title","Company").groupBy("Company").count().sortBy(-1).slice(SlicingStart, SlicingEnd);
		
		List<String> companyList= dfJoinery.col("Company");
		List<String> countList=dfJoinery.col("Title");
		
		List<List<String>> LIST= new ArrayList<>();
		LIST.add(companyList);
		LIST.add(countList);
		return LIST;
	}

	@Override
	public List<List<String>> DisplayTopPopularJobTitlesCharts(joinery.DataFrame df,int SlicingStart, int SlicingEnd) 
	{
		joinery.DataFrame dfJoinery1= df.retain("Title","Company").groupBy("Title").count().sortBy(-1).slice(SlicingStart, SlicingEnd);
		
		List<String> titleList= dfJoinery1.col("Title");
		List<String> countList1=dfJoinery1.col("Company");
		List<List<String>> LIST= new ArrayList<>();
		LIST.add(titleList);
		LIST.add(countList1);
		return LIST;
	}
	
	@Override
	public List<List<String>> DisplayTopPopularAreasCharts(joinery.DataFrame df,int SlicingStart, int SlicingEnd) 
	{
	    joinery.DataFrame dfJoinery2= df.retain("Location","Title").groupBy("Location").count().sortBy(-1).slice(SlicingStart, SlicingEnd);
	    
	    
	    List<String> locationList= dfJoinery2.col("Location");
		List<String> countList2=dfJoinery2.col("Title");
		List<List<String>> LIST= new ArrayList<>();
		LIST.add(locationList);
		LIST.add(countList2);
		return LIST;
		
	}

	@Override
	public Map<String,Integer> Skills(joinery.DataFrame df) 
	{
		
		DataFrame J=df.retain("Skills");
		List SkillsList=J.flatten();
		String s=SkillsList.toString();
		List<String> items = Arrays.asList(s.split(","));
		
		Set<String> distinct = new HashSet<>(items);
		Map<String,Integer> map= new HashMap<String, Integer>();
        
		for (String ST: distinct){map.put(ST, Collections.frequency(items, ST));}
		

		return map;
	}
	
	@Override
	public joinery.DataFrame YearsEXPcol_Factorization(joinery.DataFrame df) 
	{
		
		
		joinery.DataFrame YearsEXP=df.retain("YearsExp");
		List YearsEXPList=YearsEXP.flatten();
		
		List<String> YearsEXPNEW= new ArrayList<String>();
		
		for (Object s: YearsEXPList) 
		{
			s = ((String) s).replace("Yrs of Exp", "").strip();
			s = ((String) s).replace("+", "0").strip();
			s = ((String) s).replace("-", "").strip();
			s = ((String) s).replace("null", "0").strip();
			YearsEXPNEW.add((String) s);
		}
		
	    
	    List<String> NewOne= new ArrayList<String>();

	    for (String s:YearsEXPNEW) 
	    {
	    	
	    	if (s.equals("0")|s.equals("1")) {
	    		NewOne.add("0");}
	    	
	    	else if (s.equals("200"))  {
	    		NewOne.add("3");}
	    	
	    	else if (s.length()==2 && Character.getNumericValue(s.charAt(0)) >= 0 && Character.getNumericValue(s.charAt(0)) < 5 && Character.getNumericValue(s.charAt(1))<= 5) {
	    		NewOne.add("0");}
	    	else if (((s.length()==2 && Character.getNumericValue(s.charAt(0))< 10 && Character.getNumericValue(s.charAt(1))< 10 && Character.getNumericValue(s.charAt(1))> 5)) |(s.length()==2 && Character.getNumericValue(s.charAt(0))>= 5 && Character.getNumericValue(s.charAt(0))< 10 && Character.getNumericValue(s.charAt(1))== 0))  {
	    		NewOne.add("1");}
	    	
	    	else if (s.length()==3 && Character.getNumericValue(s.charAt(0))< 10 && Character.getNumericValue(s.charAt(1))== 1 && Character.getNumericValue(s.charAt(2))== 0 )  {
	    		NewOne.add("1");}
	    	
	    	else if (s.length()==3 && Character.getNumericValue(s.charAt(0))< 10 && Character.getNumericValue(s.charAt(1)) <5 && Character.getNumericValue(s.charAt(1))!=2 && Character.getNumericValue(s.charAt(2))<= 5)  {
	    		NewOne.add("2");}
	    	
	    	else if (s.length()==4 && Character.getNumericValue(s.charAt(0))== 1 && Character.getNumericValue(s.charAt(1))< 5 && Character.getNumericValue(s.charAt(2))== 1 && Character.getNumericValue(s.charAt(3)) <=5 )  {
	    		NewOne.add("2");}
	    	
	    	else {NewOne.add("3");}
		
	    }
		
		df.add("FactorizeYearsExp",NewOne);
	    return df;
   
	}
	
	@Override
    public double[][] KmeanGraph(smile.data.DataFrame df)
	{
        df = FactorizeData(df);
        smile.data.DataFrame kmean = df.select("CompanyFactorize", "JobsFactorize");
        
        double[][] KMEAN= kmean.toArray();
        return KMEAN;
        
    }
    
    @Override
    public smile.data.DataFrame FactorizeData(smile.data.DataFrame df) 
    {
        df = df.merge(IntVector.of("JobsFactorize", ColFactorize(df, "Title")));
        df = df.merge(IntVector.of("CompanyFactorize", ColFactorize(df, "Company")));
        return df;
    }
    
    @Override
    public int[] ColFactorize(smile.data.DataFrame df, String col_name) 
    {
        String[] values = df.stringVector(col_name).distinct().toArray(new String[]{});
        return df.stringVector(col_name).factorize(new NominalScale(values)).toIntArray();
    }
	
	@Override
	public DataFrame CountryColumnCleaning(DataFrame df) 
	{
		joinery.DataFrame countrydf=df.retain("Country");
		List countryList=countrydf.flatten();
		
		
		String[] governmentList={"New Valley", "Qalubia","Gharbia", "Alexandria", "Dakahlia","Ismailia", "Aswan", "Damietta","Matruh", "Fayoum", "Red Sea", "Cairo", "Beni Suef", "South Sinai", "Monufya", "Qena", "Sharqia", "Assiut", "Minya", "Beheira", "Suez", "Giza"};
		
		List<String> goverlist = new ArrayList<>();
		List<String> NEWCountrylist = new ArrayList<>();
		
		for (String t : governmentList) {goverlist.add(t);}

		for (Object str : countryList) 
		{
			for (String s:goverlist) {str = ((String) str).replaceAll(s, "Egypt");}
		NEWCountrylist.add((String) str);  
		}
		
		 
		 df.add("CleanedCountryCol",NEWCountrylist);
		return df;
	}
   

}
