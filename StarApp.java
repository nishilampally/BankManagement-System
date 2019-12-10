import java.sql.SQLException;
import java.util.Scanner;

import model.User;
import dao.UserDAO;
public class StarApp {

	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
		// TODO Auto-generated method stub
		System.out.println("Hello! Welcome to Bank of CANADA \n\nPlease use the below options\n");
		System.out.println("1: User registeration \n2: Banking \n3: Admin login ");
		Scanner sc = new Scanner(System.in);
		int opt = sc.nextInt();
		switch(opt) {
		case 1: 
			System.out.println("Enter USERNAME");
			String name = sc.next();
			System.out.println("Enter Age");
			int age = sc.nextInt();
			System.out.println("Enter Deposit amount");
			double amount = sc.nextDouble();
			System.out.println("Enter Password");
			String password = sc.next();
			
			User user = new User(name,age,amount,password);
			try {
				dao.insertUser(user);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case 2:
			System.out.println("Hi user please enter USERNAME");
			String username = sc.next();
			System.out.println("Hi "+username+"! please enter your PASSWORD");
			String pass = sc.next();
			user = dao.selectUser(username,pass);
			if(user==null) {
				System.out.println("Invalid USERNAME or PASSWORD");
			}else {
			System.out.println("Registered Username: "+user.getName()+". Your Age: "+user.getAge());
			System.out.println("Available balance is: $"+user.getSalary());
			System.out.println("\nPlease use the below options");
			int bo = 1;
			while(bo!=4) {
			System.out.println("1: Withdraw Amount 2: Deposit Amount 3: View Balance 4: Quit ");
			bo = sc.nextInt();
			
			switch(bo) {
			case 1:
				System.out.println("Enter amount to Withdraw");
				double amt1 = sc.nextDouble();
				if(user.getSalary()-amt1 < 100) {
					System.out.println("Withdraw can not happen, deficiency of funds.Minimum balance should be $100 in account");
				}
				else {
					dao.withdraw(username, user.getSalary()-amt1);
					System.out.println("Updated Balance: $" + (user.getSalary()-amt1));
					user.setSalary(user.getSalary()-amt1);
				}
				break;
			case 2:
				System.out.println("Enter amount to Deposit");
				int amt2 = sc.nextInt();
				if(user.getSalary()+amt2 > 1000000) {
					System.out.println("Bank balance cannot exceed more than $1,000,000");
				}
				else {
					dao.deposit(username, user.getSalary()+amt2);
					System.out.println("Updated balance: $" + (user.getSalary()+amt2));
					user.setSalary(user.getSalary()+amt2);
				}
				break;
			case 3:
				System.out.println("Hi! Your bank balance is: $"+user.getSalary());
			}
			}
			if(bo==4) System.out.print("Successfullly logged out");
			}
			break;

		case 3: 
			System.out.println("Enter name");
			String aname=sc.next();
			System.out.println("Enter password");
			String pswd=sc.next();
			if(aname.equals("admin")&&pswd.equals("admin")) {
			dao.selectUsers();
			}else {
				System.out.print("Invalid name or Password");
			}
			break;
		default :
			System.out.println("Please choose any of the provided options");
		}
		
	}

}