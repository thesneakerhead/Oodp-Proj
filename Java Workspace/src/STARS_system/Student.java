package STARS_system;

public class Student {
	private String name;
	private String matricNo;
	private String gender;
	private String nationality;
	private int accessPeriod;
	private STARSaccount saccount;
	
	
	public Student(String name,String matricNo,String gender,String nationality)
	{
		this.name = name;
		this.matricNo = matricNo;
		this.gender = gender;
		this.nationality=nationality;
		this.saccount = new STARSaccount(matricNo,name,this);
	}
	//getters========================================
	public String getName() {
		return name;
	}
	public String getMatricNo() {
		return matricNo;
	}
	public int getAccessPeriod() {
		return accessPeriod;
	}
	public String getGender() {
		return gender;
	}
	public String getNationality() {
		return nationality;
	}
	public STARSaccount getSaccount() {
		return saccount;
	}
	//setters========================================
	public void setAccessPeriod(int accessPeriod) {
		this.accessPeriod = accessPeriod;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public void setMatricNo(String matricNo) {
		this.matricNo = matricNo;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public void setSaccount(STARSaccount saccount) {
		this.saccount = saccount;
	}
	//==================================================
}
