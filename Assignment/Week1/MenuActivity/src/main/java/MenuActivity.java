import java.util.Scanner; 

public class MenuActivity {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		//Scanner scan = new Scanner(System.in);
		
		System.out.println("Hi, Please enter your name: ");
		String name = scan.nextLine();
		
		System.out.println("You entered: " + name);
		
		//scan.close();
	}
	
	public static void menuMethod() 
	{
		int case = scan;
		
		switch(case) 
		{
		case 1:
			
			break; 
		case 2: 
			
			break;
		
		default:
			System.out.println("Something went wrong"); 
		
		}
		scan.close();
	}

}
