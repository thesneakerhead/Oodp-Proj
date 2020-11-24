package STARS_system;

import java.util.ArrayList;
<<<<<<< HEAD
=======

>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697
/**
 * Timetable class
 *
 */
public class Timetable {
	/**
	 * Timetable array
	 */
	public String[][] timetable = new String[5][10];
<<<<<<< HEAD
=======
	
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697
	/**
	 * Construct timetable
	 */
	public Timetable() {
	    for (int i = 0; i < 5; i++)
	    {
	    	for (int j = 0; j < 10; j++)
	    	{
	    		timetable[i][j] = "0";
	    	}
	    }
	  }
<<<<<<< HEAD
=======
	
	  public boolean checkClash(ArrayList<CourseIndex>studentIndexes,CourseIndex newIndex)
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697
	/**
	 * Check if indexes clash
	 * @param studentIndexes Array of indexes
	 * @param newIndex Index to check
	 */
<<<<<<< HEAD
	  public boolean checkClash(ArrayList<courseIndex>studentIndexes,courseIndex newIndex)
=======
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697
	  {
		
	    for(int i = 0; i < studentIndexes.size(); i++)
	    {
	      ArrayList<Lesson>lessonList = studentIndexes.get(i).lessonList;
	      String Course = studentIndexes.get(i).courseCode;
	      for (int j = 0; j < lessonList.size(); j++)
	      {
	        int ST = lessonList.get(j).getLesST();
	        int ET = lessonList.get(j).getLesET();
	        String LT = lessonList.get(j).getLesType();
	        int day = lessonList.get(j).getLesday();
	        addSlot(Course, LT, ST, ET, day);
	        
	      }
	    }

	    for (int i = 0; i < newIndex.lessonList.size(); i++)
	    {
	      boolean checkclash = addSlot(newIndex.courseCode,newIndex.lessonList.get(i).getLesType(),newIndex.lessonList.get(i).getLesST(),
	          newIndex.lessonList.get(i).getLesET(),newIndex.lessonList.get(i).getLesday());
	      
	      if (checkclash == false)
	      {
	        return false;
	      }
	    }
	    return true;
	  }
<<<<<<< HEAD
=======
	  
	  public boolean checkLessonClash(ArrayList<Lesson>lessonList, Lesson newLesson)
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697
	  /**
	   * Check for lesson clash
	   * @param lessonList List of lesson
	   * @param newLesson New lesson to check
	   */
<<<<<<< HEAD
	  public boolean checkLessonClash(ArrayList<lesson>lessonList, lesson newLesson)
=======
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697
	  {

			  for (int j = 0; j < lessonList.size(); j++)
			  {
		        int ST = lessonList.get(j).getLesST();
		        int ET = lessonList.get(j).getLesET();
		        String LT = lessonList.get(j).getLesType();
		        int day = lessonList.get(j).getLesday();
		        //addSlot(course, LT, ST, ET, day);
			  }

	      boolean checkclash = addLes(newLesson.getLesType(),newLesson.getLesST(),
	          newLesson.getLesET(),newLesson.getLesday());
	      
	      return checkclash;	    
	  }
<<<<<<< HEAD
=======
	  
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697
	  /**
	   * Add lesson method
	   * @param classType Class type
	   * @param timeStart Start time
	   * @param timeEnd End time
	   * @param day Day
	   */
	  public boolean addLes(String classType,int timeStart,int timeEnd,int day)
	  {
		  
	     String combineCourseAndClasstype = classType;
	     
	     for (int i = timeStart-8; i < timeEnd-8; i++)
	     {
	    	 
	       if (timetable[day-1][i].equals("0"))
	       {
  	         timetable[day-1][i] = combineCourseAndClasstype;         
	       }
	       else
	       {
	         System.out.println("Timeslot chosen clashes with " + timetable[day-1][i]);
	         return false;
	       }
	     }
	     return true;
	  }
<<<<<<< HEAD
	  /**
			 * Add slot method
			 * @param nameOfCourse Name of course
			 * @param classType Class type
			 * @param timeStart Start time
			 * @param timeEnd End time
			 * @param day Day
			 */
=======
	  
	  /**
		 * Add slot method
		 * @param nameOfCourse Name of course
		 * @param classType Class type
		 * @param timeStart Start time
		 * @param timeEnd End time
		 * @param day Day
		 */
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697
	  public boolean addSlot(String nameOfCourse,String classType,int timeStart,int timeEnd,int day)
	  {
		  
	     String combineCourseAndClasstype = classType+" "+nameOfCourse;
	     
	     for (int i = timeStart-8; i < timeEnd-8; i++)
	     {
	    	 
	       if (timetable[day-1][i].equals("0"))
	       {
  	         timetable[day-1][i] = combineCourseAndClasstype;         
	       }
	       else
	       {
	         System.out.println("Timeslot chosen clashes with " + timetable[day-1][i]);
	         return false;
	       }
	     }
	     return true;
	  }
	
<<<<<<< HEAD
	/**
	* Print time table method
	*/
=======
	
	  /**
		 * Print time table method
		 */
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697
	public void printTimetable()
	{
		for (int i = 0; i < 10; i++)
	    {
			for (int j = 0; j <5;j++)
	    		{System.out.print(fixedLengthString(timetable[j][i], 15));}
			System.out.println("");
	    		
	    }
	}
	/**
	 * Format String method
	 */
	public static String fixedLengthString(String string, int length) {
	    return String.format("%1$"+length+ "s", string);
	}
	
	
}


