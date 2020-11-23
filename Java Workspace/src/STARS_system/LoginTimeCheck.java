package STARS_system;
import java.io.IOException;
import java.util.Scanner;


public class LoginTimeCheck extends StudentLogin
{
	private String matricNo;
	private Student currentStudent;
	public LoginTimeCheck() throws IOException
	{
		super();
		this.matricNo=super.getUsername();
		checkAccessTime();
	}

	public void checkAccessTime() throws IOException
	{
		String matricNo = this.matricNo;
		this.currentStudent = StudentDB.getStudentObj(matricNo);
		if (STARSApp.currentDate.after(this.currentStudent.accessStartTime) && STARSApp.currentDate.before(this.currentStudent.accessEndTime))
		{
			return;
		}
		else {
			System.out.println("Access Denied, login during your allocated access period");
			STARSApp.terminate();
		}
	}
	public Student getStudent()
	{
		return this.currentStudent;
	}
}
