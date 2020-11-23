package STARS_system;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Dictionary;

public abstract class Database 
{
	abstract void deleteFromDB(String key);
	abstract void addToDB(String key, Object object);
	abstract void printDB();
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