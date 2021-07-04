package ProjectMain;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


import joinery.DataFrame;
import smile.io.Write;
import tech.tablesaw.api.Table;
@SuppressWarnings({ "unchecked" ,"rawtypes"})
public class WuzzufDAOImpl implements WuzzufDAO{

	@Override
	public Table ReadAsTable(String csvFile) throws IOException {
		// TODO Auto-generated method stub
		Table table1 = Table.read().csv(csvFile);
		
		return table1;
	}
	
		
	@Override
	public List Summary_Statistics(String csvFile) throws IOException {
		Table table1 = Table.read().csv(csvFile);
		String Shape= table1.shape().toString();
		String Structure= table1.structure().toString();
		String Summary= table1.summary().toString();
		List<String> ls= new ArrayList<>();
		ls.add(Shape);
		ls.add(Structure);
		ls.add(Summary);
		return ls;
	}

	@Override
	public joinery.DataFrame DataCleaning(String InputCSV, String CleanedCSV) throws IOException {
		Table table1 = Table.read().csv(InputCSV);
		Table table2=table1.dropDuplicateRows().dropRowsWithMissingValues();
		table2.write().csv(CleanedCSV);
		DataFrame dfJoinery= DataFrame.readCsv(CleanedCSV);
		
		return dfJoinery;
	}

	@Override
	public String WriteTabletoCSV(Table TableName,String CSVoutName) throws IOException {
		
		TableName.write().csv(CSVoutName);;
		return CSVoutName;
	}

	@Override
	public smile.data.DataFrame SmileDateFrame(Table TableName) {
	
		smile.data.DataFrame dfSmile=TableName.smile().toDataFrame();
		
		return dfSmile;
	}
	
	@Override
	public String WriteSmiletoCSV(smile.data.DataFrame SmileDf, String Path, String CSVoutName) throws IOException {
		
		Path path = Paths.get(Path);
		
		
		Write.csv(SmileDf, path);
		
		return CSVoutName;
	}

	@Override
	public joinery.DataFrame ReadAsJoineryDataFrame(String csvFile) throws IOException {

		DataFrame dfJoinery= DataFrame.readCsv(csvFile);
		
		return dfJoinery;
	}

	@Override
	public List DisplayTopDemandingCompaniesforJobsCharts(joinery.DataFrame df, int SlicingStart, int SlicingEnd) {
		joinery.DataFrame dfJoinery= df.retain("Title","Company").groupBy("Company").count().sortBy(-1).slice(SlicingStart, SlicingEnd);
		
		List<String> companyList= dfJoinery.col("Company");
		List<String> countList=dfJoinery.col("Title");
		
		List<List<String>> LIST= new ArrayList<>();
		LIST.add(companyList);
		LIST.add(countList);
		return LIST;
	}

	
	@Override
	public List DisplayTopPopularJobTitlesCharts(joinery.DataFrame df,int SlicingStart, int SlicingEnd) {
		joinery.DataFrame dfJoinery1= df.retain("Title","Company").groupBy("Title").count().sortBy(-1).slice(SlicingStart, SlicingEnd);
		
		List<String> titleList= dfJoinery1.col("Title");
		List<String> countList1=dfJoinery1.col("Company");
		List<List<String>> LIST= new ArrayList<>();
		LIST.add(titleList);
		LIST.add(countList1);
		return LIST;
	}
	
	@Override
	public List DisplayTopPopularAreasCharts(joinery.DataFrame df,int SlicingStart, int SlicingEnd) {
	    joinery.DataFrame dfJoinery2= df.retain("Location","Title").groupBy("Location").count().sortBy(-1).slice(SlicingStart, SlicingEnd);
	    
	    
	    List<String> locationList= dfJoinery2.col("Location");
		List<String> countList2=dfJoinery2.col("Title");
		List<List<String>> LIST= new ArrayList<>();
		LIST.add(locationList);
		LIST.add(countList2);
		return LIST;
		
	}

	@Override
	public Map Skills(DataFrame df) {
		// TODO Auto-generated method stub
		
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
	public joinery.DataFrame YearsEXPcol_Factorization(DataFrame df) {
		
		
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
	    
	    //df.add("NewYearsExp",YearsEXPNEW);
		
		df.add("FactorizeYearsExp",NewOne);
	    return df;
   

	
	}
	
	@Override
	public DataFrame CountryColumnCleaning(DataFrame df) {
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
