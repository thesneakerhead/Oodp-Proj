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
		if (STARSapp.currentDate.after(this.currentStudent.accessStartTime) && STARSapp.currentDate.before(this.currentStudent.accessEndTime))
		{
			return;
		}
		else {
			System.out.println("Access Denied, login during your allocated access period");
			STARSapp.terminate();
		}
	}
	public Student getStudent()
	{
		return this.currentStudent;
	}
}
