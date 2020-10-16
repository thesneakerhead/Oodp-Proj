package STARS_system;

public class Course 
{
	private int courseCode;
	private String school;
	private courseIndex courseIndex[] = new courseIndex[20];
	private int numIndex;
	
	public Course(String school, int courseCode, int numIndex, int indexAR[], int vacancy)
	{
		this.courseCode = courseCode;
		this.school = school;
		this.numIndex = numIndex;
		//char first_letter = course_name.charAt(0);
		//int index = (int) first_letter*100 + 1;
		for(int i=0;i<this.numIndex;i++)
		{	
			courseIndex[i]= new courseIndex(indexAR[i], vacancy);	
		}
		
	}
	
	public int getCourse()
	{
		return courseCode;
	}
	
	public String getSchool()
	{
		return school;
	}
	
	public void editCourseCode(int newCourseCode)
	{
		courseCode = newCourseCode;
	}
	
	public void editCurrIndex(int oldIndex, int newIndex)
	{
		Boolean found = false;
		for(int i=0; i<numIndex; i++)
		{
			if (oldIndex == courseIndex[i].getIndex())
			{
				found = true;
				courseIndex[i].changeIndex(newIndex);
				System.out.println("Index "+oldIndex +" has been changed to Index "+ newIndex);
				break;
			}
		}
		
		if (!found)
			System.out.println("Course does not have index "+oldIndex);
	}
	
	public void addNewIndex (int newIndex, int vacancy)
	{
		courseIndex[numIndex] = new courseIndex(newIndex,vacancy);
		System.out.println("Index "+ newIndex + " has been added");
		numIndex++;
		
	}
	
	public void deleteIndex(int deleteIndex)
	{
		int pos=0;
		Boolean found = false;
		for(int i=0; i<numIndex; i++)
		{
			if (deleteIndex == courseIndex[i].getIndex())
			{
				found = true;
				for(int j=pos; j<numIndex-1;j++)
					courseIndex[j]=courseIndex[j+1];
				
				System.out.println("Index "+ deleteIndex + " has been deleted");
				numIndex--;
				break;
			}
			pos++;
		}
		if (!found)
			System.out.println("Course does not have index "+deleteIndex);
	}
	
	public void changeAllIndex(int numIndex,int indexAR[], int vacancy)
	{
		this.numIndex = numIndex;
		for(int i=0;i<this.numIndex;i++)
		{	
			courseIndex[i]= new courseIndex(indexAR[i], vacancy);	
		}
	}
	
	public void printVacancy(int index)
	{
		Boolean found = false;
		for(int i=0; i<numIndex; i++)
		{
			if (index == courseIndex[i].getIndex())
			{
				found = true;
				System.out.println("Vacancy for Index "+ index +" is " + courseIndex[i].getVacancy());
				break;
			}
		}
		if (!found)
			System.out.println("Course does not have index "+index);
	}
	
	public void printAvalIndex()
	{
		 
		System.out.println("Course Indexes are:");
		for(int i=0; i<numIndex; i++)
		{
			System.out.print("Index "+courseIndex[i].getIndex());
			if(courseIndex[i].getVacancy()<1)
				System.out.print(" (full)");
			else
				System.out.print(" avaliable: "+courseIndex[i].getVacancy());
				
			System.out.println();
		}	
	}
	
	public void addCourse(int index)
	{
		Boolean found = false;
		int pos = 0;
		for(int i=0; i<numIndex; i++)
		{
			if(index == courseIndex[i].getIndex())
			{
				found = true;
				break;
			}
			pos++;
		}
		if(found)
		{
			if(courseIndex[pos].getVacancy()<1)
				System.out.println("Course index "+index+" is full");
			else
			{
				System.out.println("Course "+courseCode+" Index "+courseIndex[pos].getIndex()+" has been added");
				courseIndex[pos].minusVacancy(1);
			}
		}
		
		else
			System.out.println("Course does not have index "+index);
		
	}

}
