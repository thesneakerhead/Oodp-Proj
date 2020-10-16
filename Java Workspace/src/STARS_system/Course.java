package STARS_system;

public class Course 
{
	private String courseName;
	private String school;
	private courseIndex courseIndex[] = new courseIndex[10];
	private int numIndex;
	
	public Course(String school, String course_name, int numIndex, int indexAR[], int vacancy)
	{
		courseName = course_name;
		this.school = school;
		this.numIndex = numIndex;
		//char first_letter = course_name.charAt(0);
		//int index = (int) first_letter*100 + 1;
		for(int i=0;i<this.numIndex;i++)
		{	
			courseIndex[i]= new courseIndex(indexAR[i], vacancy);	
		}
		
	}
	
	public String getCourse()
	{
		return courseName;
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
				System.out.println("Course "+courseName+" Index "+courseIndex[pos].getIndex()+" has been added");
				courseIndex[pos].minusVacancy(1);
			}
		}
		
		else
			System.out.println("Course does not have index "+index);
		
	}

}
