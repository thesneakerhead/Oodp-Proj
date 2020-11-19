package STARS_system;

import java.util.ArrayList;

public class Timetable {
	public String[][] timetable = new String[5][10];
	
	public Timetable() {
	    for (int i = 0; i < 5; i++)
	    {
	    	for (int j = 0; j < 10; j++)
	    	{
	    		timetable[i][j] = "0";
	    	}
	    }
	  }
	
	  public boolean checkClash(ArrayList<courseIndex>studentIndexes,courseIndex newIndex)
	  {
		
	    for(int i = 0; i < studentIndexes.size(); i++)
	    {
	   
	      ArrayList<lesson>lessonList = studentIndexes.get(i).lessonList;
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
	  
	  public boolean addSlot(String nameOfCourse,String classType,int timeStart,int timeEnd,int day)
	  {
		  
	     String combineCourseAndClasstype = classType+nameOfCourse;
	     
	     for (int i = timeStart-8; i <= timeEnd-8; i++)
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
	
	
	public void printTimetable()
	{
		for (int i = 0; i < 10; i++)
	    {
			for (int j = 0; j <5;j++)
	    		{System.out.print(fixedLengthString(timetable[j][i], 15));}
			System.out.println("");
	    		
	    }
	}
	public static String fixedLengthString(String string, int length) {
	    return String.format("%1$"+length+ "s", string);
	}
	
	
}


