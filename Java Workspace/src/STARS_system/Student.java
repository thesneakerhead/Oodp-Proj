package STARS_system;
import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Student class
 *
 */
public class Student implements Serializable {
	/**
	 * Name of student
	 */
	private String name;
	/**
	 * Matriculation number
	 */
	private String matricNo;
	/**
	 * Gender
	 */
	private String gender;
	/**
	 * Student nationality
	 */
	private String nationality;
	/**
	 * Accessed start time
	 */
	public Calendar accessStartTime;
	/**
	 * Accessed end time
	 */
	public Calendar accessEndTime;
	/**
	 * Stars account
	 */
	private STARSaccount saccount;
	/**
	 * Email
	 */
	private String email;
	
	public Student(String matricNo,String name,String gender,String nationality,Calendar accessStartTime,Calendar accessEndTime,String email) throws IOException, ClassNotFoundException
	/**
	 * Student contructor
	 * @param matricNo - admin's input matricNo
	 * @param name - admin's input name
	 * @param gender - admin's input gender
	 * @param nationality - admin's input nationality
	 * @param accessStartTime - admin's input accessStartTime
	 * @param accessEndTime - admin's input accessEndTime
	 */
	{
		StudentDB studentDB = new StudentDB();
		this.matricNo = matricNo;
		this.name = name;
		this.gender = gender;
		this.nationality=nationality;
		this.accessStartTime = accessStartTime;
		this.accessEndTime = accessEndTime;
		this.saccount = new STARSaccount(matricNo,name,this);
		this.email = email;
		studentDB.addToDB(matricNo, this);
		System.out.println("Student Created!");
	}
	//getters========================================
	/**
	 * get student's name
	 * @return - name
	 */
	public String getName() {
		return name;
	}
	/**
	 * get student's matric no
	 * @return - matricNo
	 */
	public String getMatricNo() {
		return matricNo;
	}
	
	/**
	 * get student's gender
	 * @return - gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * get student's nationality
	 * @return - nationality
	 */
	public String getNationality() {
		return nationality;
	}
	/**
	 * get STARS account info: matric no and name
	 * @return - saccount
	 */
	public STARSaccount getSaccount() {
		return saccount;
	}
	//setters========================================
	
	/**
	 * set student's gender
	 * @param gender - new gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**
	 * set student's matric no 
	 * @param matricNo - new matricNo
	 */
	public void setMatricNo(String matricNo) {
		this.matricNo = matricNo;
	}
	/**
	 * set student's name
	 * @param name - new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * set student's nationality
	 * @param nationality - new nationality
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	/**
	 * set student's STARS account
	 * @param saccount - new saccount
	 */
	public void setSaccount(STARSaccount saccount) {
		this.saccount = saccount;
	}
	/**
	 * set start time when student access
	 * @param accessStartTime Access time
	 */
	public void setAccessStartTime(Calendar accessStartTime) {
		this.accessStartTime = accessStartTime;
	}
	/**
	 * set end time
	 * @param accessEndTime End time
	 */
	public void setAccessEndTime(Calendar accessEndTime) {
		this.accessEndTime = accessEndTime;
	}
	/**
	 * get email method
	 * @return email
	 */
	public String getEmail()
	{
		return this.email;
	}
	/**
	 * set email method
	 * @param email email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	//==================================================
	
}
