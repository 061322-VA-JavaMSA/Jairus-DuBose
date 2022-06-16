import java.util.Random;
import java.util.Scanner; 

public class MenuActivity {
	static Scanner scan = new Scanner(System.in);
	static String name; 
	public static void main(String[] args) {
		//Scanner scan = new Scanner(System.in);
		
		System.out.println("Hi, Please enter your name: ");
		//String name = scan.nextLine();
		name = scan.nextLine();
		
		System.out.println("You entered: " + name);
		
		menuMethod(); 
		
		//scan.close();
	}
	
	public static void menuMethod() 
	{
		System.out.println("Select 1 for Random Number, 2 for Name Reversal, or 3 for to Exit");
		int selection = scan.nextInt();
		
		switch(selection) 
		{
		case 1:
			Random randomNumber = new Random();
			System.out.println(randomNumber);
			break; 
		case 2: 
			String reversedName = ""; 
			
			char[] letters = name.toCharArray(); 
			
			for(int i = letters.length-1; i >= 0 ;i--) {
				reversedName = reversedName + letters[i];
			}
			
			System.out.println("This is your name reversed: " + reversedName);
			break;
		
		case 3:
			System.out.println("Your are leaving the program");
			
			break;
		
		default:
			System.out.println("Something went wrong"); 
		
		}
	scan.close();
	}
}
