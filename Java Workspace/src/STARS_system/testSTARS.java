package STARS_system;

public class testSTARS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student student = new Student("U1922430D","Jacob Law Zhen","male","Singaporean");
		STARSaccount starSaccount = student.getSaccount();
		System.out.println(starSaccount.getAccountID());
		System.out.println(starSaccount.getAccountPW());
		System.out.println(starSaccount.getStudent().getGender());
	}

}
