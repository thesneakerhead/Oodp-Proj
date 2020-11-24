package STARS_system;
<<<<<<< HEAD:Java Workspace/src/STARS_system/usrnamePwFILE.java
/**
 *  Username and password file class
 *
 */
public class usrnamePwFILE {
=======

public class UsrnamePwFILE {
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/UsrnamePwFILE.java
	/**
	 * Contains student accounts
	 */
	private static String studentfilename = "sLoginDB.txt";
	/**
	 * Contains admin accounts
	 */
	private static String adminfilename = "aLoginDB.txt";
	/**
	 * Get Student login details
	 * @return studentfilename
	 */
	public static String getStudentFilename() {
		return studentfilename;
	}
	/**
	 * Get Administrator login details
	 * @return adminfilename
	 */
	public static String getAdminFilename() {
		return adminfilename;
	}
}
