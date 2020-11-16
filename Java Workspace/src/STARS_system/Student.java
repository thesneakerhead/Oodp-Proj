package STARS_system;
import java.io.IOException;
import java.io.Serializable;

public class Student implements Serializable {
	private String name;
	private String matricNo;
	private String gender;
	private String nationality;
	private int accessPeriod;
	private STARSaccount saccount;
	
	
	public Student(String matricNo,String name,String gender,String nationality) throws IOException
	{
		
		this.matricNo = matricNo;
		this.name = name;
		this.gender = gender;
		this.nationality=nationality;
		this.saccount = new STARSaccount(matricNo,name,this);
		StudentDB.addStudent(matricNo, this);
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
