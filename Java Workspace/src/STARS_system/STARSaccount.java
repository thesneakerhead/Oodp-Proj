package STARS_system;

public class STARSaccount {
	private String accountID;
	private String accountPW;
	private Student student;
	private boolean isAdmin;
	
	public STARSaccount(String accountID,String accountPW,Student student)
	{
		this.accountID = accountID;
		this.accountPW = accountPW;
		this.student = student;
		this.isAdmin = false;
	}
	// one more constuctor needed for admin account;
		//public STARSaccount() {
			// TODO Auto-generated constructor stub
		//}
	
	
	
	
	//getters========================================
	public String getAccountID() {
		return accountID;
	}
	public String getAccountPW() {
		return accountPW;
	}
	public Student getStudent() {
		return student;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	//setters========================================
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
	public void setAccountPW(String accountPW) {
		this.accountPW = accountPW;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	//================================================
}
