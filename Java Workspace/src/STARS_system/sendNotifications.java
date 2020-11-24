package STARS_system;
<<<<<<< HEAD
=======

public interface SendNotifications {
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697
/**
 * Send notification interface
 *
 */
<<<<<<< HEAD
public interface SendNotifications {
=======
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697
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
