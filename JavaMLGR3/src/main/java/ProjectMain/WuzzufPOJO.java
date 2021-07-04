package ProjectMain;

import java.util.List;

public class WuzzufPOJO {
	
	private String Title;
	private String Company;
	private String Location;
	private String Type;
	private String Level;
	private String YearsExp;
	private String Country;
	private String Skills;
	
	public WuzzufPOJO() {
		super();
	}
	public WuzzufPOJO(List<String> header) {
		super();
		this.Title = header.get(0);
		this.Company = header.get(1);
		this.Location = header.get(2);
		this.Type = header.get(3);
		this.Level = header.get(4);
		this.YearsExp = header.get(5);
		this.Country = header.get(6);
		this.Skills = header.get(7);
	}
	
	@Override
	public String toString() {
		return "Wuzzuf_Creation [Title=" + Title + ", Company=" + Company + ", Location=" + Location + ", Type=" + Type
				+ ", Level=" + Level + ", YearsExp=" + YearsExp + ", Country=" + Country + ", Skills=" + Skills + "]";
	}

	public String getTitle() {
		return Title;
	}

	public String getCompany() {
		return Company;
	}

	public String getLocation() {
		return Location;
	}

	public String getType() {
		return Type;
	}

	public String getLevel() {
		return Level;
	}

	public String getYearsExp() {
		return YearsExp;
	}

	public String getCountry() {
		return Country;
	}

	public String getSkills() {
		return Skills;
	}

	
	
	
	

}
