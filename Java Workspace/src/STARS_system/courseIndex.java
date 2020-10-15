package STARS_system;

public class courseIndex
{
	private int course_index;
	private int vacancy;
	//private String classtime;
	
	public courseIndex(int course_index)
	{
		this.course_index = course_index;
		vacancy = 10;
	}
	
	public int getIndex()
	{
		return course_index;
	}
	
	public int getVacancy()
	{
		return vacancy;
	}
	
	public void minusVacancy(int i)
	{
		vacancy = vacancy-i;
	}
	
	public void addVacancy(int i)
	{
		vacancy = vacancy+i;
	}
}
