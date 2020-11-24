package STARS_system;
import java.io.IOException;
import java.util.Scanner;
/**
 * Login time check class
 *
 */

<<<<<<< HEAD:Java Workspace/src/STARS_system/LoginTimeCheck.java
=======

>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/loginTimeCheck.java
public class LoginTimeCheck extends StudentLogin
{
	/**
	 * Matriculation number
	 */
	private String matricNo;
	/**
	 * Current student
	 */
	private Student currentStudent;
<<<<<<< HEAD:Java Workspace/src/STARS_system/LoginTimeCheck.java
	/**
	 * Login time check constructor
	 * @throws IOException Exception handling
	 */
=======
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/loginTimeCheck.java
	public LoginTimeCheck() throws IOException
	{
		super();
		this.matricNo=super.getUsername();
		checkAccessTime();
	}
	/**
	 * Check access time method
	 * @throws IOException Exception handling
	 */
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
	/**
	 * Get student method
	 */
	public Student getStudent()
	{
		return this.currentStudent;
	}
}
