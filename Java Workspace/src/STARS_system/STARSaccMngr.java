package STARS_system;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class STARSaccMngr {
/**
 * Stars account manager class
 *
 */
	/**
	 * Hash password method
	 * @param passwordToHash Password to hash
	 * @return Hashed password
	 */
	public static String passwordHash(String passwordToHash)
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
	/**
	 * Write method
	 * @param usernamepwString Username string
	 * @param isAdmin Check if user is admin
	 * @throws IOException Exception handling
	 */
	public static void write(String usernamepwString,boolean isAdmin) throws IOException  {
		String filename;
		if (isAdmin == true)
		{
			filename = UsrnamePwFILE.getAdminFilename();
		}
		else {
			filename = UsrnamePwFILE.getStudentFilename();
		}
		
		FileWriter fw = new FileWriter(filename, true);
	    BufferedWriter bw = new BufferedWriter(fw);
	    PrintWriter out = new PrintWriter(bw);

	    try {
	    		
	      		out.println(usernamepwString);
	    }
	    finally {
	      out.close();
	    }
	  }
	/**
	 * Delete account method
	 * @param username Username
	 * @param isAdmin Check if user is admin
	 * @throws IOException Exception handling
	 */
	public static void deleteAcc(String username,boolean isAdmin) throws IOException  {
	
			String filename;
			if (isAdmin == true)
			{
				filename = UsrnamePwFILE.getAdminFilename();
			}
			else 
			{
			
				filename = UsrnamePwFILE.getStudentFilename();
			}
			List data = AccVerify.readDB(filename);
			
		    PrintWriter out = new PrintWriter(new FileWriter(filename));
		    String matricNo;
		
		    
		    try {
				for (int i =0; i < data.size() ; i++) {
					matricNo = ((String) data.get(i)).substring(0,9);
					
					if (matricNo.equals(username))
					{
						
						continue;
					}
					else
					{
						out.println((String)data.get(i));
					}
		      		
				}
		    }
		    finally {
		      out.close();
		    }
		  }
	
	/**
	 * Edit password method
	 * @param studentMatric Student matriculation number
	 * @param newPW new password
	 * @param isAdmin check if administrator
	 * @throws IOException Exception handling
	 */
	public static void editPassword(String studentMatric, String newPW, boolean isAdmin) throws IOException  {
		String filename;
		if (isAdmin == true)
		{
			filename = UsrnamePwFILE.getAdminFilename();
		}
		else {
			filename = UsrnamePwFILE.getStudentFilename();
		}
		List data = AccVerify.readDB(filename);
		String SEPARATOR = "|";
		PrintWriter out = new PrintWriter(new FileWriter(filename));
	    String matricNo;
	    String password;
	    
	    String[] parts;
	    try {
			for (int i =0; i < data.size() ; i++) {
				
				parts = ((String) data.get(i)).split("\\"+ SEPARATOR);
				matricNo = parts[0];
				password = parts[1];
				
				String reconstructString;
				if (matricNo.equals(studentMatric))
				{
					reconstructString = matricNo+SEPARATOR+newPW;
					out.println(reconstructString);
				}
				else
				{
					out.println((String)data.get(i));
				}
			}
	    }
	    finally {
	      out.close();
	    }
	  }

}
