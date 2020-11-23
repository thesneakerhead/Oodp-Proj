package STARS_system;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



/**
 * Stars Account class
 *
 */
public class STARSaccount implements Serializable {
	/**
	 * Account id
	 */
	private String accountID;
	/**
	 * Account password
	 */
	private String accountPW;
	/**
	 * Student
	 */
	private Student student;
	/**
	 * Check if admin
	 */
	private boolean isAdmin;
	/**
	 * Inbox
	 */
	public String inbox[];
	/**
	 * Number of messages
	 */
	public int numOfMessages = 0;
	
	/**
	 * Stars Account constructor
	 * @param accountID Account ID
	 * @param accountPW Account Password
	 * @throws IOException Exception handling
	 */
	public STARSaccount(String accountID,String accountPW) throws IOException
	{
		this.accountID = accountID;
		this.accountPW = STARSaccMngr.passwordHash(accountPW);
		this.isAdmin = true;
		this.student = null;
		this.inbox = new String[20];
		saveToDb();
	}
	
	/**
	 * Stars Account constructor
	 * @param accountID Account ID
	 * @param accountPW Account Password
	 * @param student Student
	 * @throws IOException Exception handling
	 */
	public STARSaccount(String accountID,String accountPW,Student student) throws IOException
	{
		this.accountID = accountID;
		this.accountPW = STARSaccMngr.passwordHash(accountPW);
		this.student = student;
		this.isAdmin = false;
		this.inbox = new String[20];
		saveToDb();
		
	}
	// one more constuctor needed for admin account;
		//public STARSaccount() {
			// TODO Auto-generated constructor stub
		//}
	
	
	
	
	/**
	 * Get account method
	 * @return accountID
	 */
	//getters========================================
	public String getAccountID() {
		return accountID;
	}
	/**
	 * Get account password method
	 * @return Account Password
	 */
	public String getAccountPW() {
		return accountPW;
	}
	/**
	 * Get student method
	 * @return student
	 */
	public Student getStudent() {
		return student;
	}
	
	//setters========================================
	/**
	 * Set account ID method
	 * @param accountID account ID
	 */
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
	/**
	 * Set account password method
	 * @param accountPW account password
	 */
	public void setAccountPW(String accountPW) {
		this.accountPW = accountPW;
	}
	/**
	 * Set student method
	 * @param student student
	 */
	public void setStudent(Student student) {
		this.student = student;
	}
	/**
	 * Save to database method
	 * @throws IOException Exception handling
	 */
	private void saveToDb() throws IOException
	{
		
		String SEPARATOR = "|";
		StringBuilder st =  new StringBuilder() ;
		st.append(accountID.trim());
		st.append(SEPARATOR);
		st.append(this.accountPW.trim());
			
		STARSaccMngr.write(st.toString(),this.isAdmin);
	}
	/**
	 * Add notification method
	 * @param notification notification
	 */
	public void addNotification(String notification)
	{
		this.inbox[numOfMessages] = notification;
		numOfMessages++;
	}
	/**
	 * Print notifications method
	 */
	public void printNotifications()
	{
		if (numOfMessages!=0)
		{
			for (int i=0;i<numOfMessages;i++)
			{
				System.out.println(this.inbox[i]);
			}
		}
	}
}
