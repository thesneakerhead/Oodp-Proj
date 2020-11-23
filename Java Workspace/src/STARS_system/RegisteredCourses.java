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
import java.util.Set;

public class RegisteredCourses extends Database implements Serializable {
/**
 * Registered courses class
 *
 */
	/**
	 * Stores all registered courses
	 */
	public static Dictionary registerDict;

	/**
	 * File name
	 */
	private static String filename = "registeredCourses.ser";
	public RegisteredCourses() throws IOException, ClassNotFoundException
	
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
	            serializeDB(dictionary,filename);
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

	/**
	 * Method to register index
	 * @param matricNo Method to register index
	 * @param courseCode Course code
	 * @param courseindex Course index
	 * @param isWaitlist Check if on wait list
	 */
	public static void registerIndex(String matricNo, String courseCode,String courseindex,boolean isWaitlist)
	{
		ArrayList<CourseIndex> indexList = (ArrayList<CourseIndex>)registerDict.get(matricNo);
		if (indexList == null)
		{
			ArrayList<CourseIndex> newindexList = new ArrayList<CourseIndex>();
			Course course = CourseDB.getCourseObj(courseCode);
			CourseIndex cindex = course.getIndex(courseindex);
			newindexList.add(cindex);
			if (isWaitlist == true)
			{
			registerDict.put(matricNo, newindexList);
			CourseIndex cdex = newindexList.get(0);
			cdex.isWaitList = true;
			
			}
			else {
				registerDict.put(matricNo, newindexList);
			}
			
		}
		else {
			Course course = CourseDB.getCourseObj(courseCode);
			CourseIndex cindex = course.getIndex(courseindex);
			indexList.add(cindex);
			if (isWaitlist==true)
			{
				registerDict.put(matricNo,indexList);
				for (int i =0;i<indexList.size();i++)
				{
					if(indexList.get(i).indexID==courseindex)
					{
						indexList.get(i).isWaitList = true;
					}
				}
			}
			else {
				registerDict.put(matricNo,indexList);
			}
		}
		
	}
	/**
	 * Serialize Register Dictionary method
	 * @param registerDict Register Dictionary
	 */
	/*public static void serializeRegisterDict(Dictionary registerDict)
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
	}*/
	public void addToDB(String key, Object object) {}
	public void deleteFromDB(String matricNo)
	/**
	 * Remove student index method
	 * @param matricNo Student matric number
	 */
	{
		registerDict.remove(matricNo);
	}
	public static ArrayList<CourseIndex> getIndexes(String matricNo)
	/**
	 * Get indexes method
	 * @param matricNo Matriculation number of student
	 * @return Array of course index
	 */
	{
		return (ArrayList<CourseIndex>)registerDict.get(matricNo);
	}
	public void printDB() {}
	public void printDB(String matricNo)
	/**
	 * Print registered indexes method
	 * @param matricNo Matriculation number of student
	 */
	public void printRegisteredIndexes(String matricNo)
	{
		ArrayList<CourseIndex>arrayList = (ArrayList<CourseIndex>)registerDict.get(matricNo);
		for (int i = 0;i<arrayList.size();i++)
		{
			System.out.println(arrayList.get(i).indexID);
		}
	}
	/**
	 * Delete index from course method
	 * @param courseCode courseCode
	 */
	public static void deleteIndexFromCourse(String courseCode)
	{
		Set<String> keys = ((Hashtable) registerDict).keySet();
        for(String key: keys){
        	ArrayList<CourseIndex> tempList = (ArrayList<CourseIndex>)registerDict.get(key);
        	for (int i=0;i<tempList.size();i++)
        	{
        		if(tempList.get(i).courseCode.equals(courseCode))
        		{
        			tempList.remove(i);
        			registerDict.put(key, tempList);
        		}
        	}
        	
        }
	}
	/**
	 * Delete index method
	 * @param indexID indexID
	 */
	public static void deleteIndex(String indexID)
	{
		Set<String> keys = ((Hashtable) registerDict).keySet();
        for(String key: keys){
        	ArrayList<CourseIndex> tempList = (ArrayList<CourseIndex>)registerDict.get(key);
        	for (int i=0;i<tempList.size();i++)
        	{
        		if(tempList.get(i).indexID.equals(indexID))
        		{
        			tempList.remove(i);
        			registerDict.put(key, tempList);
        		}
        	}
        	
        }
	}
	
}
