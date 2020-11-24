package STARS_system;

public interface SendNotifications {
/**
 * Send notification interface
 *
 */
	/**
	 * Login notification
	 * @param student Student
	 */
	public void loginNotification(Student student);
	/**
	 * Register course notification
	 * @param student Student
	 * @param courseCode Course Code
	 * @param courseIndex Course Index
	 */
	public void courseIndexRegNotification(Student student,String courseCode,String courseIndex);
	/**
	 * On waiting list notification
	 * @param student Student
	 * @param courseCode Course Code
	 * @param courseIndex Course Index
	 */
	public void waitingListNotification(Student student,String courseCode,String courseIndex);
	/**
	 * Exit waiting list notification
	 * @param student Student
	 * @param courseCode Course Code
	 * @param courseIndex Course Index
	 */
	public void exitWaitingListNotification(Student student,String courseCode,String courseIndex);
}
