package STARS_system;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class accVerify {
	
		private static Dictionary verify; //stores all username/password pairs
		public accVerify() throws IOException
		{
			String accDB = "accDB.txt";
			Dictionary verify = new Hashtable();
			
				List a = starsaccMngr.reads(accDB);
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
		
}
