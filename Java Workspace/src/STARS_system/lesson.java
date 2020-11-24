package STARS_system;

import java.io.Serializable;

public class lesson implements Serializable 
{
	private String lessonType;
	private int startTime;
	private int endTime;
	private int day;
	
	public lesson (String lessonType,int day, int startTime, int endTime)
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
	
	public int getLesday()
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
