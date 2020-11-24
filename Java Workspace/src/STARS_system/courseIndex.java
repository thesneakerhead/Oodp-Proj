package STARS_system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
<<<<<<< HEAD:Java Workspace/src/STARS_system/CourseIndex.java
=======

public class CourseIndex implements Serializable {
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/courseIndex.java
/**
 * Course index class
 *
 */
<<<<<<< HEAD:Java Workspace/src/STARS_system/CourseIndex.java
public class courseIndex implements Serializable {
=======
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/courseIndex.java
	/**
	 * Index id
	 */
	public String indexID;
<<<<<<< HEAD:Java Workspace/src/STARS_system/CourseIndex.java
	/**
	 * Array list for lessons
	 */
	public ArrayList<lesson> lessonList;
=======
	public ArrayList<Lesson> lessonList;
	/**
	 * Array list for lessons
	 */
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/courseIndex.java
	/**
	 * Vacancy for index
	 */
	public int indexVacancy;
	/**
	 * Student list
	 */
	public ArrayList<Student> studentList;
	/**
	 * Wait list
	 */
	public ArrayList<Student> waitList;
	/**
	 * Course code
	 */
	public String courseCode;
	/**
	 * Check if on waiting list
	 */
	public boolean isWaitList;
<<<<<<< HEAD:Java Workspace/src/STARS_system/CourseIndex.java
=======
	
	public CourseIndex(String indexID,String courseCode)
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/courseIndex.java
	/**
	 * Constructor for courseIndex
	 * @param indexID - user's given indexID
	 * @param courseCode - user's given courseCode
	 */
<<<<<<< HEAD:Java Workspace/src/STARS_system/CourseIndex.java
	public courseIndex(String indexID,String courseCode)
=======
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/courseIndex.java
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
<<<<<<< HEAD:Java Workspace/src/STARS_system/CourseIndex.java
	/**
	  * Add lessons to a courseIndex
	  * @return Array list of lessons
	  */
	public static ArrayList<lesson> addLessons()
=======
	
	public static ArrayList<Lesson> addLessons()
	/**
	  * add lessons to a courseIndex
	  * @return - arraylist of lessons
	  */
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/courseIndex.java
	  {
		Boolean clash=false;
		Timetable timetable = new Timetable();
		int startTime=0,endTime=0,Day=0;
	    ArrayList<Lesson> lessonList = new ArrayList<Lesson>();
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
	      	
	      Lesson lesson = new Lesson("LEC", Day, startTime, endTime);
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
	      	
	      	Lesson lesson = new Lesson("TUT",Day, startTime, endTime);
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
	      Lesson lesson = new Lesson("LAB",Day, startTime, endTime);
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
<<<<<<< HEAD:Java Workspace/src/STARS_system/CourseIndex.java
	/**
	 * Add a student to a courseIndex 	
=======
	
	/**
	 * add a student to a courseIndex 	
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/courseIndex.java
	 */
	public void addStudent(Student student){
		studentList.add(student);
	}
	/**
	 * Add student to waitlist method
	 * @param student student to add
	 */
	public void addToWaitlist(Student student)
	{
		waitList.add(student);
	}
<<<<<<< HEAD:Java Workspace/src/STARS_system/CourseIndex.java
=======
	
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/courseIndex.java
	/**
	 * Remove student from waitlist method
	 * @param student student to remove
	 */
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
	/**
<<<<<<< HEAD:Java Workspace/src/STARS_system/CourseIndex.java
	 * Remove student from a courseIndex
	 * @param student student who is registered in the courseIndex
=======
	 * remove student from a courseIndex
	 * @param student - student who is registered in the courseIndex
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/courseIndex.java
	 */
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
	/**
	 * Print student list method
	 */
	public void printStudentList()
	{
		
		for(int i = 0;i<studentList.size();i++)
		{
			System.out.println(studentList.get(i).getMatricNo()+ " "+studentList.get(i).getName());
		}
	}
	/**
	 * Print wait list method
	 */
	public void printWaitList()
	{
		
		for(int i = 0;i<waitList.size();i++)
		{
			System.out.println(waitList.get(i).getMatricNo()+ " "+waitList.get(i).getName());
		}
	}
	/**
	 * Dequeue student method
	 */
	public void dequeueStudent()
	{
		Student student = waitList.get(0);
<<<<<<< HEAD:Java Workspace/src/STARS_system/CourseIndex.java
		ArrayList<courseIndex> indexList = RegisteredCourses.getIndexes(student.getMatricNo());
=======
		ArrayList<CourseIndex> indexList = RegisteredCourses.getIndexes(student.getMatricNo());
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/courseIndex.java
		for (int i =0;i<indexList.size();i++)
		{
			if(indexList.get(i).indexID.equals(this.indexID))
			{
				indexList.get(i).isWaitList = false;
			}
		}
		Student tempStudent = StudentDB.getStudentObj(student.getMatricNo());
		tempStudent.getSaccount().addNotification("You have sucessfully registered for the course: "+this.courseCode+" indexID:"+this.indexID);
		STARSApp.emailSender.exitWaitingListNotification(tempStudent, this.courseCode, this.indexID);
		waitList.remove(0);
		studentList.add(student);
		
	}
}
