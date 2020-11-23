package STARS_system;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class AccVerify {
	
/**
 * Account Verify class
 *
 */
		/**
		 * Stores all username and password pairs
		 */
		private static Dictionary verify; //stores all username/password pairs
		public AccVerify(boolean isAdmin) throws IOException
		/**
		 * Account verify constructor (verify login details for Student/Administrator)
		 * @param isAdmin Check is user is administrator
		 * @throws IOException Exception handling
		 */
		{
			String accDB;
			if (isAdmin == true)
			{
				accDB = UsrnamePwFILE.getAdminFilename();
			}
			else {
				accDB = UsrnamePwFILE.getStudentFilename();
			}
			Dictionary verify = new Hashtable();
			
				List a = readDB(accDB);
				for (int i =0; i < a.size() ; i++) {
					String username = ((String) a.get(i)).substring(0,9);
					String password = ((String) a.get(i)).substring(10,42);
					 verify.put(username, password);
				}
				this.verify = verify;
		}
		/**
		 * verify username and password are in the database
		 * @param username - Admin/Student username
		 * @param password - Admin/Student password
		 * @return - verified
		 */
		public static boolean verification(String username,String password)
		{
			String dbPassword = (String)verify.get(username);
			String temppw = STARSaccMngr.passwordHash(password);
			if(temppw.equals(dbPassword))
			{
				return true;
			}
			else {
			return false;}
		}
		/**
		 * read the student/admin database filled with the username and passwords
		 * @param fileName - aLoginDB.txt or sLoginDB.txt
		 * @return - list of username and passwords
		 * @throws IOException Exception handling
		 */
		public static List readDB(String fileName) throws IOException {
			List data = new ArrayList();
			
		    Scanner scanner = new Scanner(new FileInputStream(fileName));
		    try {
		      while (scanner.hasNext()){
		    	;
		        data.add(scanner.nextLine());
		     
		      }
		    }
		    finally{
		      scanner.close();
		    }
		 
		    return data;
		  }
		
}
