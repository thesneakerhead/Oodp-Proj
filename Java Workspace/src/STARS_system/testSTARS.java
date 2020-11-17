package STARS_system;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;



public class testSTARS {
	
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//StudentDB studentDB = new StudentDB();
		
		//Login login = new Login();
		//System.out.println(login.loginType);
		
		
		//studentDB.serializeStudentDB(studentDB.studentDB);
		
		
		
		Timetable stud1Timetable = new Timetable();
		
		stud1Timetable.addSlot("cz2007", "lab", 8, 10, 3);
		stud1Timetable.printTimetable();
		
//	    Scanner sc = new Scanner(System.in);
//	
//		// TODO Auto-generated method stub
//		Student student = new Student("U1922430D","Jacob Law Zhen","male","Singaporean");
//		STARSaccount starSaccount = student.getSaccount();
//		System.out.println(starSaccount.getAccountID());
//		System.out.println(starSaccount.getAccountPW());
//		System.out.println(starSaccount.getStudent().getGender());
//		
//		//TESTING DATABASE STUFF
//		StudentDatabase studDB = new StudentDatabase();
//    	String filename = "student.txt" ;
//		try {
//			 //read file containing Professor records.
//			//ArrayList al = studDB.readStudent(filename) ;
//			//for (int i = 0 ; i < al.size() ; i++) {
//					//Student stud = (Student)al.get(i);
//			
//			int tester = 6;
//			switch (tester)
//			{
//				case 1:
//					//Add Student
//					ArrayList al = studDB.readStudent(filename) ;
//					Student s1 = new Student("U1920006F", "Zeta Chua", "F", "Singaporean");
//					al.add(s1);
//					StudentDatabase.saveStudent(filename, al);
//					break;
//				
//				case 2:
//					//Delete Student
//					String matricToBeDeleted = "U1920008F";
//					StudentDatabase.deleteStudent(filename, StudentDatabase.read(filename),matricToBeDeleted);
//					break;
//					
//				case 3:
//					//Edit Student Matric
//					String currentMatric = "U1920007F";
//					String ammendedMatric = "U2020006E";
//					StudentDatabase.editStudentMatric(filename, StudentDatabase.read(filename),currentMatric,ammendedMatric);
//					break;
//				
//				case 4:
//					//Edit Student Name
//					currentMatric = "U1920007F";
//					String ammendedName = "Kontol Boy";
//					StudentDatabase.editStudentName(filename, StudentDatabase.read(filename),currentMatric,ammendedName);
//					break;
//				
//				case 5:
//					currentMatric = "U1920007F";
//					String ammendedGender = "F";
//					StudentDatabase.editStudentGender(filename, StudentDatabase.read(filename),currentMatric,ammendedGender);
//					break;
//				
//				case 6:
//					currentMatric = "U1920008F";
//					String ammendedNationality = "Chinanese Outcast";	
//					StudentDatabase.editStudentNationality(filename, StudentDatabase.read(filename),currentMatric,ammendedNationality);
//					break;
//			}
//		
//		}
//		
//		catch (IOException e) 
//		{
//			System.out.println("IOException > " + e.getMessage());
//		}
//		
//		
//		//Course Testing
////		System.out.println("Add Course");
////		System.out.println("Course code: ");
////		int courseCode = sc.nextInt();
////		System.out.println("Add school");
////		System.out.println("school: ");
////		String school = sc.nextLine();
////		System.out.println("number of indexes: ");
////		int numIndex = sc.nextInt();
////		System.out.println("Enter indexes: ");
////		int indexAR[] = new int[numIndex];
////		for(int i=0; i<numIndex; i++)
////		{
////			indexAR[i]=sc.nextInt();
////		}
////		System.out.println("Enter vacancy: ");
////		int vacancy = sc.nextInt();
////		
////		Course course = new Course(school,courseCode,numIndex,indexAR,vacancy);
////		System.out.println(course.getCourse());
////		course.printAvalIndex();
////		
////		for(int i=0;i<3;i++)
////		{
////			course.addCourse(101);
////		}
////		for(int i=0;i<2;i++)
////		{
////			course.addCourse(103);
////		}
////		course.printAvalIndex();
////	}

}
}
