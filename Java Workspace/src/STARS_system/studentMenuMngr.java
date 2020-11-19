package STARS_system;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Scanner;

public class studentMenuMngr {
	Scanner sc = new Scanner(System.in);
	public studentMenuMngr(int choice,Student student) throws IOException
	{
		
		switch(choice)
		{
			case 1 :  
				
				break;
			case 2 :
				
				break;
			case 3 :
				
				break;
			case 4 :
				
				break;
				
			case 5 :
				
				break;
			case 6 :
				
				break;
			
		}
	}
	
	public void swapIndex(Student student1) throws IOException
	{
		Boolean firstRegistered=false,secRegistered=false;
		String course1 = null,course2=null;
		int i =0,j=0;
		courseIndex index1 = null,index2 = null;
		
		System.out.println("What is your index number that you would like to swap");
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
		System.out.println("What is student 2's index number to be swapped");
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
				indexList1.remove(i);
				indexList1.add(index2);
				indexList2.remove(j);
				indexList2.add(index1);
				System.out.println("indexlist1 :");
				for(i=0;i<indexList1.size();i++)
				{
					System.out.println(indexList1.get(i).indexID);
				}
				System.out.println("indexlist2 :");
				for(j=0;j<indexList2.size();j++)
				{
					System.out.println(indexList2.get(j).indexID);
				}
			}
			else
				System.out.println("Course code of both indexes are not the same");
		}
		else
			System.out.println("1 or both of the indexes have not been registered by the students");
		
	}
	
	public void changeIndex (Student student) throws IOException
	{
		System.out.println("What is the index number that you would like to change");
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
				break;
			}
			else
			{
				System.out.println("You are not registered for index: "+curIndex);
				return;
			}
		}
		Boolean found = false;
		Course indexCourse = courseDB.getCourseObj(coursecode);
		for (int j=0;j<20;j++)
		{
			courseIndex indexOfCourse = indexCourse.courseIndex[j];
			if(newIndex.equals(indexOfCourse.indexID))
			{
				found = true;
				if(indexOfCourse.indexVacancy>0)
				{
					//student add new course function
					//student drop cur course function
				}
			}
		}
		
	}
}
