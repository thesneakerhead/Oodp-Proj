package STARS_system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class courseIndex implements Serializable {
	public String indexID;
	public ArrayList<lesson> lessonList;
	public int indexVacancy;
	public ArrayList<Student> studentList;
	public ArrayList<Student> waitList;
	public String courseCode;
	public boolean isWaitList;
	
	public courseIndex(String indexID,String courseCode)
	{
		this.courseCode = courseCode;
		Scanner sc = new Scanner(System.in);
		this.indexID = indexID;
		this.lessonList = addLessons();
		System.out.println("Enter index vacancy:");
		this.indexVacancy=sc.nextInt();
		this.studentList = new ArrayList<Student>();
		this.waitList = new ArrayList<Student>();
		this.isWaitList = false;
	}
	
	public static ArrayList<lesson> addLessons()
	  {
		Boolean clash=false;
		Timetable timetable = new Timetable();
		int startTime=0,endTime=0,Day=0;
	    ArrayList<lesson> lessonList = new ArrayList<lesson>();
	    Scanner sc = new Scanner(System.in);
	    System.out.println("No. of lectures per week:");
	    int numLectures = sc.nextInt();
	    for (int i=0;i<numLectures;i++)
	    {	    	
	      	do 
	      	{
	      		System.out.print("Enter start time(hr) of lecture "+(i+1));
	      		System.out.println(". Start time must be within 8am-5pm(8-17)");
			    while (!sc.hasNextInt()) {
			    	System.out.println("Start time must be within 8am-5pm(8-17)");
			        sc.next(); 
			    }
			    startTime = sc.nextInt();
			}while(startTime<8||startTime>17);	      	
	      	do 
	      	{
	      		System.out.print("Enter end time(hr) of lecture "+(i+1));
	      		System.out.println(". End time must be after start time and within 9am-6pm(9-18)");
			    while (!sc.hasNextInt()) {
			    	System.out.println("End time must be after start time and within 9am-6pm(9-18)");
			        sc.next(); 
			    }
			    endTime = sc.nextInt();
			}while(endTime<9||endTime>18||endTime<startTime);	      	
	      	do 
	      	{
	      		System.out.println("Enter Day in the week MON-FRI(1-5)");
			    while (!sc.hasNextInt()) {
			    	System.out.println("Day must be MON-FRI(1-5)");
			        sc.next(); 
			    }
			    Day = sc.nextInt();
			}while(Day<1||Day>5);
	      	
	      lesson lesson = new lesson("LEC", Day, startTime, endTime);
	      clash = timetable.checkLessonClash(lessonList, lesson);
	      if(clash)
	    	  lessonList.add(lesson);
	      else
	      {
	    	  System.out.println("Lesson clashes with existing lessons, please re-input");
	    	  i--;
	      }
	    }
	    sc.nextLine();
	    System.out.println("Add tutorial for this index?('y' to add)");
	    String ans = sc.nextLine();
	    while (ans.equals("y"))
	    {
	    	do 
	      	{
	      		System.out.print("Enter start time(hr) of tutorial");
	      		System.out.println(". Start time must be within 8am-5pm(8-17)");
			    while (!sc.hasNextInt()) {
			    	System.out.println("Start time must be within 8am-5pm(8-17)");
			        sc.next(); 
			    }
			    startTime = sc.nextInt();
			}while(startTime<8||startTime>17);	      	
	      	do 
	      	{
	      		System.out.print("Enter end time(hr) of tutorial");
	      		System.out.println(". End time must be after start time and within 9am-6pm(9-18)");
			    while (!sc.hasNextInt()) {
			    	System.out.println("End time must be after start time and within 9am-6pm(9-18)");
			        sc.next(); 
			    }
			    endTime = sc.nextInt();
			}while(endTime<9||endTime>18||endTime<startTime);	      	
	      	do 
	      	{
	      		System.out.println("Enter Day in the week MON-FRI(1-5)");
			    while (!sc.hasNextInt()) {
			    	System.out.println("Day must be MON-FRI(1-5)");
			        sc.next(); 
			    }
			    Day = sc.nextInt();
			}while(Day<1||Day>5);
	      	
	      	lesson lesson = new lesson("TUT",Day, startTime, endTime);
	      	clash = timetable.checkLessonClash(lessonList, lesson);
		      if(clash)
		      {
		    	  lessonList.add(lesson);
		    	  ans="OK";
		    	  sc.nextLine();
		      }
		      else
		    	  System.out.println("Lesson clashes with existing lessons, please re-input");
		    
	    }
	    
	    System.out.println("Add lab for this index?('y' to add)");
	    String ans2 = sc.nextLine();
	    while (ans2.equals("y"))
	    {
	    	do 
	      	{
	      		System.out.print("Enter start time(hr) of lab");
	      		System.out.println(". Start time must be within 8am-5pm(8-17)");
			    while (!sc.hasNextInt()) {
			    	System.out.println("Start time must be within 8am-5pm(8-17)");
			        sc.next(); 
			    }
			    startTime = sc.nextInt();
			}while(startTime<8||startTime>17);	      	
	      	do 
	      	{
	      		System.out.print("Enter end time(hr) of lab");
	      		System.out.println(". End time must be after start time and within 9am-6pm(9-18)");
			    while (!sc.hasNextInt()) {
			    	System.out.println("End time must be after start time and within 9am-6pm(9-18)");
			        sc.next(); 
			    }
			    endTime = sc.nextInt();
			}while(endTime<9||endTime>18||endTime<startTime);
	      	do 
	      	{
	      		System.out.println("Enter Day in the week MON-FRI(1-5)");
			    while (!sc.hasNextInt()) {
			    	System.out.println("Day must be MON-FRI(1-5)");
			        sc.next(); 
			    }
			    Day = sc.nextInt();
			}while(Day<1||Day>5);
	      lesson lesson = new lesson("LAB",Day, startTime, endTime);
	      clash = timetable.checkLessonClash(lessonList, lesson);
	      if(clash)
	      {
	    	  lessonList.add(lesson);
	    	  ans2="OK";
	      }
	      else
	    	  System.out.println("Lesson clashes with existing lessons, please re-input");
	      
	    }
	    return lessonList;    
	}
	
	public void addStudent(Student student){
		studentList.add(student);
	}
	public void addToWaitlist(Student student)
	{
		waitList.add(student);
	}
	
	public void removeFromWaitlist(Student student)
	{
		int oSize = waitList.size();
		for(int i = 0;i<waitList.size();i++)
		{
			Student stdent = waitList.get(i);
			if (stdent.getMatricNo().equals(student.getMatricNo()))
			{
				waitList.remove(i);
			}
		}
		if(waitList.size()==oSize)
		{
			System.out.println("Student not in waitlist");
		}
	}
	public void removeStudent(Student student){
		int oSize = studentList.size();
		for(int i = 0;i<studentList.size();i++)
		{
			Student stdent = studentList.get(i);
			if (stdent.getMatricNo().equals(student.getMatricNo()))
			{
				studentList.remove(i);
			}
		}
		if(studentList.size()==oSize)
		{
			System.out.println("Student not registered in this course!");
		}
	}
	public void printStudentList()
	{
		
		for(int i = 0;i<studentList.size();i++)
		{
			System.out.println(studentList.get(i).getMatricNo()+ " "+studentList.get(i).getName());
		}
	}
	public void printWaitList()
	{
		
		for(int i = 0;i<waitList.size();i++)
		{
			System.out.println(waitList.get(i).getMatricNo()+ " "+waitList.get(i).getName());
		}
	}
	public void dequeueStudent()
	{
		Student student = waitList.get(0);
		ArrayList<courseIndex> indexList = registeredCourses.getIndexes(student.getMatricNo());
		for (int i =0;i<indexList.size();i++)
		{
			if(indexList.get(i).indexID.equals(this.indexID))
			{
				indexList.get(i).isWaitList = false;
			}
		}
		Student tempStudent = StudentDB.getStudentObj(student.getMatricNo());
		tempStudent.getSaccount().addNotification("You have sucessfully registered for the course: "+this.courseCode+" indexID:"+this.indexID);
		StarsApp.emailSender.exitWaitingListNotification(tempStudent, this.courseCode, this.indexID);
		waitList.remove(0);
		studentList.add(student);
		
	}
}
