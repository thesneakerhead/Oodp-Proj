package STARS_system;
import java.util.Scanner; 


public class testSTARS {

	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	
		// TODO Auto-generated method stub
		Student student = new Student("U1922430D","Jacob Law Zhen","male","Singaporean");
		STARSaccount starSaccount = student.getSaccount();
		System.out.println(starSaccount.getAccountID());
		System.out.println(starSaccount.getAccountPW());
		System.out.println(starSaccount.getStudent().getGender());
		
		//Course Testing
		System.out.println("Add Course");
		System.out.println("Course name: ");
		String courseName = sc.nextLine();
		System.out.println("number of indexes: ");
		int numIndex = sc.nextInt();
		System.out.println("Enter indexes: ");
		int indexAR[] = new int[numIndex];
		for(int i=0; i<numIndex; i++)
		{
			indexAR[i]=sc.nextInt();
		}
		System.out.println("Enter vacancy: ");
		int vacancy = sc.nextInt();
		
		Course course = new Course(courseName,numIndex,indexAR,vacancy);
		System.out.println(course.getCourse());
		course.printAvalIndex();
		
		for(int i=0;i<3;i++)
		{
			course.addCourse(101);
		}
		for(int i=0;i<2;i++)
		{
			course.addCourse(103);
		}
		course.printAvalIndex();
	}

}
