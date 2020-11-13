package STARS_system;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Dictionary;
import java.util.Hashtable;


public class StudentDB {
	public  static Dictionary studentDB;//stores all matricno password pairs
	private static String filename = "studentDB.ser";
	public StudentDB()
	
	{
		 try
	        {    
	            // Reading the object from a file 
	            FileInputStream file = new FileInputStream(filename); 
	            ObjectInputStream in = new ObjectInputStream(file); 
	              
	            // Method for deserialization of object 
	            this.studentDB = (Dictionary)in.readObject(); 
	              
	            in.close(); 
	            file.close(); 
	              
	            System.out.println("Object has been deserialized "); 
	        }
		 catch(IOException ex) 
	        { 
	            Dictionary dictionary = new Hashtable();
	            serializeStudentDB(dictionary);
	            
	        } 
	          
	        catch(ClassNotFoundException ex) 
	        { 
	            System.out.println("ClassNotFoundException is caught"); 
	        } 
	}
	public static void serializeStudentDB(Dictionary studentDB)
	{
		 
        
        // Serialization  
        try
        {    
            //Saving of object in a file 
            FileOutputStream file = new FileOutputStream(filename); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
              
            // Method for serialization of object 
            out.writeObject(studentDB); 
              
            out.close(); 
            file.close(); 
              
            System.out.println("studentDB has been serialized"); 
  
        } 
          
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught"); 
        } 
	}
	public static Student getStudentObj(String MatricNo)
	{
		Student aStudent = (Student)studentDB.get(MatricNo);
		return aStudent;
	}
	public static void addStudent(String MatricNo,Student student)
	{
		studentDB.put(MatricNo,student);
	}
	
}
