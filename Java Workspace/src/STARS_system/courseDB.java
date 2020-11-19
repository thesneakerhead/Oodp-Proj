package STARS_system;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Dictionary;
import java.util.Hashtable;

public class courseDB {
	public  static Dictionary courseDB;//stores all matricno Student pairs
	private static String filename = "courseDB.ser";
	public courseDB() throws IOException, ClassNotFoundException
	
	{
		 try
	        {    
	            // Reading the object from a file 
	            FileInputStream file = new FileInputStream(filename); 
	            ObjectInputStream in = new ObjectInputStream(file); 
	              
	            // Method for deserialization of object 
	            this.courseDB = (Dictionary)in.readObject(); 
	              
	            in.close(); 
	            file.close(); 
	              
	           
	        }
		 catch(IOException ex) 
	        { 
	            Dictionary dictionary = new Hashtable();
	            serializeCourseDB(dictionary);
	            FileInputStream file = new FileInputStream(filename); 
	            ObjectInputStream in = new ObjectInputStream(file); 
	              
	            // Method for deserialization of object 
	            this.courseDB = (Dictionary)in.readObject(); 
	              
	            in.close(); 
	            file.close(); 
	              
	          
	            
	        } 
	          
	        catch(ClassNotFoundException ex) 
	        { 
	            System.out.println("ClassNotFoundException is caught"); 
	        } 
	}
	public static void serializeCourseDB(Dictionary courseDB)
	{
		 
        
        // Serialization  
        try
        {    
            //Saving of object in a file 
            FileOutputStream file = new FileOutputStream(filename); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
              
            // Method for serialization of object 
            out.writeObject(courseDB); 
              
            out.close(); 
            file.close(); 
              
           
  
        } 
          
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught"); 
            
        } 
	}
	public static Course getCourseObj(String courseCode)
	{
		Course aStudent = (Course)courseDB.get(courseCode);
		return aStudent;
	}
	public static void addCourse(String courseCode,Course course)
	{
		courseDB.put(courseCode,course);
	}
	public static void deleteCourse(String courseCode)
	{
		courseDB.remove(courseCode);
	}
}
