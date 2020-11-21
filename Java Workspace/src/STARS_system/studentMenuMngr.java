package STARS_system;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Scanner;

public class studentMenuMngr {
	Scanner sc = new Scanner(System.in);
	public studentMenuMngr(int choice,Student student) throws IOException
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
			//default:StarsApp.terminate();
				//	break;
		}
	}
	
	
	public void swapIndex(Student student1) throws IOException
	{
		Boolean firstRegistered=false,secRegistered=false;
		String course1 = null,course2=null;
		int i =0,j=0;
		courseIndex index1 = null,index2 = null;
		
		System.out.println("What is your current index number");
		String stud1Index = sc.next();
		
		Login2 login2 = new Login2();
		
		ArrayList<courseIndex> indexList1 = (ArrayList<courseIndex>)registeredCourses.getIndexes(student1.getMatricNo());
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
		
		Student student2 = login2.currentStudent;
		System.out.println("What is student 2's index number");
		String stud2Index = sc.next();
		
		ArrayList<courseIndex> indexList2 = (ArrayList<courseIndex>)registeredCourses.getIndexes(student2.getMatricNo());
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
				Course course = courseDB.getCourseObj(course1);
				courseIndex cIndex1 = course.getIndex(stud1Index);
				courseIndex cIndex2 = course.getIndex(stud2Index);
				cIndex1.removeStudent(student1);
				cIndex1.addStudent(student2);
				cIndex2.removeStudent(student2);
				cIndex2.addStudent(student1);
				
				indexList1.remove(i);
				indexList1.add(index2);
				indexList2.remove(j);
				indexList2.add(index1);

			}
			else
				System.out.println("Course code of both indexes are not the same");
		}
		else
			System.out.println("1 or both of the indexes have not been registered by the students");
		
	}
	
	public void changeIndex (Student student) throws IOException
    {
    Boolean curWaitlist = false;
      Timetable timetable = new Timetable();
      System.out.println("What is your current index number");
      String curIndex = sc.next();
      System.out.println("What is the new index number that you would like to change to");
      String newIndex = sc.next();
      String coursecode = null;
      int counter = 0;
      ArrayList<courseIndex> indexList = (ArrayList<courseIndex>)registeredCourses.getIndexes(student.getMatricNo());

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
      Course indexCourse = courseDB.getCourseObj(coursecode);
      courseIndex newCourseIndex = indexCourse.getIndex(newIndex);
      courseIndex curCourseIndex = indexCourse.getIndex(curIndex);
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
            
            lesson les =curCourseIndex.lessonList.get(l);
            
            System.out.println(les.getLesType()+"\t "+DAY[les.getLesday()]+"\t "+les.getLesST()+"\t "+les.getLesET());
          }
          System.out.println("------------------------------------------");
          System.out.println("New index: "+newIndex);
          System.out.println("Lesson:\tDay:\tST(hr):\tET(hr):");
          for(int nl=0;nl<newCourseIndex.lessonList.size();nl++)
          {
            lesson nles = newCourseIndex.lessonList.get(nl);
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
            	  
                registeredCourses.registerIndex(student.getMatricNo(),coursecode,newIndex,false);   
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
                      registeredCourses.registerIndex(student.getMatricNo(),coursecode,newIndex,false);
                      
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
                	registeredCourses.registerIndex(student.getMatricNo(),curCourseIndex.courseCode,newIndex,true);
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
	  ArrayList<courseIndex> indexList = (ArrayList<courseIndex>)registeredCourses.getIndexes(matricNo);
	  if(indexList==null||indexList.size()==0)
		  return;
	  
	  System.out.println("Enter course code you would like to drop:");
	  String courseToDrop = sc.nextLine();
	  for(int i=0;i<indexList.size();i++) 
	  {
		  if(indexList.get(i).courseCode.equals(courseToDrop))
		  {
			  Course course = courseDB.getCourseObj(courseToDrop);
			  courseIndex cindex = course.getIndex(indexList.get(i).indexID);
			  if(cindex.isWaitList==true)
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
	  courseDB.printCourses();
	  String matricNo=student.getMatricNo();
	  ArrayList<courseIndex> indexList = (ArrayList<courseIndex>)registeredCourses.getIndexes(matricNo);
	  if(indexList==null||indexList.size()==0)
	  {
		  System.out.println("No courses registered!");
		  return;
	  }
	 
	  for(int i=0;i<indexList.size();i++) 
	  {
		  System.out.println(indexList.get(i).indexID+indexList.get(i).isWaitList);
		  if(indexList.get(i).isWaitList==false)
		  {System.out.println("Course: "+indexList.get(i).courseCode+" Index: "+indexList.get(i).indexID);}
		  else
		  {
			  System.out.println("Course: "+indexList.get(i).courseCode+" Index: "+indexList.get(i).indexID + "(WAITLIST)");
		  }
	  }
	 }
	 
	 private void addCourse(Student student) {
		 Scanner sc = new Scanner(System.in);
			System.out.println("Enter Course that you want to register for:");
			String courseCode = sc.nextLine();		
			Course course = courseDB.getCourseObj(courseCode);			
			course.printIndexes();		
			System.out.println("Enter course index that you want to register for:");
			
			String courseIndexString = sc.nextLine();
			courseIndex courseIndex = course.getIndex(courseIndexString);
			int vacancy = courseIndex.indexVacancy;
			
			Timetable timetable = new Timetable();
			ArrayList<courseIndex> indexlist = registeredCourses.getIndexes(student.getMatricNo());

			if (indexlist==null)
			{
				if(vacancy<1)
				{
					registeredCourses.registerIndex(student.getMatricNo(),courseCode,courseIndexString,true);
					courseIndex.addToWaitlist(student);
					System.out.println("There are no vacancies for the course! you'll be added to the waitlist");
				}
				else {
					registeredCourses.registerIndex(student.getMatricNo(),courseCode,courseIndexString,false);
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
				else {
					if(vacancy<1)
					{
						registeredCourses.registerIndex(student.getMatricNo(),courseCode,courseIndexString,true);
						courseIndex.addToWaitlist(student);
						System.out.println("There are no vacancies for the course! you'll be added to the waitlist");
					}
					else {
							registeredCourses.registerIndex(student.getMatricNo(),courseCode,courseIndexString,false);
							System.out.println("Course registered!");
							courseIndex.indexVacancy--;
							courseIndex.addStudent(student);
						}
				}
			}
			else
			{
				if(vacancy<1)
				{
					registeredCourses.registerIndex(student.getMatricNo(),courseCode,courseIndexString,true);
					courseIndex.addToWaitlist(student);
					System.out.println("There are no vacancies for the course! you'll be added to the waitlist");
				}
				
				else{registeredCourses.registerIndex(student.getMatricNo(),courseCode,courseIndexString,false);
				System.out.println("Course registered!");
				courseIndex.indexVacancy--;
				courseIndex.addStudent(student);}
			}
	
	 }
	 public void checkVacancy()
	   {
	     System.out.println("Enter course code to check vacancy");
	     String check = sc.next();
	     Course course = courseDB.getCourseObj(check);
	     System.out.println("Index:\tVacancy:\tWaitlist:");
	     for(int i=0;i<course.numIndex;i++)
	     {
	       String ID = course.courseIndex[i].indexID;
	       courseIndex cIndex = course.getIndex(ID);
	       System.out.println(cIndex.indexID+"\t"+cIndex.indexVacancy+"\t\t"+cIndex.waitList.size());
	       
	     }
	   }
}
