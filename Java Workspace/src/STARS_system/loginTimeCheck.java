package STARS_system;
import java.io.IOException;
import java.util.Scanner;


public class loginTimeCheck extends studentLogin
{
	private String matricNo;
	private Student currentStudent;
	public loginTimeCheck() throws IOException
	{
		super();
		this.matricNo=super.getUsername();
		checkAccessTime();
	}

	public void checkAccessTime() throws IOException
	{
		String matricNo = this.matricNo;
		this.currentStudent = StudentDB.getStudentObj(matricNo);
		if (StarsApp.currentDate.after(this.currentStudent.accessStartTime) && StarsApp.currentDate.before(this.currentStudent.accessEndTime))
		{
			return;
		}
		else {
			System.out.println("Access Denied, login during your allocated access period");
			StarsApp.terminate();
		}
	}
	public Student getStudent()
	{
		return this.currentStudent;
	}
}
