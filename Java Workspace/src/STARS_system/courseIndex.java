package STARS_system;

public class courseIndex
{
	private int course_index;
	private int vacancy;
	//private String classtime;
	
	public courseIndex(int course_index, int vacancy)
	{
		this.course_index = course_index;
		this.vacancy = vacancy;
	}
	
	public int getIndex()
	{
		return course_index;
	}
	
	public int getVacancy()
	{
		return vacancy;
	}
	
	public void changeIndex (int newIndex)
	{
		course_index = newIndex;
	}
	
	public void changeVacancy(int newVacancy)
	{
		vacancy = newVacancy;
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
