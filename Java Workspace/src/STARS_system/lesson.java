package STARS_system;

import java.io.Serializable;

public class Lesson implements Serializable 
/**
 * Lesson class
 *
 */
{
	/**
	 * Lesson type
	 */
	private String lessonType;
	/*
	 * Start time
	 */
	private int startTime;
	/**
	 * End time
	 */
	private int endTime;
	/**
	 * Day
	 */
	private int day;
	
	public Lesson (String lessonType,int day, int startTime, int endTime)
	/**
	 * Lesson Constructor
	 * @param lessonType - user's given lessonType
	 * @param day - user's given day
	 * @param startTime - user's given startTime
	 * @param endTime - user's given endTime
	 */
	{
		this.lessonType = lessonType;
		this.startTime = startTime;
		this.endTime = endTime;
		this.day = day;
	}
	
	/**
	 * get lesson type
	 * @return - lessonType
	 */
	public String getLesType()
	{
		return lessonType;
	}
	
	/**
	 * get lesson day
	 * @return - day
	 */
	public int getLesday()
	{
		return day;
	}
	
	/**
	 * get lesson start time
	 * @return - startTime
	 */
	public int getLesST()
	{
		return startTime;
	}
	
	/**
	 * get lesson end time
	 * @return - endTime
	 */
	public int getLesET()
	{
		return endTime;
	}
	
	/**
	 * print lessonType, day, start and end time
	 */
	public void printLesson()
	{
		System.out.println(lessonType+" ("+day+")");
		System.out.println("Start Time: "+startTime);
		System.out.println("End Time: "+endTime);
	}

}
