package STARS_system;

public interface SendNotifications {
	public void loginNotification(Student student);
	public void courseIndexRegNotification(Student student,String courseCode,String courseIndex);
	public void waitingListNotification(Student student,String courseCode,String courseIndex);
	public void exitWaitingListNotification(Student student,String courseCode,String courseIndex);
}
