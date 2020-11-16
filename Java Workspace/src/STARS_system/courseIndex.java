package STARS_system;

import java.util.Scanner;

public class courseIndex
{
	Scanner sc = new Scanner(System.in);
	private int course_index;
	private int vacancy;
	private lesson LecTutLab[] = new lesson[10];
	private int numLesson;
	//private String classtime;
	
	public courseIndex(int course_index, int vacancy, int numLec, String day[], int lecStartTime[], int lecEndTime[])
	{
		this.course_index = course_index;
		this.vacancy = vacancy;
		
		for(int i=0; i<numLec;i++)
		{
			LecTutLab[i] = new lesson("lecture", day[i], lecStartTime[i], lecEndTime[i]);
		}
		System.out.println("Would you like to add more lessons to this index?");
		System.out.println("1: yes   2: no");
		int cont = sc.nextInt();
		String lesType;
		String lesday;
		int startTime;
		int endTime;
		numLesson = numLec;
		
		while (cont==1)
		{
			System.out.println("What lesson would you like to add to this index?");
			System.out.println("(Tutorial, Lab, Seminar)");
			lesType = sc.nextLine();
			System.out.println("Please input day for "+lesType);
			System.out.println("(Mon,Tue,Wed,Thur,Fri)");
			lesday = sc.nextLine();
			System.out.println("Please indicate start time for "+lesType);
			startTime = sc.nextInt();
			System.out.println("Please indicate end time for "+lesType);
			endTime = sc.nextInt();
			LecTutLab[numLesson] = new lesson(lesType,lesday,startTime,endTime);
			numLesson ++;
			
			System.out.println("Would you like to add more lessons to this index?");
			System.out.println("1: yes   2: no");
			cont = sc.nextInt();
		}
		
	}
	
	public void addLesson()
	{
		String lesType;
		String lesday;
		int startTime;
		int endTime;
		int cont = 1;
		
		while (cont==1)
		{
			System.out.println("What lesson would you like to add to this index?");
			System.out.println("(Tutorial, Lab, Seminar)");
			lesType = sc.nextLine();
			System.out.println("Please input day for "+lesType);
			System.out.println("(Mon,Tue,Wed,Thur,Fri)");
			lesday = sc.nextLine();
			System.out.println("Please indicate start time for "+lesType);
			startTime = sc.nextInt();
			System.out.println("Please indicate end time for "+lesType);
			endTime = sc.nextInt();
			LecTutLab[numLesson] = new lesson(lesType,lesday,startTime,endTime);
			numLesson ++;
			
			System.out.println("Would you like to add more lessons to this index?");
			System.out.println("1: yes   2: no");
			cont = sc.nextInt();
		}
		
	}
	
	public int getIndex()
	{
		return course_index;
	}
	
	public int getVacancy()	
	{
		return vacancy;
	}
	
	public void changeIndex (int newIndex)
	{
		course_index = newIndex;
	}
	
	public void changeVacancy(int newVacancy)
	{
		vacancy = newVacancy;
	}
	
	public void minusVacancy(int i)
	{
		vacancy = vacancy-i;
	}
	
	public void addVacancy(int i)
	{
		vacancy = vacancy+i;
	}
}
