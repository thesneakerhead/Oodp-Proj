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

public class registeredCourses extends Database implements Serializable {
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

	public static void registerIndex(String matricNo, String courseCode,String courseindex,boolean isWaitlist)
	{
		ArrayList<courseIndex> indexList = (ArrayList<courseIndex>)registerDict.get(matricNo);
		if (indexList == null)
		{
			ArrayList<courseIndex> newindexList = new ArrayList<courseIndex>();
			Course course = courseDB.getCourseObj(courseCode);
			courseIndex cindex = course.getIndex(courseindex);
			newindexList.add(cindex);
			if (isWaitlist == true)
			{
			registerDict.put(matricNo, newindexList);
			courseIndex cdex = newindexList.get(0);
			cdex.isWaitList = true;
			
			}
			else {
				registerDict.put(matricNo, newindexList);
			}
			
		}
		else {
			Course course = courseDB.getCourseObj(courseCode);
			courseIndex cindex = course.getIndex(courseindex);
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
	{
		registerDict.remove(matricNo);
	}
	public static ArrayList<courseIndex> getIndexes(String matricNo)
	{
		return (ArrayList<courseIndex>)registerDict.get(matricNo);
	}
	public void printDB() {}
	public void printDB(String matricNo)
	{
		ArrayList<courseIndex>arrayList = (ArrayList<courseIndex>)registerDict.get(matricNo);
		for (int i = 0;i<arrayList.size();i++)
		{
			System.out.println(arrayList.get(i).indexID);
		}
	}
	public static void deleteIndexFromCourse(String courseCode)
	{
		Set<String> keys = ((Hashtable) registerDict).keySet();
        for(String key: keys){
        	ArrayList<courseIndex> tempList = (ArrayList<courseIndex>)registerDict.get(key);
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
	public static void deleteIndex(String indexID)
	{
		Set<String> keys = ((Hashtable) registerDict).keySet();
        for(String key: keys){
        	ArrayList<courseIndex> tempList = (ArrayList<courseIndex>)registerDict.get(key);
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
