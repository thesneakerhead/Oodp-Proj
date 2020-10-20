package STARS_system;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class StudentDatabase {
	public static final String SEPARATOR = "|";

    // an example of reading
	public static ArrayList readStudent(String filename) throws IOException {
		// read String from text file
		ArrayList stringArray = (ArrayList)read(filename);
		
		ArrayList alr = new ArrayList() ;// to store Professors data

        for (int i = 0 ; i < stringArray.size() ; i++) {
				String st = (String)stringArray.get(i);
				System.out.println(st);
				// get individual 'fields' of the string separated by SEPARATOR
				StringTokenizer star = new StringTokenizer(st , SEPARATOR);	// pass in the string to the string tokenizer using delimiter ","
				//int  contact = Integer.parseInt(star.nextToken().trim()); // third token
				
				//String matricNo,String name,String gender,String nationality
				String matricNo = star.nextToken().trim();
				String name = star.nextToken().trim();
				String gender = star.nextToken().trim();
				String nationality = star.nextToken().trim();
	
				// create Professor object from file data
				Student stud = new Student(matricNo, name, gender, nationality);
				// add to Professors list
				alr.add(stud) ;
			}
			return alr ;
	}
	
	  // an example of saving
	public static void saveStudent(String filename, List al) throws IOException {
			List alw = new ArrayList() ;// to store Professors data

	        for (int i = 0 ; i < al.size() ; i++) {
					Student stud = (Student)al.get(i);
					StringBuilder st =  new StringBuilder() ;
					st.append(stud.getMatricNo().trim());
					st.append(SEPARATOR);
					st.append(stud.getName().trim());
					st.append(SEPARATOR);
					st.append(stud.getGender());
					st.append(SEPARATOR);
					st.append(stud.getNationality());
					alw.add(st.toString()) ;
				}
				write(filename,alw);
		}
	
	/** Write fixed content to the given file. */
	  public static void write(String fileName, List data) throws IOException  {
	    PrintWriter out = new PrintWriter(new FileWriter(fileName));

	    try {
			for (int i =0; i < data.size() ; i++) {
	      		out.println((String)data.get(i));
			}
	    }
	    finally {
	      out.close();
	    }
	  }
	  
	  /** Read the contents of the given file. */
	  public static List read(String fileName) throws IOException {
		List data = new ArrayList() ;
	    Scanner scanner = new Scanner(new FileInputStream(fileName));
	    try {
	      while (scanner.hasNextLine()){
	        data.add(scanner.nextLine());
	      }
	    }
	    finally{
	      scanner.close();
	    }
	    return data;
	  }
	  
	  public static List reads(String fileName) throws IOException {
			List data = new ArrayList() ;
			String matricNo;
		    Scanner scanner = new Scanner(new FileInputStream(fileName));
		    try {
		      while (scanner.hasNextLine()){
		    	matricNo = scanner.nextLine().substring(0,8);
		    	System.out.println(matricNo);
		        data.add(scanner.nextLine());
		      }
		    }
		    finally{
		      scanner.close();
		    }
		    return data;
		  }
	  
	  //Delete student
	  public static void deleteStudent(String fileName, List data, String studentMatric) throws IOException  {
	    PrintWriter out = new PrintWriter(new FileWriter(fileName));
	    String matricNo;
	    

	    try {
			for (int i =0; i < data.size() ; i++) {
				matricNo = ((String) data.get(i)).substring(0,9);
				if (matricNo.equals(studentMatric))
				{
					continue;
				}
				else
				{
					out.println((String)data.get(i));
				}
	      		
			}
	    }
	    finally {
	      out.close();
	    }
	  }
	  
	  //Edit Student Matric No
	  public static void editStudentMatric(String fileName, List data, String studentMatric, String ammendedMatricNo) throws IOException  {
		    PrintWriter out = new PrintWriter(new FileWriter(fileName));
		    String matricNo;
		    String name;
		    String gender;
		    String nationality;
		    String[] parts;
		    try {
				for (int i =0; i < data.size() ; i++) {
					
					parts = ((String) data.get(i)).split("\\"+ SEPARATOR);
					matricNo = parts[0];
					name = parts[1];
					gender = parts[2];
					nationality = parts[3];
					String reconstructString;
					if (matricNo.equals(studentMatric))
					{
						reconstructString = ammendedMatricNo+SEPARATOR+name+SEPARATOR+gender+SEPARATOR+nationality;
						out.println(reconstructString);
					}
					else
					{
						out.println((String)data.get(i));
					}
				}
		    }
		    finally {
		      out.close();
		    }
		  }
	  
	  //Edit Student Name
	  public static void editStudentName(String fileName, List data, String studentMatric, String ammendedName) throws IOException  {
		    PrintWriter out = new PrintWriter(new FileWriter(fileName));
		    String matricNo;
		    String name;
		    String gender;
		    String nationality;
		    String[] parts;
		    try {
				for (int i =0; i < data.size() ; i++) {
					
					parts = ((String) data.get(i)).split("\\"+ SEPARATOR);
					matricNo = parts[0];
					name = parts[1];
					gender = parts[2];
					nationality = parts[3];
					String reconstructString;
					if (matricNo.equals(studentMatric))
					{
						reconstructString = matricNo+SEPARATOR+ammendedName+SEPARATOR+gender+SEPARATOR+nationality;
						out.println(reconstructString);
					}
					else
					{
						out.println((String)data.get(i));
					}
				}
		    }
		    finally {
		      out.close();
		    }
		  }
	  //Edit Student Gender
	  public static void editStudentGender(String fileName, List data, String studentMatric, String ammendedGender) throws IOException  {
		    PrintWriter out = new PrintWriter(new FileWriter(fileName));
		    String matricNo;
		    String name;
		    String gender;
		    String nationality;
		    String[] parts;
		    try {
				for (int i =0; i < data.size() ; i++) {
					
					parts = ((String) data.get(i)).split("\\"+ SEPARATOR);
					matricNo = parts[0];
					name = parts[1];
					gender = parts[2];
					nationality = parts[3];
					String reconstructString;
					if (matricNo.equals(studentMatric))
					{
						reconstructString = matricNo+SEPARATOR+name+SEPARATOR+ammendedGender+SEPARATOR+nationality;
						out.println(reconstructString);
					}
					else
					{
						out.println((String)data.get(i));
					}
				}
		    }
		    finally {
		      out.close();
		    }
		  }
	  
	  public static void editStudentNationality(String fileName, List data, String studentMatric, String ammendedNationality) throws IOException  {
		    PrintWriter out = new PrintWriter(new FileWriter(fileName));
		    String matricNo;
		    String name;
		    String gender;
		    String nationality;
		    String[] parts;
		    try {
				for (int i =0; i < data.size() ; i++) {
					
					parts = ((String) data.get(i)).split("\\"+ SEPARATOR);
					matricNo = parts[0];
					name = parts[1];
					gender = parts[2];
					nationality = parts[3];
					String reconstructString;
					if (matricNo.equals(studentMatric))
					{
						reconstructString = matricNo+SEPARATOR+name+SEPARATOR+gender+SEPARATOR+ammendedNationality;
						out.println(reconstructString);
					}
					else
					{
						out.println((String)data.get(i));
					}
				}
		    }
		    finally {
		      out.close();
		    }
		  }
	  
	  
	 	
}
