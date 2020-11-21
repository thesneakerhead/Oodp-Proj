package STARS_system;
import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Student implements Serializable {
	private String name;
	private String matricNo;
	private String gender;
	private String nationality;
	public Calendar accessStartTime;
	public Calendar accessEndTime;
	private STARSaccount saccount;
	private String email;
	
	public Student(String matricNo,String name,String gender,String nationality,Calendar accessStartTime,Calendar accessEndTime,String email) throws IOException
	{
		
		this.matricNo = matricNo;
		this.name = name;
		this.gender = gender;
		this.nationality=nationality;
		this.accessStartTime = accessStartTime;
		this.accessEndTime = accessEndTime;
		this.saccount = new STARSaccount(matricNo,name,this);
		this.email = email;
		StudentDB.addStudent(matricNo, this);
		System.out.println("Student Created!");
	}
	//getters========================================
	public String getName() {
		return name;
	}
	public String getMatricNo() {
		return matricNo;
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
	public void setAccessStartTime(Calendar accessStartTime) {
		this.accessStartTime = accessStartTime;
	}
	public void setAccessEndTime(Calendar accessEndTime) {
		this.accessEndTime = accessEndTime;
	}
	public String getEmail()
	{
		return this.email;
	}
	
	//==================================================
	
}
