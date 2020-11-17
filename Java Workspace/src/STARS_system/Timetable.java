package STARS_system;

public class Timetable {
	String[][] timetable = new String[5][10];
	
	public Timetable() {
	    for (int i = 0; i < 5; i++)
	    {
	    	for (int j = 0; j < 10; j++)
	    	{
	    		timetable[i][j] = "0";
	    	}
	    }
	  }
	
	public void addSlot(String nameOfCourse,String classType,int timeStart,int timeEnd,int day)
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
			 }
		 }
		 
	}
	
	
	public void printTimetable()
	{
		for (int i = 0; i < 5; i++)
	    {
			System.out.println();
	    	for (int j = 0; j < 10; j++)
	    	{
	    		System.out.print(timetable[i][j]);
	    	}
	    }
	}
	
	
}


