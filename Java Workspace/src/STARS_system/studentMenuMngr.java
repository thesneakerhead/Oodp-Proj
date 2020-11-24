package STARS_system;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Scanner;
<<<<<<< HEAD:Java Workspace/src/STARS_system/StudentMenuMngr.java
=======

public class StudentMenuMngr {
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/studentMenuMngr.java
/**
 * 
 * Student Menu Manager Class
 *
 */
<<<<<<< HEAD:Java Workspace/src/STARS_system/StudentMenuMngr.java
public class StudentMenuMngr {
	Scanner sc = new Scanner(System.in);
=======
	Scanner sc = new Scanner(System.in);
	
	public StudentMenuMngr(int choice,Student student) throws IOException, ClassNotFoundException
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/studentMenuMngr.java
	/**
	 * Student menu manager constructor
	 * @param choice Choice of function
	 * @param student Student
	 * @throws IOException Exception handling
	 */
<<<<<<< HEAD:Java Workspace/src/STARS_system/StudentMenuMngr.java
	public StudentMenuMngr(int choice,Student student) throws IOException, ClassNotFoundException
=======
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/studentMenuMngr.java
	{
		Student currentStudent = student;
		switch(choice)
		{
			case 1 :addCourse(currentStudent);
				
				break;
			case 2 :dropCourse(currentStudent);
				
				break;
			case 3 :printCourse(currentStudent);
				
				break;
			case 4 :checkVacancy();
				
				break;
				
			case 5 :changeIndex(currentStudent);
				
				break;
			case 6 :swapIndex(currentStudent);
				
			
				break;
			case 7 :changeDetails(currentStudent);
				
				break;
			//default:StarsApp.terminate();
				//	break;
		}
	}
	/**
	 * Change email and password method
	 * @param student Student
	 * @throws IOException Exception handling
	 */
	private void changeDetails(Student student) throws IOException, ClassNotFoundException
	/**
	 * Change email and password method
	 * @param student Student
	 * @throws IOException Exception handling
	 */
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("=======================================================");
		System.out.println("|      1. Change Password                             |");
		System.out.println("|      2. Change Email                                |");
		System.out.println("=======================================================");
		System.out.println("Enter Choice:");
		int selection = sc.nextInt();
		sc.nextLine();
		switch (selection) {
			case 1:
				while(true)
					{
						System.out.println("Enter new password");
						String pw = sc.nextLine();
						System.out.println("Re-enter new password");
						String repw = sc.nextLine();
						if (pw.equals(repw))
						{
							
<<<<<<< HEAD:Java Workspace/src/STARS_system/StudentMenuMngr.java
							student.getSaccount().setAccountPW(STARSAccMngr.passwordHash(pw));
							STARSApp.studentDB.addToDB(student.getMatricNo(), student);
							STARSAccMngr.editPassword(student.getMatricNo(), STARSAccMngr.passwordHash(pw), false);
=======
							student.getSaccount().setAccountPW(STARSaccMngr.passwordHash(pw));
							STARSApp.studentDB.addToDB(student.getMatricNo(), student);
							STARSaccMngr.editPassword(student.getMatricNo(), STARSaccMngr.passwordHash(pw), false);
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/studentMenuMngr.java
							break;
						}
						else {
							System.out.println("Passwords not matching!");
							System.out.println("Enter (Y) to continue");
							String cont = sc.nextLine();
							if(cont.equals("Y")||cont.equals("y"))
							{
								continue;
							}
							else {
								break;
							}
							
						}
					}
				
				break;
				
			case 2:
				String email;
				 do {
				        System.out.println("Please enter Email that you would like to switch to:");
				        email = sc.nextLine();
				        if (!((email.endsWith(".com")||email.endsWith(".com.sg")||email.endsWith(".net"))&&email.contains("@")))
				        {
				        	System.out.println("Invalid email! Please re-enter");
				        }
				        }while(!((email.endsWith(".com")||email.endsWith(".com.sg")||email.endsWith(".net"))&&email.contains("@")));
				 student.setEmail(email);
				 
				 STARSApp.studentDB.addToDB(student.getMatricNo(), student);
					
				break;
		}
		
	}
<<<<<<< HEAD:Java Workspace/src/STARS_system/StudentMenuMngr.java
=======
	
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/studentMenuMngr.java
	/**
	 * Swap index method
	 * @param student1 Student
	 * @throws IOException Exception handling
	 */
	private void swapIndex(Student student1) throws IOException
	{
		Boolean firstRegistered=false,secRegistered=false;
		String course1 = null,course2=null;
		int i =0,j=0;
		CourseIndex index1 = null,index2 = null;
		
		System.out.println("What is your current index number");
		String stud1Index = sc.next();
		System.out.println("Student 2 login:");
		StudentLogin login2 = new StudentLogin();
		
<<<<<<< HEAD:Java Workspace/src/STARS_system/StudentMenuMngr.java
		ArrayList<courseIndex> indexList1 = (ArrayList<courseIndex>)RegisteredCourses.getIndexes(student1.getMatricNo());
=======
		ArrayList<CourseIndex> indexList1 = (ArrayList<CourseIndex>)RegisteredCourses.getIndexes(student1.getMatricNo());
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/studentMenuMngr.java
		for(i=0;i<indexList1.size();i++)
		{
			index1 = indexList1.get(i);
			course1 = index1.courseCode;
			if(stud1Index.equals(index1.indexID))
			{
				firstRegistered = true;
				break;
			}
			
		}
		
		Student student2 = login2.getStudent();
		System.out.println("What is student 2's index number");
		String stud2Index = sc.next();
		
<<<<<<< HEAD:Java Workspace/src/STARS_system/StudentMenuMngr.java
		ArrayList<courseIndex> indexList2 = (ArrayList<courseIndex>)RegisteredCourses.getIndexes(student2.getMatricNo());
=======
		ArrayList<CourseIndex> indexList2 = (ArrayList<CourseIndex>)RegisteredCourses.getIndexes(student2.getMatricNo());
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/studentMenuMngr.java
		for(j=0;j<indexList2.size();j++)
		{
			index2 = indexList2.get(j);
			course2 = index2.courseCode;
			if(stud2Index.equals(index2.indexID))
			{
				secRegistered = true;
				break;
			}
		}
		if (firstRegistered && secRegistered)
		{
			if(course1.equals(course2))
			{
				Course course = CourseDB.getCourseObj(course1);
<<<<<<< HEAD:Java Workspace/src/STARS_system/StudentMenuMngr.java
				courseIndex cIndex1 = course.getIndex(stud1Index);
				courseIndex cIndex2 = course.getIndex(stud2Index);
=======
				CourseIndex cIndex1 = course.getIndex(stud1Index);
				CourseIndex cIndex2 = course.getIndex(stud2Index);
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/studentMenuMngr.java
				String[] DAY = new String[] {"","M","T","W","TH","F"};
		        System.out.println("Current index: "+stud1Index);
		        System.out.println("Lesson:\tDay:\tST(hr):\tET(hr):");

		        for(int l=0;l<cIndex1.lessonList.size();l++)
		        {
		            
		            Lesson les =cIndex1.lessonList.get(l);
		            
		            System.out.println(les.getLesType()+"\t "+DAY[les.getLesday()]+"\t "+les.getLesST()+"\t "+les.getLesET());
		        }
		        System.out.println("------------------------------------------");
		        System.out.println("New index: "+stud2Index);
		        System.out.println("Lesson:\tDay:\tST(hr):\tET(hr):");
		        for(int nl=0;nl<cIndex2.lessonList.size();nl++)
		        {
		            Lesson nles = cIndex2.lessonList.get(nl);
		            System.out.println(nles.getLesType()+"\t "+DAY[nles.getLesday()]+"\t "+nles.getLesST()+"\t "+nles.getLesET());
		        }
		        System.out.println("(Y) to confirm change, any other key to cancel");
		        String confirm = sc.next();
		        if(confirm.equals("y")||confirm.equals("Y"))
		        {
					cIndex1.removeStudent(student1);
					cIndex1.addStudent(student2);
					cIndex2.removeStudent(student2);
					cIndex2.addStudent(student1);
					
					indexList1.remove(i);
					indexList1.add(index2);
					indexList2.remove(j);
					indexList2.add(index1);
		        }

			}
			else
				System.out.println("Course code of both indexes are not the same");
		}
		else
			System.out.println("1 or both of the indexes have not been registered by the students");
		
	}
<<<<<<< HEAD:Java Workspace/src/STARS_system/StudentMenuMngr.java
=======
	
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/studentMenuMngr.java
	/**
	 * Change index method
	 * @param student Student
	 * @throws IOException Exception handling
	 */
	private void changeIndex (Student student) throws IOException
    {
    Boolean curWaitlist = false;
      Timetable timetable = new Timetable();
      System.out.println("What is your current index number");
      String curIndex = sc.next();
      System.out.println("What is the new index number that you would like to change to");
      String newIndex = sc.next();
      String coursecode = null;
      int counter = 0;
<<<<<<< HEAD:Java Workspace/src/STARS_system/StudentMenuMngr.java
      ArrayList<courseIndex> indexList = (ArrayList<courseIndex>)RegisteredCourses.getIndexes(student.getMatricNo());
=======
      ArrayList<CourseIndex> indexList = (ArrayList<CourseIndex>)RegisteredCourses.getIndexes(student.getMatricNo());
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/studentMenuMngr.java

      for(int i=0;i<indexList.size();i++)
      {
        if(curIndex.equals(indexList.get(i).indexID))
        {
          coursecode = indexList.get(i).courseCode;
          counter = i;
          if(indexList.get(i).isWaitList==true)
            curWaitlist=true;
          break;
        }
        else
        {
          System.out.println("You are not registered for index: "+curIndex);
          return;
        }
      }
      Course indexCourse = CourseDB.getCourseObj(coursecode);
<<<<<<< HEAD:Java Workspace/src/STARS_system/StudentMenuMngr.java
      courseIndex newCourseIndex = indexCourse.getIndex(newIndex);
      courseIndex curCourseIndex = indexCourse.getIndex(curIndex);
=======
      CourseIndex newCourseIndex = indexCourse.getIndex(newIndex);
      CourseIndex curCourseIndex = indexCourse.getIndex(curIndex);
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/studentMenuMngr.java
      if(newCourseIndex == null)
      {
        System.out.println("New index is not part of the course "+coursecode);
        return;
      }
      else
      {
        String[] DAY = new String[] {"","M","T","W","TH","F"};
          System.out.println("Current index: "+curIndex);
          System.out.println("Lesson:\tDay:\tST(hr):\tET(hr):");

          for(int l=0;l<curCourseIndex.lessonList.size();l++)
          {
            
            Lesson les =curCourseIndex.lessonList.get(l);
            
            System.out.println(les.getLesType()+"\t "+DAY[les.getLesday()]+"\t "+les.getLesST()+"\t "+les.getLesET());
          }
          System.out.println("------------------------------------------");
          System.out.println("New index: "+newIndex);
          System.out.println("Lesson:\tDay:\tST(hr):\tET(hr):");
          for(int nl=0;nl<newCourseIndex.lessonList.size();nl++)
          {
            Lesson nles = newCourseIndex.lessonList.get(nl);
            System.out.println(nles.getLesType()+"\t "+DAY[nles.getLesday()]+"\t "+nles.getLesST()+"\t "+nles.getLesET());
          }
          int vacancy = newCourseIndex.indexVacancy;
          
        if(curWaitlist==false) //if not in waitlist of course to change index
        {
          if(vacancy>0) //if new index available
          {
            
            System.out.println("(Y) to confirm change, any other key to cancel");
            String confirm = sc.next();
            if(confirm.equals("y")||confirm.equals("Y"))
            {
              //student drop cur course function
              indexList.remove(counter);
              //student add new course function
              boolean checkclash = timetable.checkClash(indexList, newCourseIndex);
              if (checkclash == false)
              {
                indexList.add(curCourseIndex);
                System.out.println("You cant register for this course!");
              }
              else {
            	  
                RegisteredCourses.registerIndex(student.getMatricNo(),coursecode,newIndex,false);   
                newCourseIndex.addStudent(student);
                curCourseIndex.removeStudent(student);
                System.out.println("Index Changed to "+newIndex);
              }  
            }
          }
          else//new index not available and student registered in another index
          System.out.println("New index has no vacancy");
        }    
        else //student in waitlist of current index
        {
          if(vacancy>0)//new index available, remove from current waitlist and register new course
          {
        	  System.out.println("(Y) to confirm change, any other key to cancel");
              String confirm = sc.next();
              if(confirm.equals("y")||confirm.equals("Y"))
              {  
            	  indexList.remove(counter);
            	  boolean checkclash = timetable.checkClash(indexList, newCourseIndex);
                  if (checkclash == false)
                  {
                    indexList.add(curCourseIndex);
                    System.out.println("You cant register for this course!");
                  }
                  else 
                  {
                      RegisteredCourses.registerIndex(student.getMatricNo(),coursecode,newIndex,false);
                      
                      newCourseIndex.addStudent(student);
                      curCourseIndex.removeFromWaitlist(student);
                      
                      System.out.println("Index Changed to "+newIndex);
                   }  
                }
            }
            else// new index not avaliable, add to new index waitlist
            {
            	System.out.println("(Y) to confirm change, any other key to cancel");
                String confirm = sc.next();
                if(confirm.equals("y")||confirm.equals("Y"))
                {  
                	indexList.remove(curCourseIndex);
                	RegisteredCourses.registerIndex(student.getMatricNo(),curCourseIndex.courseCode,newIndex,true);
                	newCourseIndex.addToWaitlist(student);
                }
            }
          }
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
<<<<<<< HEAD:Java Workspace/src/STARS_system/StudentMenuMngr.java
	  ArrayList<courseIndex> indexList = (ArrayList<courseIndex>)RegisteredCourses.getIndexes(matricNo);
=======
	  ArrayList<CourseIndex> indexList = (ArrayList<CourseIndex>)RegisteredCourses.getIndexes(matricNo);
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/studentMenuMngr.java
	  if(indexList==null||indexList.size()==0)
		  return;
	  
	  System.out.println("Enter course code you would like to drop:");
	  String courseToDrop = sc.nextLine();
	  Course course = CourseDB.getCourseObj(courseToDrop);
	  while(course == null)
	  { 			 
			 System.out.println("Please enter a valid course code:");
			 courseToDrop = sc.nextLine();	
			 course = CourseDB.getCourseObj(courseToDrop);	
	  }
	  for(int i=0;i<indexList.size();i++) 
	  {
		  if(indexList.get(i).courseCode.equals(courseToDrop))
		  {
			  
			  CourseIndex cindex = course.getIndex(indexList.get(i).indexID);
			  CourseIndex cidx = indexList.get(i);
			  if(cidx.isWaitList==true)
				  cindex.removeFromWaitlist(student);
			  else
			  {
				  cindex.removeStudent(student);      
				  if(!cindex.waitList.isEmpty())
					  cindex.dequeueStudent();
		      
				  else 
					  course.getIndex(indexList.get(i).indexID).indexVacancy++;
			  }
		     
			  indexList.remove(i);
			  System.out.println("Course dropped!");
			  break;

		  }
	  }

	 }
	 /**
	  * Print course method
	  * @param student
	  */
	 private void printCourse(Student student) {
	  
	  String matricNo=student.getMatricNo();
<<<<<<< HEAD:Java Workspace/src/STARS_system/StudentMenuMngr.java
	  ArrayList<courseIndex> indexList = (ArrayList<courseIndex>)RegisteredCourses.getIndexes(matricNo);
=======
	  ArrayList<CourseIndex> indexList = (ArrayList<CourseIndex>)RegisteredCourses.getIndexes(matricNo);
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/studentMenuMngr.java
	  if(indexList==null||indexList.size()==0)
	  {
		  System.out.println("No courses registered!");
		  return;
	  }
	 
	  for(int i=0;i<indexList.size();i++) 
	  {
		  if(indexList.get(i).isWaitList==false)
		  {System.out.println("Course: "+indexList.get(i).courseCode+" Index: "+indexList.get(i).indexID);}
		  else
		  {
			  System.out.println("Course: "+indexList.get(i).courseCode+" Index: "+indexList.get(i).indexID + "(WAITLIST)");
		  }
	  }
	 }
	 /**
	  * Add course method
	  * @param student Student
	  */
	 private void addCourse(Student student) throws ClassNotFoundException, IOException 
	 /**
	  * Add course method
	  * @param student Student
	  */
	 {
		 System.out.println(student.getMatricNo());
		 
		 STARSApp.courseDB.printDB();
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Enter course(code) that you want to register for:");
		 String courseCode = sc.nextLine();		
<<<<<<< HEAD:Java Workspace/src/STARS_system/StudentMenuMngr.java
 		 Course course = CourseDB.getCourseObj(courseCode);
=======
		 System.out.println(student.getMatricNo());
 		 Course course = CourseDB.getCourseObj(courseCode);
 		 System.out.println(student.getMatricNo());
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/studentMenuMngr.java
 		 while(course == null)
 		 { 			 
 			 System.out.println("Please enter a valid course code:");
 			 courseCode = sc.nextLine();	
 			 course = CourseDB.getCourseObj(courseCode);	
 		 }
 		 if(course.numIndex == 0)
		 {
			 return;
		 }
 		 course.printIndexes();	
		 System.out.println("Enter course index that you want to register for:");
		 String courseIndexString = sc.nextLine();
		 CourseIndex courseIndex = course.getIndex(courseIndexString);
		 while(courseIndex == null)
 		 { 			 
 			 System.out.println("Please enter a valid course index:");
 			 courseIndexString = sc.nextLine();
 			 courseIndex = course.getIndex(courseIndexString);	
 		 }
		
		 int vacancy = courseIndex.indexVacancy;
		 Timetable timetable = new Timetable();
<<<<<<< HEAD:Java Workspace/src/STARS_system/StudentMenuMngr.java
		 ArrayList<courseIndex> indexlist = RegisteredCourses.getIndexes(student.getMatricNo());
=======
		 ArrayList<CourseIndex> indexlist = RegisteredCourses.getIndexes(student.getMatricNo());
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/studentMenuMngr.java
		if (indexlist==null)
		{
			if(vacancy<1)
			{
				RegisteredCourses.registerIndex(student.getMatricNo(),courseCode,courseIndexString,true);
				STARSApp.emailSender.waitingListNotification(student, courseCode, courseIndexString);
				courseIndex.addToWaitlist(student);
				System.out.println("There are no vacancies for the course! you'll be added to the waitlist");
			}
			else {
				RegisteredCourses.registerIndex(student.getMatricNo(),courseCode,courseIndexString,false);
				STARSApp.emailSender.courseIndexRegNotification(student, courseCode, courseIndexString);
				System.out.println("Course registered!");
				courseIndex.indexVacancy--;
				courseIndex.addStudent(student);
			}
			
		}
		else if (indexlist.size()!=0)
		{
			boolean checkclash = timetable.checkClash(indexlist, courseIndex);
			if (checkclash == false)
			{
				System.out.println("You cant register for this course!");
			}
			else 
			{
				if(vacancy<1)
				{
					RegisteredCourses.registerIndex(student.getMatricNo(),courseCode,courseIndexString,true);
					STARSApp.emailSender.waitingListNotification(student, courseCode, courseIndexString);
					courseIndex.addToWaitlist(student);
					System.out.println("There are no vacancies for the course! you'll be added to the waitlist");
				}
				else {
						RegisteredCourses.registerIndex(student.getMatricNo(),courseCode,courseIndexString,false);
						System.out.println("Course registered!");
						STARSApp.emailSender.courseIndexRegNotification(student, courseCode, courseIndexString);
						courseIndex.indexVacancy--;
						courseIndex.addStudent(student);

					}
			}
		}
		else
		{
			if(vacancy<1)
			{
				RegisteredCourses.registerIndex(student.getMatricNo(),courseCode,courseIndexString,true);
				STARSApp.emailSender.waitingListNotification(student, courseCode, courseIndexString);
				courseIndex.addToWaitlist(student);
				System.out.println("There are no vacancies for the course! you'll be added to the waitlist");
			}
			
			else
			{

				RegisteredCourses.registerIndex(student.getMatricNo(),courseCode,courseIndexString,false);
				STARSApp.emailSender.courseIndexRegNotification(student, courseCode, courseIndexString);
				System.out.println("Course registered!");
				courseIndex.indexVacancy--;
				courseIndex.addStudent(student);
			}
		}

 }
	 /**
	  * Check vacancy method
	  */
	 private void checkVacancy() throws ClassNotFoundException, IOException
	 /**
	  * Check vacancy method
	  */
	   {
		 
		 String check;
		 Course course=null;
		 
		 while(true) {
			 
			 STARSApp.courseDB.printDB();
		     System.out.println("Enter course code to check vacancy");
		     check = sc.nextLine();
		     course = CourseDB.getCourseObj(check);
		     if (course == null)
		     {
		    	 System.out.println("Course code non-existent! press (y) to re-enter Course code");
		    	 String choice = sc.nextLine();
		    	 if (!choice.equals("y")||!choice.equals("y"))
		    	 {
		    		 return;
		    	 }
		    	 
		     }
		     else {
		    	 break;
		     }

		 
		 	}
	     System.out.println("Index\t|Vacancy:\t|Waitlist:\t|");
	     for(int i=0;i<course.numIndex;i++)
	     {
	       String ID = course.courseIndex[i].indexID;
	       CourseIndex cIndex = course.getIndex(ID);
	       System.out.println(cIndex.indexID+"\t"+cIndex.indexVacancy+"\t\t"+cIndex.waitList.size());
	       
	     }
	   }
}
