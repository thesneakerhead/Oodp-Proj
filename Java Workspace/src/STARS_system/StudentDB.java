package STARS_system;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Dictionary;
import java.util.Hashtable;

/**
 * Student database class
 *
 */
public class StudentDB extends Database {
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697
/**
 * Student database class
 *
 */
<<<<<<< HEAD
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697
=======
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697
	/**
	 * Stores all matriculation number and student pairs
	 */
	public  static Dictionary studentDB;//stores all matricno Student pairs
	/**
<<<<<<< HEAD
<<<<<<< HEAD
	 * File name of serialized student database
	 */
	
=======
	 * File name
	 */
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697
=======
	 * File name
	 */
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697
	private static String filename = "studentDB.ser";
	/**
	 * Student database constructor
	 * @throws ClassNotFoundException Class not found Exception handling
	 * @throws IOException Exception handling
	 */
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
	/**
	 * Serialize Student database method
	 * @param studentDB Student database
	 */
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
<<<<<<< HEAD
<<<<<<< HEAD
	}*/
=======
	}
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697
=======
	}
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697
	/**
	 * Get student object method
	 * @param MatricNo Matriculation number of student
	 * @return aStudent
	 */
	public static Student getStudentObj(String MatricNo)
	{
		Student aStudent = (Student)studentDB.get(MatricNo);
		return aStudent;
	}
	/**
	 * Add student method
	 * @param MatricNo Matriculation number of student
	 * @param student Student
	 */
	public void addToDB(String MatricNo,Object student)
	/**
	 * Add student method
	 * @param MatricNo Matriculation number of student
	 * @param student Student
	 */
	{
		if(student instanceof Student)
		{
			Student stud = (Student)student;
			studentDB.put(MatricNo,stud);
		}
		else 
			System.out.println("Object is not a student");
	}
	/**
	 * Delete student method
	 * @param MatricNo Matriculation number of student
	 */
	public void deleteFromDB(String MatricNo)
	/**
	 * Delete student method
	 * @param MatricNo Matriculation number of student
	 */
	{
		studentDB.remove(MatricNo);
	}
	public void printDB() {}
}
