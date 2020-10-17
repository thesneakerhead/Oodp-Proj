package STARS_system;
import java.io.Serializable;

public class Student implements Serializable {
	private String name;
	private String matricNo;
	private String gender;
	private String nationality;
	private int accessPeriod;
	private STARSaccount saccount;
	
	
	public Student(String matricNo,String name,String gender,String nationality)
	{
		this.matricNo = matricNo;
		this.name = name;
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
	
	//I dont understand what this is
	public boolean equals(Object o) {
		if (o instanceof Student) {
			Student p = (Student)o;
			return (getName().equals(p.getName()));
		}
		return false;
	}
}
