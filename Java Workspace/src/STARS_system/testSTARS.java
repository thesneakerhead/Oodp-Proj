package STARS_system;
import java.io.IOException;
import java.util.ArrayList;
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
		
		//TESTING DATABASE STUFF
		StudentDatabase studDB = new StudentDatabase();
    	String filename = "student.txt" ;
		try {
			// read file containing Professor records.
			ArrayList al = studDB.readStudent(filename) ;
			for (int i = 0 ; i < al.size() ; i++) {
					Student stud = (Student)al.get(i);
					System.out.println("Name: " + stud.getName() );
					System.out.println("Matric No: " + stud.getMatricNo() );
			}
			Student s1 = new Student("U1920007F", "Zoey", "M", "Euro");
			// al is an array list containing Professor objs
			al.add(s1);
			// write Professor record/s to file.
			StudentDatabase.saveStudent(filename, al);
			
			String matricToBeDeleted = "U1920007F";
			StudentDatabase.deleteStudent(filename, StudentDatabase.read(filename),matricToBeDeleted);
		}catch (IOException e) {
			System.out.println("IOException > " + e.getMessage());
		}
		
		
		//Course Testing
//		System.out.println("Add Course");
//		System.out.println("Course code: ");
//		int courseCode = sc.nextInt();
//		System.out.println("Add school");
//		System.out.println("school: ");
//		String school = sc.nextLine();
//		System.out.println("number of indexes: ");
//		int numIndex = sc.nextInt();
//		System.out.println("Enter indexes: ");
//		int indexAR[] = new int[numIndex];
//		for(int i=0; i<numIndex; i++)
//		{
//			indexAR[i]=sc.nextInt();
//		}
//		System.out.println("Enter vacancy: ");
//		int vacancy = sc.nextInt();
//		
//		Course course = new Course(school,courseCode,numIndex,indexAR,vacancy);
//		System.out.println(course.getCourse());
//		course.printAvalIndex();
//		
//		for(int i=0;i<3;i++)
//		{
//			course.addCourse(101);
//		}
//		for(int i=0;i<2;i++)
//		{
//			course.addCourse(103);
//		}
//		course.printAvalIndex();
//	}

}
}
