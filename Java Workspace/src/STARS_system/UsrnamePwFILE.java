package STARS_system;

public class UsrnamePwFILE {
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
