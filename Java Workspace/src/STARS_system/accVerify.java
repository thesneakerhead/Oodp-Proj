package STARS_system;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class accVerify {
	
		private static Dictionary verify; //stores all username/password pairs
		public accVerify(boolean isAdmin) throws IOException
		{
			String accDB;
			if (isAdmin == true)
			{
				accDB = usrnamePwFILE.getAdminFilename();
			}
			else {
				accDB = usrnamePwFILE.getStudentFilename();
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
		public static boolean verification(String username,String password)
		{
			String dbPassword = (String)verify.get(username);
			String temppw = starsaccMngr.passwordHash(password);
			if(temppw.equals(dbPassword))
			{
				return true;
			}
			else {
			return false;}
		}
		public static List readDB(String fileName) throws IOException {
			List data = new ArrayList() ;
			String matricNo;
		    Scanner scanner = new Scanner(new FileInputStream(fileName));
		    try {
		      while (scanner.hasNext()){
		    	
		        data.add(scanner.nextLine());
		        
		      }
		    }
		    finally{
		      scanner.close();
		    }
		    return data;
		  }
		
}
