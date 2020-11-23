package STARS_system;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Set;

public class CourseDB extends Database {
/**
 * Course database class
 *
 */
	/**
	 * Stores all course code and course pairs
	 */
	public  static Dictionary courseDB;//stores all course code and course pairs
	
	/**
	 * File name
	 */
	private static String filename = "courseDB.ser";

	public CourseDB() throws IOException, ClassNotFoundException
	/**
	 * Course database constructor that read the database and deserialize the objects in courseDB 
	 * @throws IOException Exception handling
	 * @throws ClassNotFoundException Class not found exception handling
	 */
	
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
	            serializeDB(dictionary,filename);
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
	/*public static void serializeCourseDB(Dictionary courseDB)
	/**
	 * serialize course DB
	 * @param courseDB Course database
	 */
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
	}*/
	/**
	 * get course object from courseCode
	 * @param courseCode - existing courseCode
	 * @return Student
	 */
	public static Course getCourseObj(String courseCode)
	{
		Course aStudent = (Course)courseDB.get(courseCode);
		return aStudent;
	}
	/*public static void addCourse(String courseCode,Course course)
	{		
		courseDB.put(courseCode,course);
	}*/
	public void addToDB(String MatricNo,Object course)
	/**
	 * add a course
	 * @param courseCode - new courseCode
	 * @param course - new course
	 */
	{
		if(course instanceof Course)
		{
			Course cour = (Course)course;
			courseDB.put(MatricNo,course);
		}
		else 
			System.out.println("Object is not a course");
	}
	public void deleteFromDB(String courseCode)
	/**
	 * delete an existing course
	 * @param courseCode - existing courseCode
	 */
	{
		courseDB.remove(courseCode);
	}
	public void printDB()
	/**
	 * Print courses method
	 */
	{
		Dictionary departmentCourses = new Hashtable();
		
		System.out.println("List of Courses:");
		System.out.println("Course Name               |Course Code    |Department    |");
		
		Set<String> keys = ((Hashtable) courseDB).keySet();
        for(String key: keys){
        	Course tempCourse = (Course)courseDB.get(key);
        	if (departmentCourses.get(tempCourse.getDepartment())==null)
        	{
        		ArrayList<Course> courseArray= new ArrayList<Course>();
        		courseArray.add(tempCourse);
        		departmentCourses.put(tempCourse.getDepartment(), courseArray);
        	}
        	else {
        		ArrayList<Course> courseArray = (ArrayList<Course>)departmentCourses.get(tempCourse.getDepartment());
        		courseArray.add(tempCourse);
        		departmentCourses.put(tempCourse.getDepartment(), courseArray);
			}
        	
        }
        
        Set<Department> keyys = ((Hashtable) departmentCourses).keySet();
        for(Department keyy:keyys) {
        	ArrayList<Course> cArray = (ArrayList<Course>)departmentCourses.get(keyy);
        	for(int i=0;i<cArray.size();i++)
        	{
        		System.out.print(fixedLengthString(cArray.get(i).getCourseName(), 27));
        		System.out.print(fixedLengthString(cArray.get(i).courseCode, 16));
        		System.out.print(fixedLengthString(cArray.get(i).getDepartment().name(), 15));
        		System.out.println();
        	}
        	
        }
        System.out.println("");
        
        
        
        
	}
	/**
	 * Delete student from index method
	 * @param matricNo Matriculation number of student
	 */
	public static void deleteStudentFromIndex(String matricNo)
	{
		Set<String> keys = ((Hashtable) courseDB).keySet();
		for(String key: keys){
			Course tempCourse = (Course)courseDB.get(key);
			CourseIndex tempList[] = tempCourse.courseIndex;
			for (int i=0;i<tempCourse.numIndex;i++)
			{
				CourseIndex tempIndex = tempList[i];
				for(int j=0;j<tempIndex.studentList.size();j++)
				{
					if(tempIndex.studentList.get(j).getMatricNo().equals(matricNo))
					{
						tempIndex.studentList.remove(j);
						tempIndex.indexVacancy++;
	
					}
				}
				for(int k=0;k<tempIndex.waitList.size();k++)
				{
					if(tempIndex.waitList.get(k).getMatricNo().equals(matricNo))
					{
						tempIndex.waitList.remove(k);
					}
				}
				
			}
			tempCourse.updateVacancy();
			
		}
		
	}
	/**
	 * Reformat string method
	 */
	public static String fixedLengthString(String string, int length) {
	    return String.format("%1$-"+length+ "s", string);
	}
}
