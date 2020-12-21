import java.util.Iterator;
import java.util.Scanner;

import Users.User;
import Users.UserMenu;

public class Main {
	
	Scanner scan = new Scanner(System.in);
	private UserMenu um;
	private User u;
	private User user;
	
	public Main() {
		um = new UserMenu();
		menu();
	}
	
	public void menu() {
		int pilih=0;
		do {
			cls();
			System.out.println("1. Login");
			System.out.println("2. Register");
			System.out.println("3. Exit");
			System.out.print(">> ");
			pilih = scan.nextInt();scan.nextLine();
			switch(pilih) {
			case 1:
				login();
				break;
			case 2:
				register();
				break;
			}
			System.out.println(pilih);
		}while(pilih!=3);
		System.out.println("Terima Kasih");
	}
	
	public void mainMenu() {
		int choose=0;
		do {
		cls();
		System.out.println("Hello " + u.getName());
		System.out.println("=================");
		System.out.println("1. Show my profile");
		System.out.println("2. Log out");
		System.out.print(">> ");
		choose = scan.nextInt();scan.nextLine();
		switch(choose) {
		case 1:
			showProfile();
			break;
		}
		}while(choose!=2);
		menu();
//		back to menu
	}
	
	public void showProfile() {
		displayUser();
	}

	
	public void login() {
		String email, password;
		int failed=0;
		
		do {
			email = "";
			password = "";
			cls();
			System.out.println("Login");
			System.out.println("================");
			
			do {
				System.out.print("Email : ");
				email = scan.nextLine();
			}while(!email.contains("@") || !email.contains(".com") && email.length() > 4);
			
			do {
				System.out.print("Password : ");
				password = scan.nextLine();
			}while(password.length()<4);
			
			//VALIDATE WITH PROXY PATTERN
			u = um.Validate(email, password);
			if(u != null) {
				mainMenu();
			}else { 
				failed++;
				System.out.println("Email atau password salah");
				scan.nextLine();
			}
		}while(failed!=4);
		
		if(failed == 4){
			System.out.println("Anda sudah salah 4 kali, coba lagi nanti !");
			scan.nextLine();
			menu();
		}
	}
	
	public void register() {
		String name,email,password,desc;
		String  job,companyName,currentJob;
		int age;
		
		do {
			System.out.print("Insert name[4-10]: ");
			name = scan.nextLine();
		}while(name.length()<4 || name.length()>10);
		
		do {
			System.out.print("Set Your Email[must have '@' and '.com'] : ");
			email = scan.nextLine();
		}while(!email.contains("@") || !email.contains(".com") && email.length() > 4);
		
		do {
			System.out.print("set your pasword : ");
			password = scan.nextLine();
		}while(password.length()<6 || password.length()>12);
		
		System.out.println("Success create profile! now for the last step fill your resume!");
		scan.nextLine();
		
		do {
			System.out.print("Do you have current job? [Y|N] :");
			currentJob = scan.nextLine();
		}while(!currentJob.equals("Y") && !currentJob.equals("N"));
				
		if(currentJob.equals("Y")) {
			System.out.print("Input your company name : ");
			companyName = scan.nextLine();
		}else {
			companyName = "-";
		}
		
		System.out.print("set your age : ");
		age = scan.nextInt();scan.nextLine();
			
		System.out.println("Describe your character");
		System.out.println("=======================");
		System.out.print(">> ");
		desc = scan.nextLine();
		
		//STORE USING ITERATOR PATTERN
		um.addUser(name, email, password, currentJob, companyName, desc, age);
	}
	
	public void displayUser() {
		Iterator userIt = um.createIterator();
		user = display(userIt, u.getName());
		user.display();
		scan.nextLine();
	}
	
	public User display(Iterator users, String name) {
		while(users.hasNext()) {
			User user = (User) users.next();
			if(user.getName().equals(name)) {
				return user;
			}
		}
		return null;
	}
	
	public void cls() {
		for(int j=0;j<20;j++) {
			System.out.println();
		}
	}

	public static void main(String[] args) {
		new Main();
	}

}
