package STARS_system;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Dictionary;
import java.util.Hashtable;


public class StudentDB extends Database {
	public  static Dictionary studentDB;//stores all matricno Student pairs
	private static String filename = "studentDB.ser";
	public StudentDB() throws IOException, ClassNotFoundException
	
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
	              
	           
	        }
		 catch(IOException ex) 
	        { 
	            Dictionary dictionary = new Hashtable();
	            serializeDB(dictionary,filename);
	            FileInputStream file = new FileInputStream(filename); 
	            ObjectInputStream in = new ObjectInputStream(file); 
	              
	            // Method for deserialization of object 
	            this.studentDB = (Dictionary)in.readObject(); 
	              
	            in.close(); 
	            file.close(); 
	              
	          
	            
	        } 
	          
	        catch(ClassNotFoundException ex) 
	        { 
	            System.out.println("ClassNotFoundException is caught"); 
	        } 
	}
	/*public static void serializeStudentDB(Dictionary studentDB)
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
        } 
          
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught");    
        } 
	}*/
	public static Student getStudentObj(String MatricNo)
	{
		Student aStudent = (Student)studentDB.get(MatricNo);
		return aStudent;
	}
	public void addToDB(String MatricNo,Object student)
	{
		if(student instanceof Student)
		{
			Student stud = (Student)student;
			studentDB.put(MatricNo,stud);
		}
		else 
			System.out.println("Object is not a student");
	}
	public void deleteFromDB(String MatricNo)
	{
		studentDB.remove(MatricNo);
	}
	public void printDB() {}
}
