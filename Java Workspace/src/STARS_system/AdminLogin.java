package STARS_system;

import java.io.IOException;
import java.util.Scanner;

public class AdminLogin extends Login 
{
	private String username;
	private String password;

	public AdminLogin() throws IOException
	{
		Boolean valid = false;
		while(valid == false)
		{
			super.askInput();
			this.username = super.getUsername();
			this.password = super.getPassword();
			valid = systemLogin(this.username,this.password);
		}
	}

	public Boolean systemLogin(String username, String password) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		AccVerify verifier = new AccVerify(true);
		if (verifier.verification(username, password)==true)
			return true;
		else 
		{
			System.out.println("Wrong Username/Password!");
			System.out.println("Continue(y/n)?");
			String again= sc.nextLine();
			if(again.equals("n"))
			{
				STARSApp.terminate();
			}
			return false;
		}
	}
	
}
