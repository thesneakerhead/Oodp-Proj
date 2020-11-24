package STARS_system;

import java.io.IOException;
import java.io.Serializable;
import java.util.Dictionary;



public class Course implements Serializable{
	public  String courseCode;
	private  String courseName;
	private Department department;
	public  courseIndex courseIndex[]=new courseIndex[20];
	public  int numIndex=0;
	public  int courseVacancy=0;
	
	public Course(String courseName,String courseCode,Department department) throws ClassNotFoundException, IOException
	{
		courseDB CourseDB = new courseDB();
		this.courseName = courseName;
		this.courseCode = courseCode;
		this.department = department;
		CourseDB.addToDB(courseCode, this);
	}
	public void addIndex(String indexID)
	{
		courseIndex[this.numIndex] = new courseIndex(indexID,this.courseCode);
		this.numIndex++;
		updateVacancy();
	}
	public void updateVacancy()
	{
		courseVacancy = 0;
		for(int i = 0;i<numIndex;i++)
		{
			courseVacancy = courseVacancy + courseIndex[i].indexVacancy;
		}
	}
	public courseIndex getIndex(String indexID)
	{
		for(int i=0;i<this.numIndex;i++)
		{
			if (courseIndex[i].indexID.equals(indexID))
			{
				return courseIndex[i];
			}
			
		}
		return null;
	}
	public boolean removeIndex(String indexID) throws ClassNotFoundException, IOException
	{
		courseDB CourseDB = new courseDB();
		for(int i=0;i<this.numIndex;i++)
		{
			if (courseIndex[i].indexID.equals(indexID))
			{
				for(int j=i;j<this.numIndex-1;j++)
				{
					System.out.println(courseIndex[j].indexID);
					System.out.println(courseIndex[j+1].indexID);
					courseIndex[j]=courseIndex[j+1];

				}
				this.numIndex--;
				updateVacancy();
				CourseDB.addToDB(courseCode, this);
				return true;
			}
		}
		System.out.println("No such Index!");
		return false;
	}
	public void printIndexes()
	{	
		if (this.numIndex!=0)
		{
			System.out.println("Course Has Indexes:");
			
			for(int i=0;i<this.numIndex;i++)
		{
			System.out.println(courseIndex[i].indexID);
		}}
		else {
			System.out.println("There are no indexes yet!");
		}
		
	}
	public Department getDepartment()
	{
		return this.department;
	}
	public String getCourseName()
	{
		return this.courseName;
	}
	
	
	
}
