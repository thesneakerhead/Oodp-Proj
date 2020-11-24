package STARS_system;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Dictionary;
/**
 * Abstract Class Database
 *
 */
public abstract class Database 
{
	/**
	 * Abstract method delete from database
	 * @param key key
	 */
	abstract void deleteFromDB(String key);
	/**
	 * Abstract method add to database
	 * @param key key
	 * @param object Object
	 */
	abstract void addToDB(String key, Object object);
	/**
	 * Abstract method print database
	 */
	abstract void printDB();
	/**
	 * Serialize database method
	 * @param DB Database
	 * @param filename File name
	 */
	public static void serializeDB(Dictionary DB,String filename)
	{
		// Serialization  
        try
        {    
            //Saving of object in a file 
            FileOutputStream file = new FileOutputStream(filename); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
              
            // Method for serialization of object 
            out.writeObject(DB); 
              
            out.close(); 
            file.close();         
        } 
          
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught");    
        } 
	}
}