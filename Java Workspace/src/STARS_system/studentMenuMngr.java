package STARS_system;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class studentMenuMngr {
	public studentMenuMngr(int choice,Student student) throws IOException
	{
		Student currentStudent = student;
		switch(choice)
		{
			case 1 :  
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter Course that you want to register for:");
				
				String courseCode = sc.nextLine();
			
				Course course = courseDB.getCourseObj(courseCode);
				
				course.printIndexes();
			
				System.out.println("Enter course index that you want to register for:");
				
				String courseIndexString = sc.nextLine();
				
				courseIndex courseIndex = course.getIndex(courseIndexString);
				
				Timetable timetable = new Timetable();
				ArrayList<courseIndex> indexlist = registeredCourses.getIndexes(currentStudent.getMatricNo());
				if (indexlist == null)
				{
					registeredCourses.registerIndex(currentStudent.getMatricNo(),courseCode,courseIndexString);
					System.out.println("Course registered!");
				}
				else {
					boolean checkclash = timetable.checkClash(indexlist, courseIndex);
					if (checkclash == false)
					{
						System.out.println("You cant register for this course!");
					}
					else {
						registeredCourses.registerIndex(currentStudent.getMatricNo(),courseCode,courseIndexString);
						System.out.println("Course registered!");
					}
				}
				
			
			
				
				break;
			case 2 :dropCourse(currentStudent);
					
				break;
			case 3 :printCourse(currentStudent);
				
				break;
			case 4 :
				
				break;
				
			case 5 :
				
				break;
			case 6 :
				
				break;
			
		}

			  
	}
	/**
	  * Drop course method
	  * @param student Student
	  */
	 private void dropCourse(Student student) {
	  printCourse(student);
	  String matricNo=student.getMatricNo();
	  Scanner sc = new Scanner(System.in);
	  System.out.println("Enter course code you would like to drop:");
	  String courseToDrop = sc.nextLine();
	  ArrayList<courseIndex> indexList = (ArrayList<courseIndex>)registeredCourses.getIndexes(matricNo);
	  for(int i=0;i<indexList.size();i++) {
	   if(indexList.get(i).courseCode.equals(courseToDrop))
	   {
	    indexList.remove(i);
	   }
	  }
	  
	 }
	 /**
	  * Print course method
	  * @param student
	  */
	 private void printCourse(Student student) {
	  String matricNo=student.getMatricNo();
	  
	  ArrayList<courseIndex> indexList = (ArrayList<courseIndex>)registeredCourses.getIndexes(matricNo);
	  for(int i=0;i<indexList.size();i++) {
	   System.out.println(indexList.get(i).courseCode);
	  }
	  
	 }
}
