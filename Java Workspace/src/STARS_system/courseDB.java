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

public class courseDB {
	public  static Dictionary courseDB;//stores all course code and course pairs
	
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
	public static void printCourses()
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
	public static void deleteStudentFromIndex(String matricNo)
	{
		Set<String> keys = ((Hashtable) courseDB).keySet();
		for(String key: keys){
			Course tempCourse = (Course)courseDB.get(key);
			courseIndex tempList[] = tempCourse.courseIndex;
			for (int i=0;i<tempCourse.numIndex;i++)
			{
				courseIndex tempIndex = tempList[i];
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
	public static String fixedLengthString(String string, int length) {
	    return String.format("%1$-"+length+ "s", string);
	}
}
