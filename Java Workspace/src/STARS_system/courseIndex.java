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
	    ArrayList<lesson> lessonList = new ArrayList<lesson>();
	    Scanner sc = new Scanner(System.in);
	    System.out.println("No. of lectures per week:");
	    int numLectures = sc.nextInt();
	    for (int i=0;i<numLectures;i++)
	    {
	      System.out.println("Enter Start time of lecture "+(i+1));
	      int startTime = sc.nextInt();
	      System.out.println("Enter End time of lecture "+(i+1));
	      int endTime = sc.nextInt();
	      System.out.println("Enter Day in the week");
	      int Day = sc.nextInt();
	      lesson lesson = new lesson("LEC", Day, startTime, endTime);
	      lessonList.add(lesson);
	    }
	    sc.nextLine();
	    System.out.println("Add tutorial for this index?('y' to add)");
	    String ans = sc.nextLine();
	    if (ans.equals("y"))
	    {
	      System.out.println("Enter Start time of tutorial");
	      int startTime = sc.nextInt();
	      System.out.println("Enter End time of tutorial");
	      int endTime = sc.nextInt();
	      System.out.println("Enter Day in the week");
	      int Day = sc.nextInt();
	      lesson lesson = new lesson("TUT", Day, startTime, endTime);
	      lessonList.add(lesson);
	      sc.nextLine();
	    }
	    
	    System.out.println("Add lab for this index?('y' to add)");
	    String ans2 = sc.nextLine();
	    if (ans2.equals("y"))
	    {
	      System.out.println("Enter Start time of lab");
	      int startTime = sc.nextInt();
	      System.out.println("Enter End time of lab");
	      int endTime = sc.nextInt();
	      System.out.println("Enter Day in the lab");
	      int Day = sc.nextInt();
	      lesson lesson = new lesson("LAB",Day, startTime, endTime);
	      lessonList.add(lesson);
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
		waitList.remove(0);
		studentList.add(student);
		
	}
}
