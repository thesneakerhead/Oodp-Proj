package STARS_system;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class STARSaccount {
	private String accountID;
	private String accountPW;
	private Student student;
	private boolean isAdmin;
	
	public STARSaccount(String accountID,String accountPW,Student student)
	{
		this.accountID = accountID;
		this.accountPW = passwordHash(accountPW);
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
	//Password Hashing================================
	
	public String passwordHash(String passwordToHash)
	{
		String hashedPW = null;
		 try {
	            // Create MessageDigest instance for MD5
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            //Add password bytes to digest
	            md.update(passwordToHash.getBytes());
	            //Get the hash's bytes 
	            byte[] bytes = md.digest();
	            //This bytes[] has bytes in decimal format;
	            //Convert it to hexadecimal format
	            StringBuilder sb = new StringBuilder();
	            for(int i=0; i< bytes.length ;i++)
	            {
	                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	            }
	            //Get complete hashed password in hex format
	            hashedPW = sb.toString();
	        } 
	        catch (NoSuchAlgorithmException e) 
	        {
	            e.printStackTrace();
	        }
	        
		return hashedPW;
	}
	
}
