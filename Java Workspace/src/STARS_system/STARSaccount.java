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



public class STARSaccount implements Serializable {
	private String accountID;
	private String accountPW;
	private Student student;
	private boolean isAdmin;
	
	public STARSaccount(String accountID,String accountPW) throws IOException
	{
		this.accountID = accountID;
		this.accountPW = starsaccMngr.passwordHash(accountPW);
		this.isAdmin = true;
		this.student = null;
		saveToDb();
	}
	
	public STARSaccount(String accountID,String accountPW,Student student) throws IOException
	{
		this.accountID = accountID;
		this.accountPW = starsaccMngr.passwordHash(accountPW);
		this.student = student;
		this.isAdmin = false;
		saveToDb();
		
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
	
	//setters========================================
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
	public void setAccountPW(String accountPW) {
		this.accountPW = accountPW;
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}
	private void saveToDb() throws IOException
	{
		
		String SEPARATOR = "|";
		StringBuilder st =  new StringBuilder() ;
		st.append(accountID.trim());
		st.append(SEPARATOR);
		st.append(this.accountPW.trim());
			
		starsaccMngr.write(st.toString(),this.isAdmin);
	}
}
