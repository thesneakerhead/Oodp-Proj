package STARS_system;

import java.io.IOException;
import java.io.Serializable;
import java.util.Dictionary;


<<<<<<< HEAD
=======

>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697
/**
 * Course class
 *
 */
public class Course implements Serializable{
	/**
	 * Course code
	 */
	public  String courseCode;
	/**
	 * Course Name
	 */
	private  String courseName;
	/**
	 * Department of course
	 */
	private Department department;
<<<<<<< HEAD
	/**
	 * Course indexes
	 */
	public  courseIndex courseIndex[]=new courseIndex[20];
	/**
	 * Number of course indexes
=======
	public  CourseIndex courseIndex[]=new CourseIndex[20];
	/**
	 * Course index
	 */
	/**
	 * Index number
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697
	 */
	public  int numIndex=0;
	/**
	 * Course vacancy
	 */
	public  int courseVacancy=0;
	/**
	 * Course constructor
	 * @param courseName - user's given courseName
	 * @param courseCode - user's given courseCode
	 * @param department - user's given department
	 */
	public Course(String courseName,String courseCode,Department department) throws ClassNotFoundException, IOException
	/**
	 * Course constructor
	 * @param courseName - user's given courseName
	 * @param courseCode - user's given courseCode
	 * @param department - user's given department
	 */
	{
<<<<<<< HEAD
		
=======
		CourseDB CourseDB = new CourseDB();
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697
		this.courseName = courseName;
		this.courseCode = courseCode;
		this.department = department;
		STARSApp.courseDB.addToDB(courseCode, this);
	}
	/**
	 * Add new index for an existing course method
	 * @param indexID - new indexID
	 */
	public void addIndex(String indexID)
	{
		courseIndex[this.numIndex] = new CourseIndex(indexID,this.courseCode);
		this.numIndex++;
		updateVacancy();
	}
	/**
	 * Update vacancy method
	 */
	public void updateVacancy()
	{
		courseVacancy = 0;
		for(int i = 0;i<numIndex;i++)
		{
			courseVacancy = courseVacancy + courseIndex[i].indexVacancy;
		}
	}
<<<<<<< HEAD
=======
	public CourseIndex getIndex(String indexID)
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697
	/**
	 * Get index method
	 * @param indexID - existing indexID
	 * @return - courseIndex
	 */
<<<<<<< HEAD
	public courseIndex getIndex(String indexID)
=======
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697
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
	/**
	 * Remove index method
	 * @param indexID - existing indexID
	 * @return - removed or indexID does not exist
	 */
	public boolean removeIndex(String indexID) throws ClassNotFoundException, IOException
	/**
	 * Remove index method
	 * @param indexID - existing indexID
	 * @return - removed or indexID does not exist
	 */
	{
		CourseDB CourseDB = new CourseDB();
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
	/**
	 * Print Indexes of course method
	 */
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
	/**
	 * Get department method
	 * @return department
	 */
	public Department getDepartment()
	{
		return this.department;
	}
	/**
	 * Get course name method
	 * @return courseName
	 */
	public String getCourseName()
	{
		return this.courseName;
	}
	
	
	
}
