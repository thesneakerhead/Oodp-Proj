package STARS_system;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class registeredCourses implements Serializable{
	public static Dictionary registerDict;

	private static String filename = "registeredCourses.ser";
	public registeredCourses() throws IOException, ClassNotFoundException
	
	{
		 try
	        {    
	            // Reading the object from a file 
	            FileInputStream file = new FileInputStream(filename); 
	            ObjectInputStream in = new ObjectInputStream(file); 
	              
	            // Method for deserialization of object 
	            this.registerDict = (Dictionary)in.readObject(); 
	              
	            in.close(); 
	            file.close(); 
	              
	           
	        }
		 catch(IOException ex) 
	        { 
	            Dictionary dictionary = new Hashtable();
	            serializeRegisterDict(dictionary);
	            FileInputStream file = new FileInputStream(filename); 
	            ObjectInputStream in = new ObjectInputStream(file); 
	              
	            // Method for deserialization of object 
	            this.registerDict = (Dictionary)in.readObject(); 
	              
	            in.close(); 
	            file.close(); 
	              
	          
	            
	        } 
	          
	        catch(ClassNotFoundException ex) 
	        { 
	            System.out.println("ClassNotFoundException is caught"); 
	        } 
	}

	public void registerIndex(String matricNo, String courseCode,String courseIndex)
	{
		ArrayList<courseIndex> indexList = (ArrayList<courseIndex>)registerDict.get(matricNo);
		if (indexList == null)
		{
			ArrayList<courseIndex> newindexList = new ArrayList<courseIndex>();
			Course course = courseDB.getCourseObj(courseCode);
			courseIndex cindex = course.getIndex(courseIndex);
			newindexList.add(cindex);
			this.registerDict.put(matricNo, newindexList);
		}
		else {
			Course course = courseDB.getCourseObj(courseCode);
			courseIndex cindex = course.getIndex(courseIndex);
			indexList.add(cindex);
			this.registerDict.put(matricNo,indexList);
		}
		
	}
	public static void serializeRegisterDict(Dictionary registerDict)
	{
		 
        
        // Serialization  
        try
        {    
            //Saving of object in a file 
            FileOutputStream file = new FileOutputStream(filename); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
              
            // Method for serialization of object 
            out.writeObject(registerDict); 
              
            out.close(); 
            file.close(); 
              
           
  
        } 
          
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught"); 
            
        } 
	}
	public static void removeStudentIndexes(String matricNo)
	{
		registerDict.remove(matricNo);
	}
	public static ArrayList<courseIndex> getIndexes(String matricNo)
	{
		return (ArrayList<courseIndex>)registerDict.get(matricNo);
	}
}
