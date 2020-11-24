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
<<<<<<< HEAD:Java Workspace/src/STARS_system/RegisteredCourses.java
=======

public class RegisteredCourses extends Database implements Serializable {
<<<<<<< HEAD:Java Workspace/src/STARS_system/registeredCourses.java
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/registeredCourses.java
=======
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/RegisteredCourses.java
/**
 * Registered courses class
 *
 */
<<<<<<< HEAD:Java Workspace/src/STARS_system/registeredCourses.java
<<<<<<< HEAD:Java Workspace/src/STARS_system/RegisteredCourses.java
public class RegisteredCourses extends Database implements Serializable {
=======
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/registeredCourses.java
=======
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/RegisteredCourses.java
	/**
	 * Stores all registered courses
	 */
	public static Dictionary registerDict;
<<<<<<< HEAD:Java Workspace/src/STARS_system/RegisteredCourses.java
=======

<<<<<<< HEAD:Java Workspace/src/STARS_system/registeredCourses.java
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/registeredCourses.java
=======
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/RegisteredCourses.java
	/**
	 * File name
	 */
	private static String filename = "registeredCourses.ser";
<<<<<<< HEAD:Java Workspace/src/STARS_system/registeredCourses.java
<<<<<<< HEAD:Java Workspace/src/STARS_system/RegisteredCourses.java
	/**
	 * Registered courses constructor
	 * @throws IOException Exception handling
	 * @throws ClassNotFoundException Class not found exception handling
	 */
=======
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/registeredCourses.java
=======
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/RegisteredCourses.java
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
<<<<<<< HEAD:Java Workspace/src/STARS_system/RegisteredCourses.java
=======

<<<<<<< HEAD:Java Workspace/src/STARS_system/registeredCourses.java
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/registeredCourses.java
=======
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/RegisteredCourses.java
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
<<<<<<< HEAD:Java Workspace/src/STARS_system/registeredCourses.java
<<<<<<< HEAD:Java Workspace/src/STARS_system/RegisteredCourses.java
			ArrayList<courseIndex> newindexList = new ArrayList<courseIndex>();
			Course course = CourseDB.getCourseObj(courseCode);
			courseIndex cindex = course.getIndex(courseindex);
=======
			ArrayList<CourseIndex> newindexList = new ArrayList<CourseIndex>();
			Course course = CourseDB.getCourseObj(courseCode);
			CourseIndex cindex = course.getIndex(courseindex);
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/registeredCourses.java
=======
			ArrayList<CourseIndex> newindexList = new ArrayList<CourseIndex>();
			Course course = CourseDB.getCourseObj(courseCode);
			CourseIndex cindex = course.getIndex(courseindex);
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/RegisteredCourses.java
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
<<<<<<< HEAD:Java Workspace/src/STARS_system/registeredCourses.java
<<<<<<< HEAD:Java Workspace/src/STARS_system/RegisteredCourses.java
			courseIndex cindex = course.getIndex(courseindex);
=======
			CourseIndex cindex = course.getIndex(courseindex);
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/registeredCourses.java
=======
			CourseIndex cindex = course.getIndex(courseindex);
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/RegisteredCourses.java
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
	/**
	 * Remove student index method
	 * @param matricNo Student matric number
	 */
	public void deleteFromDB(String matricNo)
	/**
	 * Remove student index method
	 * @param matricNo Student matric number
	 */
	{
		registerDict.remove(matricNo);
	}
<<<<<<< HEAD:Java Workspace/src/STARS_system/registeredCourses.java
<<<<<<< HEAD:Java Workspace/src/STARS_system/RegisteredCourses.java
=======
	public static ArrayList<CourseIndex> getIndexes(String matricNo)
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/registeredCourses.java
=======
	public static ArrayList<CourseIndex> getIndexes(String matricNo)
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/RegisteredCourses.java
	/**
	 * Get indexes method
	 * @param matricNo Matriculation number of student
	 * @return Array of course index
	 */
<<<<<<< HEAD:Java Workspace/src/STARS_system/registeredCourses.java
<<<<<<< HEAD:Java Workspace/src/STARS_system/RegisteredCourses.java
	public static ArrayList<courseIndex> getIndexes(String matricNo)
=======
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/registeredCourses.java
=======
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/RegisteredCourses.java
	{
		return (ArrayList<CourseIndex>)registerDict.get(matricNo);
	}
	public void printDB() {}
	/**
	 * Print database method
	 * @param matricNo Matriculation number
	 */
	public void printDB(String matricNo)
	{
		ArrayList<CourseIndex>arrayList = (ArrayList<CourseIndex>)registerDict.get(matricNo);
<<<<<<< HEAD:Java Workspace/src/STARS_system/registeredCourses.java
		for (int i = 0;i<arrayList.size();i++)
		{
			System.out.println(arrayList.get(i).indexID);
		}
	}
	/**
	 * Print registered indexes method
	 * @param matricNo Matriculation number of student
	 */
	public void printRegisteredIndexes(String matricNo)
	{
<<<<<<< HEAD:Java Workspace/src/STARS_system/RegisteredCourses.java
		ArrayList<courseIndex>arrayList = (ArrayList<courseIndex>)registerDict.get(matricNo);
=======
		ArrayList<CourseIndex>arrayList = (ArrayList<CourseIndex>)registerDict.get(matricNo);
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/registeredCourses.java
=======
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/RegisteredCourses.java
		for (int i = 0;i<arrayList.size();i++)
		{
			System.out.println(arrayList.get(i).indexID);
		}
	}
	/**
<<<<<<< HEAD:Java Workspace/src/STARS_system/registeredCourses.java
=======
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
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/RegisteredCourses.java
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
