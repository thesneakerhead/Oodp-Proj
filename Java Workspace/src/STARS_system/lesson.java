package STARS_system;

public class lesson 
{
	private String lessonType;
	private int startTime;
	private int endTime;
	private String day;
	
	public lesson (String lessonType,String day, int startTime, int endTime)
	{
		this.lessonType = lessonType;
		this.startTime = startTime;
		this.endTime = endTime;
		this.day = day;
	}
	
	public String getLesType()
	{
		return lessonType;
	}
	
	public String getLesday()
	{
		return day;
	}
	
	public int getLesST()
	{
		return startTime;
	}
	
	public int getLesET()
	{
		return endTime;
	}
	
	public void printLesson()
	{
		System.out.println(lessonType+" ("+day+")");
		System.out.println("Start Time: "+startTime);
		System.out.println("End Time: "+endTime);
	}

}
