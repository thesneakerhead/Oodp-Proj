package STARS_system;

import java.io.Serializable;
import java.util.Dictionary;



public class Course implements Serializable{
	public  String courseCode;
	private  String courseName;
	private Department department;
	public  courseIndex courseIndex[]=new courseIndex[20];
	public  int numIndex=0;
	public  int courseVacancy=0;
	
	public Course(String courseName,String courseCode,Department department)
	{
		this.courseName = courseName;
		this.courseCode = courseCode;
		this.department = department;
		courseDB.addCourse(courseCode, this);
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
			else {
				return null;
			}
		}
		return null;
	}
	public boolean removeIndex(String indexID)
	{
		for(int i=0;i<this.numIndex;i++)
		{
			if (courseIndex[i].indexID.equals(indexID))
			{
				for(int j=i;j<this.numIndex;j++)
				{
					System.out.println(courseIndex[j].indexID);
					System.out.println(courseIndex[j+1].indexID);
					courseIndex[j]=courseIndex[j+1];
					
					updateVacancy();
					courseDB.addCourse(courseCode, this);
					return true;
				}
				this.numIndex--;
			}
		}
		System.out.println("No such Index!");
		return false;
	}
	public void printIndexes()
	{	
		if (this.numIndex!=0)
		{for(int i=0;i<this.numIndex;i++)
		{
			System.out.println(courseIndex[i].indexID);
		}}
		else {
			System.out.println("There are no indexes yet!");
		}
		
	}
	
	
	
}
