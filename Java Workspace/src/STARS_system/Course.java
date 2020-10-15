package STARS_system;

public class Course 
{
	private String courseName;
	private courseIndex courseIndex[] = new courseIndex[2];
	
	public Course(String course_name)
	{
		courseName = course_name;
		char first_letter = course_name.charAt(0);
		int index = (int) first_letter*100 + 1;
		for(int i=0;i<2;i++)
		{
			courseIndex[i]= new courseIndex(index);	
			index++;
		}
		
	}
	
	public String getCourse()
	{
		return courseName;
	}
	
	public void printAvalIndex()
	{
		 
		System.out.println("Course Indexes are:");
		for(int i=0; i<2; i++)
		{
			System.out.print("Index "+courseIndex[i].getIndex());
			if(courseIndex[i].getVacancy()<1)
				System.out.print(" (full)");
				
			System.out.println();
		}
		
	}
	
	public void addCourse(int index)
	{
		int i=-1;
		char first_letter = courseName.charAt(0);
		int Algoindex = (int) first_letter*100 + 1;
		if (index==Algoindex)
			i = 0;
		else if (index==Algoindex + 1)
			i = 1;
		
		if(i>=0)
		{
			if(courseIndex[i].getVacancy()<1)
				System.out.println("Course index "+index+" is full");
			else
			{
				System.out.println("Course "+courseName+" Index "+Algoindex+" has been added");
				courseIndex[i].minusVacancy(1);
			}
		}
		
		else
			System.out.println("Course does not have index "+index);
		
	}

}
