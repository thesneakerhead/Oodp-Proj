package STARS_system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class courseIndex implements Serializable {
	public String indexID;
	public ArrayList<lesson> lessonList;
	public int indexVacancy;
	public ArrayList<Student> studentList;
	
	public String courseCode;
	
	public courseIndex(String indexID,String courseCode)
	{
		this.courseCode = courseCode;
		Scanner sc = new Scanner(System.in);
		this.indexID = indexID;
		this.lessonList = addLessons();
		System.out.println("Enter index vacancy:");
		this.indexVacancy=sc.nextInt();
		this.studentList = new ArrayList<Student>();
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
			lesson lesson = new lesson("lecture", Day, startTime, endTime);
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
			lesson lesson = new lesson("tutorial", startTime, endTime, Day);
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
			lesson lesson = new lesson("lab", startTime, endTime, Day);
			lessonList.add(lesson);
		}
		return lessonList;
		
		
		
	}
	public void addStudent(Student student){
		studentList.add(student);
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
}
