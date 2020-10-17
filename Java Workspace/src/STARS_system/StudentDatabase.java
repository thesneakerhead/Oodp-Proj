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
	  
	  public static void main(String[] aArgs)  {
	    	StudentDatabase studDB = new StudentDatabase();
	    	String filename = "student.txt" ;
			try {
				// read file containing Professor records.
				ArrayList al = studDB.readStudent(filename) ;
				for (int i = 0 ; i < al.size() ; i++) {
						Student stud = (Student)al.get(i);
						System.out.println("Name " + stud.getName() );
						System.out.println("Matric No " + stud.getMatricNo() );
				}
				Student s1 = new Student("U1920006F", "Lam Kim Fai", "M", "Singaporean");
				// al is an array list containing Professor objs
				al.add(s1);
				// write Professor record/s to file.
				StudentDatabase.saveStudent(filename, al);
			}catch (IOException e) {
				System.out.println("IOException > " + e.getMessage());
			}
	  }
	  
		
}
